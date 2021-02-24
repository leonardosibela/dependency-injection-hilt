package com.example.dependencyinjectionhilt

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    suspend fun getMoviesCoroutines(): List<Movie> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            val movies = arrayListOf<Movie>()
            movies.add(Movie("1", "Deadpool"))
            movies.add(Movie("2", "50 First Dates"))
            movies.add(Movie("3", "Kimetsu no Yaiba: Mugen Train"))
            movies.add(Movie("4", "Man in Black 3"))
            movies
        }
    }
}