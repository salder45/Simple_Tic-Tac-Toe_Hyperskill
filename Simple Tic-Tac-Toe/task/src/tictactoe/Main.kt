package tictactoe

fun main() {
    val input: String = readln()
    println("-".repeat(9))
    print("| ")
    print("${input[0]} ${input[1]} ${input[2]}")
    print(" |")
    println()
    print("| ")
    print("${input[3]} ${input[4]} ${input[5]}")
    print(" |")
    println()
    print("| ")
    print("${input[6]} ${input[7]} ${input[8]}")
    println(" |")
    println("-".repeat(9))
}