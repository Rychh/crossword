package com.crosswordsolver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_game_view.*
import kotlinx.android.synthetic.main.activity_game_view.view.*

import kotlinx.android.synthetic.main.activity_solved.*
import kotlinx.android.synthetic.main.activity_solved.toolbar

class Solved : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Solved tk Oncreate\n")
        count(Sudoku.getNumbersArray())
        setContentView(R.layout.activity_solved)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private var base = Array(9, {IntArray(9)})
    private var result = Array(9, {IntArray(9)})
    private var solved = false


    private fun consolelog(tab : Array<IntArray>) {
        print("Tablica:\n")
        for (x in 0..8) {
            for (y in 0..8) {
                print(tab[x][y])
            }
            print("\n")
        }
    }

    public fun isBase(x: Int, y: Int) : Boolean {
        return base[x][y] != 0
    }

    public fun count(sudoku : Array<IntArray>) {
        for (x in 0..8) {
            for (y in 0..8) {
                result[x][y] = sudoku[x][y]
                base[x][y] = sudoku[x][y]
            }
        }
        solved = false
        solved = solve(0,0)
        consolelog(base)
        consolelog(result)
        for (x in 0..8) {
            for (y in 0..8) {
                if(base[x][y] != 0)
                    result[x][y] *= -1
            }
        }
        Sudoku.setNumbersArray(result)
    }

    public fun isSolved() : Boolean {
        return solved
    }

    public fun getResult() : Array<IntArray> {
        return result
    }

    private fun can_insert(x : Int, y : Int, value : Int) : Boolean {
        for (i in 0..8) {
            if (value == result[x][i] || value == result[i][y] ||
                value == result[x / 3 * 3 + i % 3][y / 3 * 3 + i / 3])
                return false
        }
        return true
    }

    private fun next(x : Int, y : Int) : Boolean {
        return if (x == 8 && y == 8) {
            true
        } else {
            if (x == 8)
                solve(0, y + 1)
            else
                solve(x + 1, y)
        }
    }

    private fun solve(x : Int, y : Int) : Boolean {
        println("liczonko")
        if (base[x][y] == 0) {
            for(i in 1..9) {
                if (can_insert(x, y, i)) {
                    result[x][y] = i
                    if (next(x, y))
                        return true
                }
            }
            result[x][y] = 0
            return false
        }
        return next(x, y)
    }
}
