package br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.andersonluisdev.home.databinding.SubscriptionItemLayoutBinding
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.dataui.SubscriptionDataUi

class UserSubscriptionsAdapter(
    private val onClickItem: (SubscriptionDataUi) -> Unit
) : ListAdapter<SubscriptionDataUi, UserSubscriptionsAdapter.UserSubscriptionsViewHolder>(
    SubscriptionsDiffUtil()
) {

    inner class UserSubscriptionsViewHolder(
        private val binding: SubscriptionItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subscription: SubscriptionDataUi) {
            with(binding) {
                subscriptionTitle.text = subscription.subModelName
                root.setOnClickListener {
                    onClickItem(subscription)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSubscriptionsViewHolder {
        return UserSubscriptionsViewHolder(
            SubscriptionItemLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserSubscriptionsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class SubscriptionsDiffUtil : DiffUtil.ItemCallback<SubscriptionDataUi>() {
    override fun areItemsTheSame(
        oldItem: SubscriptionDataUi,
        newItem: SubscriptionDataUi
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: SubscriptionDataUi,
        newItem: SubscriptionDataUi
    ): Boolean = oldItem == newItem

}
