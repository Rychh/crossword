package com.crosswordsolver

class Problem {
    companion object {

        private var blank: Boolean = true

        private val SUDOKUS = arrayOf(
            arrayOf(
                intArrayOf(0, 0, 0, 2, 6, 0, 7, 0, 1),
                intArrayOf(6, 8, 0, 0, 7, 0, 0, 9, 0),
                intArrayOf(1, 9, 0, 0, 0, 4, 5, 0, 0),
                intArrayOf(8, 2, 0, 1, 0, 0, 0, 4, 0),
                intArrayOf(0, 0, 4, 6, 0, 2, 9, 0, 0),
                intArrayOf(0, 5, 0, 0, 0, 3, 0, 2, 8),
                intArrayOf(0, 0, 9, 3, 0, 0, 0, 7, 4),
                intArrayOf(0, 4, 0, 0, 5, 0, 0, 3, 6),
                intArrayOf(7, 0, 3, 0, 1, 8, 0, 0, 0)
            )
        )

        private val BLANK = Array(9) { IntArray(9) {0} }


        private fun getRandomSudoku(): Array<IntArray> {
            return SUDOKUS[0]
        }

        private fun getBlank(): Array<IntArray> {
            return BLANK
        }

        fun setBlank(_blank: Boolean) {
            blank = _blank
        }

        fun getSudokuLayout(): Array<IntArray> {
            return when (blank) {
                true -> getBlank()
                false -> getRandomSudoku()
            }
        }

    }
}