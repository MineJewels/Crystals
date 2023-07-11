package org.minejewels.jewelscrystals.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.minejewels.jewelscrystals.JewelsCrystals;

public class MineralsPlaceholder extends PlaceholderExpansion {

    private final JewelsCrystals plugin;

    public MineralsPlaceholder(final JewelsCrystals plugin) {
        this.plugin = plugin;

        this.register();
    }

    @Override
    public @NotNull String getIdentifier() {
        return "crystals";
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
