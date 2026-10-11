package de.freecamlimiter;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

/** Server -> client on staffel5:freecam (channel name kept for compatibility): allowed freecam distance as VarInt. Registering it also tells the server the mod is installed. */
public record ConfigPayload(int maxDistance) implements CustomPacketPayload {
	public static final Type<ConfigPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath("staffel5", "freecam"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ConfigPayload> CODEC =
			StreamCodec.composite(ByteBufCodecs.VAR_INT, ConfigPayload::maxDistance, ConfigPayload::new);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
