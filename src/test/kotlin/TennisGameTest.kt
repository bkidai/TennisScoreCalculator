import Score.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TennisGameTest {

    lateinit var tennisGame: TennisGame
    lateinit var playerOne: Player
    lateinit var playerTwo: Player

    @BeforeEach
    fun setUp() {
        playerOne = Player(name = "Nadal")
        playerTwo = Player(name = "Federer")
        tennisGame = TennisGame(
            playerOne = playerOne,
            playerTwo = playerTwo
        )
    }

    @Test
    fun `when game initialized score should be LOVE`() {
        assertEquals(tennisGame.playerOne.name, "Nadal")
        assertEquals(tennisGame.playerOne.score, LOVE)
        assertEquals(tennisGame.playerTwo.name, "Federer")
        assertEquals(tennisGame.playerTwo.score, LOVE)
    }

    @Test
    fun `when player win first point score should be FIFTEEN`() {
        // When
        tennisGame.playerWinAPoint(playerOne)

        // Then
        assertEquals(tennisGame.playerOne.score, FIFTEEN)
    }

    @Test
    fun `when player with THIRTY win point against FORTY score should be FORTY (DEDUCE)`() {
        // Given
        playerOne.apply {
            score = THIRTY
        }
        playerTwo.apply {
            score = FORTY
        }

        // When
        tennisGame.playerWinAPoint(playerOne)

        // Then
        assertEquals(tennisGame.playerOne.score, FORTY)
    }


    @Test
    fun `when player with FORTY win point against LOVE score should be GAME`() {
        // Given
        playerOne.apply {
            score = FORTY
        }

        // When
        tennisGame.playerWinAPoint(playerOne)

        // Then
        assertEquals(tennisGame.playerOne.score, GAME)
    }

    @Test
    fun `when player with FORTY win point against ADVANTAGE score should be DEDUCE`() {
        // Given
        playerOne.apply {
            score = FORTY
        }
        playerTwo.apply {
            score = ADVANTAGE
        }

        // When
        tennisGame.playerWinAPoint(playerOne)

        // Then
        assertEquals(tennisGame.playerOne.score, DEDUCE)
    }

    @Test
    fun `when both players are FORTY next point win should be ADVANTAGE`() {
        // Given
        playerOne.apply {
            score = FORTY
        }
        playerTwo.apply {
            score = FORTY
        }

        // When
        tennisGame.playerWinAPoint(playerOne)

        // Then
        assertEquals(tennisGame.playerOne.score, ADVANTAGE)
    }

    @Test
    fun `when both players are DEDUCE next point win should be ADVANTAGE`() {
        // Given
        playerOne.apply {
            score = DEDUCE
        }
        playerTwo.apply {
            score = DEDUCE
        }

        // When
        tennisGame.playerWinAPoint(playerOne)

        // Then
        assertEquals(tennisGame.playerOne.score, ADVANTAGE)
    }
}
