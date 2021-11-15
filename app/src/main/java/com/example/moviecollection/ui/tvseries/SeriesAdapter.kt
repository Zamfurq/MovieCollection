package com.example.moviecollection.ui.tvseries

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecollection.R
import com.example.moviecollection.databinding.ItemsSeriesBinding
import com.example.moviecollection.entity.MovieEntity
import com.example.moviecollection.entity.SeriesEntity
import com.example.moviecollection.ui.detail.DetailSeriesActivity

class SeriesAdapter (private val callback: SeriesCallback):PagedListAdapter<SeriesEntity,SeriesAdapter.SeriesViewHolder>(
    DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesAdapter.SeriesViewHolder {
        val itemsSeriesBinding = ItemsSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(itemsSeriesBinding)
    }

    override fun onBindViewHolder(holder: SeriesAdapter.SeriesViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null) {
            holder.bind(series)
        }
    }

    inner class SeriesViewHolder(private val binding : ItemsSeriesBinding) : RecyclerView.ViewHolder(binding.root) {
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
}