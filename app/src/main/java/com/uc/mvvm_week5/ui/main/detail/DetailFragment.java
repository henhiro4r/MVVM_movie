package com.uc.mvvm_week5.ui.main.detail;

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
import com.uc.mvvm_week5.ui.splash.SplashFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link DetailFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class DetailFragment extends Fragment {

    @BindView(R.id.btn_to_movie)
    Button button;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        //view1 cuma penamaan saja, bisa v juga
        button.setOnClickListener(view1 -> {
            //penamaan sesuai graph action, disini manggil by id panah yg udh kita kasih
            NavDirections action = DetailFragmentDirections.actionMovie();
            Navigation.findNavController(view).navigate(action);
        });
    }
}