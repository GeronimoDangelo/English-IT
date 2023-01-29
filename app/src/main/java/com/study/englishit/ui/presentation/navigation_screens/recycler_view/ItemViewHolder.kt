package com.study.englishit.ui.presentation.navigation_screens.recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ItemViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}