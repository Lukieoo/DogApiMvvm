package com.lukieoo.dogapimvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.lukieoo.dogapimvvm.databinding.ActivityMainBinding
import com.lukieoo.dogapimvvm.repository.MainRepository
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.Executors
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dogViewModel: DogViewModel by viewModels()

    @Inject
    lateinit var mainRepository: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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