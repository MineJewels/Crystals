package org.minejewels.jewelsminerals.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.command.CommandSender;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsminerals.JewelsMinerals;
import org.minejewels.jewelsminerals.commands.subcommands.*;

public class MineralsCommand extends AbyssCommand<JewelsMinerals, CommandSender> {

    public MineralsCommand(final JewelsMinerals plugin) {
        super(plugin, "minerals", CommandSender.class);

        this.setAliases(Lists.mutable.of("mineral", "jewelminerals", "minerals"));

        this.register(
                new MineralsBalanceCommand(plugin),
                new MineralsPayCommand(plugin),
                new MineralsSetCommand(plugin),
                new MineralsRemoveCommand(plugin),
                new MineralsAddCommand(plugin));
        this.register();
    }

    @Override
    public void execute(CommandContext<CommandSender> context) {

        final CommandSender player = context.getSender();

        if (!player.hasPermission("minerals.admin")) {
            this.plugin.getMessageCache().sendMessage(player, "messages.help-player");
            return;
        }

        this.plugin.getMessageCache().sendMessage(player, "messages.help-admin");
    }
}
