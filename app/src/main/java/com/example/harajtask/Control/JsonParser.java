package com.example.harajtask.Control;

import android.content.Context;
import android.util.Log;

import com.example.harajtask.Model.Post;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonParser {

    private String path;
    private Context context;

    public JsonParser(Context context, String path) {
        this.path = path;
        this.context = context;
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        String reader = loadData(path);
        try {
            JSONArray arr = new JSONArray(reader);
            for (int i = 0; i < arr.length(); i++) {
                Post post = new Post();
                post.setTitle(arr.getJSONObject(i).getString("title"));
                post.setDate(arr.getJSONObject(i).getLong("date"));
                post.setUsername(arr.getJSONObject(i).getString("username"));
                post.setThumbURL(arr.getJSONObject(i).getString("thumbURL"));
                post.setCommentCount(arr.getJSONObject(i).getInt("commentCount"));
                post.setCity(arr.getJSONObject(i).getString("city"));
                post.setBody(arr.getJSONObject(i).getString("body"));
                posts.add(post);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        posts.add(new Post("asdsad", "Sdsada", "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/142x288-1_-ZZo3ZDrRMaWuu9.jpg", "sadsad", "saddsadasadasdas", 20, 1621848857));
//        posts.add(new Post("asdsad", "Sdsada", "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/142x288-1_-ZZo3ZDrRMaWuu9.jpg", "sadsad", "saddsadasadasdas", 20, 1621848857));
//        posts.add(new Post("asdsad", "Sdsada", "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/142x288-1_-ZZo3ZDrRMaWuu9.jpg", "sadsad", "saddsadasadasdas", 20, 1621848857));
//        posts.add(new Post("asdsad", "Sdsada", "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/142x288-1_-ZZo3ZDrRMaWuu9.jpg", "sadsad", "saddsadasadasdas", 20, 1621848857));
//        posts.add(new Post("asdsad", "Sdsada", "https://s3-eu-west-1.amazonaws.com/img4.haraj.com.sa/cache4/142x288-1_-ZZo3ZDrRMaWuu9.jpg", "sadsad", "saddsadasadasdas", 20, 1621848857));
        return posts;
    }

    private String loadData(String inFile) {
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            Log.i("JsonParser", e.getMessage());
        }

        return tContents;

    }
}
