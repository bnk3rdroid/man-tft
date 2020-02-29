package yb.lol.tft.ui.test.adapter

interface ITestAdapter<in T> {
    fun update(newData: List<T>)
}