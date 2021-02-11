import Score.*

class TennisGame(
    val playerOne: Player,
    val playerTwo: Player
) {
    fun playerWinAPoint(pointWinner: Player) {
        if (getOpponentPlayer(pointWinner).isHavingAdvantage()) {
            getOpponentPlayer(pointWinner).setDeduce()
            pointWinner.setDeduce()
            return
        }
        if (isDeducedPlayers()) {
            pointWinner.setAdvantage()
            return println("Advantage ${pointWinner.name}")
        }
        if (pointWinner.isHavingPointGame()) {
            pointWinner.score = GAME
        }
        if (pointWinner.isWinning()) {
            return println("\n${pointWinner.name} win the game\n")
        }
        pointWinner.addPoint()
        printScore()
    }

    private fun getOpponentPlayer(player: Player) = if (player == playerOne) {
        playerTwo
    } else {
        playerOne
    }

    private fun isDeducedPlayers() = playerOne.score == FORTY && playerTwo.score == FORTY

    private fun printScore() {
        println("${playerOne.name} vs ${playerTwo.name} : ${playerOne.score.points} | ${playerTwo.score.points}")
    }
}