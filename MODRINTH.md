# Modrinth project — fields to fill in (modrinth.com → "+" → Create a project)

## Create dialog
- Name: Freecam Limiter
- URL (slug): freecam-limiter   (if taken: freecam-limiter-mod)
- Visibility: Unlisted
- Summary (short description):
  Keeps the Freecam mod fair on multiplayer servers: the camera can't fly through blocks and stays within 100 blocks of you.

## Settings → General
- Icon: icon.png (this folder)
- Project type: Mod

## Settings → Tags
- Categories: Utility (primary), Game Mechanics
- Environment ("Client and server" section): Client-side **required**, Server-side **unsupported**
  (newer UI: "Client only")

## Settings → License
- MIT License

## Settings → Links
- Source code: https://github.com/Seey00/freecam-limiter
- Issues:      https://github.com/Seey00/freecam-limiter/issues

## Description (paste the whole block)
---8<---
**Freecam Limiter** keeps the [Freecam](https://modrinth.com/mod/freecam) mod fair on multiplayer servers.

### What it does
- 🧱 **Collision:** in multiplayer, the free camera collides with blocks. No more flying through walls, floors or other people's bases.
- 📏 **Distance limit:** the camera stays within **100 blocks** of your player (servers can change this). Flying further just stops at the edge, so you can't look at the cut-open side of the loaded world to find caves and ores.
- 🏠 **Singleplayer & your own LAN world:** no limits, Freecam works as usual.
- Without Freecam installed, this mod does nothing.

Freecam stays useful: look around corners, check your build from above, take screenshots.

> ⚠️ The limits apply on **every** multiplayer server while the mod is installed. Remove it if you play somewhere freecam is unrestricted.

### Requirements
- Minecraft 26.3, Fabric Loader, **Fabric API**
- **Freecam** 1.5.x by hashalite & Matt Sturgeon (optional dependency — the mod only acts when it's installed)

### For server owners
The mod registers the plugin channel `staffel5:freecam`.
- **Require it:** kick players who didn't register that channel (Paper: `player.getListeningPluginChannels()`).
- **Change the distance:** send a plugin message on that channel with one VarInt = max distance in blocks (min 8).

This is a fair-play tool for friendly servers, not an anti-cheat — modified clients can ignore it. Pair it with Paper's built-in anti-xray.

### Credits
Inspired by AntiFreecam by Kesuaheli. Works with Freecam by hashalite & Matt Sturgeon; not affiliated with it. Open source (MIT).

---
🇩🇪 **Kurz auf Deutsch:** Im Multiplayer geht Freecam nicht mehr durch Blöcke und bleibt max. 100 Blöcke bei deinem Spieler (Server kann das ändern). Im Einzelspieler keine Einschränkung. Benötigt Fabric API.
---8<---

## Versions → Upload a version
- File: build/libs/freecam-limiter-1.1.1.jar
- Version name: Freecam Limiter 1.1.1
- Version number: 1.1.1
- Release channel: Release
- Loaders: Fabric
- Game versions: 26.3
- Dependencies:
  - Fabric API — Required
  - Freecam — Optional
- Changelog: First public release. Forced block collision + 100-block distance limit for Freecam in multiplayer; servers can require the mod and set the distance.

## Then: Submit for review
