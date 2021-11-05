package com.example.buscaminas;


import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Atributos
    private ImageButton bConfig, bPlay, bExit;
    private EditText inputUsername;
    private String nullValue, username, exitConfirm;
    //ID de los intents
    public static final int SETTINGS_ACTIVITY = 2;
    public static final int GAME_ACTIVITY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bConfig = (ImageButton) findViewById(R.id.configButtonId);
        bPlay = (ImageButton) findViewById(R.id.playButtonId);
        bExit = (ImageButton) findViewById(R.id.exitButtonId);
        inputUsername = (EditText) findViewById(R.id.inputUsernameId);
        nullValue = getString(R.string.text_null);
        exitConfirm = getString(R.string.text_exit_confirm);
        bConfig.setOnClickListener(this);
        bPlay.setOnClickListener(this);
        bExit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        username = inputUsername.getText().toString();
        switch(v.getId()){
            case R.id.configButtonId:
                    //Intent intent = new Intent(MainActivity.this, Settings.class);
                    //startActivityForResult(intent, SETTINGS_ACTIVITY);
                break;
            case R.id.playButtonId:
                if(username.isEmpty()){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setMessage(nullValue);
                    alertDialog.setPositiveButton(android.R.string.ok, null);
                    alertDialog.show();
                }else{
                    //Intent intent = new Intent(MainActivity.this, Game.class);
                    //intent.putExtra("username", username);
                    //startActivityForResult(intent, GAME_ACTIVITY);
                }
                break;
            case R.id.exitButtonId:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setMessage(exitConfirm);
                alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                        System.exit(0);
                    }
                });
                alertDialog.setNegativeButton(android.R.string.no, null);
                alertDialog.show();
                break;
        }

    }
}