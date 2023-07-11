package org.minejewels.jewelsminerals;

import lombok.Getter;
import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.storage.Storage;
import net.abyssdev.abysslib.text.MessageCache;
import org.bukkit.command.CommandSender;
import org.minejewels.jewelsminerals.commands.MineralsCommand;
import org.minejewels.jewelsminerals.listeners.PlayerJoinListener;
import org.minejewels.jewelsminerals.placeholder.MineralsPlaceholder;
import org.minejewels.jewelsminerals.player.MineralPlayer;
import org.minejewels.jewelsminerals.player.storage.MineralPlayerStorage;

import java.util.UUID;

@Getter
public final class JewelsMinerals extends AbyssPlugin {

    private static JewelsMinerals api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");

    private final MessageCache messageCache = new MessageCache(this.langConfig);

    private final Storage<UUID, MineralPlayer> playerStorage = new MineralPlayerStorage(this);

    private AbyssCommand<JewelsMinerals, CommandSender> mineralsCommand;

    @Override
    public void onEnable() {
        JewelsMinerals.api = this;

        this.loadMessages(this.messageCache, this.langConfig);

        this.mineralsCommand = new MineralsCommand(this);

        new PlayerJoinListener(this);
        new MineralsPlaceholder(this);
    }

    @Override
    public void onDisable() {
        this.playerStorage.write();
    }

    public static JewelsMinerals get() {
        return JewelsMinerals.api;
    }
}
