package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val username = binding.usernameEdit.text.toString()
            val name = binding.nameEdit.text.toString()
            val email = binding.emailEdit.text.toString()
            val address = binding.addressEdit.text.toString()
            val password = binding.passwordEdit.text.toString()
            val passwordConfirmation = binding.passwordconfirmEdit.text.toString()

            val response = viewModel.register(username, name, email, address, password, passwordConfirmation)
            Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()

            if(!response.isError) {
                findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
            }
        }
    }
}