package com.example.home_edit_fragment_viewmodel_livedata.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.home_edit_fragment_viewmodel_livedata.R
import com.example.home_edit_fragment_viewmodel_livedata.viewModels.MainActivityViewModel

class EditFragment : Fragment() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lastName = view.findViewById<EditText>(R.id.etLastName)
        val firstName = view.findViewById<EditText>(R.id.etFirstName)
        val mail = view.findViewById<EditText>(R.id.etMail)

        viewModel.lastName.observe(viewLifecycleOwner) {
            lastName.setText(it)
        }
        viewModel.firstName.observe(viewLifecycleOwner) {
            firstName.setText(it)
        }
        viewModel.email.observe(viewLifecycleOwner) {
            mail.setText(it)
        }

        lastName.doAfterTextChanged {
            if (!TextUtils.isEmpty(it) && !TextUtils.equals(it, viewModel.lastName.value)) {
                viewModel.setLastName(it.toString())
            }
        }

        firstName.doAfterTextChanged {
            if (!TextUtils.isEmpty(it) && !TextUtils.equals(it, viewModel.firstName.value)) {
                viewModel.setFirstName(it.toString())
            }
        }

        mail.doAfterTextChanged {
            if (!TextUtils.isEmpty(it) && !TextUtils.equals(it, viewModel.email.value)) {
                viewModel.setEmail(it.toString())
            }
        }


    }
}