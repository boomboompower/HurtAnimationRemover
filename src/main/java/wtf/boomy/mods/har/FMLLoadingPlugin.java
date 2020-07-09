package wtf.boomy.mods.har;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * To load this in a dev environment, the following must be added to the VM args
 * -Dfml.coreMods.load=wtf.boomy.mods.har.FMLLoadingPlugin
 */
@IFMLLoadingPlugin.MCVersion("1.8.9")
@IFMLLoadingPlugin.TransformerExclusions({"wtf.boomy.mods"})
public class FMLLoadingPlugin implements IFMLLoadingPlugin {
    
    @Override
    public String[] getASMTransformerClass() {
        return new String[] { ClassTransformer.class.getName() };
    }
    
    @Override
    public String getModContainerClass() {
        return null;
    }
    
    @Override
    public String getSetupClass() {
        return null;
    }
    
    @Override
    public void injectData(Map<String, Object> data) { }
    
    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
