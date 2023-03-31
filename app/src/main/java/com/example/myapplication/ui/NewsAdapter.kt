package com.example.myapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Article
import com.example.myapplication.databinding.RawNewsBinding
import com.example.myapplication.utils.BaseRecyclerViewAdapter
import com.example.myapplication.utils.loadImage

class NewsAdapter(
    val context: Context,
    val onItemClick: (data: Article, position: Int) -> Unit?
) :
    BaseRecyclerViewAdapter<Article, NewsAdapter.NewsAdapterViewHolder>() {

    override fun createItemViewHolder(parent: ViewGroup): NewsAdapterViewHolder {
        val itemBinding =
            RawNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsAdapterViewHolder(itemBinding)
    }

    override fun bindItemViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    inner class NewsAdapterViewHolder(private val itemBinding: RawNewsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: Article, position: Int) {
            itemBinding.root.setOnClickListener {
                onItemClick.invoke(data, position)
            }
            data?.media?.let {
                itemBinding.ivNews.loadImage(it)
            }
            data?.title?.let {
                itemBinding.tvNews.text = it

            }


        }

    }
}