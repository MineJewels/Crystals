package org.minejewels.jewelstokens;

import lombok.Getter;
import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.storage.Storage;
import net.abyssdev.abysslib.text.MessageCache;
import org.bukkit.command.CommandSender;
import org.minejewels.jewelstokens.commands.TokensCommand;
import org.minejewels.jewelstokens.listeners.PlayerJoinListener;
import org.minejewels.jewelstokens.placeholder.TokensPlaceholder;
import org.minejewels.jewelstokens.player.TokenPlayer;
import org.minejewels.jewelstokens.player.storage.TokenPlayerStorage;

import java.util.UUID;

@Getter
public final class JewelsTokens extends AbyssPlugin {

    private static JewelsTokens api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");

    private final MessageCache messageCache = new MessageCache(this.langConfig);

    private final Storage<UUID, TokenPlayer> playerStorage = new TokenPlayerStorage(this);

    private AbyssCommand<JewelsTokens, CommandSender> tokensCommand;

    @Override
    public void onEnable() {
        JewelsTokens.api = this;

        this.loadMessages(this.messageCache, this.langConfig);

        this.tokensCommand = new TokensCommand(this);

        new PlayerJoinListener(this);
        new TokensPlaceholder(this);
    }

    @Override
    public void onDisable() {
        this.playerStorage.write();
    }

    public static JewelsTokens get() {
        return JewelsTokens.api;
    }
}
