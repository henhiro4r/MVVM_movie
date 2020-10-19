package com.uc.mvvm_week5.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.uc.mvvm_week5.R;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.TvShow;

import java.util.List;

public class TvShowAdapter extends AppCompatActivity {

    private Context context;
    private List<TvShow> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_adapter);
    }
}