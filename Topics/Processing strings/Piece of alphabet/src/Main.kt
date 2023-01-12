fun main() {
    val input: String = readln()
    var response: String = "false"
    if (input != "") {
        val alphabet: String = "abcdefghijklmnopqrstuvwxyz"
        val initialPosition = alphabet.indexOf(input[0])
        if (initialPosition != -1 && input == alphabet.substring(initialPosition, initialPosition + input.length)) {
            response = "true"
        }
    } else {
        response = "true"
    }
    println(response)
}