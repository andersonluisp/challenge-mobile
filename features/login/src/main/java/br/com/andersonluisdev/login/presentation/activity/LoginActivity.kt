package br.com.andersonluisdev.login.presentation.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.com.andersonluisdev.common.baseviewmodel.extension.onAction
import br.com.andersonluisdev.common.baseviewmodel.extension.onStateChange
import br.com.andersonluisdev.common.extension.showToast
import br.com.andersonluisdev.home.presentation.activity.HomeActivity
import br.com.andersonluisdev.login.databinding.ActivityLoginBinding
import br.com.andersonluisdev.login.presentation.activity.action.LoginAction
import br.com.andersonluisdev.login.presentation.activity.state.LoginViewState
import br.com.andersonluisdev.login.presentation.activity.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        stateChangeListener()
        actionListener()
        setupButtonListeners()

        setupStatusBar()
    }

    private fun setupButtonListeners() {
        binding.loginButton.setOnClickListener {
            viewModel.buttonSignInClicked()
        }
        binding.genericErrorLayout.btnTryAgain.setOnClickListener {
            viewModel.buttonTryAgainClicked()
        }
    }

    private fun stateChangeListener() {
        onStateChange(viewModel) { state ->
            with(state) {
                updateButtonState()
                updateGenericError()
            }
        }
    }

    private fun actionListener() {
        onAction(viewModel) { action ->
            when(action) {
                is LoginAction.ButtonSignInClicked -> signIn()
                is LoginAction.NavigateToHome -> navigateToHome()
                is LoginAction.ShowInvalidLoginToast -> showToast(action.errorMessage)
            }
        }
    }

    private fun navigateToHome() {
        val intent = Intent(applicationContext, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun signIn() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        viewModel.signIn(email, password)
    }

    private fun LoginViewState.updateButtonState() {
        binding.loginButton.setLoading(isLoginButtonLoading)
        binding.loginButton.isEnabled = !isLoginButtonLoading
    }

    private fun LoginViewState.updateGenericError() {
        binding.groupContent.isVisible = isLoginError.not()
        binding.genericErrorLayout.root.isVisible = isLoginError
    }

    private fun setupStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }
}

