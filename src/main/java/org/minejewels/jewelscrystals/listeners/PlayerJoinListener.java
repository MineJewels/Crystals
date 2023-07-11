package org.minejewels.jewelscrystals.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.minejewels.jewelscrystals.JewelsCrystals;
import org.minejewels.jewelscrystals.player.CrystalPlayer;

public class PlayerJoinListener extends AbyssListener<JewelsCrystals> {

    public PlayerJoinListener(final JewelsCrystals plugin) {
        super(plugin);
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if (this.plugin.getPlayerStorage().contains(player.getUniqueId())) return;

        this.plugin.getPlayerStorage().save(new CrystalPlayer(player.getUniqueId()));
    }
}
