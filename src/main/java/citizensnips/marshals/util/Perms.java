package citizensnips.marshals.util;

import com.dumptruckman.minecraft.pluginbase.permission.Perm;

public class Perms {
    public static final Perm CMD_SHACKLE = new Perm.Builder("shackle").usePluginName().commandPermission().build();
}
