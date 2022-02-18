package com.example.movielist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielist.R;
import com.example.movielist.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    List<MovieModel> list;
    Context context;

    public MovieListAdapter(List<MovieModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

     public void setList(List<MovieModel> list)
     {
         this.list = list;
         notifyDataSetChanged();
     }
    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.ViewHolder holder, int position) {

        holder.title.setText(this.list.get(position).getLogin().toString());
        holder.url.setText(this.list.get(position).getUrl().toString());


    }


    @Override
    public int getItemCount() {
        if(this.list != null)
        {
            return this.list.size();
        }
      return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView url;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleView);
            url = itemView.findViewById(R.id.titleView2);

        }
    }
}
