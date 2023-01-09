package tictactoe

fun main() {
    val input: String = readln()
    val gameBoard: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("_", "_", "_"),
        mutableListOf("_", "_", "_"),
        mutableListOf("_", "_", "_")
    )
    var xTimes: Int = 0
    var oTimes: Int = 0
    var emptyTimes: Int = 0
    for (position in input.indices) {
        if(input[position] == 'X') {
            xTimes++
        } else if (input[position] == 'O') {
            oTimes++
        } else {
            emptyTimes++
        }
        if (position in 0..2) {
            gameBoard[0][position] = input[position].toString()
        } else if (position in 3..5) {
            gameBoard[1][position - 3] = input[position].toString()
        } else {
            gameBoard[2][position - 6] = input[position].toString()
        }
    }
    println("-".repeat(9))
    for (index in 0..2) {
        print("| ")
        print(gameBoard[index].joinToString(" "))
        println(" |")
    }
    println("-".repeat(9))
    val xWins = if ((gameBoard[0][0] == "X"
        && gameBoard[0][1] == "X"
        && gameBoard[0][2] == "X") ||
        (gameBoard[1][0] == "X"
                && gameBoard[1][1] == "X"
                && gameBoard[1][2] == "X")||
        (gameBoard[2][0] == "X"
                && gameBoard[2][1] == "X"
                && gameBoard[2][2] == "X")) {
        true
    } else if ((gameBoard[0][0] == "X"
        && gameBoard[1][0] == "X"
        && gameBoard[2][0] == "X")||
        (gameBoard[0][1] == "X"
                && gameBoard[1][1] == "X"
                && gameBoard[2][1] == "X")||
        (gameBoard[0][2] == "X"
                && gameBoard[1][2] == "X"
                && gameBoard[2][2] == "X")) {
        true
    } else if ((gameBoard[0][0] == "X" &&
                gameBoard[1][1] == "X" &&
                gameBoard[2][2] == "X") ||
        (gameBoard[0][2] == "X" &&
                gameBoard[1][1] == "X" &&
                gameBoard[0][2] == "X")) {
        true
    } else {
        false
    }
    val oWins = if ((gameBoard[0][0] == "O"
                && gameBoard[0][1] == "O"
                && gameBoard[0][2] == "O") ||
        (gameBoard[1][0] == "O"
                && gameBoard[1][1] == "O"
                && gameBoard[1][2] == "O")||
        (gameBoard[2][0] == "O"
                && gameBoard[2][1] == "O"
                && gameBoard[2][2] == "O")) {
        true
    } else if ((gameBoard[0][0] == "O"
                && gameBoard[1][0] == "O"
                && gameBoard[2][0] == "O")||
        (gameBoard[0][1] == "O"
                && gameBoard[1][1] == "O"
                && gameBoard[2][1] == "O")||
        (gameBoard[0][2] == "O"
                && gameBoard[1][2] == "O"
                && gameBoard[2][2] == "O")) {
        true
    } else if ((gameBoard[0][0] == "O" &&
                gameBoard[1][1] == "O" &&
                gameBoard[2][2] == "O") ||
        (gameBoard[0][2] == "O" &&
                gameBoard[1][1] == "O" &&
                gameBoard[0][2] == "O")) {
        true
    } else {
        false
    }
    if ((xWins && oWins) ||
        (xTimes > oTimes && xTimes - oTimes > 1) ||
        (xTimes < oTimes && oTimes - xTimes > 1)) {
        println("Impossible")
    } else if (xWins && !oWins) {
        println("X wins")
    } else if (!xWins && oWins) {
        println("O wins")
    } else if (!xWins && !oWins && emptyTimes == 0) {
        println("Draw")
    } else if (!xWins && !oWins && emptyTimes > 0) {
        println("Game not finished")
    }
    //Not finished
    //Draw
    //X wins
    //O Wins
    //Impossible
}