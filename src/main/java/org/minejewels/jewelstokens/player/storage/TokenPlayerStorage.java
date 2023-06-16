package org.minejewels.jewelstokens.player.storage;

import net.abyssdev.abysslib.storage.json.JsonStorage;
import net.abyssdev.abysslib.utils.file.Files;
import org.minejewels.jewelstokens.JewelsTokens;
import org.minejewels.jewelstokens.player.TokenPlayer;

import java.util.UUID;

public class TokenPlayerStorage extends JsonStorage<UUID, TokenPlayer> {

    public TokenPlayerStorage(final JewelsTokens plugin) {
        super(Files.file("data.json", plugin), TokenPlayer.class);
    }
}
