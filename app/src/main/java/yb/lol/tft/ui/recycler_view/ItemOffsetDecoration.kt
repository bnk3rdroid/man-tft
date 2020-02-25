package yb.lol.tft.ui.recycler_view

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(
    private val ctx: Context,
    private val itemOffset: Int
) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(0, 0, 0, ctx.resources.getDimensionPixelSize(itemOffset))
    }
}