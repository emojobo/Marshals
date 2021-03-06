package citizensnips.marshals;

import citizensnips.marshals.api.MarshalConfig;
import citizensnips.marshals.command.ShackleCommand;
import citizensnips.marshals.util.CommentedConfig;
import citizensnips.marshals.util.Language;
import com.dumptruckman.minecraft.pluginbase.plugin.AbstractBukkitPlugin;
import com.dumptruckman.minecraft.pluginbase.plugin.command.HelpCommand;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MarshalsPlugin extends AbstractBukkitPlugin<MarshalConfig> {

    private final List<String> cmdPrefixes = Arrays.asList("marshal");
    private final Set<Player> playersUsingShackle = new HashSet<Player>();

    @Override
    protected MarshalConfig newConfigInstance() throws IOException {
        return new CommentedConfig(this, true, new File(getDataFolder(), "config.yml"), MarshalConfig.class);
    }

    @Override
    public void preEnable() {
        Language.init();
        HelpCommand.addStaticPrefixedKey("");
    }

    @Override
    public void postEnable() {
        getServer().getPluginManager().registerEvents(new MarshalsListener(this), this);
        getCommandHandler().registerCommand(new ShackleCommand(this));
    }


    @Override
    public List<String> dumpVersionInfo() {
        List<String> versionInfo = new LinkedList<String>();

        return versionInfo;
    }

    @Override
    public List<String> getCommandPrefixes() {
        return cmdPrefixes;
    }

    public Set<Player> getPlayersUsingShackle() {
        return playersUsingShackle;
    }
}