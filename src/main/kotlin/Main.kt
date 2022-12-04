import java.io.File

fun main(args: Array<String>) {
//    //TODO https://adventofcode.com/2022/day/1
//    val file = File("/home/akakyi/projects/cosysoft/advent2022/src/main/kotlin/newDoc.txt")
//    var blocks = mutableListOf<Long>()
//    blocks.add(0)
//    var currentBlockIndex = 0
//    file.forEachLine {
//        if (it == "") {
//            currentBlockIndex++
//            blocks.add(0)
//        } else {
//            val currentCalories = it.toLong()
//            blocks[currentBlockIndex] += currentCalories
//        }
//    }
//    blocks.sortDescending()
//    println(blocks[0])
//    println(blocks[1])
//    println(blocks[2])

//    //TODO https://adventofcode.com/2022/day/2
//    val file = File("//home/akakyi/projects/cosysoft/advent2022/src/main/kotlin/newDoc 2.txt")
//    val winMap = mapOf(
//        "A" to "PAPER",
//        "B" to "SCISSORS",
//        "C" to "ROCK"
//    )
//    val drawMap = mapOf(
//        "A" to "ROCK",
//        "B" to "PAPER",
//        "C" to "SCISSORS"
//    )
//    val looseMap = mapOf(
//        "A" to "SCISSORS",
//        "B" to "ROCK",
//        "C" to "PAPER"
//    )
//    val pointsMap = mapOf(
//        "ROCK" to 1,
//        "PAPER" to 2,
//        "SCISSORS" to 3
//    )
//    val strategyMap = mapOf(
//        "X" to looseMap,
//        "Y" to drawMap,
//        "Z" to winMap
//    )
//    var total = 0
//    file.forEachLine {
//        val input = it.split(" ")
//        val enemyInput = input[0]
//        val strategy = input[1]
//        val chooseDirection = strategyMap[strategy] ?: throw RuntimeException("Null?")
//        val myInput = chooseDirection[enemyInput]
//
//        val forChooseScore = pointsMap[myInput] ?: throw RuntimeException("Null?")
//        val winLooseScore = if (winMap[enemyInput] == myInput) {
//            6
//        } else if (drawMap[enemyInput] == myInput) {
//            3
//        } else {
//            0
//        }
//        total += forChooseScore + winLooseScore
//    }
//    println(total)

//    //TODO https://adventofcode.com/2022/day/3
//    val lowerShift = 96
//    val upperShift = 38
//    println('a'.toInt() - lowerShift)
//    println('z'.toInt() - lowerShift)
//    println('A'.toInt() - upperShift)
//    println('Z'.toInt() - upperShift)
//
//    var scoreCount = 0
//    val file = File("/home/akakyi/projects/cosysoft/advent2022/src/main/kotlin/newDoc 3.txt")
//    file.forEachLine {
//        val firstHalf = it.substring(0 until (it.length / 2))
//        val secondHalf = it.substring(it.length / 2 until it.length)
//
//        scoreCount += firstHalf.filter { ch ->
//            secondHalf.contains(ch)
//        }.toSet().map { ch ->
//            when (ch) {
//                in 'a'..'z' -> {
//                    ch.toInt() - lowerShift
//                }
//                in 'A'..'Z' -> {
//                    ch.toInt() - upperShift
//                }
//                else -> {
//                    0
//                }
//            }
//        }.reduce { acc, sc ->
//            acc + sc
//        }
//    }
//    println(scoreCount)

    //TODO https://adventofcode.com/2022/day/3#part2
    val lowerShift = 96
    val upperShift = 38

    var groupItemsCounter = 0
    var crossingChars = ""
    var badgesPrioritiesCounter = 0
    val file = File("/home/akakyi/projects/cosysoft/advent2022/src/main/kotlin/newDoc 4.txt")
    file.forEachLine {
        if (groupItemsCounter == 0) {
            crossingChars = it
        }

        crossingChars = it.filter { ch -> crossingChars.contains(ch) }

        if (groupItemsCounter >= 2) {
            badgesPrioritiesCounter += crossingChars
                .toSet()
                .map { ch ->
                    when (ch) {
                        in 'a'..'z' -> {
                            ch.toInt() - lowerShift
                        }
                        in 'A'..'Z' -> {
                            ch.toInt() - upperShift
                        }
                        else -> {
                            0
                        }
                    }
                }.reduce { acc, sc ->
                    acc + sc
                }
            groupItemsCounter = 0
        } else {
            groupItemsCounter++
        }
    }

    println(badgesPrioritiesCounter)
}
