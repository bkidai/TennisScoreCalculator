import Score.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PlayerTest {
    lateinit var player: Player

    @BeforeEach
    fun setUp() {
        player = Player("Nadal")
    }

    @Test
    fun setDeduce() {
        // When
        player.setDeduce()

        // Then
        assertEquals(player.score, DEDUCE)
    }

    @Test
    fun setAdvantage() {
        // Given
        player.apply {
            score = ADVANTAGE
        }

        // When
        player.setAdvantage()

        // Then
        assertEquals(player.score, ADVANTAGE)
    }

    @Test
    fun isHavingAdvantage() {
        // Given
        player.apply {
            score = ADVANTAGE
        }

        // When
        val expected = player.isHavingAdvantage()

        // Then
        assertEquals(expected, true)
    }

    @Test
    fun isWinning() {
        // Given
        player.apply {
            score = GAME
        }

        // When
        val expected = player.isWinning()

        // Then
        assertEquals(expected, true)
    }

    @Test
    fun isHavingPointGame() {
        // Given
        player.apply {
            score = FORTY
        }

        // When
        val expected = player.isHavingPointGame()

        // Then
        assertEquals(expected, true)
    }

    @Test
    fun addPoint() {
        // When
        player.addPoint()

        // Then
        assertEquals(player.score, FIFTEEN)
    }
}