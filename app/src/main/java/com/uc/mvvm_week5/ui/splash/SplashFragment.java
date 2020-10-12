package com.uc.mvvm_week5.ui.splash;

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

import butterknife.BindView;
import butterknife.ButterKnife;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link SplashFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class SplashFragment extends Fragment {

    @BindView(R.id.btn_to_start)
    Button button;

    public SplashFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        //view1 cuma penamaan saja, bisa v juga
        button.setOnClickListener(view1 -> {
            NavDirections action = SplashFragmentDirections.actionMovieFragment();
            Navigation.findNavController(view).navigate(action);
        });
    }
}