package com.example.harajtask.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.harajtask.Model.Post;
import com.example.harajtask.R;
import java.text.SimpleDateFormat;

public class PostActivity extends AppCompatActivity {

    private Post post;
    private ImageView image, share;
    private TextView title, date, username, city, body, phone;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        post = (Post) getIntent().getSerializableExtra("post");
        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        username = findViewById(R.id.username);
        city = findViewById(R.id.city);
        body = findViewById(R.id.body);
        phone = findViewById(R.id.phone);
        toolbar = findViewById(R.id.toolbar);

        Glide.with(this)
                .load(post.getThumbURL())
                .fitCenter()
                .into(image);
        title.setText(post.getTitle());
        date.setText(getDateFormat(post.getDate()));
        username.setText(post.getUsername());
        city.setText(post.getCity());
        body.setText(post.getBody());
        phone.setText(post.getPhone());
        setSupportActionBar(toolbar);
        share = toolbar.findViewById(R.id.share);


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(PostActivity.this, post.getPhone());
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, post.getTitle());
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    private String getDateFormat(long date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm aa");
        return formatter.format(date * 1000);
    }

    private void checkPermission(Context context, String perCode, int requestCode) {
        if (ContextCompat.checkSelfPermission(context, perCode) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions((Activity) context, new String[] { perCode }, requestCode);
        }
    }

    private void call(Context context, String num) {
        checkPermission(context, Manifest.permission.CALL_PHONE, 102);
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + num));
            context.startActivity(callIntent);
        } else {
            Toast.makeText(context, "Please grant phone permission", Toast.LENGTH_SHORT).show();
        }
    }
}