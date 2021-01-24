package com.lukieoo.dogapimvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukieoo.dogapimvvm.models.ImageDog
import com.lukieoo.dogapimvvm.repository.MainRepository
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.Executors
import javax.inject.Inject

class DogViewModel @Inject constructor(var mainRepository: MainRepository) : ViewModel() {


    private val productDetails = MutableLiveData<ImageDog>()
    init {
        fetchDogApi()
    }
          fun fetchDogApi() {
        mainRepository.fetchData().observeOn(AndroidSchedulers.mainThread())
            .subscribe({ image ->
                productDetails.value = image
                Executors.newSingleThreadExecutor().execute {
                    mainRepository.insertDog(image)
                }

            }, { t ->
                t.printStackTrace()
                productDetails.value = null
            })
    }

    fun getProductDetails(): LiveData<ImageDog> {
        return productDetails
    }
}