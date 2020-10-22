package com.uc.mvvm_week5.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uc.mvvm_week5.R;
import com.uc.mvvm_week5.model.Movie;
import com.uc.mvvm_week5.model.TvShow;
import com.uc.mvvm_week5.ui.main.tvShow.TvShowFragmentDirections;
import com.uc.mvvm_week5.util.Constants;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>  {

    private Context context;
    private List<TvShow> showList;

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    public void setTvShow(List<TvShow> tvShow) {
        this.showList = tvShow;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_movie_adapter, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.TvShowViewHolder holder, int position) {
        TvShow tv = showList.get(position);
        Glide.with(context)
                .load(Constants.BaseSetting.BASE_IMAGE_URL + tv.getCover())
                .into(holder.img_tv);
        holder.title_tv.setText(tv.getTitle());
        holder.popular_tv.setText(tv.getPopularity());
        holder.date_tv.setText(tv.getReleaseDate());
        holder.itemView.setOnClickListener(view -> {
            TvShowFragmentDirections.ActionTvtoDetail action = TvShowFragmentDirections.actionTvtoDetail(null,tv);
            Navigation.findNavController(view).navigate(action);

        });
    }

    @Override
    public int getItemCount() {return showList.size();}
    class TvShowViewHolder extends RecyclerView.ViewHolder {

        ImageView img_tv;
        TextView title_tv, popular_tv, date_tv;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            img_tv = itemView.findViewById(R.id.img_movie);
            title_tv = itemView.findViewById(R.id.text_title_movie);
            popular_tv = itemView.findViewById(R.id.text_popular_movie);
            date_tv = itemView.findViewById(R.id.text_date_movie);
        }
    }
}