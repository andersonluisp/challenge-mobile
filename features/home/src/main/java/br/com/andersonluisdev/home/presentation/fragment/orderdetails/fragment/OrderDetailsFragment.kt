package br.com.andersonluisdev.home.presentation.fragment.orderdetails.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.andersonluisdev.common.baseviewmodel.extension.formatMoney
import br.com.andersonluisdev.common.baseviewmodel.extension.onStateChange
import br.com.andersonluisdev.home.R
import br.com.andersonluisdev.home.databinding.FragmentOrderDetailsBinding
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.adapter.ImageSliderAdapter
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.state.OrderDetailsViewState
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.viewmodel.OrderDetailsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val SKELETON_RADIUS = 100f

class OrderDetailsFragment : Fragment() {

    private val binding: FragmentOrderDetailsBinding by lazy {
        FragmentOrderDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<OrderDetailsViewModel>()

    private val args: OrderDetailsFragmentArgs by navArgs()

    private val imageSliderAdapter = ImageSliderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupImageSlider()
        viewModel.getOrderDetails(args.orderId)
        setupToolbarTitle()
    }

    private fun setupToolbarTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.order_details_title, args.orderId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setupTryAgainButtonListener()
        setupStateListener()
        setupLoadingSkeleton()

        return binding.root
    }

    private fun setupTryAgainButtonListener() {
        binding.genericError.btnTryAgain.setOnClickListener {
            viewModel.tryAgainClicked(args.orderId)
        }
    }

    private fun setupStateListener() {
        onStateChange(viewModel) { state ->
            imageSliderAdapter.submitList(state.orderDetails?.vehicleDetails?.imageUrl)
            state.updateContent()
            Log.d("Challenge", state.orderDetails.toString())
        }
    }

    private fun OrderDetailsViewState.updateContent() {
        binding.skeletonLayout.root.isVisible = isLoading
        binding.orderDetailsScrollview.isVisible = isSuccess
        binding.genericError.root.isVisible = isError
        updateCarInformation()
        updatePlanInfo()
        updateValuesInfo()
    }

    private fun OrderDetailsViewState.updateCarInformation() {
        orderDetails?.let { order ->
            binding.yearBrandTv.text = getFormatYearBrand()
            binding.modelTv.text = order.vehicleDetails?.vehicleModel
            binding.priceTv.text =
                getString(R.string.currency, order.summaryValues?.monthlyPrice)
            binding.carFuelTv.text = order.vehicleDetails?.fuelType
            binding.carDoorsTv.text =
                getString(R.string.doors, order.vehicleDetails?.doorsQtd?.toString())
            binding.carEngineTypeTv.text = order.vehicleDetails?.engineType
            binding.carEngineTv.text =
                getString(R.string.engine, order.vehicleDetails?.engine)
        }
    }

    private fun OrderDetailsViewState.updatePlanInfo() {
        orderDetails?.signatureDetails?.let { signature ->
            binding.monthsValueTv.text = signature.months?.toString()
            binding.planTypeValueTv.text = signature.planType?.toString()
            binding.additionalFranchiseValueTv.text =
                signature.additionalFranchise?.toDouble()?.formatMoney()
        }
    }

    private fun OrderDetailsViewState.updateValuesInfo() {
        orderDetails?.summaryValues?.let { values ->
            binding.monthlyPriceValue.text =
                values.monthlyPrice?.toDouble()?.formatMoney()
            binding.extrasPriceValue.text =
                values.extras?.toDouble()?.formatMoney()
            binding.totalPriceValue.text =
                values.totalPrice?.toDouble()?.formatMoney()
        }
    }

    private fun setupImageSlider() {
        with(binding.carImageSlider) {
            adapter = imageSliderAdapter
            TabLayoutMediator(binding.dotsTabLayout, this) { _, _ ->
                //Tab layout to show dots at image slider
            }.attach()
        }

    }

    private fun setupLoadingSkeleton() {
        val skeleton = binding.skeletonLayout.skeleton
        skeleton.maskCornerRadius = SKELETON_RADIUS
        skeleton.showSkeleton()
    }
}
