package com.example.event_evaluation_i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.event_evaluation_i.adapter.EventAdapter
import com.example.event_evaluation_i.database.DatabaseHandler
import com.example.event_evaluation_i.listener.OnItemClick
import com.example.event_evaluation_i.model.EventModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*

class MainActivity : AppCompatActivity() , OnItemClick {
    private  var eventlist : MutableList<EventModel> = mutableListOf()
    lateinit var mAdapter: EventAdapter
    lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)
        eventlist = dbHandler.ReteriveData()
        mAdapter = EventAdapter(this, eventlist , this)
        recyclewView.layoutManager = LinearLayoutManager(this)

        recyclewView.adapter = mAdapter
        dbHandler = DatabaseHandler(this)

        BtnAdd.setOnClickListener {
            dbHandler.InsertRoutine("Desc", "10/10/21" , "Delhi", "100000")
        }
        BtnEdit.setOnClickListener {
            dbHandler.updateRoutine(1, "NewDesc" , " 12/12/21" , "Up" , "20000")
        }
        BtnDelete.setOnClickListener {
            dbHandler.deleteRoutine(1)
        }


    }

    override fun onEditBtn(eventModel: EventModel) {
        dbHandler.updateRoutine(eventModel.id , "NewDesc", "12/12/21" , "Up" , "2000")
        eventlist.clear()
        eventlist.addAll(dbHandler.ReteriveData())
        mAdapter.notifyDataSetChanged()
    }

    override fun onDeleteBtn(eventModel: EventModel) {
        dbHandler.deleteRoutine(eventModel.id)
        eventlist.clear()
        eventlist.addAll(dbHandler.ReteriveData())
        mAdapter.notifyDataSetChanged()
    }
}