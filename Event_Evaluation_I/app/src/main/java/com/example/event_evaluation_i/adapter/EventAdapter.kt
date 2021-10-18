package com.example.event_evaluation_i.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.event_evaluation_i.MainActivity
import com.example.event_evaluation_i.R
import com.example.event_evaluation_i.listener.OnItemClick
import com.example.event_evaluation_i.model.EventModel

class EventAdapter(
    val context: Context,
    val routineList : MutableList<EventModel>,
    val listener : OnItemClick
) : RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflter = LayoutInflater.from(context)
        val view : View = inflter.inflate(R.layout.item_layout,parent,false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val routine = routineList.get(position)
        holder.btnEdit.setOnClickListener {
            listener.onEditBtn(routine)
        }
        holder.btnDelete.setOnClickListener {
            listener.onDeleteBtn(routine)
        }
    }

    override fun getItemCount(): Int {
        return routineList.size
    }
}
class EventViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    lateinit var desc : TextView
    lateinit var date : TextView
    lateinit var location : TextView
    lateinit var price : TextView
    lateinit var btnEdit : Button
    lateinit var btnDelete : Button

    init {
        desc = itemView.findViewById(R.id.TvEventName)
        date = itemView.findViewById(R.id.TvEventDate)
        location = itemView.findViewById(R.id.TvEventLocation)
        price = itemView.findViewById(R.id.TvEventPrice)
        btnEdit = itemView.findViewById(R.id.BtnEdit)
        btnDelete = itemView.findViewById(R.id.BtnDelete)
    }

}