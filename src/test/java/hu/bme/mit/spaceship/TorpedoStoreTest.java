package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void fire_AllTests(int[] torpedoCounts) {
        GT4500 ship = new GT4500(torpedoCounts[0], 0.0, torpedoCounts[1], 0.0);
        boolean result = ship.fireTorpedo(FiringMode.ALL);
        assertEquals(torpedoCounts[0] + torpedoCounts[1] > 0, result);
    }

    private static Stream<int[]> parameters() {
        return Stream.of(
                new int[] {0, 0},
                new int[] {1, 0},
                new int[] {0, 1},
                new int[] {1, 1});
    }
}
