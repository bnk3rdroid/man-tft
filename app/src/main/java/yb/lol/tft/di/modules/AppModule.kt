package yb.lol.tft.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import yb.lol.tft.TFTApplication
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return TFTApplication.instance
    }

}