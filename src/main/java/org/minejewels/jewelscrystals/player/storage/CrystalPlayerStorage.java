package org.minejewels.jewelscrystals.player.storage;

import net.abyssdev.abysslib.storage.json.JsonStorage;
import net.abyssdev.abysslib.utils.file.Files;
import org.minejewels.jewelscrystals.JewelsCrystals;
import org.minejewels.jewelscrystals.player.CrystalPlayer;

import java.util.UUID;

public class CrystalPlayerStorage extends JsonStorage<UUID, CrystalPlayer> {

    public CrystalPlayerStorage(final JewelsCrystals plugin) {
        super(Files.file("data.json", plugin), CrystalPlayer.class);
    }
}
