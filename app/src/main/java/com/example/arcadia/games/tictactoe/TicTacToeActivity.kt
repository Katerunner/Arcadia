package com.example.arcadia.games.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arcadia.MainMenuActivity
import com.example.arcadia.R
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToeActivity : AppCompatActivity() {
    private var tttGame = TicTacToeGame()
    private var inProgress = false
    private var isEnded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        TTTgoToMainMenu.setOnClickListener { onClickGoToMainMenu() }
        TTTrestart.setOnClickListener { onClickRestart() }

        TTTcomupterGoesFirstBtn.setOnClickListener {
            if (!inProgress) {
                tttGame.gameStep(-1, -1)
                displayField()
                inProgress = true
            }
        }

        cell11.setOnClickListener { gameStepWrapper(0, 0) }
        cell12.setOnClickListener { gameStepWrapper(0, 1) }
        cell13.setOnClickListener { gameStepWrapper(0, 2) }

        cell21.setOnClickListener { gameStepWrapper(1, 0) }
        cell22.setOnClickListener { gameStepWrapper(1, 1) }
        cell23.setOnClickListener { gameStepWrapper(1, 2) }

        cell31.setOnClickListener { gameStepWrapper(2, 0) }
        cell32.setOnClickListener { gameStepWrapper(2, 1) }
        cell33.setOnClickListener { gameStepWrapper(2, 2) }

        displayField()
    }

    private fun onClickGoToMainMenu() {
        val intent = Intent(this, MainMenuActivity::class.java)
        startActivity(intent)
    }


    private fun onClickRestart() {
        val intent = Intent(this, this::class.java)
        startActivity(intent)
    }

    private fun decodeNumber(rowId: Int, colId: Int): String {
        if (tttGame.field[rowId][colId] == 1) {
            return "⨉"
        }
        if (tttGame.field[rowId][colId] == 2) {
            return "ⵔ"
        }
        return ""
    }

    private fun gameStepWrapper(rowId: Int, colId: Int) {
        if (!isEnded) {

            inProgress = true
            val status = tttGame.gameStep(rowId, colId)

            displayField()


            if (status == 1) {
                isEnded = true
                TTTcomupterGoesFirstBtn.text = "You Win!"
                for (pair in tttGame.checkIfWin()) {
                    highlightWinningCombination(pair[0], pair[1])
                }

            } else if (status == 2) {
                isEnded = true
                TTTcomupterGoesFirstBtn.text = "You Lost!"
                for (pair in tttGame.checkIfWin()) {
                    highlightWinningCombination(pair[0], pair[1])
                }
            }
        }
    }

    private fun highlightWinningCombination(rowId: Int, colId: Int) {
        if (rowId == 0 && colId == 0) {
            cell11.textScaleX = 1.5F
        }
        if (rowId == 0 && colId == 1) {
            cell12.textScaleX = 1.5F
        }
        if (rowId == 0 && colId == 2) {
            cell13.textScaleX = 1.5F
        }

        if (rowId == 1 && colId == 0) {
            cell21.textScaleX = 1.5F
        }
        if (rowId == 1 && colId == 1) {
            cell22.textScaleX = 1.5F
        }
        if (rowId == 1 && colId == 2) {
            cell23.textScaleX = 1.5F
        }

        if (rowId == 2 && colId == 0) {
            cell31.textScaleX = 1.5F
        }
        if (rowId == 2 && colId == 1) {
            cell32.textScaleX = 1.5F
        }
        if (rowId == 2 && colId == 2) {
            cell33.textScaleX = 1.5F
        }
    }

    private fun displayField() {
        cell11.text = decodeNumber(0, 0)
        cell12.text = decodeNumber(0, 1)
        cell13.text = decodeNumber(0, 2)

        cell21.text = decodeNumber(1, 0)
        cell22.text = decodeNumber(1, 1)
        cell23.text = decodeNumber(1, 2)

        cell31.text = decodeNumber(2, 0)
        cell32.text = decodeNumber(2, 1)
        cell33.text = decodeNumber(2, 2)
    }


}