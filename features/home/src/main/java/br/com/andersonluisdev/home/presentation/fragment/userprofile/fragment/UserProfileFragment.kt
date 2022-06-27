package br.com.andersonluisdev.home.presentation.fragment.userprofile.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import br.com.andersonluisdev.common.baseviewmodel.extension.onAction
import br.com.andersonluisdev.common.baseviewmodel.extension.onStateChange
import br.com.andersonluisdev.common.extension.disable
import br.com.andersonluisdev.common.extension.enable
import br.com.andersonluisdev.common.extension.setUrlImage
import br.com.andersonluisdev.home.R
import br.com.andersonluisdev.home.databinding.FragmentUserProfileBinding
import br.com.andersonluisdev.home.presentation.fragment.userprofile.action.UserProfileAction
import br.com.andersonluisdev.home.presentation.fragment.userprofile.adapter.OrderStatusAdapter
import br.com.andersonluisdev.home.presentation.fragment.userprofile.state.UserProfileViewState
import br.com.andersonluisdev.home.presentation.fragment.userprofile.util.SnapPagerScrollListener
import br.com.andersonluisdev.home.presentation.fragment.userprofile.viewmodel.UserProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val SKELETON_RADIUS = 100f
private const val LOGIN_DEEPLINK = "androidchallenge://login"

class UserProfileFragment : Fragment() {

    private val binding: FragmentUserProfileBinding by lazy {
        FragmentUserProfileBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<UserProfileViewModel>()
    private var orderAdapter = OrderStatusAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupArrowButtonsListener()
        setupTryAgainButtonListener()
        stateChangeListener()
        setupActionListener()
        setupLogoutListener()
        setupUserSubscriptionsListener()
        setupLoadingSkeleton()
    }

    private fun setupUserSubscriptionsListener() {
        binding.userSubscriptionsContainer.setOnClickListener {
            viewModel.userSubscriptionsClicked()
        }    }

    private fun setupTryAgainButtonListener() {
        binding.genericError.btnTryAgain.setOnClickListener {
            viewModel.tryAgainClicked()
        }
    }

    private fun setupLogoutListener() {
        binding.logoutContainer.setOnClickListener {
            viewModel.logout()
        }
    }

    private fun setupActionListener() {
        onAction(viewModel) { action ->
            when (action) {
                UserProfileAction.NavigateToUserSubscriptions -> Log.d(
                    "Challenge",
                    "Navigate to userSubscriptions"
                )
                UserProfileAction.Logout -> {
                    navigateToLogin()
                }
            }
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(LOGIN_DEEPLINK))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun stateChangeListener() {
        onStateChange(viewModel) { state ->
            state.updateContent()
        }
    }

    private fun setupLoadingSkeleton() {
        val skeleton = binding.skeletonLayout.skeleton
        skeleton.maskCornerRadius = SKELETON_RADIUS
        skeleton.showSkeleton()
    }

    private fun UserProfileViewState.updateContent() {
        binding.skeletonLayout.root.isVisible = isLoading
        binding.contentGroup.isVisible = isSuccess
        binding.genericError.root.isVisible = isError

        profileData?.let { profile ->
            takeIf { it.isSuccess }?.apply {
                orderAdapter.submitList(profile.orders)
            }
            binding.profileIv.setUrlImage(profile.avatarUrl, binding.root)
            binding.fullNameTv.text = profile.fullName
            binding.cityStateTv.text =
                resources.getString(R.string.city_state, profile.city, profile.stateAbbr)
        }
    }

    private fun setupArrowButtonsListener() {
        with(binding) {
            leftArrowIv.setOnClickListener {
                orderAdapter.actualOrderPosition?.let { position ->
                    statusRv.smoothScrollToPosition(position - 1)
                }
            }
            rightArrowIv.setOnClickListener {
                orderAdapter.actualOrderPosition?.let { position ->
                    statusRv.smoothScrollToPosition(position + 1)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.statusRv)
        binding.statusRv.adapter = orderAdapter

        binding.statusRv.addOnScrollListener(
            SnapPagerScrollListener(
                snapHelper,
                SnapPagerScrollListener.ON_SCROLL,
                true,
            ) { position ->
                orderAdapter.setActualOrderPosition(position)
                setupArrowDrawables()
                updateOrderTitle()
            }
        )
    }

    private fun setupArrowDrawables() {
        with(binding) {
            when {
                orderAdapter.currentList.size == 1 -> {
                    leftArrowIv.disable(R.drawable.ic_arrow_left_disabled)
                    rightArrowIv.disable(R.drawable.ic_arrow_right_disabled)
                }
                orderAdapter.actualOrderPosition == 0 -> {
                    leftArrowIv.disable(R.drawable.ic_arrow_left_disabled)
                    rightArrowIv.enable(R.drawable.ic_arrow_right_enabled)
                }
                orderAdapter.actualOrderPosition == (orderAdapter.currentList.size - 1) -> {
                    leftArrowIv.enable(R.drawable.ic_arrow_left_enabled)
                    rightArrowIv.disable(R.drawable.ic_arrow_right_disabled)
                }
                else -> {
                    leftArrowIv.enable(R.drawable.ic_arrow_left_enabled)
                    rightArrowIv.enable(R.drawable.ic_arrow_right_enabled)
                }
            }
        }
    }

    private fun updateOrderTitle() {
        binding.orderTitleTv.text = resources.getString(
            R.string.order_title,
            orderAdapter.getActualOrder()?.orderId,
            orderAdapter.getActualOrder()?.subModelName
        )
    }
}
