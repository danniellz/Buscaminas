package com.example.buscaminas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {
    private GridLayout gameGrid;
    private ImageButton box;
    private String username;
    private TextView usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Recoger el usuario del MainActivity
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");

        //IDs
        gameGrid = (GridLayout) findViewById(R.id.gameGridId);
        usernameText = (TextView) findViewById(R.id.textUsernameId);

        //Establecer el nombre de usuario en la ventana
        usernameText.setText(username);

    }

    @Override
    public void onClick(View view) {

    }
}