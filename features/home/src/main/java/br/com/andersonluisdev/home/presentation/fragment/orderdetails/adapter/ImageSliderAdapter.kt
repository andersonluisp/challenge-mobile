package br.com.andersonluisdev.home.presentation.fragment.orderdetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.andersonluisdev.common.extension.setUrlImage
import br.com.andersonluisdev.home.databinding.ImageCarItemBinding

class ImageSliderAdapter : ListAdapter<String, ImageSliderAdapter.ImageSliderViewHolder>(ImageSliderDiffUtil()) {

    inner class ImageSliderViewHolder(
        private val binding: ImageCarItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            binding.photoCarIv.setUrlImage(url, binding.root)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderViewHolder {
        return ImageSliderViewHolder(
            ImageCarItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageSliderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class ImageSliderDiffUtil : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}
