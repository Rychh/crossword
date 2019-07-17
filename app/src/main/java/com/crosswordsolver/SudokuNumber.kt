package com.crosswordsolver

import android.content.Context
import android.graphics.Color
import android.text.InputType
import android.util.AttributeSet
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import androidx.core.text.set

class SudokuNumber(context: Context, attrs: AttributeSet) : EditText(context, attrs) {

    var row: Int
    var column: Int

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SudokuNumber,
            0, 0).apply {

            try {
                row = getInteger(R.styleable.SudokuNumber_row, 1)
                column = getInteger(R.styleable.SudokuNumber_column, 1)

                setText(Sudoku.getNumber(row-1, column-1).toString())

                if(((row-1)/3 + (column -1)/3)%2 == 0 )
                    setBackgroundColor(Color.parseColor("#ffcccc"))
                else
                    setBackgroundColor(Color.parseColor("#f2f2f2"))

            } finally {
                recycle()
            }
        }

        this.inputType = InputType.TYPE_CLASS_NUMBER

        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                var value: Int
                if (p0 == null  || p0.isEmpty())
                    value = 0
                else
                    value = p0.toString().toInt()
                Sudoku.setNumber(row-1, column-1, value)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
}