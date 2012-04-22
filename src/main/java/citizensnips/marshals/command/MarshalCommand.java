package citizensnips.marshals.command;

import citizensnips.marshals.MarshalsPlugin;
import com.dumptruckman.minecraft.pluginbase.plugin.command.PluginCommand;

/**
 * An abstract ChestRestock command.
 */
public abstract class MarshalCommand extends PluginCommand<MarshalsPlugin> {

    public MarshalCommand(MarshalsPlugin plugin) {
        super(plugin);
    }
}
