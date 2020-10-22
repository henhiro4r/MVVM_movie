package com.uc.mvvm_week5.ui.main.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.TvShow;
import com.uc.mvvm_week5.repository.MovieRepository;
import com.uc.mvvm_week5.repository.TvShowRepository;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private TvShowRepository repository;

    public TvShowViewModel(){
        repository = TvShowRepository.getInstance();
    }

    public LiveData<List<TvShow>> getTvShowCollection(){
        return repository.getTvShowCollection();
    }
}
