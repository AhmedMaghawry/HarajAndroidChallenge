package com.example.harajtask.Control;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.harajtask.Model.Post;
import com.example.harajtask.R;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PostsAdapter extends ArrayAdapter<PostHolder> {

    private Activity context;
    private List<Post> posts;

    public PostsAdapter(Activity context, List<Post> posts) {
        super(context, R.layout.item_post);
        this.context=context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_post, null,true);
        Post post = posts.get(position);
        PostHolder postHolder = new PostHolder(rowView);
        postHolder.getTitle().setText(post.getTitle());
        postHolder.getDate().setText("Since " + getDuration(post.getDate()) + " hours");
        postHolder.getCity().setText(post.getCity());
        postHolder.getUsername().setText(post.getUsername());
        Glide.with(inflater.getContext())
                .load(post.getThumbURL())
                .fitCenter()
                .into(postHolder.getImage());
        if (post.getCommentCount() == 0)
            postHolder.getCommentsView().setVisibility(View.INVISIBLE);
        else
            postHolder.getComments().setText(post.getCommentCount() + "");
        return rowView;
    }

    private long getDuration(long date) {
        Date today = new Date();
        long daysDiff = today.getTime() - (date * 1000);
        return TimeUnit.HOURS.convert(daysDiff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int getCount() {
        return posts.size();
    }
}
