package com.lunarvnx.shortvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class VideoPlayer extends AppCompatActivity {
    TextView txtJudul;
    TextView txtDesc;
    TextView txtResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        VideoView videoView =(VideoView)findViewById(R.id.vPlayer);

        // Get Data From Intent
        String datafilm = getIntent().getStringExtra("DataFilm").toString();
        String datadesc = getIntent().getStringExtra("DataDesc").toString();
        String datares = getIntent().getStringExtra("DataSource").toString();


        //Deklarasi Komponen
        txtJudul = (TextView) findViewById(R.id.txtJudul);
        txtJudul.setText(datafilm);

        txtDesc = (TextView) findViewById(R.id.txtDesc);
        txtDesc.setText("Video Description:\n" + datadesc);

        txtResource = (TextView) findViewById(R.id.txtResource);
        txtResource.setText("Video Resource:\n" +datares);

        // Action Bar Back
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setTitle(datafilm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set MediaController  to enable play, pause, forward, etc options.
        String location = getIntent().getStringExtra("DataLocation").toString();
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //Location of Media File
        int videoResource = getResources().
                getIdentifier(location, "raw", getPackageName());
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResource);
        //Starting VideView By Setting MediaController and URI
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }

    // Click Back Button Action Bar
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}