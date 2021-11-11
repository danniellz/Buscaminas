package com.example.buscaminas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout gameGrid;
    private ImageButton box;
    private String username, mode, theme;
    private TextView usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Recoger el usuario del MainActivity
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        mode=extras.getString("mode");
        theme=extras.getString("theme");
    }

    @Override
    public void onClick(View view) {

    }
}