package wtf.boomy.mods.har.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.GameRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinGameRenderer  {
    
    @Inject(method = "hurtCameraEffect", at = @At(value = "HEAD"), cancellable = true)
    private void injectHurtCameraEffect(MatrixStack matrixStackIn, float partialTicks, CallbackInfo ci) {
        ci.cancel();
    }
}
