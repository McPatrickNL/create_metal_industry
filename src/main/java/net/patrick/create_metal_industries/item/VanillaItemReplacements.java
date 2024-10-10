package net.patrick.create_metal_industries.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VanillaItemReplacements
{
    // Create DeferredRegister for Tools in the "minecraft" namespace
    public static final DeferredRegister<Item> REPLACEMENT =
            DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft"); // Use "minecraft" namespace
    
    // Register the replacement for the vanilla tools
    private static final int damage = 0;
    private static final float speed = 0.000f;
    public static final RegistryObject<Item> WOODEN_SWORD = REPLACEMENT.register("wooden_sword", () -> new SwordItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> WOODEN_SHOVEL = REPLACEMENT.register("wooden_shovel", () -> new ShovelItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> WOODEN_PICKAXE = REPLACEMENT.register("wooden_pickaxe", () -> new PickaxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> WOODEN_AXE = REPLACEMENT.register("wooden_axe", () -> new AxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> WOODEN_HOE = REPLACEMENT.register("wooden_hoe", () -> new HoeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> STONE_SWORD = REPLACEMENT.register("stone_sword", () -> new SwordItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> STONE_SHOVEL = REPLACEMENT.register("stone_shovel", () -> new ShovelItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> STONE_PICKAXE = REPLACEMENT.register("stone_pickaxe", () -> new PickaxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> STONE_AXE = REPLACEMENT.register("stone_axe", () -> new AxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> STONE_HOE = REPLACEMENT.register("stone_hoe", () -> new HoeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> GOLDEN_SWORD = REPLACEMENT.register("golden_sword", () -> new SwordItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> GOLDEN_SHOVEL = REPLACEMENT.register("golden_shovel", () -> new ShovelItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> GOLDEN_PICKAXE = REPLACEMENT.register("golden_pickaxe", () -> new PickaxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> GOLDEN_AXE = REPLACEMENT.register("golden_axe", () -> new AxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> GOLDEN_HOE = REPLACEMENT.register("golden_hoe", () -> new HoeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> IRON_SWORD = REPLACEMENT.register("iron_sword", () -> new SwordItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> IRON_SHOVEL = REPLACEMENT.register("iron_shovel", () -> new ShovelItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> IRON_PICKAXE = REPLACEMENT.register("iron_pickaxe", () -> new PickaxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> IRON_AXE = REPLACEMENT.register("iron_axe", () -> new AxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> IRON_HOE = REPLACEMENT.register("iron_hoe", () -> new HoeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> DIAMOND_SWORD = REPLACEMENT.register("diamond_sword", () -> new SwordItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> DIAMOND_SHOVEL = REPLACEMENT.register("diamond_shovel", () -> new ShovelItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> DIAMOND_PICKAXE = REPLACEMENT.register("diamond_pickaxe", () -> new PickaxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> DIAMOND_AXE = REPLACEMENT.register("diamond_axe", () -> new AxeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> DIAMOND_HOE = REPLACEMENT.register("diamond_hoe", () -> new HoeItem(Tiers.WOOD, damage, speed, new Item.Properties().durability(1).setNoRepair().defaultDurability(1)));
    public static final RegistryObject<Item> NETHERITE_SWORD = REPLACEMENT.register("netherite_sword", () -> new SwordItem(Tiers.WOOD, damage, speed, (new Item.Properties().durability(1).setNoRepair().defaultDurability(1))));
    public static final RegistryObject<Item> NETHERITE_SHOVEL = REPLACEMENT.register("netherite_shovel", () -> new ShovelItem(Tiers.WOOD, damage, speed, (new Item.Properties().durability(1).setNoRepair().defaultDurability(1))));
    public static final RegistryObject<Item> NETHERITE_PICKAXE = REPLACEMENT.register("netherite_pickaxe", () -> new PickaxeItem(Tiers.WOOD, damage, speed, (new Item.Properties().durability(1).setNoRepair().defaultDurability(1))));
    public static final RegistryObject<Item> NETHERITE_AXE = REPLACEMENT.register("netherite_axe", () -> new AxeItem(Tiers.WOOD, damage, speed, (new Item.Properties().durability(1).setNoRepair().defaultDurability(1))));
    public static final RegistryObject<Item> NETHERITE_HOE = REPLACEMENT.register("netherite_hoe", () -> new HoeItem(Tiers.WOOD, damage, speed, (new Item.Properties().durability(1).setNoRepair().defaultDurability(1))));
    
    
    // Register method for attaching this to the event bus
    public static void register(IEventBus eventBus)
    {
        REPLACEMENT.register(eventBus);
    }
}
