package yb.lol.tft.ui.compositions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import yb.lol.tft.models.entities.Composition

class CompositionsViewModel : ViewModel() {

    private val _comps = MutableLiveData<List<Composition>>().apply {
        value = listOf()
    }

    val compositions: MutableLiveData<List<Composition>> = _comps
}