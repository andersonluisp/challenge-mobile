package br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import br.com.andersonluisdev.common.baseviewmodel.extension.onAction
import br.com.andersonluisdev.common.baseviewmodel.extension.onStateChange
import br.com.andersonluisdev.home.databinding.FragmentUserSubscriptionsBinding
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.adapter.UserSubscriptionsAdapter
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.dataui.SubscriptionDataUi
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.state.UserSubscriptionsViewState
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.viewmodel.UserSubscriptionsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val SKELETON_RADIUS = 100f

class UserSubscriptionsFragment : Fragment() {

    private val binding: FragmentUserSubscriptionsBinding by lazy {
        FragmentUserSubscriptionsBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<UserSubscriptionsViewModel>()

    private val subscriptionsAdapter = UserSubscriptionsAdapter(::handleSubscriptionClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setupRecyclerview()
        setupLoadingSkeleton()
        stateChangeListener()
        setupActionListener()
        setupTryAgainButtonListener()
        return binding.root
    }

    private fun setupTryAgainButtonListener() {
        binding.genericError.btnTryAgain.setOnClickListener {
            viewModel.tryAgainClicked()
        }
    }

    private fun stateChangeListener() {
        onStateChange(viewModel) { state ->
            state.updateContent()
        }
    }

    private fun setupActionListener() {
        onAction(viewModel) {

        }
    }

    private fun UserSubscriptionsViewState.updateContent() {
        binding.skeletonLayout.root.isVisible = isLoading
        binding.genericError.root.isVisible = isError
        binding.subscriptionsRv.isVisible = isSuccess

        subscriptions?.let { subscriptionsList ->
            subscriptionsAdapter.submitList(subscriptionsList)
        }
    }

    private fun setupRecyclerview() {
        with(binding) {
            subscriptionsRv.adapter = subscriptionsAdapter
        }
    }

    private fun handleSubscriptionClick(subscription: SubscriptionDataUi) {
        subscription.orderId?.let { orderId ->
            val direction = UserSubscriptionsFragmentDirections.toOrderDetailsFragment(orderId)
            findNavController().navigate(direction)
        }
        Log.d("Challenge", subscription.orderId.toString())
    }

    private fun setupLoadingSkeleton() {
        val skeleton = binding.skeletonLayout.skeleton
        skeleton.maskCornerRadius = SKELETON_RADIUS
        skeleton.showSkeleton()
    }
}
