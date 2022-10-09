package com.example.postswithroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder>{

    private List<Post> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostsViewHolder holder, int position) {
        holder.textViewTitleItem.setText(postsList.get(position).getTitle());
        holder.textViewBodyItem.setText(postsList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitleItem;
        TextView textViewBodyItem;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitleItem = itemView.findViewById(R.id.textViewTitleItem);
            textViewBodyItem = itemView.findViewById(R.id.textViewBodyItem);

        }
    }
    public void setList(List<Post> list){
        this.postsList = list;
    }
}
