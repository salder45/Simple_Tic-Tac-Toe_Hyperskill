fun main() {
    val input: String = readln()
    val letters = mutableListOf<String>()
    val values = mutableListOf<Int>()
    var currentLetterEncoded: Char = input[0]
    for (char in input) {
        if (letters.isEmpty()) {
            letters.add("$char")
            values.add(1)
        } else {
            if (currentLetterEncoded == char) {
                values[values.lastIndex]++
            } else {
                currentLetterEncoded = char
                letters.add("$char")
                values.add(1)
            }
        }
    }
    for (position in letters.indices) {
        print("${letters[position]}${values[position]}")
    }
    println()
}