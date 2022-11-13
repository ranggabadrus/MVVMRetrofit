package com.rangga.mvvmretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel: ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()

    fun getPopularMovies(){
        RetrofitInstance.api.getPopularMovies("570c36d75740509c00d865a804d826a5").enqueue(object :
            Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if(response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun observeMovieLiveData():LiveData<List<Result>>{
        return movieLiveData
    }
}