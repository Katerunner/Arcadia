package com.example.arcadia.games.tictactoe

import kotlin.random.Random

class TicTacToeGame(val skillMode: String = "easy") {
    val field: Array<IntArray> =
        arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))


    fun gameStep(rowId: Int, colId: Int): Int {
        if (rowId == -1) {
            makeComputerMove()
            return resolveWinner(checkIfWin())

        } else {
            makePlayerMove(rowId, colId)

            var status = resolveWinner(checkIfWin())

            if (status == -1) {
                makeComputerMove()
            }

            status = resolveWinner(checkIfWin())

            return status
        }
    }

    private fun resolveWinner(result: Array<IntArray>): Int {
        if (result[0][0] == -1) {
            return -1
        }
        return field[result[0][0]][result[0][1]]
    }

    private fun makePlayerMove(rowId: Int, colId: Int) {
        field[rowId][colId] = 1
    }

    fun checkIfWin(): Array<IntArray> {
        for (i in 0..2) {
            if ((field[i][0] != 0) && (field[i][0] == field[i][1]) && (field[i][1] == field[i][2])) {
                return arrayOf(intArrayOf(i, 0), intArrayOf(i, 1), intArrayOf(i, 2))
            }
        }

        for (j in 0..2) {
            if ((field[0][j] != 0) && (field[0][j] == field[1][j]) && (field[1][j] == field[2][j])) {
                return arrayOf(intArrayOf(0, j), intArrayOf(1, j), intArrayOf(2, j))
            }
        }


        if ((field[0][0] != 0) && (field[0][0] == field[1][1]) && (field[1][1] == field[2][2])) {
            return arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 2))
        }

        if ((field[2][0] != 0) && (field[2][0] == field[1][1]) && (field[1][1] == field[0][2])) {
            return arrayOf(intArrayOf(2, 0), intArrayOf(1, 1), intArrayOf(0, 2))
        }

        return arrayOf(intArrayOf(-1, -1), intArrayOf(-1, -1), intArrayOf(-1, -1))
    }

    private fun makeComputerMove() {
        val freePlaces = ArrayList<IntArray>()

        for (i in 0..2) {
            for (j in 0..2) {
                if (field[i][j] == 0) {
                    freePlaces.add(intArrayOf(i, j))
                }
            }
        }

        val randomIndex = Random.nextInt(freePlaces.size)
//        println("Step")
//        for (i in freePlaces[randomIndex]) {
//            println(i)
//        }
        field[freePlaces[randomIndex][0]][freePlaces[randomIndex][1]] = 2

    }
}