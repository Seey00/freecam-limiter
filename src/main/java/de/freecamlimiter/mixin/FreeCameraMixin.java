package de.freecamlimiter.mixin;

import de.freecamlimiter.FreecamLimiter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Keeps the Freecam camera entity within maxDistance of the player (stops looking at the world's cut edge). */
@Pseudo
@Mixin(targets = "net.xolt.freecam.util.FreeCamera", remap = false)
public class FreeCameraMixin {
	@Inject(method = "tick", at = @At("TAIL"))
	private void freecamlimiter$leash(CallbackInfo ci) {
		if (!FreecamLimiter.active()) return;
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null) return;

		Entity cam = (Entity) (Object) this;
		double max = FreecamLimiter.maxDistance;
		Vec3 origin = player.getEyePosition();
		Vec3 offset = cam.position().subtract(origin);
		double dist = offset.length();
		if (dist <= max) return;

		// Prefer the last valid position (stays collision-safe); otherwise pull back along the line to the player.
		Vec3 previous = new Vec3(cam.xo, cam.yo, cam.zo);
		Vec3 target = previous.distanceTo(origin) <= max ? previous : origin.add(offset.scale(max / dist));
		cam.setPos(target.x, target.y, target.z);
		cam.setDeltaMovement(Vec3.ZERO);
	}
}
