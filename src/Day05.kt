import java.util.Stack

fun main() {
    val input = readInput("Day05")
     val emptyLine = input.indexOfFirst { it.isEmpty() }
    data class CrateMove(val items: Int, val from: Int, val to: Int)

    val regex = Regex("\\d+")


    fun parseCrateMove(command: String): CrateMove {
        val (num, from, to) = regex.findAll(command).map { it.value.toInt() }.toList()
        return CrateMove(num, from - 1, to - 1)
    }


    val moves: List<CrateMove> = input.drop(emptyLine + 1).map(::parseCrateMove)


    // Define the stacks
    val stack= mutableListOf<Stack<Char>>()
    // Define the data
    val data = listOf(
        listOf('W', 'B', 'D', 'N', 'C', 'F', 'J'),
        listOf('P', 'Z', 'V', 'Q', 'L', 'S', 'T'),
        listOf('P', 'Z', 'B', 'G', 'J', 'T'),
        listOf('D', 'T', 'L', 'J', 'Z', 'B', 'H', 'C'),
        listOf('G', 'V', 'B', 'J', 'S'),
        listOf('P', 'S', 'Q'),
        listOf('B', 'V', 'D', 'F', 'L', 'M', 'P', 'N'),
        listOf('P', 'S', 'M', 'F', 'B', 'D', 'L', 'R'),
        listOf('V', 'D', 'T', 'R')
    )

    for (i in data.indices) {
        val st=Stack<Char>()
        st.addAll(data[i])
        println("stack -> $st")
        stack.add(i,st)
    }



     fun CrateMove.moveAtOnce() = Stack<Char>().apply {
        repeat(items) {
            push(stack[from].pop())
        }
        repeat(items) {
            stack[to].push(pop())
        }
    }

    fun CrateMove.moveOneByOne() = repeat(items) {
        stack[to].push(stack[from].pop())
    }



    fun moveAll(mover: (move: CrateMove) -> Unit): String {
        moves.forEach(mover)
        return String(stack.map { it.pop() }.toCharArray())
    }


    fun part1(input: List<String>): String {
       return moveAll { move -> move.moveOneByOne() }
    }

    fun part2(input: List<String>): String {
        return moveAll { move -> move.moveAtOnce() }
    }




//    println("result part 1 ==  ${part1(input)}")
    println("result part 2 == ${part2(input)}")
}