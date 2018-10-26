package com.example.kayshini.tutorial.dto;

import java.util.List;

public class QuestionDto {
    private String question;
    private String questionImagePath;
    private List<String> options;
    private String answer;
    private String explanation;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionImagePath() {
        return questionImagePath;
    }

    public void setQuestionImagePath(String questionImagePath) {
        this.questionImagePath = questionImagePath;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
