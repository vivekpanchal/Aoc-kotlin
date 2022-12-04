fun main() {

    fun part1(input: List<String>): Int {
        input.map {
            val parts = it.split(",").let {
                Pair(it[0], it[1])
            }
            println(parts)

        }

        return 1
    }

    fun part2(input: List<String>): Int {

        return -1
    }


    val input = readInput("Day04")
    println("result part 1 ==  ${part1(input)}")
    println("result part 2 == ${part2(input)}")
}