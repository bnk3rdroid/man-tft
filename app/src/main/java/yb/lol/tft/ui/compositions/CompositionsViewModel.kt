package yb.lol.tft.ui.compositions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import yb.lol.tft.models.Composition

class CompositionsViewModel : ViewModel() {

    private val _comps = MutableLiveData<ArrayList<Composition>>().apply {
        value = arrayListOf()
    }

    val compositions: MutableLiveData<ArrayList<Composition>> = _comps
}