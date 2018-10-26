package com.example.kayshini.tutorial.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;

import com.example.kayshini.tutorial.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Activity containing a youtube player to show the videos about the topics about exceptions
 */
public class YoutubeViewerActivity extends YouTubeBaseActivity {

    private static final String TAG = "Youtube Activity";
    private static final String API_KEY = "AIzaSyBrTpjLX0xwlaePZvv62FO81-R_fVMNbD8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_viewer);

        String videoId = getIntent().getStringExtra("videoId");

        YouTubePlayerView youTubePlayerView = findViewById(R.id.player);

        youTubePlayerView.initialize(API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean wasRestored) {
                        if (!wasRestored) {
                            youTubePlayer.setFullscreen(true);

                            Log.i(TAG, "Loading youtube video " + videoId);
                            youTubePlayer.loadVideo(videoId);
                        }
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {
                        Log.e(TAG, "Youtube initialization has failed");
                        Toast.makeText(YoutubeViewerActivity.this, "Youtube Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
