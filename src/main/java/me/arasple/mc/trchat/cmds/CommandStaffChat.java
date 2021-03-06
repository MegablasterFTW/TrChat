package me.arasple.mc.trchat.cmds;

import io.izzel.taboolib.module.command.base.BaseCommand;
import io.izzel.taboolib.module.command.base.BaseMainCommand;
import io.izzel.taboolib.module.locale.TLocale;
import io.izzel.taboolib.util.ArrayUtil;
import me.arasple.mc.trchat.channels.ChannelStaff;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author Arasple
 * @date 2019/8/4 21:19
 */
@BaseCommand(name = "staff", aliases = {"staffchannel"}, permission = "trchat.staff")
public class CommandStaffChat extends BaseMainCommand {

    @Override
    public String getCommandTitle() {
        return TLocale.asString("PLUGIN.COMMAND-TITLE");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            TLocale.sendTo(sender, "STAFF-CHANNEL.NOT-PLAYER");
            return true;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            boolean state = ChannelStaff.switchStaff(p);
            TLocale.sendTo(p, state ? "STAFF-CHANNEL.JOIN" : "STAFF-CHANNEL.QUIT");
        } else {
            ChannelStaff.execute(p, ArrayUtil.arrayJoin(args, 0));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        return null;
    }

}
