package org.minejewels.jewelsminerals.player.storage;

import net.abyssdev.abysslib.storage.json.JsonStorage;
import net.abyssdev.abysslib.utils.file.Files;
import org.minejewels.jewelsminerals.JewelsMinerals;
import org.minejewels.jewelsminerals.player.MineralPlayer;

import java.util.UUID;

public class MineralPlayerStorage extends JsonStorage<UUID, MineralPlayer> {

    public MineralPlayerStorage(final JewelsMinerals plugin) {
        super(Files.file("data.json", plugin), MineralPlayer.class);
    }
}
