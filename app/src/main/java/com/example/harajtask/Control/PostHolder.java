package com.example.harajtask.Control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.harajtask.R;

public class PostHolder {

    private TextView title, date, city, username, comments;
    private ImageView image;
    private LinearLayout commentsView;

    public PostHolder(View itemView) {
        title = itemView.findViewById(R.id.title);
        date = itemView.findViewById(R.id.date);
        city = itemView.findViewById(R.id.city);
        username = itemView.findViewById(R.id.username);
        image = itemView.findViewById(R.id.image);
        comments = itemView.findViewById(R.id.comments);
        commentsView = itemView.findViewById(R.id.comments_view);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDate() {
        return date;
    }

    public TextView getCity() {
        return city;
    }

    public TextView getUsername() {
        return username;
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getComments() {
        return comments;
    }

    public LinearLayout getCommentsView() {
        return commentsView;
    }
}
