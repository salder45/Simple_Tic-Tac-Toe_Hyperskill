fun main() {
    val input: String = readln()
    var firstHalfSum: Int = 0
    var lastHalfSum: Int = 0
    for (index in 0..2) {
        firstHalfSum += input[index].digitToInt()
    }

    for (index in 3..5) {
        lastHalfSum += input[index].digitToInt()
    }

    if (firstHalfSum == lastHalfSum) {
        println("Lucky")
    } else {
        println("Regular")
    }
}