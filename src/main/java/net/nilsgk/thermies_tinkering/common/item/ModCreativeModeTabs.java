package net.nilsgk.thermies_tinkering.common.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nilsgk.thermies_tinkering.ThermiesTinkering;
import net.nilsgk.thermies_tinkering.common.block.ModBlocks;
import net.nilsgk.thermies_tinkering.common.fluids.ModFluids;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermiesTinkering.MODID);

    public static final RegistryObject<CreativeModeTab> THERMIES_THINGS = CREATIVE_MODE_TABS.register("thermies_things",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.HARDBLOOD_BLOCK.get()))
                    .title(Component.translatable("creativetab.thermies_things"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.HARDBLOOD_INGOT.get());
                        pOutput.accept(ModItems.HARDBLOOD_NUGGET.get());
                        pOutput.accept(ModBlocks.HARDBLOOD_BLOCK.get());
                        pOutput.accept(ModItems.BOTTLE_OF_SANGUINE.get());
                        pOutput.accept(ModFluids.SANGUINE.getBucket());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
