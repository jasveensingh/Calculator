package com.github.jasveensingh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class MainActivity : AppCompatActivity() {

    private lateinit var numeralZeroBtn: Button
    private lateinit var numeralOneBtn: Button
    private lateinit var numeralTwoBtn: Button
    private lateinit var numeralThreeBtn: Button
    private lateinit var numeralFourBtn: Button
    private lateinit var numeralFiveBtn: Button
    private lateinit var numeralSixBtn: Button
    private lateinit var numeralSevenBtn: Button
    private lateinit var numeralEightBtn: Button
    private lateinit var numeralNineBtn: Button
    private lateinit var equalBtn: Button
    private lateinit var decimalBtn: Button
    private lateinit var additionBtn: Button
    private lateinit var subtractionBtn: Button
    private lateinit var multiplyBtn: Button
    private lateinit var divisionBtn: Button
    private lateinit var percentBtn: Button
    private lateinit var leftParenthesisBtn: Button
    private lateinit var rightParenthesisBtn: Button
    private lateinit var clearBtn: Button

    private lateinit var inputTextview: TextView
    private lateinit var outputTextview: TextView

    private lateinit var process: String
    private var checkBracket: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numeralZeroBtn = findViewById(R.id.numeral_zero_btn)
        numeralOneBtn = findViewById(R.id.numeral_one_btn)
        numeralTwoBtn = findViewById(R.id.numeral_two_btn)
        numeralThreeBtn = findViewById(R.id.numeral_three_btn)
        numeralFourBtn = findViewById(R.id.numeral_four_btn)
        numeralFiveBtn = findViewById(R.id.numeral_five_btn)
        numeralSixBtn = findViewById(R.id.numeral_six_btn)
        numeralSevenBtn = findViewById(R.id.numeral_seven_btn)
        numeralEightBtn = findViewById(R.id.numeral_eight_btn)
        numeralNineBtn = findViewById(R.id.numeral_nine_btn)

        equalBtn = findViewById(R.id.equal_btn)
        decimalBtn = findViewById(R.id.decimal_btn)
        additionBtn = findViewById(R.id.addition_btn)
        subtractionBtn = findViewById(R.id.subtraction_btn)
        multiplyBtn = findViewById(R.id.multiply_btn)
        divisionBtn = findViewById(R.id.division_btn)
        percentBtn = findViewById(R.id.percent_btn)
        leftParenthesisBtn = findViewById(R.id.left_parenthesis_btn)
        rightParenthesisBtn = findViewById(R.id.right_parenthesis_btn)
        clearBtn = findViewById(R.id.clear_btn)

        inputTextview = findViewById(R.id.input_textview)
        outputTextview = findViewById(R.id.output_textview)

        clearBtn.setOnClickListener {
            inputTextview.text = ""
            outputTextview.text = ""
        }

        numeralZeroBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "0"
        }

        numeralOneBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "1"
        }

        numeralTwoBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "2"
        }

        numeralThreeBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "3"
        }

        numeralFourBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "4"
        }

        numeralFiveBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "5"
        }

        numeralSixBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "6"
        }

        numeralSevenBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "7"
        }

        numeralEightBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "8"
        }

        numeralNineBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "9"
        }

        additionBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = "$process+"
        }

        subtractionBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = "$process-"
        }

        multiplyBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = process + "x"
        }

        divisionBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = "$process/"
        }

        decimalBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = "$process."
        }

        percentBtn.setOnClickListener {
            process = inputTextview.text.toString()
            inputTextview.text = "$process%"
        }

        leftParenthesisBtn.setOnClickListener {
            if(!checkBracket) {
                process = inputTextview.text.toString()
                inputTextview.text = "$process("
                checkBracket = true
            }
        }

        rightParenthesisBtn.setOnClickListener {
            if(checkBracket) {
                process = inputTextview.text.toString()
                inputTextview.text = "$process)"
                checkBracket = false
            }
        }

        equalBtn.setOnClickListener {
            process = inputTextview.text.toString()
            if(!"".equals(process)) {
                process = process.replace("x", "*")
                process = process.replace("%", "/100")

                var rhino: Context = Context.enter()
                rhino.optimizationLevel = -1

                outputTextview.text = try {
                    var scriptable: Scriptable = rhino.initStandardObjects()
                    rhino.evaluateString(scriptable, process, "javascript", 1, null).toString()
                } catch (e: Exception) {
                    "0"
                }
            }
        }

    }

}
