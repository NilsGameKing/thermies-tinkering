package net.nilsgk.thermies_tinkering.common.fluids;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.nilsgk.thermies_tinkering.ThermiesTinkering;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.fluids.fluids.SlimeFluid;

import static slimeknights.tconstruct.fluids.block.MobEffectLiquidBlock.createEffect;

public class ModFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(ThermiesTinkering.MODID);

//    public static final FlowingFluidObject<ForgeFlowingFluid> SANGUINE = FLUIDS.register("sanguine")
//            .type(slime("sanguine").temperature(1100).lightLevel(2)).bucket().block(MapColor.COLOR_RED, 1).flowing(SlimeFluid.Source::new, SlimeFluid.Flowing::new);
//
//    public static final FlowingFluidObject<ForgeFlowingFluid> SANGUINE = register("sanguine", 5000, 5000, 1100, 3, MapColor.COLOR_RED);

    public static final FlowingFluidObject<ForgeFlowingFluid> SANGUINE = FLUIDS.register("sanguine")
            .type(notYowie("sanguine")
                    .density(1600)
                    .viscosity(1600)
                    .temperature((950))
                    .lightLevel(3))
            .bucket()
            .block(MapColor.COLOR_RED, 3)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .tickRate(70).flowing();


    //code i stole from slimeknights without learning it
    private static FluidType.Properties notYowie(String name/*, int density, int viscosity, int temperature*/) {
        return FluidType.Properties.create()//.density(density).viscosity(viscosity).temperature(temperature)
                .descriptionId(TConstruct.makeDescriptionId("fluid", name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .canExtinguish(true);
    }

    //fluid that dont hurt
    //private static FlowingFluidObject<ForgeFlowingFluid> register(String name, int density, int viscosity, int temperature, int lightLevel, MapColor mapColor) {
    //    return FLUIDS.register(name).type(notYowie(name, density, viscosity, temperature)).block(mapColor, lightLevel).bucket().flowing();
    //}

    public static void register(IEventBus eventBus) { FLUIDS.register(eventBus); }
}
