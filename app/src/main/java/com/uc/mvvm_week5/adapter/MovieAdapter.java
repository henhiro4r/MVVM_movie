package com.uc.mvvm_week5.adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uc.mvvm_week5.R;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.TvShow;
import com.uc.mvvm_week5.ui.main.movie.MovieFragmentDirections;
import com.uc.mvvm_week5.util.Constants;

import java.util.List;




public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context) {
        this.context = context;
    }


    public void setMovies(List<Movie> movies) {
        this.movieList = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_movie_adapter, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder movieViewHolder, int i) {
        Movie m = movieList.get(i);
        Glide.with(context)
                .load(Constants.BaseSetting.BASE_IMAGE_URL + m.getCover())
                .into(movieViewHolder.img_movie);
        movieViewHolder.title_movie.setText(m.getTitle());
        movieViewHolder.popular_movie.setText(m.getPopularity());
        movieViewHolder.date_movie.setText(m.getReleaseDate());
        movieViewHolder.itemView.setOnClickListener(view -> {
            MovieFragmentDirections.ActionMovieToDetail action = MovieFragmentDirections.actionMovieToDetail(m,null);
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView img_movie;
        TextView title_movie, popular_movie, date_movie;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            img_movie = itemView.findViewById(R.id.img_movie);
            title_movie = itemView.findViewById(R.id.text_title_movie);
            popular_movie = itemView.findViewById(R.id.text_popular_movie);
            date_movie = itemView.findViewById(R.id.text_date_movie);
        }
    }
}