package com.example.kotlinlevel1task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    private var data: List<Int> = arrayListOf()

    fun setData(data: List<Int>) {
        this.data = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainAdapter.RecyclerItemViewHolder {
        return RecyclerItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.square_item, parent, false) as View)
    }

    override fun onBindViewHolder(holder: MainAdapter.RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RecyclerItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind (data: Int) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                val thisView = itemView.findViewById<Button>(R.id.square)
                with(thisView) {
                    text = data.toString()
                    if (data % 2 == 0){
                        setBackgroundColor(resources.getColor(R.color.red))
                    } else {
                        setBackgroundColor(resources.getColor(R.color.blue))
                    }
                }
            }
        }
    }
}