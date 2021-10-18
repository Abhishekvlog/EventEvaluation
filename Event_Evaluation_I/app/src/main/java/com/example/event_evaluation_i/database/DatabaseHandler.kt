package com.example.event_evaluation_i.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.event_evaluation_i.model.EventModel

class DatabaseHandler(val context: Context) : SQLiteOpenHelper(context, "eventdb", null , 1) {
    companion object{
        val TABLE_NAME = "Event_Table"
        val ID = "id"
        val EVENT_DESC = "desc"
        val EVENT_DATE = "date"
        val EVENT_LOCATION = "location"
        val EVENT_PRICE = "price"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY ," +
                " $EVENT_DESC TEXT," +
                " $EVENT_DATE TEXT ," +
                " $EVENT_LOCATION TEXT ," +
                " $EVENT_PRICE TEXT)"
        db?.execSQL(createQuery)

    }

    fun InsertRoutine(desc : String , date : String , location : String , price : String){
        val db = writableDatabase

        val values = ContentValues()
        values.put(EVENT_DESC , desc)
        values.put(EVENT_DATE , date)
        values.put(EVENT_LOCATION , location)
        values.put(EVENT_PRICE , price )

        val id = db.insert(TABLE_NAME , null ,values)

        if (id.toInt() == -1){
            Toast.makeText(context , "Error in Insertion", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context , "Successfully Insertion", Toast.LENGTH_SHORT).show()
        }
    }

    fun ReteriveData() : MutableList<EventModel>{
        val listRoutine = mutableListOf<EventModel>()
        val db = readableDatabase
        val query = "Select * From $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0){
            cursor.moveToFirst()

            do {
                val idIndex = cursor.getColumnIndex(ID)
                val descIndex = cursor.getColumnIndex(EVENT_DESC)
                val dateIndex = cursor.getColumnIndex(EVENT_DATE)
                val locationIndex = cursor.getColumnIndex(EVENT_LOCATION)
                val priceIndex = cursor.getColumnIndex(EVENT_PRICE)

                val id = cursor.getInt(idIndex)
                val desc = cursor.getString(descIndex)
                val date = cursor.getString(dateIndex)
                val location = cursor.getString(locationIndex)
                val price = cursor.getString(priceIndex)

                val eventModel = EventModel(id, desc , date , location , price)
                listRoutine.add(eventModel)

            }while (cursor.moveToNext())
        }
        return listRoutine
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}