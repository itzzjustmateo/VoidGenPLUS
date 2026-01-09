# VoidGen+ Tutorial

This guide explains how to install and configure **VoidGen+**, allowing your Minecraft server to generate fully customizable void-based worlds.

---

## Step 0 — Install the Plugin

1. Stop your Minecraft server.
2. Download the latest release of **VoidGen+**.
3. Place the `.jar` file into your server’s `plugins/` directory.
4. Start the server.
5. Verify that the plugin loaded successfully by running:

   ```
   /plugins
   ```

   or:

   ```
   /pl
   ```

   You should see **VoidGenPLUS** listed in green text in the console.

---

## Recommended Setup — Multiverse-Core (Primary Method)

**Multiverse-Core is the officially supported and recommended way** to create and manage VoidGen+ worlds.

> `bukkit.yml` is the **vanilla Minecraft method** of world management. While it currently works, it is considered legacy and **will not receive further development or support** if this option is removed in the future.

VoidGen+ development focuses entirely on **Multiverse-Core integration** to ensure stability, compatibility, and ease of use.

---

## Creating Worlds with Multiverse-Core

After installing **Multiverse-Core**, use the following command to create a VoidGen+ world:

```bash
/mv create <worldname> normal --world-type flat --generator VoidGen --no-structures
```

Replace `<worldname>` with your desired world name.

---

## Recommended Multiverse Settings

The following options are **strongly recommended** when creating VoidGen+ worlds using Multiverse-Core.

| Setting      | Value      | Reason                                                |
| ------------ | ---------- |-------------------------------------------------------|
| Environment  | `normal`   | Required for standard overworld-style generation      |
| World Type   | `flat`     | Prevents vanilla terrain noise                        |
| Generator    | `VoidGen`  | Activates VoidGen+                                    |
| Structures   | `disabled` | Prevents unwanted vanilla structures                  |
| Seed         | Optional   | VoidGen+ does show no changes if you'll use a seed |
| Adjust Spawn | Disabled   | Avoids unexpected spawn shifts                        |

---

## Managing Worlds (Multiverse-Core)

Common commands for managing VoidGen+ worlds:

```bash
/mv list
/mv unload <worldname>
/mv load <worldname>
/mv delete <worldname>
```

These commands allow safe world control without editing server files.

---

## Legacy Setup — `bukkit.yml` (Not Recommended)

Configuring worlds via `bukkit.yml` is considered the **vanilla** method of world management.

> ⚠️ This method is **not actively supported** and **will not receive further improvements**.

If support for `bukkit.yml` is removed in the future, **VoidGen+ will not provide backward compatibility**.

### Example (Legacy)

```yaml
worlds:
  void_world:
    generator: VoidGen
```

This method should only be used for legacy servers or testing purposes.

---

## Advanced — Layered Worlds

VoidGen+ supports custom layered world generation through generator parameters.

> This feature currently requires configuration via `bukkit.yml`, which is considered legacy and will not be supported in future releases.

### Superflat Example

```yaml
worlds:
  superflat:
    generator: VoidGen:{"biome":"plains","layers":[{"block":"bedrock","height":1},{"block":"dirt","height":2},{"block":"grass_block","height":1}]}
```

### Nether-Style Void World

```yaml
worlds:
  nether_void:
    generator: VoidGen:{"biome":"nether_wastes","layers":[{"block":"bedrock","height":1},{"block":"netherrack","height":40}]}
```

---

## Layer Object Structure

| Key      | Type              | Description                   |
| -------- | ----------------- | ----------------------------- |
| `block`  | string            | Minecraft block identifier    |
| `height` | integer           | Number of blocks in the layer |
| `data`   | object (optional) | Additional block state data   |

---

## Notes

* Layer order matters: the first layer is placed at the bottom
* Invalid parameters fall back to default behavior
* Always validate JSON when editing parameters

---

You are now ready to generate and manage VoidGen+ worlds using **Multiverse-Core**.
