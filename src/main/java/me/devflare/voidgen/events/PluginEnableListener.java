package me.devflare.voidgen.events;

import me.devflare.voidgen.VoidGen;
import me.devflare.voidgen.hooks.MultiverseGeneratorPluginHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.mvplugins.multiverse.core.MultiverseCoreApi;

import java.lang.reflect.InvocationTargetException;

public class PluginEnableListener implements Listener {

    private final VoidGen voidGen;

    public PluginEnableListener(VoidGen voidGen) {
        this.voidGen = voidGen;
        this.voidGen.getServer().getPluginManager().registerEvents(this, voidGen);
    }

    /**
     * Detects when Multiverse-Core is enabled and attempts to register VoidGen's generator hook with it.
     *
     * <p>If the hookup succeeds an info message is logged; if it fails (for example due to an incompatible
     * Multiverse-Core version) warning messages are logged advising an update to Multiverse-Core 5.0.0 or above.</p>
     *
     * @param event the plugin enable event that triggered this handler
     */
    @EventHandler(priority = EventPriority.LOW)
    public void onPluginLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equals("Multiverse-Core")) {
            try {
                Class.forName("org.mvplugins.multiverse.core.MultiverseCoreApi");
                MultiverseCoreApi.get().getGeneratorProvider().registerGeneratorPlugin(MultiverseGeneratorPluginHook.class.getDeclaredConstructor().newInstance());
                this.voidGen.getLogger().info("VoidGen hooked into Multiverse!");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException | ClassNotFoundException ex) {
                this.voidGen.getLogger().warning("VoidGen tried to hook into Multiverse-Core, but you're using an outdated version of it!");
                this.voidGen.getLogger().warning("Please update Multiverse-Core to the latest version (5.0.0 or above)!");
                this.voidGen.getLogger().warning("If this doesn't apply for your server version, please ignore.");
            }
        }
    }

    public void terminate() {
        PlayerLoginEvent.getHandlerList().unregister(this.voidGen);
    }
}