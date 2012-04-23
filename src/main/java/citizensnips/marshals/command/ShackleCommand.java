package citizensnips.marshals.command;

import citizensnips.marshals.MarshalsPlugin;
import citizensnips.marshals.util.Language;
import citizensnips.marshals.util.Perms;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

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
          this.addKey("shackle");
          if (!(sender instanceof Player)){
            messager.bad(Language.IN_GAME_ONLY, sender);
            return;
          }
          Player player = (Player) sender;
          if(plugin.getPlayersUsingShackle().contains(player))
          {
             plugin.getPlayersUsingShackle().remove(player);
             messager.normal(Language.SHACKLE_OFF, player);
          }
          else
          {
             plugin.getPlayersUsingShackle().add(player);
             messager.normal(Language.SHACKLE_ON, player);
          }
        }
 }
