package com.example.harajtask.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toolbar
import com.example.harajtask.Control.JsonParser
import com.example.harajtask.Control.PostsAdapter
import com.example.harajtask.Model.Post
import com.example.harajtask.R

class MainActivity : AppCompatActivity() {

    private lateinit var postsList : ListView
    private lateinit var postsAdapter: PostsAdapter
    private lateinit var posts: List<Post>
    private lateinit var jsonParser: JsonParser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jsonParser = JsonParser(this, "data.json")
        posts = jsonParser.posts
        val intent = Intent(this, PostActivity::class.java)
        postsList = findViewById<ListView>(R.id.posts)
        postsAdapter = PostsAdapter(this, posts)
        postsList.adapter = postsAdapter

        postsList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                intent.putExtra("post", posts.get(position))
                startActivity(intent)
            }
    }
}