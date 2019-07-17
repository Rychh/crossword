package com.crosswordsolver

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_game_view.*
import android.content.Intent



class GameView() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Sudoku.setNumbersArray(Problem.getSudokuLayout())
        setContentView(R.layout.activity_game_view)
        setSupportActionBar(toolbar)


        solve_button.setOnClickListener { view ->
            try {
                print("GameView  przed\n")
                val k = Intent(this@GameView, Solved::class.java)
                print("GameView  w\n")

                startActivity(k)
                print("GameView  po\n")
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
