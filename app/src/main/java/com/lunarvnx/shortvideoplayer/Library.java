package com.lunarvnx.shortvideoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Library extends AppCompatActivity {

    public List<VideoModel> clubList = new ArrayList<VideoModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        String datanama = getIntent().getStringExtra("DataNama").toString();

        // Action Bar Back
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setTitle("Hello, " + datanama);

        Toast.makeText(this, "Hello, " + datanama, Toast.LENGTH_SHORT).show();
        List<VideoModel> clubList = new ArrayList<VideoModel>();

//        clubList.add(new VideoModel("Donald Duck", "Watch as Donald Duck is annoyed by those pesky chipmunks Chip 'n' Dale in this classic Disney cartoon short.", "youtube.com", "video1"));
//        clubList.add(new VideoModel("2018 The Little Duck", "The Little Duck is a commercial released by Disney on December 25th for Disneyland Paris. Its posting reads is part Disneyland Paris is a place where all the magic of the Disney world, its wonderful tales and its incredible stories, exists in real life. This epic melting of love, humor and bravery is for all those, young and old, who grew up dreaming of meeting a Disney character someday. At Disneyland Paris, magic is for real. #LaMagiePourDeVrai. Wording was adjusted for translation.", "youtube.com", "video2"));
//
//
        RecyclerView videoRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        VideoAdapter clubAdapter = new VideoAdapter(getApplicationContext(), clubList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        videoRecyclerView.setLayoutManager(layoutManager);
        videoRecyclerView.setAdapter(clubAdapter);

    }

    // Membuat Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Action Option Menu Saat Salah Satu Di Tekan
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            showAddDialog(this);
        } else if (item.getItemId() == R.id.menuKeluar){
            startActivity(new Intent(Library.this, MainActivity.class));
        }
        return true;
    }

    private void showAddDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        taskEditText.setHint("Add toDo List");
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Add List")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        if (task.equals("")){
                            Toast.makeText(c,"Name Must Be Filled", Toast.LENGTH_SHORT).show();
                        } else{
                            clubList.add(new VideoModel(task, "test", "test", "video1"));
                            RecyclerView videoRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                            VideoAdapter clubAdapter = new VideoAdapter(getApplicationContext(), clubList);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                            videoRecyclerView.setLayoutManager(layoutManager);
                            videoRecyclerView.setAdapter(clubAdapter);
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }




}