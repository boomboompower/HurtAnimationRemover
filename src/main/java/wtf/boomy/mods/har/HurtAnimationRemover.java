package wtf.boomy.mods.har;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = HurtAnimationRemover.MOD_ID)
public class HurtAnimationRemover {
    
    public static final String MOD_ID = "har";
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    public HurtAnimationRemover() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Hello World!");
    }
}
