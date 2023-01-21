package tictactoe
fun main() {
    print("Enter cells: ")
    val input = readln()
    val r = input.toMutableList()
    println(
        """
        ---------
        | ${r[0]} ${r[1]} ${r[2]} |
        | ${r[3]} ${r[4]} ${r[5]} |
        | ${r[6]} ${r[7]} ${r[8]} |
        ---------
    """.trimIndent()
    )

    var xCount = 0
    var oCount = 0
    var emptyCount = 0

    for (i in 0..8) {
        if (r[i] == 'X') xCount++
        else if (r[i] == 'O') oCount++
//        else if (r[i] == '_') emptyCount++
        else emptyCount++
    }
    if (xCount - oCount > 1) {
        println("Impossible")
        return
    }
    if (oCount > xCount + 1) {
        println("Impossible")
        return
    }

    var xWins = false
    var oWins = false

    // check rows
    for (i in 0..2) {
        if (r[i * 3] == r[i * 3 + 1] && r[i * 3] == r[i * 3 + 2]) {
            if (r[i * 3] == 'X') xWins = true
            else if (r[i * 3] == 'O') oWins = true
        }
    }

    // check columns
    for (i in 0..2) {
        if (r[i] == r[i + 3] && r[i] == r[i + 6]) {
            if (r[i] == 'X') xWins = true
            else if (r[i] == 'O') oWins = true
        }
    }

    // check diagonals
    if (r[0] == r[4] && r[0] == r[8]) {
        if (r[0] == 'X') xWins = true
        else if (r[0] == 'O') oWins = true
    }
    if (r[2] == r[4] && r[2] == r[6]) {
        if (r[2] == 'X') xWins = true
        else if (r[2] == 'O') oWins = true
    }

    if (xWins && oWins) {
        println("Impossible")
    } else if (xWins) {
        println("X wins")
    } else if (oWins) {
        println("O wins")
    } else if (emptyCount > 0) {
        println("Game not finished")
    } else {
        println("Draw")
    }
}


