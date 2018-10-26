package com.example.kayshini.tutorial.helper;

import android.content.Context;

import com.example.kayshini.tutorial.dto.QuestionDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class QuestionaireGenerator {

    private Context context;

    public QuestionaireGenerator(Context context) {
        this.context = context;
    }

    /**
     * Creates a list of questions for the quiz activity from the questionaire file
     *
     * @return a list of questions
     */
    public List<QuestionDto> createQuestionaire() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        return gson.fromJson(
                AssetFileReader.readElementsFromAssets(context, "questionaire.json"),
                TypeToken.getParameterized(ArrayList.class, QuestionDto.class).getType());
    }
}
