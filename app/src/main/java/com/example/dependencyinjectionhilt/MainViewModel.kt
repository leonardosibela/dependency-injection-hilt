package com.example.dependencyinjectionhilt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val moviesEvent = MutableLiveData<List<Movie>>()

    fun getMoviesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }

            moviesEvent.value = movies
        }
    }

    class MainViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(MainRepository::class.java).newInstance(repository)
        }
    }
}