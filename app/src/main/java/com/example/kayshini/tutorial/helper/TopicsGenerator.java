package com.example.kayshini.tutorial.helper;

import android.content.Context;

import com.example.kayshini.tutorial.dto.ExceptionTopic;
import com.example.kayshini.tutorial.dto.QuestionDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class TopicsGenerator {

    private Context context;

    public TopicsGenerator(Context context) {
        this.context = context;
    }

    /**
     * Creates a list of exception topics from the topics file. This list is used in the
     * ExploreExceptionActivity to show the topics.
     *
     * @return a list of exception topics
     */
    public List<ExceptionTopic> createExceptionTopics() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        return gson.fromJson(
                AssetFileReader.readElementsFromAssets(context, "topics.json"),
                TypeToken.getParameterized(ArrayList.class, ExceptionTopic.class).getType());
    }
}
