package citizensnips.marshals.util;

import com.dumptruckman.minecraft.pluginbase.locale.Message;

public class Language {
    
    public static final Message IN_GAME_ONLY = new Message("cmd.in_game_only",
            "You may only use this command in game!");
    public static final Message TARGETING = new Message("cmd.targeting",
            "You must be targeting a chest to use this command!");
    public static final Message CMD_NOT_RCHEST = new Message("cmd.not_restock_chest",
            "The targeted chest is not managed by ChestRestock.");

    public static final Message CMD_CREATE_NAME = new Message("cmd.create.name",
            "Initiates targeted chest for restocking.");
    public static final Message CMD_CREATE_ALREADY_MADE = new Message("cmd.create.already_made",
            "This chest is already configured! Make use of the other sub-commands to change the options for this chest.",
            "To update the chest contents, use the update sub-command.");
    public static final Message CMD_CREATE_SUCCESS = new Message("cmd.create.success",
            "This chest will restock with the items currently inside of it, every %1 seconds. (default)");
    public static final Message CMD_CREATE_ERROR = new Message("cmd.create.error",
            "There was an internal error while creating a new restock chest.  Please refer to server.log");

    public static final Message CMD_CHECK_NAME = new Message("cmd.check.name",
            "Checks a chest and gives info relating to ChestRestock");
    public static final Message CMD_CHECK_SUCCESS = new Message("cmd.check.success",
            "Chest name: %1",
            "Chest restocks every %2 second(s)",
            "Chest restock mode: %3",
            "Chest period mode: %4",
            "Chest will preserve slots: %5",
            "Chest is indestructible: %6",
            "Chest player limit: %7",
            "Chest has unique inventory: %8",
            "Chest restocks when powered: %9");
    public static final Message CMD_CHECK_GLOBAL_MESSAGE = new Message("cmd.check.global_message",
            "Chest accepting polls: %1",
            "Chest global message: %2",
            "Chest loot table: %3");

    public static final Message CMD_UPDATE_NAME = new Message("cmd.update.name",
            "Updates the restocking contents of a chest.");
    public static final Message CMD_UPDATE_SUCCESS = new Message("cmd.update.success",
            "Chest will now restock with the items currently inside of it.");

    public static final Message CMD_DISABLE_NAME = new Message("cmd.disable.name",
            "Disables restocking for a chest.");
    public static final Message CMD_DISABLE_SUCCESS = new Message("cmd.disable.success",
            "Chest will no longer be managed by ChestRestock.");

    public static final Message CMD_RESTOCK_NAME = new Message("cmd.restock.name",
            "Restocks a chest immediately.");
    public static final Message CMD_RESTOCK_SUCCESS = new Message("cmd.restock.success",
            "Chest has been restocked!");

    public static final Message CMD_SET_NAME = new Message("cmd.set.name",
            "Sets a property of a restock chest.");
    public static final Message CMD_SET_NEW_CMD = new Message("cmd.set.new_cmd",
            "If you are trying to set up a restock chest, use the \"create\" command instead.");
    public static final Message CMD_SET_LIST_PROPS = new Message("cmd.set.list_props",
            "Possible properties you may set are: %1");
    public static final Message CMD_SET_INVALID_PROP = new Message("cmd.set.invalid_prop",
            "'%1' is not a valid chest property!");
    public static final Message CMD_SET_INVALID_VALUE = new Message("cmd.set.invalid_value",
            "'%1' is not a valid value for '%2'!",
            "Use '/%1' for more information.");
    public static final Message CMD_SET_POSSIBLE_VALUES = new Message("cmd.set.possible_values",
            "Possible values for property '%1' are: %2");
    public static final Message CMD_SET_SUCCESS = new Message("cmd.set.success",
            "'%1' for this chest is now '%2'!");

    public static final Message PERIOD_DESC = new Message("props.period.desc",
            "This will change the period at which the chest restocks its contents.");
    public static final Message PERIOD_MODE_DESC = new Message("props.period_mode.desc",
            "This will change the period mode of the chest.  Options are \"player\" and \"fixed\".",
            "Player mode means the chest will restock every Period amount of seconds after a player checks a restocked chest.",
            "Fixed mode means the chest will restock every Period amount of seconds after configuration, regardless of player interaction.");
    public static final Message PERIOD_MODE_INVALID = new Message("props.period_mode.invalid",
            "Valid options are \"player\" and \"fixed\"!");
    public static final Message RESTOCK_MODE_DESC = new Message("props.restock_mode.desc",
            "This will change the restock mode of the chest.  Options are \"add\" and \"replace\".",
            "Add mode means the restock items will be added to whatever is in the chest.",
            "Replace mode means the restock items will replace anything in the chest.");
    public static final Message RESTOCK_MODE_INVALID = new Message("props.restock_mode.invalid",
            "Valid options are \"add\" and \"replace\"!");
    public static final Message PRESERVE_SLOTS_DESC = new Message("props.preserve_slots.desc",
            "This will set the default setting for whether or not to preserve the item slots of chests that are restocked.",
            "That is to say, the position of restocked items will stay the same.");
    public static final Message INDESTRUCTIBLE_DESC = new Message("props.indestructible.desc",
            "This will cause a chest managed by dChest to become indestructible except by those with sufficient permission.");
    public static final Message PLAYER_LIMIT_DESC = new Message("props.player_limit.desc",
            "This will change the number of times a single player can loot the chest.",
            "-1 = no limit, 0 = none or permission based",
            "1 (or greater) = number of times a chest will restock for a player.");
    public static final Message UNIQUE_DESC = new Message("props.unique.desc",
            "Ensures that the chest is unique per player.  This means, they will each see a different set of items per chest");
    public static final Message NAME_DESC = new Message("props.name.desc",
            "A name for this chest.  This is used for giving specific permissions for a chest.");
    public static final Message REDSTONE_DESC = new Message("props.redstone.desc",
            "This will cause the chest to be restocked when it receives redstone power.");
    public static final Message ACCEPT_POLL_DESC = new Message("props.accept_poll.desc",
            "When true, the global polling task for ChestRestock will check to see if this chest needs to restock and restock it if it is time.");
    public static final Message LOOT_TABLE_DESC = new Message("props.loot_table.desc",
            "The name of the loot table to use as defined in loot_tables.yml");
    public static final Message GLOBAL_MESSAGE_DESC = new Message("props.global_message.desc",
            "A message to be broadcast to the server when this chest restocks.  Blank means no message.");

    public static void init() { }
}
