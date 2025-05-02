package rs.onako2.bundlecrashfix;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientSelectBundleItem;

public class BundleSelectPacketListener implements PacketListener {
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        if (event.getPacketType() != PacketType.Play.Client.SELECT_BUNDLE_ITEM)
            return;

        WrapperPlayClientSelectBundleItem selectBundleItem = new WrapperPlayClientSelectBundleItem(event);

        if (selectBundleItem.getSelectedItemIndex() < -1) {
            event.setCancelled(true);
        }
    }
}
