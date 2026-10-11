# Freecam Limiter

A small client-side Fabric mod that keeps the [Freecam](https://modrinth.com/mod/freecam) mod fair on multiplayer servers.

- **Collision:** in multiplayer, the free camera collides with blocks, so it can't fly through walls, floors or bases.
- **Distance limit:** the camera stays within **100 blocks** of your player by default. Flying further just stops at the edge, so you can't look at the cut-open side of the loaded world.
- **Singleplayer / your own LAN world:** no limits, Freecam works as usual.
- Without Freecam installed the mod does nothing.

Freecam is still allowed: look around corners, check your build from above, take screenshots.

## Requirements
- Minecraft **26.3**, Fabric Loader ≥ 0.19, **Fabric API**
- [Freecam](https://modrinth.com/mod/freecam) 1.5.x (by hashalite & Matt Sturgeon) — optional, this mod only does something when it's installed

## For server owners
The mod registers the plugin channel `staffel5:freecam` (name kept for compatibility).
- **Require the mod:** check whether the player registered that channel (e.g. Paper: `player.getListeningPluginChannels()`), kick if not.
- **Set the distance:** send a plugin message on `staffel5:freecam` whose payload is one VarInt = max distance in blocks (minimum 8).
  Example (Paper): `player.sendPluginMessage(plugin, "staffel5:freecam", new byte[]{ 50 })` for 50 blocks (values < 128 are a single byte).

This is a fair-play tool for friendly servers, not an anti-cheat: modified clients can ignore it. Combine it with Paper's anti-xray.

## How it works
Two small mixins into Freecam 1.5.x: collision checks always return "collide" on multiplayer servers, and the camera entity is pulled back if it gets too far from the player. No Freecam code is included.

## Credits
Inspired by [AntiFreecam](https://github.com/Kesuaheli/AntiFreecam) by Kesuaheli. Works with [Freecam](https://github.com/MinecraftFreecam/Freecam) by hashalite & Matt Sturgeon. Not affiliated with either project.

## Building
JDK 25, Gradle 9.7: `gradle build` → `build/libs/freecam-limiter-<version>.jar`

## License
MIT, see [LICENSE](LICENSE).

---

### Deutsch (kurz)
Client-Mod für Fabric: Im Multiplayer geht Freecam nicht mehr durch Blöcke und bleibt höchstens 100 Blöcke (vom Server einstellbar) bei deinem Spieler. Im Einzelspieler keine Einschränkung. Benötigt Fabric API; wirkt nur zusammen mit dem Freecam-Mod.
