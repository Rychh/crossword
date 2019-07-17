package com.crosswordsolver

import android.app.Application

class Sudoku: Application() {
    companion object {

        private val ROWS = 9
        private val COLUMNS = 9

        private var numbers: Array<IntArray> = Problem.getSudokuLayout()

        fun getNumber(row: Int, col: Int): Int {
            if (row >= ROWS || col >= COLUMNS) return 0
            else return numbers[row][col]
        }

        fun setNumber(row: Int, col: Int, value: Int) {
            if (row >= ROWS || col >= COLUMNS) return
            else numbers[row][col] = value
        }

        fun getNumbersArray(): Array<IntArray> {
            return numbers
        }

        fun setNumbersArray(newNumbers :Array<IntArray>) {
            numbers = newNumbers
        }

    }
}