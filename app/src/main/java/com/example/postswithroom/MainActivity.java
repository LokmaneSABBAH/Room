package com.example.postswithroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    EditText editTextTitle;
    EditText editTextBody;
    PostsDatabase postsDatabase;
    PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editTextTitle = findViewById(R.id.editTextTextTitle);
        editTextBody = findViewById(R.id.editTextTextBody);

        adapter = new PostsAdapter();
        recyclerView.setAdapter(adapter);

        postsDatabase = PostsDatabase.getInstance(this);






    }

    public void insertPost(View view) {
        String title = editTextTitle.getEditableText().toString();
        String body = editTextBody.getEditableText().toString();

        postsDatabase.postsDao().insertPost(new Post(new User(1, "lokmane"), title, body))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: insert");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void getPosts(View view) {
        postsDatabase.postsDao().getPosts()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Post> posts) {
                        Log.d(TAG, "lokmane onSuccess: get"+posts.get(0).getUser().getUserName());
                        adapter.setList(posts);
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}