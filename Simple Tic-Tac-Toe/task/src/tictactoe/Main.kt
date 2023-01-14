package tictactoe

fun main() {
    val gameBoard: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("_", "_", "_"),
        mutableListOf("_", "_", "_"),
        mutableListOf("_", "_", "_")
    )
    var emptySpaces: Int = 9;
    var count: Int = 0
    do {
        count++
        //manage turn
        val symbol = getSymbolTurn(count)
        //capture input
        emptySpaces = captureInput(gameBoard, symbol, emptySpaces)
        //evaluate game status
    } while(checkGameStatus(gameBoard, emptySpaces))
    /*
    println("-----")
    var isValidInput: Boolean = false;
    do {
        val moveInput: String = readln()
        //check data are numbers
        if (moveInput.length == 3 && !moveInput[0].isDigit() || !moveInput[0].isDigit() ) {
            println("You should enter numbers!")
        } else {
            val coordinates = moveInput.split(" ")
            val x: Int = coordinates[0].toInt() - 1
            val y: Int = coordinates[1].toInt() - 1
            if (x !in 0..2 || y !in 0..2) {
                println("Coordinates should be from 1 to 3!")
            } else if(gameBoard[x][y] != "_") {
                println("This cell is occupied! Choose another one!")
            } else {
                isValidInput = true
                gameBoard[x][y] = "X"
                println("-".repeat(9))
                for (index in 0..2) {
                    print("| ")
                    print(gameBoard[index].joinToString(" "))
                    println(" |")
                }
                println("-".repeat(9))
            }
        }
        //check is inbounds
        //coordinates are available
    } while (!isValidInput)

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
     */
    //Not finished
    //Draw
    //X wins
    //O Wins
    //Impossible
}

fun printGameBoard(gameBoard: MutableList<MutableList<String>>) {
    println("-".repeat(9))
    for (index in 0..2) {
        print("| ")
        print(gameBoard[index].joinToString(" "))
        println(" |")
    }
    println("-".repeat(9))
}

fun checkGameStatus(gameBoard: MutableList<MutableList<String>>, emptySpaces: Int): Boolean {
    val xWins = checkWins(gameBoard,"X")
    val oWins = checkWins(gameBoard,"O")
    return when {
        xWins -> {
            print("X wins")
            false
        }
        oWins -> {
            print("O wins")
            false
        }
        emptySpaces == 0 -> {
            print("Draw")
            false
        }
        else -> true
    }
}

fun getSymbolTurn(count: Int): String {
    return if (count % 2 == 0) {
        "O"
    } else {
        "X"
    }
}

fun captureInput(gameBoard: MutableList<MutableList<String>>, symbol: String, emptySpaces: Int): Int {
    var captureFailed: Boolean = true
    do {
        val moveInput: String = readln()
        if ((moveInput.length == 3 && !moveInput[0].isDigit() || !moveInput[0].isDigit()) || moveInput.length != 3) {
            println("You should enter numbers!")
        } else {
            val coordinates = moveInput.split(" ")
            val x: Int = coordinates[0].toInt() - 1
            val y: Int = coordinates[1].toInt() - 1
            if (x !in 0..2 || y !in 0..2) {
                println("Coordinates should be from 1 to 3!")
            } else if(gameBoard[x][y] != "_") {
                println("This cell is occupied! Choose another one!")
            } else {
                captureFailed = false
                gameBoard[x][y] = symbol
                printGameBoard(gameBoard)
            }
        }
    } while(captureFailed)
    return emptySpaces - 1
}

fun checkWins(gameBoard: MutableList<MutableList<String>>, symbol: String): Boolean {
    return when {
        gameBoard[0][0] == symbol
                && gameBoard[0][1] == symbol
                && gameBoard[0][2] == symbol -> true
        gameBoard[1][0] == symbol
                && gameBoard[1][1] == symbol
                && gameBoard[1][2] == symbol -> true
        gameBoard[2][0] == symbol
                && gameBoard[2][1] == symbol
                && gameBoard[2][2] == symbol -> true
        gameBoard[0][0] == symbol
                && gameBoard[1][0] == symbol
                && gameBoard[2][0] == symbol -> true
        gameBoard[0][1] == symbol
                && gameBoard[1][1] == symbol
                && gameBoard[2][1] == symbol -> true
        gameBoard[0][2] == symbol
                && gameBoard[1][2] == symbol
                && gameBoard[2][2] == symbol -> true
        gameBoard[0][0] == symbol
                && gameBoard[1][1] == symbol
                && gameBoard[2][2] == symbol -> true
        gameBoard[0][2] == symbol
                && gameBoard[1][1] == symbol
                && gameBoard[2][0] == symbol -> true
        else -> false
    }
}