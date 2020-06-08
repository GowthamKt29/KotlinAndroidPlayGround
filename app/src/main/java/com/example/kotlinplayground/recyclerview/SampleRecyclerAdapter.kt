package com.example.kotlinplayground.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinplayground.R


import kotlinx.android.synthetic.main.item_layout.view.*

class SampleRecyclerAdapter(
    val context: Context,
    private val localData: ArrayList<LocalData>,
    private val onItemClickListener: (LocalData) -> Unit
) : RecyclerView.Adapter<SampleRecyclerAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: LocalData) {
            itemView.tv.text = data.name
//           itemView.setOnClickListener {
//               onItemClickListener
//           }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = localData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(localData.get(position))
        holder.itemView.setOnClickListener {
            onItemClickListener(localData.get(position))
        }
//        holder.itemView.setOnClickListener {
//            if (context is MainActivity) {
//                context.setPosition(localData.get(position).name)
//            }
//        }
    }


}

interface OnItemClickListener {
    fun onItemClicked(data: LocalData)
}