package rs.onako2.bundlecrashfix;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.retrooper.packetevents.velocity.factory.VelocityPacketEventsBuilder;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
        id = "bundlecrashfix",
        name = "BundleCrashFix",
        version = BuildConstants.VERSION,
        description = "Prevent bad people from crashing your server with the Bundle crashing method",
        authors = {"Onako2"}
)
public class MainVelocity {
    private final Logger logger;
    private final ProxyServer server;
    private final Path dataDirectory;

    @Inject
    public MainVelocity(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        PacketEvents.setAPI(VelocityPacketEventsBuilder.build(server, server.getPluginManager().ensurePluginContainer(this), logger, dataDirectory));
        PacketEvents.getAPI().load();
        PacketEvents.getAPI().getEventManager().registerListener(
                new BundleSelectPacketListener(), PacketListenerPriority.NORMAL);
        PacketEvents.getAPI().init();
    }
    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        PacketEvents.getAPI().terminate();
    }
}