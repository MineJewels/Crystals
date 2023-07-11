package org.minejewels.jewelscrystals.commands.subcommands;

import net.abyssdev.abysslib.command.AbyssSubCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Sets;
import org.minejewels.jewelscrystals.JewelsCrystals;

public class CrystalsBalanceCommand extends AbyssSubCommand<JewelsCrystals> {

    public CrystalsBalanceCommand(final JewelsCrystals plugin) {
        super(plugin, 0, Sets.immutable.of("balance", "bal"));
    }

    @Override
    public void execute(CommandContext<?> context) {

        final Player player = context.getSender();

        if (context.getArguments().length != 1) {
            this.plugin.getMessageCache().sendMessage(player, "messages.crystals-balance", new PlaceholderReplacer().addPlaceholder("%amount%", Utils.format(this.plugin.getPlayerStorage().get(player.getUniqueId()).getTokens())));
            return;
        }

        final Player target = context.asPlayer(0);

        if (target == null) {
            this.plugin.getMessageCache().sendMessage(player, "messages.invalid-player");
            return;
        }

        this.plugin.getMessageCache().sendMessage(player, "messages.crystals-balance-others", new PlaceholderReplacer().addPlaceholder("%player%", target.getName()).addPlaceholder("%amount%", Utils.format(this.plugin.getPlayerStorage().get(target.getUniqueId()).getTokens())));
    }
}
