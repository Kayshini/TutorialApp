package com.example.kayshini.tutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.kayshini.tutorial.R;

/**
 * A simple launcher activity containing  buttons to explore topics about java exception handling, and quiz.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.apptitle);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /**
     * Navigate to the Explore exception handling topics page
     * @param view
     */
    public void exploreContent(View view) {
        Log.i(TAG, "Navigate to the explore exception handling topics page");
        Intent exploreExceptionIntent = new Intent(this, ExploreExceptionActivity.class);
        startActivity(exploreExceptionIntent);
    }

    /**
     * Naviagate to the Quiz page
     * @param view
     */
    public void startQuiz(View view) {
        Log.i(TAG, "Navigate to the quiz page");
        Intent quizIntent = new Intent(this, QuizActivity.class);
        startActivity(quizIntent);
    }
}
