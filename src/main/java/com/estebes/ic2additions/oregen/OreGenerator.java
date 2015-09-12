package com.estebes.ic2additions.oregen;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class OreGenerator implements IWorldGenerator
{
    private class WorldGenInfo {

        private int amount;
        private int minY, maxY;

        private WorldGenInfo(int amount, int minY, int maxY) {
            this.amount = amount;
            this.minY = minY;
            this.maxY = maxY;
        }
    }

    public static final OreGenerator INSTANCE = new OreGenerator();

    private final Map<WorldGenMinable, WorldGenInfo> map = Maps.newHashMap();

    public void addFeature(Block block, int count, int amount)
    {
        //
        addFeature(block, count, amount, 40, 60);
    }

    public void addFeature(Block block, int count, int amount, int minY, int maxY)
    {
        //
        map.put(new WorldGenMinable(block, count), new WorldGenInfo(amount, minY, maxY));
    }

    protected void genStandardOre(WorldGenMinable gen, WorldGenInfo info, World world, Random random, int x, int z)
    {
        int var15 = Integer.parseInt((new SimpleDateFormat("Mdd")).format(new Date()));
        int baseScale = Math.round((float)(var15 * 0.1));
        int baseCount = 1 * baseScale / 64;
        int count = (int)Math.round(random.nextGaussian() * Math.sqrt((double)baseCount) + (double)baseCount);
        for (int l = 0; l < count; ++l)
        {
            int avgX = x + random.nextInt(16);
            int avgY = random.nextInt(64 * var15 / 64);
            //info.minY + random.nextInt(info.maxY - info.minY) + 1;
            int avgZ = z + random.nextInt(16);
            if (random.nextDouble() < 0.5D)
            {
                gen.generate(world, random, avgX, avgY, avgZ);
            }
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        for (WorldGenMinable gen : map.keySet())
        {
            genStandardOre(gen, map.get(gen), world, random, chunkX * 16, chunkZ * 16);
        }
    }
}
