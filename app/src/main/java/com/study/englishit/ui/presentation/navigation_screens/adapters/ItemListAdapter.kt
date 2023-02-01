package com.study.englishit.ui.presentation.navigation_screens.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.study.englishit.databinding.CardItemBinding
import com.study.englishit.domain.model.CardItemModel
import com.study.englishit.ui.common.ItemViewHolder

class ItemListAdapter(): ListAdapter<CardItemModel, ItemViewHolder<*>>(DiffUtilCallBack){

    private object DiffUtilCallBack : DiffUtil.ItemCallback<CardItemModel>() {
        override fun areItemsTheSame(oldItem: CardItemModel, newItem: CardItemModel): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: CardItemModel, newItem: CardItemModel): Boolean = oldItem.hashCode() == newItem.hashCode()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<*> {
        val itemBinding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return BindViewHolderList(itemBinding)
    }



    override fun onBindViewHolder(holder: ItemViewHolder<*>, position: Int) {
        when(holder) {
            is BindViewHolderList -> holder.bind(getItem(position),position)
        }
    }

    inner class BindViewHolderList(private val itemBinding: CardItemBinding): ItemViewHolder<CardItemModel>(itemBinding.root) {
        override fun bind(item: CardItemModel, position: Int) = with(itemBinding) {
            tvTitle.text = item.title
            ivFoxItem.setImageResource(item.img)
            cardItem.setOnClickListener{
                onCardItemClickListener?.let {click ->
                    click(item)
                }
            }
        }

        override fun isAnyItemExpanded(position: Int) {
            TODO("Not yet implemented")
        }

    }

    private var onCardItemClickListener : ((CardItemModel) -> Unit) ? = null

    fun setCardItemClickListener(listener: (CardItemModel) -> Unit) {
        onCardItemClickListener = listener
    }

}


