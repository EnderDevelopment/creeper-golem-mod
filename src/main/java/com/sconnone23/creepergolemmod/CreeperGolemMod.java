package com.sconnone23.creepergolemmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreeperGolemMod implements ModInitializer {
    public static final String MOD_ID = "creepergolemmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final EntityType<CreeperGolemEntity> CREEPER_GOLEM = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "creeper_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, CreeperGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1.4f, 2.7f))
                    .build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(CREEPER_GOLEM, CreeperGolemEntity.createCreeperGolemAttributes());
        LOGGER.info("Creeper Golem Mod initialized");
    }
}