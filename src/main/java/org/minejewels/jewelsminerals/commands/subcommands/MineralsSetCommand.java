package org.minejewels.jewelsminerals.commands.subcommands;

import net.abyssdev.abysslib.command.AbyssSubCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Sets;
import org.minejewels.jewelsminerals.JewelsMinerals;
import org.minejewels.jewelsminerals.player.MineralPlayer;

public class MineralsSetCommand extends AbyssSubCommand<JewelsMinerals> {

    public MineralsSetCommand(final JewelsMinerals plugin) {
        super(plugin, 2, Sets.immutable.of("set", "put"));
    }

    @Override
    public void execute(CommandContext<?> context) {

        final CommandSender player = context.getSender();

        if (!player.hasPermission("tokens.admin")) {
            this.plugin.getMessageCache().sendMessage(player, "messages.help-player");
            return;
        }

        if (context.getArguments().length != 2) {
            this.plugin.getMessageCache().sendMessage(player, "messages.help-admin");
            return;
        }

        final Player target = context.asPlayer(0);

        if (target == null) {
            this.plugin.getMessageCache().sendMessage(player, "messages.invalid-player");
            return;
        }

        if (!Utils.isLong(context.asString(1))) {
            this.plugin.getMessageCache().sendMessage(player, "messages.invalid-number");
            return;
        }

        final long amount = context.asLong(1);

        if (amount <= -1) {
            this.plugin.getMessageCache().sendMessage(player, "messages.invalid-number");
            return;
        }

        final MineralPlayer mineralTarget = this.plugin.getPlayerStorage().get(target.getUniqueId());

        mineralTarget.setTokens(amount);

        final PlaceholderReplacer replacer = new PlaceholderReplacer()
                .addPlaceholder("%amount%", Utils.format(amount));

        this.plugin.getMessageCache().sendMessage(target, "messages.minerals-set", replacer);
    }
}
