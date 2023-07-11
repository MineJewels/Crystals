package org.minejewels.jewelscrystals.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.command.CommandSender;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelscrystals.JewelsCrystals;
import org.minejewels.jewelscrystals.commands.subcommands.*;

public class CrystalsCommand extends AbyssCommand<JewelsCrystals, CommandSender> {

    public CrystalsCommand(final JewelsCrystals plugin) {
        super(plugin, "crystals", CommandSender.class);

        this.setAliases(Lists.mutable.of("crystals", "jewelscrystals", "crystal"));

        this.register(
                new CrystalsBalanceCommand(plugin),
                new CrystalsPayCommand(plugin),
                new CrystalsSetCommand(plugin),
                new CrystalsRemoveCommand(plugin),
                new CrystalsAddCommand(plugin));
        this.register();
    }

    @Override
    public void execute(CommandContext<CommandSender> context) {

        final CommandSender player = context.getSender();

        if (!player.hasPermission("crystals.admin")) {
            this.plugin.getMessageCache().sendMessage(player, "messages.help-player");
            return;
        }

        this.plugin.getMessageCache().sendMessage(player, "messages.help-admin");
    }
}
