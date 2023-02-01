package com.study.englishit.ui.presentation.navigation_screens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.study.englishit.databinding.PhrasesItemBinding
import com.study.englishit.domain.model.PhrasesModel
import com.study.englishit.ui.common.ItemViewHolder

class DetailsListAdapter() : ListAdapter<PhrasesModel,ItemViewHolder<*>>(DiffUtilCallBack) {

    private object DiffUtilCallBack : DiffUtil.ItemCallback<PhrasesModel>() {
        override fun areItemsTheSame(oldItem: PhrasesModel, newItem: PhrasesModel): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PhrasesModel, newItem: PhrasesModel): Boolean = oldItem.hashCode() == newItem.hashCode()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<*> {
        val detailsItemBinding = PhrasesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolderDetailsList(detailsItemBinding)
    }

    inner class BindViewHolderDetailsList( private val detailsItemBinding: PhrasesItemBinding): ItemViewHolder<PhrasesModel>(detailsItemBinding.root) {
        override fun bind(item: PhrasesModel, position: Int) = with(detailsItemBinding){
            tvTitlePhrase.text = item.title
            tvDescPhrase.text= item.desc

            val isExpandible : Boolean = item.isExpandable
            tvDescPhrase.visibility = if (isExpandible) View.VISIBLE else View.GONE
            cardView.visibility = if (isExpandible) View.VISIBLE else View.GONE
            translateBG.visibility = if (isExpandible) View.VISIBLE else View.GONE


            constraitLayoutDesc.setOnClickListener {
                isAnyItemExpanded(position)
                item.isExpandable = !item.isExpandable
                notifyItemChanged(position)
            }

            translateBG.setOnClickListener {
                onDetailsItemClickListener?.let { click ->
                    click(item)
                }
            }



        }

        override fun isAnyItemExpanded(position: Int) {
            val current = currentList.indexOfFirst {
                it.isExpandable
            }
            if (current >= 0 && current != position){
                currentList[current].isExpandable = false
                notifyItemChanged(current,0)
            }
        }


    }



    override fun onBindViewHolder(holder: ItemViewHolder<*>, position: Int) {
        when (holder) {
            is  BindViewHolderDetailsList -> holder.bind(getItem(position),position)
        }
    }



    private var onDetailsItemClickListener : ((PhrasesModel) -> Unit) ? = null


    fun setDetailsItemClickListener(listener: (PhrasesModel) -> Unit) {
        onDetailsItemClickListener = listener
    }



}