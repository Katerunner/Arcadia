package com.example.arcadia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.R
import com.example.arcadia.domains.GameDomain

class GameListAdapter(private val games: ArrayList<GameDomain>) : RecyclerView
.Adapter<GameListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.gameViewholderTitle)
        val genre: TextView = itemView.findViewById(R.id.gameViewholderGenre)
        val pic: ImageView = itemView.findViewById(R.id.gameViewholderIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_viewholder, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = games[position].title
        holder.genre.text = games[position].genre
    }

    override fun getItemCount() = games.size
}