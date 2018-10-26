package com.example.kayshini.tutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.kayshini.tutorial.R;
import com.example.kayshini.tutorial.adapter.ExceptionTopicAdapter;
import com.example.kayshini.tutorial.dto.ExceptionTopic;
import com.example.kayshini.tutorial.helper.TopicsGenerator;
import java.util.List;

/**
 * Activity containing a recycle view to show the list of subtopics to explore java exception handling
 */
public class ExploreExceptionActivity extends AppCompatActivity implements ExceptionTopicAdapter.OnItemClickListener {

    private static final String TAG = "Explore Activity";

    /**
     * Create a screen to show recycle view with the list of exception handling topics.
     * Each topic is displayed as a card.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_exception);

        TextView txtSubTopics = findViewById(R.id.txt_subtopics);
        txtSubTopics.setText(R.string.str_subtopics);

        ExceptionTopicAdapter topicAdapter = new ExceptionTopicAdapter(getData(), this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(topicAdapter);
    }

    /**
     * Navigate to the Exception Topic Details activity
     * @param exceptionTopic
     */
    @Override
    public void onItemClick(ExceptionTopic exceptionTopic) {
        Log.i(TAG, "Navigate to the ExceptionTopics Details page");
        Intent expTopicDetailsIntent = new Intent(this, ExceptionTopicDetailsActivity.class);
        expTopicDetailsIntent.putExtra("webPage", exceptionTopic.getWebPageName());
        expTopicDetailsIntent.putExtra("videoId", exceptionTopic.getYoutubeVideoId());
        startActivity(expTopicDetailsIntent);
    }

    private List<ExceptionTopic>  getData() {
        Log.d(TAG, "Loading the exception handling topics");
        TopicsGenerator topicsGenerator = new TopicsGenerator(getApplicationContext());
        return topicsGenerator.createExceptionTopics();
    }
}
