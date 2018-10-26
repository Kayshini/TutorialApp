package com.example.kayshini.tutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.kayshini.tutorial.R;

/**
 * Activity to show the results of the quiz activity
 */
public class ResultActivity extends AppCompatActivity {

    private static final String TAG = "Results Activity";

    /**
     * Creates ratings bar and score of the quiz activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score = getIntent().getIntExtra("score", 0);
        int totalQuestions = getIntent().getIntExtra("total_questions", 0);

        RatingBar bar = findViewById(R.id.ratingBar);
        double ratings = ((double) bar.getNumStars() / (double) totalQuestions) * score;
        bar.setRating((float) ratings);

        TextView txtQuestions = findViewById(R.id.textQuestionNo);
        txtQuestions.setText("You have completed " + totalQuestions + "/" + totalQuestions + " questions");

        int percentage = (score * 100) / totalQuestions;
        TextView txtResult = findViewById(R.id.textResult);
        txtResult.setText("Your accuracy is " + percentage + "%");

        Log.i(TAG, "The accuracy is " + percentage);
    }

    /**
     * Navigate back to the Main activity instead of the quiz page
     */
    @Override
    public void onBackPressed()
    {
        Log.i(TAG, "Navigating to the main page");
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
