package citizensnips.marshals;

import citizensnips.marshals.api.MarshalConfig;
import citizensnips.marshals.command.CheckCommand;
import citizensnips.marshals.util.CommentedConfig;
import citizensnips.marshals.util.Language;
import com.dumptruckman.minecraft.pluginbase.plugin.AbstractBukkitPlugin;
import com.dumptruckman.minecraft.pluginbase.plugin.command.HelpCommand;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MarshalsPlugin extends AbstractBukkitPlugin<MarshalConfig> implements ChestRestock {

    private final List<String> cmdPrefixes = Arrays.asList("cr");

    private ChestManager chestManager = null;
    private LootConfig lootConfig = null;

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
        getCommandHandler().registerCommand(new CreateCommand(this));
        getCommandHandler().registerCommand(new UpdateCommand(this));
        getCommandHandler().registerCommand(new CheckCommand(this));
        getCommandHandler().registerCommand(new DisableCommand(this));
        getCommandHandler().registerCommand(new SetCommand(this));
        getCommandHandler().registerCommand(new RestockCommand(this));
    }

    @Override
    public void preReload() {
        chestManager = null;
        lootConfig = null;
    }

    @Override
    public void postReload() {
        long ticks = config().get(MarshalConfig.RESTOCK_TASK) * 20;
        if (ticks > 0) {
            getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                @Override
                public void run() {
                    getChestManager().pollChests();
                }
            }, ticks, ticks);
        }
        getLootConfig();
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
        super.onDisable();
    }

    @Override
    public List<String> getCommandPrefixes() {
        return cmdPrefixes;
    }

    @Override
    public ChestManager getChestManager() {
        if (chestManager == null) {
            chestManager = new DefaultChestManager(this);
        }
        return chestManager;
    }

    @Override
    public LootConfig getLootConfig() {
        if (lootConfig == null) {
            lootConfig = new DefaultLootConfig(this);
        }
        return lootConfig;
    }

    @Override
    public boolean hasChestManagerLoaded() {
        if (chestManager == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<String> dumpVersionInfo() {
        List<String> versionInfo = new LinkedList<String>();
        versionInfo.add("Restock task period: " + config().get(MarshalConfig.RESTOCK_TASK));
        versionInfo.add("Chests to poll: " + getChestManager().getNumberChestsPolled());
        versionInfo.add("Chests cached: " + getChestManager().getNumberCachedChests());
        return versionInfo;
    }
}
