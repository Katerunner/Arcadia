package com.example.arcadia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.adapters.GameListAdapter
import com.example.arcadia.domains.GameDomain
import com.example.arcadia.games.tictactoe.TicTacToeActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.game_viewholder.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

//        textView.setOnClickListener {
//            val intent = Intent(this, TicTacToeActivity::class.java)
//            startActivity(intent)
//        }

        val recyclerView: RecyclerView = findViewById(R.id.gamesList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GameListAdapter(fillGamesList())
    }

    private fun fillGamesList(): ArrayList<GameDomain> {
        val games = ArrayList<GameDomain>()

        games.add(GameDomain("Tic-Tac-Toe", "Competitive", TicTacToeActivity()))
//        games.add(GameDomain("Sudoku", "Competitive", "NaN"))
//        games.add(GameDomain("Minesweeper", "Competitive", "NaN"))
//        games.add(GameDomain("Nonograms", "Competitive", "NaN"))

        return games
    }


}