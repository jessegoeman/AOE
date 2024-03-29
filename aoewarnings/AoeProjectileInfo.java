package net.runelite.client.plugins.aoewarnings;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.ProjectileID;

public enum AoeProjectileInfo
{
    LIZARDMAN_SHAMAN_AOE(ProjectileID.LIZARDMAN_SHAMAN_AOE, 3000, 3),
    CRAZY_ARCHAEOLOGIST_AOE(ProjectileID.CRAZY_ARCHAEOLOGIST_AOE, 3000, 3),
    ICE_DEMON_RANGED_AOE(ProjectileID.ICE_DEMON_RANGED_AOE, 3000, 3),
    /**
     * When you don't have pray range on ice demon does an ice barrage
     */
    ICE_DEMON_ICE_BARRAGE_AOE(ProjectileID.ICE_DEMON_ICE_BARRAGE_AOE, 3000, 3),
    /**
     * The AOE when vasa first starts
     */
    VASA_AWAKEN_AOE(ProjectileID.VASA_AWAKEN_AOE, 4500, 3),
    VASA_RANGED_AOE(ProjectileID.VASA_RANGED_AOE, 3000, 3),
    TEKTON_METEOR_AOE(ProjectileID.TEKTON_METEOR_AOE, 4000, 3),

    /**
     * The AOEs of Vorkath
     */
    VORKATH_BOMB(ProjectileID.VORKATH_BOMB_AOE, 2400, 3),
    VORKATH_POISON_POOL(ProjectileID.VORKATH_POISON_POOL_AOE, 1800, 1),
    VORKATH_SPAWN(ProjectileID.VORKATH_SPAWN_AOE, 3000, 1), //extra tick because hard to see otherwise
    VORKATH_TICK_FIRE(ProjectileID.VORKATH_TICK_FIRE_AOE, 600, 1),

    /**
     * the AOEs of Galvek
     */
    GALVEK_MINE(ProjectileID.GALVEK_MINE, 3600, 3),
    GALVEK_BOMB(ProjectileID.GALVEK_BOMB, 2400, 3),

    /**
     * the AOE of Vet'ion
     */
    VETION_LIGHTNING(ProjectileID.VETION_LIGHTNING, 3000, 1),

    /**
     * the AOE of Chaos Fanatic
     */
    CHAOS_FANATIC(ProjectileID.CHAOS_FANATIC_AOE, 3000, 1),

    /**
     * the AOE of the Corporeal Beast
     */

    CORPOREAL_BEAST(ProjectileID.CORPOREAL_BEAST_AOE, 3000, 1),
    CORPOREAL_BEAST_DARK_CORE(ProjectileID.CORPOREAL_BEAST_DARK_CORE_AOE, 3000, 3),

    /**
     * the AOEs of The Great Olm
     * missing ids and length, please help
     */
    OLM_FALLING_CRYSTAL(ProjectileID.OLM_FALLING_CRYSTAL_AOE, 2400, 3),
    OLM_BURNING(ProjectileID.OLM_BURNING_AOE, 2400, 3),

    /**
     * the AOE of the Wintertodt snow that falls
     */
    WINTERTODT_SNOW_FALL(ProjectileID.WINTERTODT_SNOW_FALL_AOE, 4000, 3);


    /**
     * The id of the projectile to trigger this AoE warning
     */
    private final int id;

    /**
     * How long the indicator should last for this AoE warning This might
     * need to be a bit longer than the projectile actually takes to land as
     * there is a fade effect on the warning
     */
    private final Duration lifeTime;

    /**
     * The size of the splash radius of the AoE warning Ex. Lizardman shaman
     * AoE is a 3x3, so aoeSize = 3
     */
    private final int aoeSize;

    private static final Map<Integer, AoeProjectileInfo> map = new HashMap<>();

    static
    {
        for (AoeProjectileInfo aoe : values())
        {
            map.put(aoe.id, aoe);
        }
    }

    AoeProjectileInfo(int id, int lifeTimeMillis, int aoeSize)
    {
        this.id = id;
        this.lifeTime = Duration.ofMillis(lifeTimeMillis);
        this.aoeSize = aoeSize;
    }

    public Duration getLifeTime()
    {
        return lifeTime;
    }

    public int getId()
    {
        return id;
    }

    public int getAoeSize()
    {
        return aoeSize;
    }

    public static AoeProjectileInfo getById(int id)
    {
        return map.get(id);
    }
}