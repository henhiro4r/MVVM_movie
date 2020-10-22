package com.uc.mvvm_week5.ui.main.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uc.mvvm_week5.R;
import com.uc.mvvm_week5.model.Genre;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.TvShow;
import com.uc.mvvm_week5.ui.MainActivity;
import com.uc.mvvm_week5.ui.splash.SplashFragmentDirections;
import com.uc.mvvm_week5.util.Constants;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link DetailFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class DetailFragment extends Fragment {

    @BindView(R.id.background)
    ImageView background;
    @BindView(R.id.show)
    ImageView show;
    @BindView(R.id.title_detail_movie)
    TextView title;
    @BindView(R.id.desc_detail_movie)
    TextView desc;
    @BindView(R.id.popularity_detail_movie)
    TextView popular;
    @BindView(R.id.genre_detail_movie)
    TextView genre;
    @BindView(R.id.rv_cast)
    RecyclerView rvCast;

    private DetailViewModel viewModel;
    private DetailCastAdapter adapter;

    private Movie movie;
    private TvShow tvShow;

//    @BindView(R.id.btn_to_movie)
//    Button button;

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
        viewModel = ViewModelProviders.of(requireActivity()).get(DetailViewModel.class);

        rvCast.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new DetailCastAdapter(getActivity());

        if (getArguments() != null) {
            movie = DetailFragmentArgs.fromBundle(getArguments()).getMovie();
            tvShow = DetailFragmentArgs.fromBundle(getArguments()).getTvshow();

            if (movie != null) {
                initMovie(movie);
                observeMovieViewModel(Integer.parseInt(movie.getId_movie()));
            } else {
                initShow(tvShow);
                observeShowViewModel(Integer.parseInt(tvShow.getId_show()));
            }
        }

        //view1 cuma penamaan saja, bisa v juga
//        button.setOnClickListener(view1 -> {
//            //penamaan sesuai graph action, disini manggil by id panah yg udh kita kasih
//            NavDirections action = DetailFragmentDirections.actionMovie();
//            Navigation.findNavController(view).navigate(action);
//        });
    }

    private void observeShowViewModel(int idShow) {
        viewModel.getShowGenre(idShow).observe(requireActivity(), genres -> {
            if (genres != null) {
                for (int i = 0; i < genres.size(); i++) {
                    Genre g = genres.get(i);
                    if (i < genres.size() - 1) {
                        genre.append(g.getName() + " | ");
                    } else {
                        genre.append(g.getName());
                    }
                }
            }
        });

        viewModel.getShowCast(idShow).observe(requireActivity(), casts -> {
            if (casts != null) {
                adapter.setCastData(casts);
                adapter.notifyDataSetChanged();
                rvCast.setAdapter(adapter);
//                showLoading(false);
            }
        });
    }

    private void observeMovieViewModel(int idMovie) {
        viewModel.getMovieGenre(idMovie).observe(requireActivity(), genres -> {
            if (genres != null) {
                for (int i = 0; i < genres.size(); i++) {
                    Genre g = genres.get(i);
                    if (i < genres.size() - 1) {
                        genre.append(g.getName() + " | ");
                    } else {
                        genre.append(g.getName());
                    }
                }
            }
        });

        viewModel.getMovieCast(idMovie).observe(requireActivity(), casts -> {
            if (casts != null) {
                adapter.setCastData(casts);
                adapter.notifyDataSetChanged();
                rvCast.setAdapter(adapter);
//                showLoading(false);
            }
        });
    }

    private void initShow(TvShow tvShow) {
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setTitle(tvShow.getTitle());
        Glide.with(getActivity()).load(Constants.BaseSetting.BASE_IMAGE_URL + tvShow.getCover()).into(background);
        Glide.with(getActivity()).load(Constants.BaseSetting.BASE_IMAGE_URL + tvShow.getPoster()).into(show);
        title.setText(tvShow.getTitle());
        popular.setText(tvShow.getPopularity());
        desc.setText(tvShow.getDescription());
    }

    private void initMovie(Movie movie) {
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setTitle(movie.getTitle());
        Glide.with(getActivity()).load(Constants.BaseSetting.BASE_IMAGE_URL + movie.getCover()).into(background);
        Glide.with(getActivity()).load(Constants.BaseSetting.BASE_IMAGE_URL + movie.getPoster()).into(show);
        title.setText(movie.getTitle());
        popular.setText(movie.getPopularity());
        desc.setText(movie.getDescription());
    }

    private void showLoading(Boolean state) {
        if (state) {
//            loading.setVisibility(View.VISIBLE);
//            detailHide.setVisibility(View.VISIBLE);
        } else {
//            loading.setVisibility(View.GONE);
//            detailHide.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out));
//            detailHide.setVisibility(View.GONE);
//            detailCover.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.scale_animation));
//            detailPoster.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_transition));
//        }
        }
    }
}