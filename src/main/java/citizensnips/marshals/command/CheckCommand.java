package citizensnips.marshals.command;

import citizensnips.marshals.MarshalsPlugin;
import citizensnips.marshals.util.Language;
import citizensnips.marshals.util.Perms;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

import java.util.List;

import static citizensnips.marshals.api.CRChest.*;

public class CheckCommand extends TargetedChestRestockCommand {

    public CheckCommand(MarshalsPlugin plugin) {
        super(plugin);
        this.setName(messager.getMessage(Language.CMD_CHECK_NAME));
        this.setCommandUsage(plugin.getCommandPrefixes().get(0) + " check");
        this.setArgRange(0, 0);
        for (String prefix : plugin.getCommandPrefixes()) {
            this.addKey(prefix + " check");
        }
        this.addCommandExample("/" + plugin.getCommandPrefixes().get(0) + " check");
        this.setPermission(Perms.CMD_CHECK.getPermission());
    }

    @Override
    public void runCommand(Player player, Block block, List<String> strings) {
        CRChest rChest = chestManager.getChest(block, (InventoryHolder) block.getState());
        if (rChest == null) {
            messager.normal(Language.CMD_NOT_RCHEST, player);
            return;
        }
        messager.normal(Language.CMD_CHECK_SUCCESS, player, rChest.get(NAME),
                rChest.get(PERIOD), rChest.get(RESTOCK_MODE), rChest.get(PERIOD_MODE),
                rChest.get(PRESERVE_SLOTS), rChest.get(INDESTRUCTIBLE), rChest.get(PLAYER_LIMIT),
                rChest.get(UNIQUE), rChest.get(REDSTONE));
        messager.normal(Language.CMD_CHECK_GLOBAL_MESSAGE, player, rChest.get(ACCEPT_POLL),
                rChest.get(GLOBAL_MESSAGE), rChest.get(LOOT_TABLE));
    }
}
