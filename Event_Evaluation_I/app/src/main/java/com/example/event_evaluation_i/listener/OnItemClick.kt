package com.example.event_evaluation_i.listener

import com.example.event_evaluation_i.model.EventModel

interface OnItemClick {
    fun onEditBtn(eventModel: EventModel)
    fun onDeleteBtn(eventModel: EventModel)
}