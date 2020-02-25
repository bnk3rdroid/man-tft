package yb.lol.tft.ui.champions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import yb.lol.tft.models.Champion

class ChampionsViewModel:ViewModel() {

    private val _champions = MutableLiveData<ArrayList<Champion>>().apply {
        value = arrayListOf()
    }

    val champions: MutableLiveData<ArrayList<Champion>> = _champions
}