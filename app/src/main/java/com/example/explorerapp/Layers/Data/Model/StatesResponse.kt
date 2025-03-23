package com.example.explorerapp.Layers.Data.Model

import com.example.explorerapp.Layers.Domain.Model.State
import com.google.gson.annotations.SerializedName

data class StatesResponse(
    val error: Boolean,
    val msg: String,
    val data: List<States>

)


data class States(
    @SerializedName("States") val states: List<State>
)