fun main() {




    fun getParsed(input: List<String>): List<List<Set<Int>>> {
        return input.map {
            it.split(",").map {
                it.split("-").map(String::toInt).let { (a, b) -> (a..b).toSet() }
            }
        }
    }

    fun part1(input: List<String>): Int {
       val parsed= getParsed(input)
       return parsed.count { (a, b) -> a.containsAll(b) || b.containsAll(a)}
    }

    fun part2(input: List<String>): Int {
        val parsed= getParsed(input)

        return parsed.count { (a, b) -> a.intersect(b).isNotEmpty()}
    }





    val input = readInput("Day04")
    println("result part 1 ==  ${part1(input)}")
    println("result part 2 == ${part2(input)}")
}