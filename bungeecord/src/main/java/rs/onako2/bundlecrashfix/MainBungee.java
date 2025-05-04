package rs.onako2.bundlecrashfix;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import io.github.retrooper.packetevents.bungee.factory.BungeePacketEventsBuilder;
import net.md_5.bungee.api.plugin.Plugin;

public class MainBungee extends Plugin {

    @Override
    public void onLoad() {
        PacketEvents.setAPI(BungeePacketEventsBuilder.build(this));
        PacketEvents.getAPI().load();
        PacketEvents.getAPI().getEventManager().registerListener(
                new BundleSelectPacketListener(), PacketListenerPriority.NORMAL);
    }

    @Override
    public void onEnable() {
        PacketEvents.getAPI().init();
        Constants.LOG.info("Your Minecraft is now protected against the Bundle crash exploit!");
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }
}
