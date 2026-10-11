package de.freecamlimiter;

import net.minecraft.client.Minecraft;

public final class FreecamLimiter {
	public static final double DEFAULT_MAX_DISTANCE = 100.0;

	/** Max distance (blocks) between the freecam and the player's eyes; the server may override it on join. */
	public static volatile double maxDistance = DEFAULT_MAX_DISTANCE;

	private FreecamLimiter() {}

	/** Limits apply on every multiplayer server, never in singleplayer / own LAN world. */
	public static boolean active() {
		Minecraft mc = Minecraft.getInstance();
		return mc.getCurrentServer() != null && !mc.hasSingleplayerServer();
	}
}
