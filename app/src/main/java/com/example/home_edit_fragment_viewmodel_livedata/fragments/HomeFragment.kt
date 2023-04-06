package com.example.home_edit_fragment_viewmodel_livedata.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.home_edit_fragment_viewmodel_livedata.R
import com.example.home_edit_fragment_viewmodel_livedata.viewModels.MainActivityViewModel


class HomeFragment : Fragment() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lastName = view.findViewById<TextView>(R.id.tvLastName)
        val firstName = view.findViewById<TextView>(R.id.tvFirstName)
        val mail = view.findViewById<TextView>(R.id.tvMail)

        viewModel.lastName.observe(viewLifecycleOwner) {
            lastName.text = it
        }
        viewModel.firstName.observe(viewLifecycleOwner) {
            firstName.text = it
        }
        viewModel.email.observe(viewLifecycleOwner) {
            mail.text = it
        }
    }
}