enum class Score(var value: Int, internal val points: String) {
    LOVE(value = 0, points = "0"),
    FIFTEEN(value = 1, points = "15"),
    THIRTY(value = 2, points = "30"),
    FORTY(value = 3, points = "40"),
    DEDUCE(value = 4, "Equals"),
    ADVANTAGE(value = 5, "Advantage"),
    GAME(value = 6, "Game")
}