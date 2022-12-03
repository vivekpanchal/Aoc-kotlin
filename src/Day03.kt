
const  val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
fun main() {

    fun part1(input: List<String>): Int {
       return input.map {str->
            val pair=str.substring(0,str.length/2) to str.substring(str.length/2)
            val common=pair.first.first { pair.second.contains(it)
            }
           common
        }.sumOf {
           ALPHABET.indexOf(it).inc()
        }
    }

    fun part2(input: List<String>): Int {
      return  input.windowed(3,3)
            .sumOf { rucksacks ->
                val unique = rucksacks
                    .map { it.toSet() }
                    .reduce { init, item -> init.intersect(item) }
                unique.sumOf { ALPHABET.indexOf(it).inc() }
            }

//        return 1
    }

    val input = readInput("Day03")
    println("result part 1 ==  ${part1(input)}")
    println("result part 2 == ${part2(input)}")
}