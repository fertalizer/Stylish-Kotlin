package com.mark.stylish.kotlin.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mark.stylish.kotlin.R
import com.mark.stylish.kotlin.data.HomeItem
import com.mark.stylish.kotlin.data.Product
import com.mark.stylish.kotlin.databinding.ItemHomeCollageBinding
import com.mark.stylish.kotlin.databinding.ItemHomeFullBinding
import com.mark.stylish.kotlin.databinding.ItemHomeTitleBinding

private const val ITEM_VIEW_TYPE_TITLE = 0
private const val ITEM_VIEW_TYPE_FULL = 1
private const val ITEM_VIEW_TYPE_COLLAGE = 2
class HomeAdapter: ListAdapter<HomeItem, RecyclerView.ViewHolder>(DiffCallback) {

    class HomeTitleViewHolder(val binding: ItemHomeTitleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.title = title
            binding.executePendingBindings()
        }
    }

    class HomeFullViewHolder(val binding: ItemHomeFullBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
        }
    }

    class HomeCollageViewHolder(val binding: ItemHomeCollageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            ITEM_VIEW_TYPE_TITLE ->
                HomeTitleViewHolder(ItemHomeTitleBinding.inflate(layoutInflater, parent, false))
            ITEM_VIEW_TYPE_FULL ->
                HomeFullViewHolder(ItemHomeFullBinding.inflate(layoutInflater, parent, false))
            ITEM_VIEW_TYPE_COLLAGE ->
                HomeCollageViewHolder(ItemHomeCollageBinding.inflate(layoutInflater, parent, false))
            else ->
                throw ClassCastException("Unknown viewType ${viewType}")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HomeTitleViewHolder -> {
                val title = (getItem(position) as HomeItem.HomeTitle).title
                holder.bind(title)
            }

            is HomeFullViewHolder -> {
                val product = (getItem(position) as HomeItem.HomeFull).product
                holder.bind(product)
            }

            is HomeCollageViewHolder -> {
                val product = (getItem(position) as HomeItem.HomeCollage).product
                holder.bind(product)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is HomeItem.HomeTitle -> ITEM_VIEW_TYPE_TITLE
            is HomeItem.HomeFull -> ITEM_VIEW_TYPE_FULL
            is HomeItem.HomeCollage -> ITEM_VIEW_TYPE_COLLAGE
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<HomeItem>() {
        override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem.id == newItem.id
        }
    }
}