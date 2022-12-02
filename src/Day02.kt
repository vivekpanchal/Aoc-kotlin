fun main() {


    fun part1(input: List<String>): Int {
        //region first Approach
        var score = 0
        /**
         * Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
         *
         *  A for Rock    || X for Rock  =1 score
         *  B for paper   || Y for paper  =2 score
         *  C for Scissors || z for Scissors =3 score
         *
         *   (0 if you lost, 3 if the round was a draw, and 6 if you won).
         */
        for (i in input) {
            val arr = i.split(" ").toTypedArray()
            val opponent = arr[0]
            val player = arr[1]
            when(opponent){
                "A"->{
                    when(player){
                        "X"->{
                            score+=1
                            //draw
                            score+=3

                        }
                        "Y"->{
                            score+=2
                            //win
                            score+=6
                        }
                        "Z"->{
                            score+=3
                            //loss
                            score+=0

                        }
                    }
                }
                "B"->{
                    when(player){
                        "X"->{
                            score+=1
                            //loss
                            score+=0

                        }
                        "Y"->{
                            score+=2
                            //draw
                            score+=3
                        }
                        "Z"->{
                            score+=3
                            //win
                            score+=6

                        }
                    }
                }
                "C"->{
                    when(player){
                        "X"->{
                            score+=1
                            //win
                            score+=6

                        }
                        "Y"->{
                            score+=2
                            //loss
                            score+=0
                        }
                        "Z"->{
                            score+=3
                            //draw
                            score+=3

                        }
                    }
                }
            }
        }
        //endregion


        //region






        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        /**
         * Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
         *
         *  A for Rock    ||  Rock  =1 score
         *  B for paper   ||  paper  =2 score
         *  C for Scissors || Scissors =3 score
         *  X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
         *
         *   (0 if you lost, 3 if the round was a draw, and 6 if you won).
         */
        for (i in input) {
            val arr = i.split(" ").toTypedArray()
            val opponent = arr[0]
            when(arr[1]){
                "X"->{
                    //Loose
                    score+=0
                    when(opponent){
                        "A"->{
                            score+=3
                        }
                        "B"->{
                            score+=1
                        }
                        "C"->{
                            score+=2
                        }
                    }


                }
                "Y"->{
                    //Draw
                    score+=3
                    when(opponent){
                        "A"->{
                            score+=1
                        }
                        "B"->{
                            score+=2
                        }
                        "C"->{
                            score+=3
                        }
                    }

                }
                "Z"->{
                    //win
                    score+=6
                    when(opponent){
                        "A"->{
                            score+=2
                        }
                        "B"->{
                            score+=3
                        }
                        "C"->{
                            score+=1
                        }
                    }
                }
            }



        }
        return score
    }

    val input = readInput("Day02")
    println("part 1 ${part1(input)}")
    println("part 2 ${part2(input)}")
}