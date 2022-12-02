fun main() {
    fun part1(input: List<String>): Int {

        //region using maps
//        val elf = mutableMapOf<Int, Int>()
//        var elfCount = 1
//        var inventory = 0
//        var isElf=true
//        input.forEach {
//            if (it.isNotEmpty()) {
//                if (!isElf){
//                    isElf=true
//                    elfCount++
//                }
//                inventory += it.toInt()
//                elf[elfCount] = inventory
//            }else{
//                inventory=0
//                isElf=false
//            }
//        }
//        elf.map { (key, value) -> println("$key = $value") }
//        val maxInventory=elf.maxBy { it.value }
//        println("max inventory ==${maxInventory.key} value : ${maxInventory.value}")
//        return maxInventory.key
        //endregion maps

        //region simple max calculation
        var maxCalorie = 0
        var current = 0
        for (s in input) {
            if (s.equals("")) {
                maxCalorie = Math.max(maxCalorie, current)
                current = 0
            } else {
                current += s.toInt()
            }
        }
        return Math.max(maxCalorie, current)
        //endregion
    }

    //optimised
    fun part1(input: String): Int {
        val score = input
            .split("\n\n")
            .maxOf {
                it.split("\n").sumOf(String::toInt)
            }
        return score
    }


    fun part2(input: List<String>): Int {
        val listCalories = mutableListOf<Int>()
        var current = 0;
        for (s in input) {
            if (s.isBlank()) {
                listCalories.add(current)
                current = 0
            } else {
                //iterating and adding the current calories stored by elf
                current += s.toInt()
            }
        }
        listCalories.sort()
        var ans = 0
        listCalories.takeLast(3).forEach {
            ans += it
        }
        return ans
    }

    //optimised solution
//    fun part2(input: String): Int{
//       val score= input
//            .split("\n\n")
//            .map { it.split("\n").sumOf(String::toInt) }
//            .sorted()
//            .takeLast(3)
//            .sum()
//        return score
//    }

    val input = readInput("Day01")
    val inputString = readInputAsText("Day01")

    println(part1(input))
    println(part1(inputString))

    println(part2(input))
//    println(part2(inputString))


}
