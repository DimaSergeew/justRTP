package eu.kotori.justRTP.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.concurrent.CompletableFuture;

public final class ChunkLoader {
    private ChunkLoader() {
    }

    public static CompletableFuture<Chunk> getChunkAtAsync(World world, int chunkX, int chunkZ, boolean generate) {
        if (world == null) {
            return CompletableFuture.completedFuture(null);
        }
        try {
            return world.getChunkAtAsync(chunkX, chunkZ, generate);
        } catch (Throwable t) {
            CompletableFuture<Chunk> failed = new CompletableFuture<>();
            failed.completeExceptionally(t);
            return failed;
        }
    }

    public static CompletableFuture<Chunk> getChunkAtAsync(World world, int chunkX, int chunkZ) {
        return getChunkAtAsync(world, chunkX, chunkZ, true);
    }

    public static CompletableFuture<Chunk> getChunkAtAsync(Location location) {
        if (location == null || location.getWorld() == null) {
            return CompletableFuture.completedFuture(null);
        }
        try {
            return location.getWorld().getChunkAtAsync(location);
        } catch (Throwable t) {
            CompletableFuture<Chunk> failed = new CompletableFuture<>();
            failed.completeExceptionally(t);
            return failed;
        }
    }
}
