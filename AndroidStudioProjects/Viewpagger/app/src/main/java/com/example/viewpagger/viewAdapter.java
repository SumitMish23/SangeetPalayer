package com.example.viewpagger;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class viewAdapter extends  RecyclerView.Adapter<viewAdapter.viewholder>
{
    ArrayList<modelClass> videos;

    public viewAdapter(ArrayList<modelClass> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video_design,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.setData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {
        VideoView videoView;
        TextView title;
        ProgressBar pb;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.vv);
            title=itemView.findViewById(R.id.textView);
            pb=itemView.findViewById(R.id.progressBar);

        }
        void setData(modelClass obj)
        {
            videoView.setVideoPath(obj.getUrl());
            title.setText(obj.getTitle());
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
