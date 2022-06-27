package br.com.andersonluisdev.home.presentation.fragment.myprofile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.andersonluisdev.home.R
import br.com.andersonluisdev.home.databinding.CheckboxStatusLayoutBinding
import br.com.andersonluisdev.home.databinding.StatusItemLayoutBinding
import br.com.andersonluisdev.home.presentation.fragment.myprofile.dataui.OrderDataUi

class OrderStatusAdapter :
    ListAdapter<OrderDataUi, OrderStatusAdapter.OrderStatusViewHolder>(OrderStatusDiffUtil()) {

    private var _actualOrderPosition: Int? = null
    val actualOrderPosition: Int?
        get() = _actualOrderPosition

    inner class OrderStatusViewHolder(
        private val binding: StatusItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: OrderDataUi) {
            binding.orderStatusLayout.removeAllViews()
            order.statuses?.forEachIndexed { index, status ->
                with(CheckboxStatusLayoutBinding.inflate(LayoutInflater.from(binding.root.context))) {
                    statusDescriptionTv.text = status.label
                    statusCheckBoxIv.setImageResource(
                        getCheckBoxDrawable(status.checked)
                    )
                    setupLineCheckBox(order, index)
                    binding.orderStatusLayout.addView(root)
                }
            }
        }

        private fun CheckboxStatusLayoutBinding.setupLineCheckBox(
            order: OrderDataUi,
            statusPosition: Int
        ) {
            order.statuses?.size?.let { statusesSize ->
                when {
                    statusesSize == 1 -> {
                        aboveLine.isVisible = false
                        belowLine.isVisible = false
                    }
                    statusesSize > 1 && statusPosition == 0 -> {
                        aboveLine.isVisible = false
                        belowLine.isVisible = true
                    }
                    statusesSize > 1 && statusPosition == statusesSize - 1 -> {
                        aboveLine.isVisible = true
                        belowLine.isVisible = false
                    }
                    else -> {
                        aboveLine.isVisible = true
                        belowLine.isVisible = true
                    }
                }
            }
        }

        private fun getCheckBoxDrawable(isChecked: Boolean?): Int {
            return if (isChecked == true) R.drawable.ic_checked else R.drawable.ic_unchecked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderStatusViewHolder {
        return OrderStatusViewHolder(
            StatusItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OrderStatusViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun getActualOrder(): OrderDataUi? =
        _actualOrderPosition?.let {
            currentList[it]
        }

    fun setActualOrderPosition(newPosition: Int) {
        _actualOrderPosition = newPosition
    }
}


private class OrderStatusDiffUtil : DiffUtil.ItemCallback<OrderDataUi>() {
    override fun areItemsTheSame(oldItem: OrderDataUi, newItem: OrderDataUi): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: OrderDataUi, newItem: OrderDataUi): Boolean =
        oldItem == newItem
}
