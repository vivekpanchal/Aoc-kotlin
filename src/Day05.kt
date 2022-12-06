fun main() {

    val input = readInput("Day05")
    fun String.findUniqueChar(chars:Int)= windowed(chars).indexOfFirst { it.toSet().size==chars }+chars

    fun part1(input: List<String>): Int {
      return input.first().findUniqueChar(4)
    }

    fun part2(input: List<String>): Int {
        return input.first().findUniqueChar(14)
    }



    println("result part 1 ==  ${part1(input)}")
    println("result part 2 == ${part2(input)}")
}