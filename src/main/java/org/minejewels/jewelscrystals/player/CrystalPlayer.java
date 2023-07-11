package org.minejewels.jewelscrystals.player;

import lombok.Data;
import net.abyssdev.abysslib.storage.id.Id;

import java.util.UUID;

@Data
public class CrystalPlayer {

    @Id
    private final UUID uuid;
    private long tokens;

    public void addTokens(final long amount) {
        this.tokens += amount;
    }

    public void removeTokens(final long amount) {
        if (this.tokens - amount < 0) {
            this.tokens = 0;
            return;
        }
        this.tokens -= amount;
    }

    public boolean hasEnoughTokens(final long amount) {
        return this.tokens >= amount;
    }

    public long getTokensNeeded(final long amount) {
        if (this.hasEnoughTokens(amount)) return 0;
        return amount - this.tokens;
    }
}
