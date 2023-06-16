package org.minejewels.jewelstokens.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.minejewels.jewelstokens.JewelsTokens;
import org.minejewels.jewelstokens.player.TokenPlayer;

public class PlayerJoinListener extends AbyssListener<JewelsTokens> {

    public PlayerJoinListener(final JewelsTokens plugin) {
        super(plugin);
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if (this.plugin.getPlayerStorage().contains(player.getUniqueId())) return;

        this.plugin.getPlayerStorage().save(new TokenPlayer(player.getUniqueId()));
    }
}
