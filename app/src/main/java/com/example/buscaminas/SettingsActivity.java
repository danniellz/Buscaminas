package com.example.buscaminas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private TextView modeTxt;
    private TextView themeTxt;
    private ImageButton santaTheme;
    private ImageButton thekingsTheme;
    private RadioGroup modeChoice;
    private RadioButton ezModeRbtn;
    private RadioButton hardModeRBtn;
    private Button saveSettings;
    boolean checked;
    boolean choice;
    String mod;
    String them;

    public static final int MAIN_ACTIVITY_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //titulos de las tablas
        modeTxt = (TextView) findViewById(R.id.modeTxt);
        themeTxt = (TextView) findViewById(R.id.themeTxt);

        // RadioGroup
        modeChoice = (RadioGroup) findViewById(R.id.modeChoiceRaGr);
        modeChoice.setOnCheckedChangeListener(this);
        //RadioButtons
        ezModeRbtn = (RadioButton) findViewById(R.id.ezMode);
        hardModeRBtn = (RadioButton) findViewById(R.id.hardMode);
        hardModeRBtn.setChecked(true);
        checked = false;
        //ImgButton
        santaTheme = (ImageButton) findViewById(R.id.santaThemImBtn);
        santaTheme.setOnClickListener(this::onClick2);
        thekingsTheme = (ImageButton) findViewById(R.id.kingsThemImBtn);
        thekingsTheme.setOnClickListener(this::onClick2);
        //Boton
        saveSettings = (Button) findViewById(R.id.saveBtn);
        saveSettings.setOnClickListener(this);
        choice = false;
        saveSettings.setEnabled(false);




    }

    private void onClick2(View v) {
        santaTheme = (ImageButton) v;
        if (v.getId() == R.id.santaThemImBtn) {
            them = "santa";
            choice = true;
            saveSettings.setEnabled(true);
        } else if (v.getId() == R.id.kingsThemImBtn) {
            them =  "the3kings";
            choice = true;
            saveSettings.setEnabled(true);
        }

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

            intent.putExtra("mode", mod);
            intent.putExtra("theme",them);


        finish();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

        switch (checkId) {
            case R.id.ezMode:
                mod = "easy";
                checked = true;

                break;
            case R.id.hardMode:
                mod = "hard";
                checked = true;

                break;

        }


    }
}