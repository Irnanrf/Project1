package com.lunarvnx.shortvideoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnProfile;
    private Button btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hide Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnLibrary = (Button) findViewById(R.id.btnLibrary);
    }


    public void btnProfileClicked(View view){
        startActivity(new Intent(MainActivity.this, Profile.class));
    }

    public void btnLibraryPress(View view){
        showLoginDialog(this);
    }

    private void showLoginDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        taskEditText.setHint("Insert Your Name");
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Login Page")
                .setView(taskEditText)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        if (task.equals("")){
                            Toast.makeText(c,"Name Must Be Filled", Toast.LENGTH_SHORT).show();
                        } else{
                            Intent sendData1 = new Intent(MainActivity.this, Library.class);
                            sendData1.putExtra("DataNama", task);
                            startActivity(sendData1);
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }
}