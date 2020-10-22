package com.uc.mvvm_week5.ui.main.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepository repository;

    public MovieViewModel(){
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<Movie>> getMovieCollection(){
        return repository.getMovieCollection();
    }
}
