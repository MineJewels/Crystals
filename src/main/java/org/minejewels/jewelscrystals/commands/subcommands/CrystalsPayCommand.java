package org.minejewels.jewelscrystals.commands.subcommands;

import net.abyssdev.abysslib.command.AbyssSubCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Sets;
import org.minejewels.jewelscrystals.JewelsCrystals;
import org.minejewels.jewelscrystals.player.CrystalPlayer;

public class CrystalsPayCommand extends AbyssSubCommand<JewelsCrystals> {

    public CrystalsPayCommand(final JewelsCrystals plugin) {
        super(plugin, 2, Sets.immutable.of("pay", "send"));
    }

    @Override
    public void execute(CommandContext<?> context) {

        final Player player = context.getSender();

        if (context.getArguments().length != 2) {
            this.plugin.getMessageCache().sendMessage(player, "messages.help-player");
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

        if (amount <= 0) {
            this.plugin.getMessageCache().sendMessage(player, "messages.invalid-number");
            return;
        }

        final CrystalPlayer crystalPlayer = this.plugin.getPlayerStorage().get(player.getUniqueId());

        if (!crystalPlayer.hasEnoughTokens(amount)) {
            this.plugin.getMessageCache().sendMessage(player, "messages.not-enough-minerals", new PlaceholderReplacer().addPlaceholder("%amount%", Utils.format(crystalPlayer.getTokensNeeded(amount))));
            return;
        }

        final CrystalPlayer crystalTarget = this.plugin.getPlayerStorage().get(target.getUniqueId());

        crystalPlayer.removeTokens(amount);
        crystalTarget.addTokens(amount);

        final PlaceholderReplacer replacer = new PlaceholderReplacer()
                .addPlaceholder("%amount%", Utils.format(amount));

        this.plugin.getMessageCache().sendMessage(player, "messages.crystals-sent", replacer.addPlaceholder("%target%", target.getName()));
        this.plugin.getMessageCache().sendMessage(target, "messages.crystals-received", replacer.addPlaceholder("%player%", player.getName()));
    }
}
