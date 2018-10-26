package com.example.kayshini.tutorial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.kayshini.tutorial.R;
import com.example.kayshini.tutorial.dto.QuestionDto;
import com.example.kayshini.tutorial.helper.QuestionaireGenerator;

import java.util.List;

/**
 * Simple quiz activity to test the skills of the java exception handling
 */
public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "Quiz Activity";

    private TextView txtQuestion, txtQuestionNo;
    private RadioButton option1, option2, option3, option4;
    private RadioGroup optionGroup;
    private Button butSubmit, butNext;
    private ImageView questionImage;
    private ProgressBar progressBar;
    private int questionNo = 0;
    private int score = 0;
    private List<QuestionDto> questionaire;

    /**
     * Create a screen to show the question, multiple choices, progress bar and feedback for the wrong choices
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionaire = new QuestionaireGenerator(this).createQuestionaire();

        txtQuestion = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        optionGroup = findViewById(R.id.radioGroup);

        butNext = findViewById(R.id.next);
        butSubmit = findViewById(R.id.submit);
        questionImage = findViewById(R.id.question_image);
        txtQuestionNo = findViewById(R.id.question_no);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(questionaire.size());

        setQuestionView();

    }

    /**
     * When clicking the mobile back button, takes to the main activity instead of the previous question
     */
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Checks if any choices are selected.
     * If no, shows a alert dialog to the user to make a valid selection.
     * If yes, based on the correctness of the choice, the score is incremented or a dialog is displayed with feedback.
     * @param view
     */
    public void submit(View view) {
        int checkedRadioButton = optionGroup.getCheckedRadioButtonId();
        if (checkedRadioButton != -1) {
            QuestionDto questionDto = questionaire.get(questionNo);
            RadioButton answer = findViewById(checkedRadioButton);
            String correctAnswer = questionDto.getAnswer();
            if(answer.getText().toString().startsWith(correctAnswer)) {
                score++;
                Log.d(TAG, "The selected choice is correct. The score is incremented to " + score);
            } else {
                Log.d(TAG, "Incorrect Answer");
                new AlertDialog.Builder(this)
                        .setTitle(R.string.title_quiz_feedback)
                        .setMessage(questionDto.getExplanation())
                        .setCancelable(true)
                        .setPositiveButton("OK", null)
                        .show();
            }
            butSubmit.setEnabled(false);
            butNext.setEnabled(true);
        } else {
            Log.e(TAG, "No choice is selected");
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_answer_alert)
                    .setMessage(R.string.msg_answer_alert)
                    .setCancelable(true)
                    .setPositiveButton("OK", null)
                    .show();
        }

    }

    /**
     * Shows the next question
     * @param view
     */
    public void next(View view) {
        questionNo++;
        if (questionNo < questionaire.size()) {
            resetAllElements();
            setQuestionView();
        } else {
            Intent resultIntent = new Intent(this, ResultActivity.class);
            resultIntent.putExtra("score", score);
            resultIntent.putExtra("total_questions", questionaire.size());
            startActivity(resultIntent);
        }
    }

    /**
     * Refresh the components with the new questions and choices
     */
    private void setQuestionView()
    {
        butNext.setEnabled(false);
        optionGroup.clearCheck();
        txtQuestionNo.setText("Question No: " + (questionNo + 1));
        progressBar.setProgress(questionNo + 1);

        QuestionDto currentQuestion = questionaire.get(questionNo);

        if (!isEmpty(currentQuestion.getQuestion())) {
            txtQuestion.setText(currentQuestion.getQuestion());
            questionImage.setVisibility(View.GONE);
        }

        if (!isEmpty(currentQuestion.getQuestionImagePath())) {
            txtQuestion.setVisibility(View.GONE);
            questionImage.setImageResource(getImageId(currentQuestion.getQuestionImagePath()));

        }

        List<String> optionList = currentQuestion.getOptions();
        int optionsCount = optionGroup.getChildCount();
        for (int i = 0; i < optionsCount; i++) {
            RadioButton option = (RadioButton) optionGroup.getChildAt(i);
            if (i < (optionList.size())) {
                option.setText(optionList.get(i));
            } else {
                option.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Resets all the components
     */
    private void resetAllElements() {
        txtQuestion.setVisibility(View.VISIBLE);
        questionImage.setVisibility(View.VISIBLE);
        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);
        option4.setVisibility(View.VISIBLE);
        butSubmit.setEnabled(true);
    }

    private int getImageId(String imageName) {
        return getResources().getIdentifier("drawable/" + imageName, null, getPackageName());
    }

    private boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }


}
