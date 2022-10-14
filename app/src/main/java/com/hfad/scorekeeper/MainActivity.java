package com.hfad.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Author: Samantha Rindgen
 * This program allows Android Studio to generate a scorekeeper app
 * that carries out desired calculator functions.
 */
public class MainActivity extends AppCompatActivity {

    //Used for saved instance state
    private int homeS = 0;
    private int awayS = 0;
    private String awayN = "Away";
    private String homeN = "Home";

    //KEYS for use with the bundle
    public static final String HOME_KEY = "0";
    public static final String AWAY_KEY = "1";
    public static final String HOME_NAME = "Home Name";
    public static final String AWAY_NAME = "Away Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create buttons and textViews
        Button btnHome = findViewById(R.id.btn_Home);
        Button btnAway = findViewById(R.id.btn_Away);
        TextView tvAScore = findViewById(R.id.tv_AwayS);
        TextView tvHScore = findViewById(R.id.tv_HomeS);
        TextView tvAName = findViewById(R.id.tv_Away);
        TextView tvHName = findViewById(R.id.tv_Home);

        //Check the saved instance state
        if (savedInstanceState != null)
        {
            awayN = savedInstanceState.getString(AWAY_NAME);
            tvAName.setText(awayN);

            homeN = savedInstanceState.getString(HOME_NAME);
            tvHName.setText(homeN);

            homeS = savedInstanceState.getInt(HOME_KEY);


            awayS = savedInstanceState.getInt(AWAY_KEY);
            tvHScore.setText("" + homeS);
            tvAScore.setText("" + awayS);
        }


        //Create on click actions for the buttons
        btnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayS++;
                tvAScore.setText("" + awayS);
                //awayN = tvAName.getText().toString();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeS++;
                tvHScore.setText("" + homeS);
                //homeN = tvHName.getText().toString();
            }
        });
    }

    /**
     * This function allows the information to be stored on orientation
     * @param savedInstanceState What is being stored
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(HOME_NAME, homeN);
        savedInstanceState.putString(AWAY_NAME, awayN);
        savedInstanceState.putInt(HOME_KEY, homeS);
        savedInstanceState.putInt(AWAY_KEY, awayS);

    }
}