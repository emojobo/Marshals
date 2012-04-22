package citizensnips.marshals.command;

import citizensnips.marshals.MarshalsPlugin;
import citizensnips.marshals.util.Language;
import citizensnips.marshals.util.Perms;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

import java.util.List;

import static citizensnips.marshals.api.CRChest.*;

public class ShackleCommand extends MarshalCommand {

    public ShackleCommand(MarshalsPlugin plugin) {
        super(plugin);
        this.setName("Shackles next target"));
        this.setCommandUsage("/shackle");
        this.setArgRange(0, 0);
        this.addCommandExample("/shackle");
        this.setPermission(Perms.CMD_SHACKLE.getPermission());
    }

    @Override
    public void runCommand(CommandSender sender, List<String> strings) {

        }
    }
}
