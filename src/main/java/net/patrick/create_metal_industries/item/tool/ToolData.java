package net.patrick.create_metal_industries.item.tool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.patrick.create_metal_industries.item.tool.material.Material;
import net.patrick.create_metal_industries.item.tool.material.MaterialAbility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ToolData implements Abilities
{
    public String codeName;
    public String inGameName;
    public Material rodMaterial;
    public Material headMaterial;
    public Material coatingMaterial;
    public Material decorationMaterial;
    public ResourceLocation rodTexture;
    public ResourceLocation headTexture;
    public ResourceLocation coatingTexture;
    public ResourceLocation decorationTexture;
    public int miningLevel; // no use - see tiers
    public int durability; // no use - see tiers
    public int miningSpeed; // no use - see tiers
    public double miningSpeedModifier;
    public double attackSpeedModifier;
    public Tier tier; ////// todo is this the right import?.
    public List<ToolAbility> toolAbilities;
    
    public ToolData(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // Materials
        this.rodMaterial = rodMaterial;
        this.headMaterial = headMaterial;
        this.coatingMaterial = coatingMaterial;
        this.decorationMaterial = decorationMaterial;
        
        // Textures
        this.rodTexture = rodMaterial.texture;
        this.headTexture = headMaterial.texture;
        this.coatingTexture = coatingMaterial.texture;
        this.decorationTexture = decorationMaterial.texture;
        
        // Attributes
        this.miningSpeedModifier = MiningSpeed(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        this.attackSpeedModifier = AttackSpeed(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        
        // Tier
        // todo function to determine the highest tier amongst the applied materials
        this.tier = rodMaterial.tier;
        
        // Special abilities list
        toolAbilities = new ArrayList<ToolAbility>(List.of());
        this.toolAbilities = setPickaxeAbilities(rodMaterial, headMaterial, coatingMaterial, decorationMaterial);
        
    }
    
    private double AttackSpeed(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // All values multiplied and multiplied again by the highest factor
        return rodMaterial.attackSpeedModifier*
                headMaterial.attackSpeedModifier*
                coatingMaterial.attackSpeedModifier*
                decorationMaterial.attackSpeedModifier*
                Math.max(Math.max(rodMaterial.attackSpeedModifier,
                                headMaterial.attackSpeedModifier),
                        Math.max(coatingMaterial.attackSpeedModifier,
                                decorationMaterial.attackSpeedModifier));
    }
    
    private double MiningSpeed(Material rodMaterial, Material headMaterial, Material coatingMaterial, Material decorationMaterial)
    {
        // All values multiplied and multiplied again by the highest factor
        return rodMaterial.miningSpeedModifier*
                headMaterial.miningSpeedModifier*
                coatingMaterial.miningSpeedModifier*
                decorationMaterial.miningSpeedModifier*
                Math.max(Math.max(rodMaterial.miningSpeedModifier,
                                headMaterial.miningSpeedModifier),
                        Math.max(coatingMaterial.miningSpeedModifier,
                                decorationMaterial.miningSpeedModifier));
    }
    
    private static List<ToolAbility> setPickaxeAbilities(Material rod, Material head, Material coating, Material decoration)
    {
        // Create the list and map where all results will be stored
        List<ToolAbility> currentToolAbilities = new ArrayList<ToolAbility>(List.of());
        Map<Integer, Boolean> currentToolHasAbility = new HashMap<Integer, Boolean>();
        
        // Create a list of all materials the tool is made of.
        List<Material> toolElementMaterials = new ArrayList<Material>();
        toolElementMaterials.add(rod);
        toolElementMaterials.add(head);
        toolElementMaterials.add(coating);
        toolElementMaterials.add(decoration);
        
        // Set all ability counters to 0
        int veinMinerLevel = 0;
        int multiMinerLevel = 0;
        int magneticLevel = 0;
        int torcherLevel = 0;
        int miningReachLevel = 0;
        int treeFellerLevel = 0;
        int linkedStorageLevel = 0;
        int noLavaBurnLevel = 0;
        
        // Loop through all materials the tool is made of
        for(Material material : toolElementMaterials)
        {
            // List all abilities that each material has
            List<MaterialAbility> abilities = material.materialAbilities;
            
            // Skip if no abilities were found
            if (!(abilities.isEmpty()))
            {
                // Loop through all abilities that each material has
                for (MaterialAbility materialAbility : abilities)
                {
                    if (materialAbility.abilityID == veinMinerID)
                    {
                        veinMinerLevel += materialAbility.abilityLevel;
                    }
                    if (materialAbility.abilityID == multiMinerID)
                    {
                        multiMinerLevel += materialAbility.abilityLevel;
                    }
                    if (materialAbility.abilityID == magneticID)
                    {
                        magneticLevel += materialAbility.abilityLevel;
                    }
                    if (materialAbility.abilityID == torcherID)
                    {
                        torcherLevel += materialAbility.abilityLevel;
                    }
                    if (materialAbility.abilityID == miningReachID)
                    {
                        miningReachLevel += materialAbility.abilityLevel;
                    }
//                    if (materialAbility.abilityID == treeFellerID)
//                    {
//                        treeFellerLevel += materialAbility.abilityLevel;
//                    }
                    if (materialAbility.abilityID == linkedStorageID)
                    {
                        linkedStorageLevel += materialAbility.abilityLevel;
                    }
                    if (materialAbility.abilityID == noLavaBurnID)
                    {
                        noLavaBurnLevel += materialAbility.abilityLevel;
                    }
                }
            }
        }
        
        // Set all the abilities found in the materials to be a tool ability with appropriate level
        currentToolAbilities.add(new ToolAbility(veinMinerCodeName, veinMinerID, veinMinerLevel));
        currentToolAbilities.add(new ToolAbility(multiMinerCodeName, multiMinerID, multiMinerLevel));
        currentToolAbilities.add(new ToolAbility(magneticCodeName, magneticID, magneticLevel));
        currentToolAbilities.add(new ToolAbility(torcherCodeName, torcherID, torcherLevel));
        currentToolAbilities.add(new ToolAbility(miningReachCodeName, miningReachID, miningReachLevel));
//        currentToolAbilities.add(new ToolAbility(treeFellerCodeName, treeFellerID, treeFellerLevel));
        currentToolAbilities.add(new ToolAbility(linkedStorageCodeName, linkedStorageID, linkedStorageLevel));
        currentToolAbilities.add(new ToolAbility(noLavaBurnCodeName, noLavaBurnID, noLavaBurnLevel));
        
        // todo clear some abilities in case they're mutually exclusive. (eg. Vein Miner and Multi Miner)
        
        // Set the presence of each ability to be true or false in a map
        // todo maybe move this to the main method to create the map based on the returned list.
        currentToolHasAbility.put(veinMinerID, veinMinerLevel>0);
        currentToolHasAbility.put(multiMinerID, multiMinerLevel>0);
        currentToolHasAbility.put(magneticID, magneticLevel>0);
        currentToolHasAbility.put(torcherID, torcherLevel>0);
        currentToolHasAbility.put(miningReachID, miningReachLevel>0);
//        currentToolHasAbility.put(treeFellerID, treeFellerLevel>0);
        currentToolHasAbility.put(linkedStorageID, linkedStorageLevel>0);
        currentToolHasAbility.put(noLavaBurnID, noLavaBurnLevel>0);
        
        // todo find a way to return both the tool abilities list and the map with the ability presence
        // Suggestion: https://stackoverflow.com/questions/2832472/how-to-return-2-values-from-a-java-method
        
        // todo put a function here to determine the final ability (abilities?) based on the materials.
        // todo maybe minor and major abilities??
        
        return currentToolAbilities;
    }
}
