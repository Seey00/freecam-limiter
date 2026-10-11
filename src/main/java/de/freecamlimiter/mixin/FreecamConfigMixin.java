package de.freecamlimiter.mixin;

import de.freecamlimiter.FreecamLimiter;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Forces block collision in the Freecam mod (MinecraftFreecam 1.5.x) on multiplayer servers. */
@Pseudo
@Mixin(targets = "net.xolt.freecam.config.model.ModConfigImpl", remap = false)
public class FreecamConfigMixin {
	@Inject(method = "ignoreCollisionWith", at = @At("HEAD"), cancellable = true)
	private void freecamlimiter$collideWithBlocks(Block block, CallbackInfoReturnable<Boolean> cir) {
		if (FreecamLimiter.active()) cir.setReturnValue(false);
	}

	@Inject(method = "ignoreAllCollision", at = @At("HEAD"), cancellable = true)
	private void freecamlimiter$noIgnoreAll(CallbackInfoReturnable<Boolean> cir) {
		if (FreecamLimiter.active()) cir.setReturnValue(false);
	}

	@Inject(method = "shouldCheckInitialCollision", at = @At("HEAD"), cancellable = true)
	private void freecamlimiter$checkInitial(CallbackInfoReturnable<Boolean> cir) {
		if (FreecamLimiter.active()) cir.setReturnValue(true);
	}
}
