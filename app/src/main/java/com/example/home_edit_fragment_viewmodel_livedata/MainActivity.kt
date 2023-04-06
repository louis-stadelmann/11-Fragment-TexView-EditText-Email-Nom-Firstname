package com.example.home_edit_fragment_viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.home_edit_fragment_viewmodel_livedata.databinding.ActivityMainBinding
import com.example.home_edit_fragment_viewmodel_livedata.factories.MainActivityViewModelFactory
import com.example.home_edit_fragment_viewmodel_livedata.fragments.EditFragment
import com.example.home_edit_fragment_viewmodel_livedata.fragments.HomeFragment
import com.example.home_edit_fragment_viewmodel_livedata.viewModels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = MainActivityViewModelFactory("Louis", "STADELMANN", "mail@test.fr")
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainActivityViewModel::class.java)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment(), "home")
            .commit()

        binding.btnHome.setOnClickListener {
            val editFragment = supportFragmentManager.findFragmentByTag("edit")
            if (editFragment != null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.remove(editFragment).commit()
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, HomeFragment(), "home").commit()
        }

        binding.btnEdit.setOnClickListener {
            val homeFragment = supportFragmentManager.findFragmentByTag("home")
            if (homeFragment != null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.remove(homeFragment).commit()
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, EditFragment(), "edit").commit()
        }




    }
}