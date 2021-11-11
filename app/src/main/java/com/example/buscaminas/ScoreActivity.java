package com.example.buscaminas;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Titulo
        TextView titleTxt = findViewById(R.id.textView);
        titleTxt.setText(getString(R.string.score));

        //Base de Datos
        SQLiteDatabase database = openOrCreateDatabase("mydatadase", Context.MODE_PRIVATE, null);
        database.execSQL("DROP TABLE IF EXISTS mydatabase;"); //BORRAR
        database.execSQL("CREATE TABLE IF NOT EXISTS mydatabase(Username VARCHAR,Score VARCHAR);");

        database.execSQL("INSERT INTO mydatabase VALUES('user1', '010');");

        Cursor cursor = database.rawQuery("SELECT * FROM mydatabase ORDER BY score", null);

        TableLayout table = findViewById(R.id.tableLayout);
        while (cursor.moveToNext()) {
            TableRow row = new TableRow(this);
            TextView position = new TextView(this);
            TextView username = new TextView(this);
            TextView score = new TextView(this);

            //Añadir posicion
            position.setText(String.valueOf(cursor.getPosition()+1));
            position.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            position.setTextSize(20);
            position.setBackground(getDrawable(R.drawable.border));
            position.setTypeface(null, Typeface.BOLD);

            //Añadir username
            username.setText(cursor.getString(0));
            username.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            username.setTextSize(20);
            username.setBackground(getDrawable(R.drawable.border));

            //Añadir score
            score.setText(cursor.getString(1));
            score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            score.setTextSize(20);
            score.setBackground(getDrawable(R.drawable.border));

            //Añadir a la fila
            row.addView(position);
            row.addView(username);
            row.addView(score);
            table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        }

        cursor.close();

        //Play Again Button
        Button playAgainBtn = findViewById(R.id.button);
        playAgainBtn.setText(getString(R.string.play_again));
        playAgainBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
