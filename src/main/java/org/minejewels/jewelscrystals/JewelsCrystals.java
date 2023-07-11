package org.minejewels.jewelscrystals;

import lombok.Getter;
import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.storage.Storage;
import net.abyssdev.abysslib.text.MessageCache;
import org.bukkit.command.CommandSender;
import org.minejewels.jewelscrystals.commands.CrystalsCommand;
import org.minejewels.jewelscrystals.listeners.PlayerJoinListener;
import org.minejewels.jewelscrystals.placeholder.MineralsPlaceholder;
import org.minejewels.jewelscrystals.player.CrystalPlayer;
import org.minejewels.jewelscrystals.player.storage.CrystalPlayerStorage;

import java.util.UUID;

@Getter
public final class JewelsCrystals extends AbyssPlugin {

    private static JewelsCrystals api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");

    private final MessageCache messageCache = new MessageCache(this.langConfig);

    private final Storage<UUID, CrystalPlayer> playerStorage = new CrystalPlayerStorage(this);

    private AbyssCommand<JewelsCrystals, CommandSender> mineralsCommand;

    @Override
    public void onEnable() {
        JewelsCrystals.api = this;

        this.loadMessages(this.messageCache, this.langConfig);

        this.mineralsCommand = new CrystalsCommand(this);

        new PlayerJoinListener(this);
        new MineralsPlaceholder(this);
    }

    @Override
    public void onDisable() {
        this.playerStorage.write();
    }

    public static JewelsCrystals get() {
        return JewelsCrystals.api;
    }
}
