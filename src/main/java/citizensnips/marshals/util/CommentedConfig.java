package citizensnips.marshals.util;

import citizensnips.marshals.api.MarshalConfig;
import com.dumptruckman.minecraft.pluginbase.config.AbstractYamlConfig;
import com.dumptruckman.minecraft.pluginbase.plugin.BukkitPlugin;

import java.io.File;
import java.io.IOException;

public class CommentedConfig extends AbstractYamlConfig<MarshalConfig> implements MarshalConfig {

    public CommentedConfig(BukkitPlugin plugin, boolean doComments, File configFile, Class<? extends MarshalConfig>... configClasses) throws IOException {
        super(plugin, doComments, configFile, configClasses);
    }

    @Override
    protected String getHeader() {
        return "";
    }
}
