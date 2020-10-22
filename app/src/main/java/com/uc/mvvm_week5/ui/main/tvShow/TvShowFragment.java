package com.uc.mvvm_week5.ui.main.tvShow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.uc.mvvm_week5.R;
import com.uc.mvvm_week5.adapter.MovieAdapter;
import com.uc.mvvm_week5.adapter.TvShowAdapter;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.TvShow;
import com.uc.mvvm_week5.ui.main.movie.MovieViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TvShowFragment extends Fragment {

    @BindView(R.id.rv_tv_show)
    RecyclerView rvTv;
//    Button button;


    private TvShowViewModel viewModel;
    private TvShowAdapter tvShowAdapter;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        tvShowAdapter = new TvShowAdapter(getActivity());
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));



        viewModel = ViewModelProviders.of(requireActivity()).get(TvShowViewModel.class);
        viewModel.getTvShowCollection().observe(requireActivity(),observeViewModel);

        TvShow tvshow = new TvShow();

        //view1 cuma penamaan saja, bisa v juga
//        button.setOnClickListener(view1 -> {
//            NavDirections action = MovieFragmentDirections.actionMovieToDetail(movie);
//            Navigation.findNavController(view).navigate(action);
//        });
    }

    //klo mau jadi Lambda (Lambda itu ->) di alt enter tulisan abu"nya
    private Observer<List<TvShow>> observeViewModel = tvshows -> {
        if (tvshows !=null){
            tvShowAdapter.setTvShow(tvshows);
            tvShowAdapter.notifyDataSetChanged();
            rvTv.setAdapter(tvShowAdapter);
//            TvShow tvShow = tvshows.get(0);
//            button.setText(tvShow.getTitle());
//            Toast.makeText(requireActivity(),tvShow.getTitle(),Toast.LENGTH_SHORT).show();;
            //set adapter
//                adapter.setMovies(movies);
//                adapter.notifySetDataChanged();
//                recyclerView.setAdapter(adapter);
            // add adapter to recycleview
        }
    };
}