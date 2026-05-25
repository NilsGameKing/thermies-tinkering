package net.nilsgk.thermies_tinkering.common.modifiers;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.common.TinkerEffect;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.shared.TinkerEffects;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.effect.BleedingEffect;
import slimeknights.tconstruct.tools.stats.ToolType;

import java.util.List;

public class BloodThirstyModifier extends Modifier implements MeleeHitModifierHook, TooltipModifierHook {
    private static final Component STACKS = TConstruct.makeTranslation("modifier", "bloodthirsty.stacks");

    //applies effect to target WORKS
    public static void applyEffect(LivingEntity living, ToolType type, int duration, int add, int maxLevel) {
        TinkerEffect effect = ThermiesTinkeringModifiers.bloodthirstyEffect.get(type);
        effect.apply(living, duration, Math.min(maxLevel, TinkerEffect.getAmplifier(living,effect) + add), true);
        if(TinkerEffect.getAmplifier(living,effect) >= 49){
            living.removeEffect(effect);
            living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 8 * 20, 2));
            living.addEffect(new MobEffectInstance(MobEffects.SATURATION, 8 * 20, 2));
        }
    }

    // this WORKS
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT, ModifierHooks.TOOLTIP);
    }

    //gives effect if goon dead THIS WORKS
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (context.getLivingTarget().isDeadOrDying()) {
            applyEffect(context.getAttacker(), ToolType.MELEE, 5 * 20, 1 * modifier.getLevel(),  49);
        }
        if (context.getLivingTarget().hasEffect(TinkerEffects.bleeding.get())) {
            applyEffect(context.getAttacker(), ToolType.MELEE, 5 * 20, 1,  49);
        }
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        TooltipModifierHook.addFlatBoost(this, STACKS, TinkerEffect.getAmplifier(player, ThermiesTinkeringModifiers.bloodthirstyEffect.get(ToolType.MELEE)) + 1, tooltip);
    }
}
