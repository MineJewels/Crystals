package org.minejewels.jewelsminerals.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.minejewels.jewelsminerals.JewelsMinerals;
import org.minejewels.jewelsminerals.player.MineralPlayer;

public class PlayerJoinListener extends AbyssListener<JewelsMinerals> {

    public PlayerJoinListener(final JewelsMinerals plugin) {
        super(plugin);
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if (this.plugin.getPlayerStorage().contains(player.getUniqueId())) return;

        this.plugin.getPlayerStorage().save(new MineralPlayer(player.getUniqueId()));
    }
}
