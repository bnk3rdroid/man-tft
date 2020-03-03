package yb.lol.tft.di.modules

import dagger.Module
import dagger.Provides
import yb.lol.tft.databases.TFTDatabase
import yb.lol.tft.repositories.ChampionRepository
import javax.inject.Singleton

@Module(includes = [AppModule::class])
object ViewModelsModule {

    @Singleton
    @Provides
    fun provideChampionRepository(database: TFTDatabase): ChampionRepository {
        val championDAO = database.getChampionDao()
        val compositionChampionJoinDao = database.getCompositionChampionJoinDao()
        val championItemJoinDao = database.getChampionItemJoinDao()
        return ChampionRepository(championDAO, compositionChampionJoinDao, championItemJoinDao)
    }

}