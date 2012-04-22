package citizensnips.marshals.command;

import citizensnips.marshals.MarshalsPlugin;
import citizensnips.marshals.util.Perms;
import org.bukkit.command.CommandSender;
import java.util.List;

public class ShackleCommand extends MarshalCommand {

    public ShackleCommand(MarshalsPlugin plugin) {
        super(plugin);
        this.setName("Shackles next target");
        this.setCommandUsage("/shackle");
        this.setArgRange(0, 0);
        this.addCommandExample("/shackle");
        this.setPermission(Perms.CMD_SHACKLE.getPermission());
    }

    @Override
    public void runCommand(CommandSender sender, List<String> strings) {

        }
 }
