package de.freecamlimiter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public final class FreecamLimiterClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		PayloadTypeRegistry.clientboundPlay().register(ConfigPayload.TYPE, ConfigPayload.CODEC);
		ClientPlayNetworking.registerGlobalReceiver(ConfigPayload.TYPE,
				(payload, context) -> FreecamLimiter.maxDistance = Math.max(8, payload.maxDistance()));
		ClientPlayConnectionEvents.DISCONNECT.register((handler, client) ->
				FreecamLimiter.maxDistance = FreecamLimiter.DEFAULT_MAX_DISTANCE);
	}
}
