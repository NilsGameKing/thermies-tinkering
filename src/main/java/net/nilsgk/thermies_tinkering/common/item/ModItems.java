package net.nilsgk.thermies_tinkering.common.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nilsgk.thermies_tinkering.ThermiesTinkering;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThermiesTinkering.MODID);

    public static final RegistryObject<Item> HARDBLOOD_INGOT = ITEMS.register("hardblood_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HARDBLOOD_NUGGET = ITEMS.register("hardblood_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
