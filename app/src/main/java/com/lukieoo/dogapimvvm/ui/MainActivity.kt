package com.lukieoo.dogapimvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lukieoo.dogapimvvm.databinding.ActivityMainBinding
import com.lukieoo.dogapimvvm.repository.MainRepository
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var dogViewModel: DogViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dogViewModel = ViewModelProvider(this, viewModelFactory).get(DogViewModel::class.java)

        fetchData()
        eventButton()

    }

    private fun eventButton() {
        binding.random.setOnClickListener {
            showProgress()
            dogViewModel.fetchDogApi()
        }
    }

    private fun fetchData() {
        dogViewModel.getProductDetails().observe(this, Observer {
            if (it != null) {
                Picasso.get().load(it.message).into(binding.dogImage)
            }
            hideProgress()
        })

    }

    private fun hideProgress() {
        binding.status.visibility = View.GONE
    }

    private fun showProgress() {
        binding.status.visibility = View.VISIBLE
    }
}