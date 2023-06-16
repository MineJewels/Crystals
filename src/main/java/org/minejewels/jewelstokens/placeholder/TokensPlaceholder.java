package org.minejewels.jewelstokens.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.minejewels.jewelstokens.JewelsTokens;

public class TokensPlaceholder extends PlaceholderExpansion {

    private final JewelsTokens plugin;

    public TokensPlaceholder(final JewelsTokens plugin) {
        this.plugin = plugin;

        this.register();
    }

    @Override
    public @NotNull String getIdentifier() {
        return "tokens";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Consciences";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {

        if (params.equalsIgnoreCase("balance")) {
            return Utils.format(this.plugin.getPlayerStorage().get(player.getUniqueId()).getTokens());
        }

        return "There has been a error!";
    }
}
