package com.donthidebundles.mixin;

import net.minecraft.client.gui.screens.inventory.tooltip.ClientBundleTooltip;
import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientBundleTooltip.class)
public class ClientBundleTooltipMixin {

    @Shadow
    @Final
    private BundleContents contents;

    @Inject(method = "slotCount", at = @At("HEAD"), cancellable = true)
    private void iSlotCount(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(this.contents.size());
    }

    @Inject(method = "shouldRenderSurplusText", at = @At("HEAD"), cancellable = true)
    private static void iShouldRenderSurplusText(boolean bl, int i, int j, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
