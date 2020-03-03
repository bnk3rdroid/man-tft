package yb.lol.tft.di.components

import dagger.Component
import yb.lol.tft.activities.MainActivity
import yb.lol.tft.di.modules.AppModule
import yb.lol.tft.di.modules.ViewModelsModule
import yb.lol.tft.view_models.ChampionsViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelsModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    fun inject(championViewModel: ChampionsViewModel)

}