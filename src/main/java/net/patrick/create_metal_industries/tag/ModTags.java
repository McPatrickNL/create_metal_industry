package net.patrick.create_metal_industries.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.patrick.create_metal_industries.CreateMetalIndustries;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> DUMMY_FOR_TESTING = tag("dummy_for_testing");
        
        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(CreateMetalIndustries.MOD_ID, name));
        }
    }
    
    public static class Items
    {
        public static final TagKey<Item> BRASS = tag("brass");
        public static final TagKey<Item> COPPER = tag("copper");
        public static final TagKey<Item> GOLD = tag("gold");
        public static final TagKey<Item> IRON = tag("iron");
        public static final TagKey<Item> NETHERITE = tag("netherite");
        public static final TagKey<Item> ZINC = tag("zinc");
        
        // assumption
        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(CreateMetalIndustries.MOD_ID, name));
        }
    }
}
