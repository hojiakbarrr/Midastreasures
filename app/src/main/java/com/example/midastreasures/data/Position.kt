package com.example.midastreasures.data

import java.io.Serializable

class Position(

    var row0IsClickes: Boolean = false,
    var row1IsClickes: Boolean = false,
    var row2IsClickes: Boolean = false,
    var row3IsClickes: Boolean = false,
    var row4IsClickes: Boolean = false,
    var row5IsClickes: Boolean = false,
    var score0: Int = 0,
    var score1: Int = 0,
    var score2: Int = 0,
    var score3: Int = 0,
    var score4: Int = 0,
    var score5: Int = 0,


    ) : Serializable{
}