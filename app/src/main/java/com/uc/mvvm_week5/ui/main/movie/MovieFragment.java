package com.uc.mvvm_week5.ui.main.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uc.mvvm_week5.R;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.ui.splash.SplashFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link MovieFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class MovieFragment extends Fragment {

    @BindView(R.id.btn_to_detail)
    Button button;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Movie movie = new Movie();

        //view1 cuma penamaan saja, bisa v juga
        button.setOnClickListener(view1 -> {
            NavDirections action = MovieFragmentDirections.actionDetailFragment(movie);
            Navigation.findNavController(view).navigate(action);
        });
    }
}