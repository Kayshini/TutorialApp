package com.example.kayshini.tutorial.dto;

public class ExceptionTopic {
    private String topic;
    private String icon;
    private String webPageName;
    private String youtubeVideoId;

    public ExceptionTopic(String topic, String icon, String webPageName, String youtubeVideoId) {
        this.topic = topic;
        this.icon = icon;
        this.webPageName = webPageName;
        this.youtubeVideoId = youtubeVideoId;
    }

    public String getTopic() {
        return topic;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getWebPageName() {
        return webPageName;
    }

    public void setWebPageName(String webPageName) {
        this.webPageName = webPageName;
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }
}
