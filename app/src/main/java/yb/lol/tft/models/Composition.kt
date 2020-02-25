package yb.lol.tft.models

data class Composition(
    val name: String,
    val types: ArrayList<Type>,
    val rank: Rank,
    val optimalChampions: ArrayList<Champion>,
    val carries: Map<Champion, ArrayList<Item>>,
    val coreChampions: ArrayList<Champion>,
    val alternatives: Map<ArrayList<Champion>, ArrayList<Champion>>?
)