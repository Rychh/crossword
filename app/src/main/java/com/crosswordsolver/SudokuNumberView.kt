package com.crosswordsolver

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_game_view.view.*
import kotlinx.android.synthetic.main.activity_solved.view.*

class SudokuNumberView(context: Context, attrs: AttributeSet) : TextView(context, attrs) {

    var row: Int
    var column: Int

    init {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SudokuNumberView,
            0, 0
        ).apply {

            try {
                row = getInteger(R.styleable.SudokuNumberView_row_view, 1)
                column = getInteger(R.styleable.SudokuNumberView_column_view, 1)
                textSize = 30F
                var value = Sudoku.getNumber(row - 1, column - 1)
                if (value < 0) {
                    setTypeface(null, Typeface.BOLD)
                    setTextColor(Color.BLACK)
                    value *= -1
                } else {
                    setTypeface(null, Typeface.NORMAL)
                }
                if(((row-1)/3 + (column -1)/3)%2 == 0 )
                    setBackgroundColor(Color.parseColor("#ffcccc"))
                else
                    setBackgroundColor(Color.parseColor("#f2f2f2"))

                text = value.toString()

                println("OBTAINED NUMBER FOR ROW $row COLUMN $column: $text")

            } finally {
                recycle()
            }
        }
    }

}