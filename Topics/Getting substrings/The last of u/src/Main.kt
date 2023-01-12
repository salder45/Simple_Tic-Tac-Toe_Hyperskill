fun main() {
    val string = readln()
    val lastU: String = "${string.substringBeforeLast("u")}u${string.substringAfterLast("u").uppercase()}"
    println(lastU)
}