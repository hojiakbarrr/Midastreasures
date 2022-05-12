package com.example.midastreasures.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.midastreasures.data.Position
import com.example.midastreasures.R
import javax.inject.Inject


var matrix = arrayOf(
    //
    arrayOf(0, 0, 0, 0),  //a1,a2,a3,a4
    arrayOf(0, 0, 0, 0),  //b1,b2,b3,b4
    arrayOf(0, 0, 0, 0),  //c1,c2,c3,c4
    arrayOf(0, 0, 0, 0),  //d1,d2,d3,d4
    arrayOf(0, 0, 0, 0),  //e1,e2,e3,e4
    arrayOf(0, 0, 0, 0),  //f1,f2,f3,f4
)

private var list: ArrayList<Position> = ArrayList()
private var coin: Int = R.drawable.coin

class GameViewModel @Inject constructor(

) : ViewModel() {
    // TODO: Implement the ViewModel
    private var scoreLiveData = MutableLiveData<String>()
    private var totalScoreLiveData = MutableLiveData<String>()
    private var loseScoreLiveData = MutableLiveData<String>()

    fun observeLoseScore(): LiveData<String> {
        return loseScoreLiveData
    }

    fun observeScore(): LiveData<String> {
        return scoreLiveData
    }

    fun observeTotalScore(): LiveData<String> {
        return totalScoreLiveData
    }

    fun startAgain() {
        list.add(Position(score0 = 100, row0IsClickes = false))
        list.add(Position(score1 = 500, row0IsClickes = false))
        list.add(Position(score2 = 2000, row0IsClickes = false))
        list.add(Position(score3 = 10000, row0IsClickes = false))
        list.add(Position(score4 = 50000, row0IsClickes = false))
        list.add(Position(score5 = 2000000, row0IsClickes = false))
    }

    fun attempt(box: String) {

        list.add(Position(score0 = 100))
        list.add(Position(score1 = 500))
        list.add(Position(score2 = 2000))
        list.add(Position(score3 = 10000))
        list.add(Position(score4 = 50000))
        list.add(Position(score5 = 2000000))


        list.get(0).score0 = 100
        list.get(0).score1 = 500
        list.get(0).score2 = 2000
        list.get(0).score3 = 10000
        list.get(0).score4 = 50000
        list.get(0).score5 = 2000000


        var columns = (0..3).random()


//////////////////////////////////////////////////////////////

        matrix[0][columns] = coin
        matrix[1][columns] = coin
        matrix[2][columns] = coin
        matrix[3][columns] = coin
        matrix[4][columns] = coin
        matrix[5][columns] = coin

//////////////////////////////////////////////////////////////


        if (box.equals("00")) {
            if (!list.get(0).row0IsClickes && matrix[0][0] == coin) {
                scoreLiveData.value = list.get(0).score0.toString()
                list.get(0).row0IsClickes = true
                Log.d("Test", "00")
            } else if (!list.get(0).row0IsClickes && matrix[0][1] == coin) {
                scoreLiveData.value = list.get(0).score0.toString()
                list.get(0).row0IsClickes = true
                Log.d("Test", "01")
            } else if (!list.get(0).row0IsClickes && matrix[0][2] == coin) {
                scoreLiveData.value = list.get(0).score0.toString()
                list.get(0).row0IsClickes = true
                Log.d("Test", "02")
            } else if ( !list.get(0).row0IsClickes && matrix[0][3] == coin) {
                scoreLiveData.value = list.get(0).score0.toString()
                list.get(0).row0IsClickes = true
                Log.d("Test", "03")
            } else {
                loseScoreLiveData.value = "0"
                Log.d("Teste", "don't work is 1 row")
                list.get(0).row0IsClickes = true
            }
        }

//////////////////////////////////////////////////////////////

        else if (box.equals("10")) {
            if (!list.get(0).row1IsClickes && matrix[1][0] == coin) {
                scoreLiveData.value = list.get(0).score1.toString()
                list.get(0).row1IsClickes = true
                Log.d("Test", "10")
            } else if (!list.get(0).row1IsClickes && matrix[1][1] == coin) {
                scoreLiveData.value = list.get(0).score1.toString()
                list.get(0).row1IsClickes = true
                Log.d("Test", "11")
            } else if (!list.get(0).row1IsClickes && matrix[1][2] == coin) {
                scoreLiveData.value = list.get(0).score1.toString()
                list.get(0).row1IsClickes = true
                Log.d("Test", "12")
            } else if ( !list.get(0).row1IsClickes && matrix[1][3] == coin) {
                scoreLiveData.value = list.get(0).score1.toString()
                list.get(0).row1IsClickes = true
                Log.d("Test", "13")
            } else {
                loseScoreLiveData.value = "0"
                list.get(0).row1IsClickes = true
            }

        }


//////////////////////////////////////////////////////////////

        else if (box.equals("20")) {
            if (!list.get(0).row2IsClickes && matrix[2][0] == coin) {
                scoreLiveData.value = list.get(0).score2.toString()
                list.get(0).row2IsClickes = true
                Log.d("Test", "20")
            } else if (!list.get(0).row2IsClickes && matrix[2][1] == coin) {
                scoreLiveData.value = list.get(0).score2.toString()
                list.get(0).row2IsClickes = true
                Log.d("Test", "21")
            } else if ( !list.get(0).row2IsClickes && matrix[2][2] == coin) {
                scoreLiveData.value = list.get(0).score2.toString()
                list.get(0).row2IsClickes = true
                Log.d("Test", "22")
            } else if (!list.get(0).row2IsClickes && matrix[2][3] == coin) {
                scoreLiveData.value = list.get(0).score2.toString()
                list.get(0).row2IsClickes = true
                Log.d("Test", "23")
            } else {
                loseScoreLiveData.value = "0"
                list.get(0).row2IsClickes = true
            }
        }


//////////////////////////////////////////////////////////////
        else if (box.equals("31")) {
            if (!list.get(0).row3IsClickes && matrix[3][0] == coin) {
                scoreLiveData.value = list.get(0).score3.toString()
                list.get(0).row3IsClickes = true
                Log.d("Test", "30")
            } else if (!list.get(0).row3IsClickes && matrix[3][1] == coin) {
                scoreLiveData.value = list.get(0).score3.toString()
                list.get(0).row3IsClickes = true
                Log.d("Test", "31")
            } else if (!list.get(0).row3IsClickes && matrix[3][2] == coin) {
                scoreLiveData.value = list.get(0).score3.toString()
                list.get(0).row3IsClickes = true
                Log.d("Test", "32")
            } else if (!list.get(0).row3IsClickes && matrix[3][3] == coin) {
                scoreLiveData.value = list.get(0).score3.toString()
                list.get(0).row3IsClickes = true
                Log.d("Test", "33")
            } else {
                loseScoreLiveData.value = "0"
                list.get(0).row3IsClickes = true
            }
        }


//////////////////////////////////////////////////////////////
        else if (box.equals("40")) {
            if (!list.get(0).row4IsClickes && matrix[4][0] == coin) {
                scoreLiveData.value = list.get(0).score4.toString()
                list.get(0).row4IsClickes = true
                Log.d("Test", "40")
            } else if ( !list.get(0).row4IsClickes && matrix[4][1] == coin) {
                scoreLiveData.value = list.get(0).score4.toString()
                list.get(0).row4IsClickes = true
                Log.d("Test", "41")
            } else if (!list.get(0).row4IsClickes && matrix[4][2] == coin) {
                scoreLiveData.value = list.get(0).score4.toString()
                list.get(0).row4IsClickes = true
                Log.d("Test", "42")
            } else if ( !list.get(0).row4IsClickes && matrix[4][3] == coin) {
                scoreLiveData.value = list.get(0).score4.toString()
                list.get(0).row4IsClickes = true
                Log.d("Test", "43")
            } else {
                loseScoreLiveData.value = "0"
                list.get(0).row4IsClickes = true
            }
        }

//////////////////////////////////////////////////////////////

        else if (box.equals("50")) {
            if (!list.get(0).row5IsClickes && matrix[5][0] == coin) {
                totalScoreLiveData.value = list.get(0).score5.toString()
                list.get(0).row5IsClickes = true
                Log.d("Test", "50")
            } else if ( !list.get(0).row5IsClickes && matrix[5][1] == coin) {
                totalScoreLiveData.value = list.get(0).score5.toString()
                list.get(0).row5IsClickes = true
                Log.d("Test", "51")
            } else if ( !list.get(0).row5IsClickes && matrix[5][2] == coin) {
                totalScoreLiveData.value = list.get(0).score5.toString()
                list.get(0).row5IsClickes = true
                Log.d("Test", "52")
            } else if ( !list.get(0).row5IsClickes && matrix[5][3] == coin) {
                totalScoreLiveData.value = list.get(0).score5.toString()
                list.get(0).row5IsClickes = true
                Log.d("Test", "53")
            } else {
                loseScoreLiveData.value = "0"
                list.get(0).row5IsClickes = true
                Log.d("Test", "guessed wrong")
            }
        }else{
            loseScoreLiveData.value = "0"
        }


    }
}