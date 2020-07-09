package wtf.boomy.mods.har;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HurtAnimationRemover.MOD_ID, version = HurtAnimationRemover.VERSION, acceptedMinecraftVersions = "[1.8.8,1.8.9]", clientSideOnly = true)
public class HurtAnimationRemover {
    
    public static final String MOD_ID = "hurtanimationremover-port";
    public static final String VERSION = "1.0";
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModMetadata data = event.getModMetadata();
        data.name = "HurtAnimationRemover";
        data.modId = HurtAnimationRemover.MOD_ID;
        data.description = "Disables the screen shake from being hurt";
        data.authorList.add("boomboompower");
        data.version = HurtAnimationRemover.VERSION;
    }
    
}
