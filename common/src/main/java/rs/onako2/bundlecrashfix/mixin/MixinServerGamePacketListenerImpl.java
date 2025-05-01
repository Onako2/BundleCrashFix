package rs.onako2.bundlecrashfix.mixin;

import net.minecraft.network.protocol.game.ServerboundSelectBundleItemPacket;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerGamePacketListenerImpl.class)
public class MixinServerGamePacketListenerImpl {

    @Inject(method = "handleBundleItemSelectedPacket", at = @At("HEAD"), cancellable = true)
    private void onBundleItemSelected(ServerboundSelectBundleItemPacket packet, CallbackInfo ci) {
        if (packet.selectedItemIndex() < -1) {
            ci.cancel();
        }
    }
}
