package net.nilsgk.thermies_tinkering.common.modifiers;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.nilsgk.thermies_tinkering.ThermiesTinkering;
import slimeknights.mantle.registration.object.EnumObject;
import slimeknights.tconstruct.common.TinkerModule;
import slimeknights.tconstruct.common.TinkerEffect;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;
import slimeknights.tconstruct.tools.stats.ToolType;

public class ThermiesTinkeringModifiers extends TinkerModule {
    public static final ModifierDeferredRegister MODIFERS = ModifierDeferredRegister.create(ThermiesTinkering.MODID);

    public static final StaticModifier<BloodThirstyModifier> bloodthirsty = MODIFERS.register("bloodthirsty", BloodThirstyModifier::new);

    public static final EnumObject<ToolType, TinkerEffect> bloodthirstyEffect = MOB_EFFECTS.registerEnum("bloodthirsty", new ToolType[]{ToolType.MELEE}, type ->
            new NoMilkEffect(MobEffectCategory.BENEFICIAL, 0xf72d29, true)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, "6dd33723-fa16-4517-882b-ebc63b7a262b", 0.05, AttributeModifier.Operation.MULTIPLY_BASE));

}
