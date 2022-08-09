package com.example.arcadia.games.tictactoe

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.R
import com.example.arcadia.adapters.GameListAdapter
import com.example.arcadia.adapters.GameListAdapter.MyViewHolder
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToeAdapter(val game: TicTacToeGame) {

    fun decodeNumber(rowId: Int, colId: Int): String {
        if (game.field[rowId][colId] == 1) {
            return "X"
        }
        if (game.field[rowId][colId] == 2) {
            return "O"
        }

        return ""
    }
}