package rs.onako2.bundlecrashfix.platform;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import rs.onako2.bundlecrashfix.platform.services.IPlatformHelper;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}
