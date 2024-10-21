package net.patrick.create_metal_industries;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

import java.util.Arrays;

public class KeyBindings {
    public static final String CATEGORY = "key.category.create_metal_industries";
    public static final String TOOL_SPECIAL_ABILITY = "key.create_metal_industries.special_ability";
    
    public static KeyMapping toolSpecialAbilityKey;
    
    public static void registerKeyBindings() {
        // Register the custom keybinding for TAB
        toolSpecialAbilityKey = new KeyMapping(TOOL_SPECIAL_ABILITY, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_TAB, CATEGORY);
        
        // Register the keybinding in the Minecraft key mapping system
        KeyMapping[] allKeys = Minecraft.getInstance().options.keyMappings;
        KeyMapping[] newKeys = Arrays.copyOf(allKeys, allKeys.length + 1);
        newKeys[newKeys.length - 1] = toolSpecialAbilityKey;
        Minecraft.getInstance().options.keyMappings = newKeys;
    }
}
