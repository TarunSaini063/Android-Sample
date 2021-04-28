package com.win95.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.JsonViewHolder> {

    JsonJava[] user;
    Context context;

    public JsonAdapter(JsonJava[] user, Context context) {
        this.user = user;
        this.context = context;
    }

    @NonNull
    @Override
    public JsonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item,parent,false);
        return new JsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonViewHolder holder, int position) {
        JsonJava usr = user[position];
        holder.textView.setText(usr.getLogin());
        Glide.with(holder.imageView.getContext()).load(usr.getAvatarUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(v -> Toast.makeText(context,holder.textView.getText(),Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return user.length;
    }

    public static class JsonViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public JsonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.userImg);
            textView = itemView.findViewById(R.id.textUser);
        }
    }
}
