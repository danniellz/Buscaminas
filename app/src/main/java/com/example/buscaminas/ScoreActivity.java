package com.example.buscaminas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleTxt;
    private ImageView scoreImg;
    private TableLayout table;
    private Button playAgainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        titleTxt = (TextView) findViewById(R.id.textView);
        titleTxt.setText(getString(R.string.score));

        scoreImg = (ImageView) findViewById(R.id.imageView);

        for (int i = 0; i <= 15; i++) {
            String username = "Jugandor" + String.valueOf(i);
            String score = String.valueOf(i);
            table = (TableLayout) findViewById(R.id.tableLayout);
            TableRow row = new TableRow(this);
            TextView textview1 = new TextView(this);
            TextView textview2 = new TextView(this);

            //Añadir username
            textview1.setText(username);
            textview1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textview1.setTextSize(20);
            textview1.setBackground(getDrawable(R.drawable.border));

            //Añadir score
            textview2.setText(score);
            textview2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textview2.setTextSize(20);
            textview2.setBackground(getDrawable(R.drawable.border));

            row.addView(textview1);
            row.addView(textview2);
            table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
        String username = "Jugandor n";
        String score = "002";
        table = (TableLayout) findViewById(R.id.tableLayout);
        TableRow row = new TableRow(this);
        TextView textview1 = new TextView(this);
        TextView textview2 = new TextView(this);

        //Añadir username
        textview1.setText(username);
        textview1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textview1.setTextSize(20);
        textview1.setBackground(getDrawable(R.drawable.border));

        //Añadir score
        textview2.setText(score);
        textview2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textview2.setTextSize(20);
        textview2.setBackground(getDrawable(R.drawable.border));

        row.addView(textview1);
        row.addView(textview2);
        table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        playAgainBtn = (Button) findViewById(R.id.button);
        playAgainBtn.setText(getString(R.string.play_again));
        playAgainBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
