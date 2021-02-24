package com.example.dependencyinjectionhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
                this,
                MainViewModel.MainViewModelFactory(MainRepository())
        ).get(MainViewModel::class.java)

        viewModel.moviesEvent.observe(this, Observer { movies ->
            textViewMovies.text = movies.map {
                "${it.id} - ${it.title}\n"
            }.toString()
        })

        viewModel.getMoviesCoroutines()
    }
}