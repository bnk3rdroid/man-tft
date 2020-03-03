package yb.lol.tft

import android.app.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TFTApplication @Inject constructor() : Application() {

    companion object {
        lateinit var instance: TFTApplication
            private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}