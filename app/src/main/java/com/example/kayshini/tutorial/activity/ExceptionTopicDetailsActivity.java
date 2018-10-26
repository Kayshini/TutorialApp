package com.example.kayshini.tutorial.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.kayshini.tutorial.R;

/**
 *  Activity to show the details about the topics of java exception handling
 */
public class ExceptionTopicDetailsActivity extends AppCompatActivity {

    private static final String TAG = "Topics Detail Activity";

    /**
     * Creates a webview to show a html page containing the details about exception handling
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception_topic_details);

        WebView webView = findViewById(R.id.webviewExType);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebSettings webSettings =  webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        String webPage = getIntent().getStringExtra("webPage");

        Log.i(TAG, "Loading the page " + webPage);
        runOnUiThread(() -> webView.loadUrl("file:///android_asset/" + webPage));
    }

    /**
     * Navigate to the youtube viewer activity to play a video about exception handling
     * @param view
     */
    public void openYoutubeViewer(View view) {
        Log.i(TAG, "Navigate to the youtube viewer page");
        Intent youtubeViewerIntent = new Intent(this, YoutubeViewerActivity.class);
        youtubeViewerIntent.putExtra("videoId", getIntent().getStringExtra("videoId"));
        startActivity(youtubeViewerIntent);
    }
}
