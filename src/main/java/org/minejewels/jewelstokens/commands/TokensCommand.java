package org.minejewels.jewelstokens.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.command.CommandSender;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Sets;
import org.minejewels.jewelstokens.JewelsTokens;
import org.minejewels.jewelstokens.commands.subcommands.*;

public class TokensCommand extends AbyssCommand<JewelsTokens, CommandSender> {

    public TokensCommand(final JewelsTokens plugin) {
        super(plugin, "tokens", CommandSender.class);

        this.setAliases(Lists.mutable.of("token", "jeweltokens", "tokens"));

        this.register(
                new TokensBalanceCommand(plugin),
                new TokensPayCommand(plugin),
                new TokensSetCommand(plugin),
                new TokensRemoveCommand(plugin),
                new TokensAddCommand(plugin));
        this.register();
    }

    @Override
    public void execute(CommandContext<CommandSender> context) {

        final CommandSender player = context.getSender();

        if (!player.hasPermission("tokens.admin")) {
            this.plugin.getMessageCache().sendMessage(player, "messages.help-player");
            return;
        }

        this.plugin.getMessageCache().sendMessage(player, "messages.help-admin");
    }
}
