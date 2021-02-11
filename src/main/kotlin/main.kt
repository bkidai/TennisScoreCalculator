import Score.*

fun main(args: Array<String>) {

    val playerOne = Player(name = "Nadal")
    val playerTwo = Player(name = "Federer")

    val tennisGame = TennisGame(
        playerOne = playerOne,
        playerTwo = playerTwo
    )

    // Random player balls wi
    while (playerOne.score != GAME && playerTwo.score != GAME) {
        tennisGame.playerWinAPoint(
            pointWinner = listOf(playerOne, playerTwo).random()
        )
    }
}