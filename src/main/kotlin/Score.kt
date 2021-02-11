enum class Score(var value: Int, val points: Int = 0) {
    LOVE(value = 0),
    FIFTEEN(value = 1, points = 15),
    THIRTY(value = 2, points = 30),
    FORTY(value = 3, points = 40),
    DEDUCE(value = 4),
    ADVANTAGE(value = 5),
    GAME(value = 6)
}