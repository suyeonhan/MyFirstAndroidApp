package com.example.suyeon.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class court_counter_activity extends AppCompatActivity {

    private static final String TAG = court_counter_activity.class.getSimpleName();
    public static final int SCORE1 = 1;
    public static final int SCORE2 = 2;
    public static final int SCORE3 = 3;

    private Button mThreeButton;
    private Button mTwoButton;
    private Button mOneButton;
    private Button mThreeButton_2;
    private Button mTwoButton_2;
    private Button mOneButton_2;
    private Button mResetButton;

    private TextView mScoreTextView;
    private TextView mScoreTextView2;

    private int mScore;
    private int mScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        //레이아웃 표시
        setContentView(R.layout.court_counter_activity);

        mThreeButton = (Button) findViewById(R.id.three_button);
        mTwoButton = (Button) findViewById(R.id.two_button);
        mOneButton = (Button) findViewById(R.id.one_button);
        mThreeButton_2 = (Button) findViewById(R.id.three_button2);
        mTwoButton_2 = (Button) findViewById(R.id.two_button2);
        mOneButton_2 = (Button) findViewById(R.id.one_button2);
        mResetButton = (Button) findViewById(R.id.reset_button);

        mScoreTextView = (TextView) findViewById(R.id.score_text);
        mScoreTextView2 = (TextView) findViewById(R.id.score_text2);


        mThreeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore += SCORE3;
                mScoreTextView.setText("" + mScore);
            }
        });

        mThreeButton_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore2 += SCORE3;
                mScoreTextView2.setText("" + mScore2);
            }
        });

        mTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore += SCORE2;
                mScoreTextView.setText("" + mScore);
            }
        });

        mTwoButton_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore2 += SCORE2;
                mScoreTextView2.setText("" + mScore2);
            }
        });

        mOneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore += SCORE1;
                mScoreTextView.setText("" + mScore);
            }
        });

        mOneButton_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore2 += SCORE1;
                mScoreTextView2.setText("" + mScore2);
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                init();
                mScoreTextView.setText("" + 0);
                mScoreTextView2.setText("" + 0);
                }
        });

        int score3 = SCORE3;
        int score2 = SCORE2;
        int score1 = SCORE1;
    }

    private void init() { mScore = 0; mScore2 = 0; }
}
