import Score.*

class Player(
    val name: String,
    var score: Score = LOVE
) {
    fun setDeduce() {
        this.score = DEDUCE
    }

    fun setAdvantage() {
        this.score = ADVANTAGE
    }

    fun isHavingAdvantage(): Boolean {
        return this.score == ADVANTAGE
    }

    fun isWinning(): Boolean {
        return this.score == GAME
    }

    fun isHavingPointGame(): Boolean {
        return this.score == FORTY
    }

    fun addPoint() {
        this.score = Score.values().first { score -> score.value == (this.score.value + 1) }
    }
}
