package com.donthidebundles.mixin;

import net.minecraft.world.item.component.BundleContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public abstract class BundleContentsMixin {
    @Shadow
    public abstract int size();

    @Inject(method = "getNumberOfItemsToShow", at = @At("HEAD"), cancellable = true)
    private void getNumber(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(this.size());
    }
}
