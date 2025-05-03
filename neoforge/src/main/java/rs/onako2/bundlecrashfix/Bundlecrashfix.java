package rs.onako2.bundlecrashfix;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class Bundlecrashfix {

    public Bundlecrashfix(IEventBus eventBus) {
        CommonClass.init();
    }
}
