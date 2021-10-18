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
import com.example.event_evaluation_i.model.EventModel

class EventAdapter(
    val context: Context,
    val listener: MutableList<EventModel>,
    val routineList: MainActivity
) : RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflter = LayoutInflater.from(context)
        val view : View = inflter.inflate(R.layout.item_layout,parent,false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val routine = routineList.get(position)
        holder.BtnEdit.setOnClickListener {
            listener.onEditBtn(routine)
        }
        holder.BtnDelete.setOnClickListener {
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
    lateinit var BtnEdit : Button
    lateinit var BtnDelete : Button

    init {
        desc = itemView.findViewById(R.id.TvEventName)
        date = itemView.findViewById(R.id.TvEventDate)
        location = itemView.findViewById(R.id.TvEventLocation)
        price = itemView.findViewById(R.id.TvEventPrice)
        BtnEdit = itemView.findViewById(R.id.BtnEdit)
        BtnDelete = itemView.findViewById(R.id.BtnDelete)
    }

}