package com.androidavanzado.rickandmortyapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidavanzado.rickandmortyapp.R
import com.androidavanzado.rickandmortyapp.domain.model.Result
import com.androidavanzado.rickandmortyapp.presentation.views.OnItemClickListener
import com.bumptech.glide.Glide

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var results = ArrayList<Result>()
    lateinit var onItemClickListener : OnItemClickListener

    fun setListData(data: ArrayList<Result>, onItemClickListener : OnItemClickListener){
        this.results = data
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_list_rows, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(holder.characterImageIv)
            .load(results[position].image)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.characterImageIv)

        holder.characterNameTv.text = results[position].name
        holder.characterSpeciesTv.text = results[position].species
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClickListener(results[position])
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val characterImageIv = view.findViewById<ImageView>(R.id.characterImageIv)
        val characterNameTv = view.findViewById<TextView>(R.id.characterNameTv)
        val characterSpeciesTv = view.findViewById<TextView>(R.id.characterSpeciesTv)
    }

}