package com.example.moviecollection.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecollection.R
import com.example.moviecollection.databinding.ItemsSeriesBookmarkBinding
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.ui.detail.DetailSeriesActivity
import com.example.moviecollection.ui.tvseries.SeriesCallback

class SeriesFavoriteAdapter(private val callback: SeriesCallback): PagedListAdapter<SeriesEntity, SeriesFavoriteAdapter.SeriesFavoriteViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SeriesEntity>(){
            override fun areItemsTheSame(oldItem: SeriesEntity, newItem: SeriesEntity): Boolean {
                return oldItem.seriesId == newItem.seriesId
            }

            override fun areContentsTheSame(oldItem: SeriesEntity, newItem: SeriesEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class SeriesFavoriteViewHolder(private val binding : ItemsSeriesBookmarkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(series: SeriesEntity) {
            with(binding) {
                tvItemTitle.text = series.title
                tvItemDate.text = series.firstEpisodeYear
                tvItemGenre.text = series.synopsis
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailSeriesActivity::class.java)
                    intent.putExtra(DetailSeriesActivity.EXTRA_SERIES, series.seriesId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(series) }
                Glide.with(itemView.context)
                    .load(series.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesFavoriteViewHolder {
        val itemsSeriesFavoriteBinding = ItemsSeriesBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesFavoriteViewHolder(itemsSeriesFavoriteBinding)
    }

    override fun onBindViewHolder(holder: SeriesFavoriteViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null) {
            holder.bind(series)
        }
    }

    fun getSwipedData(swipedPosition: Int): SeriesEntity? = getItem(swipedPosition)
}