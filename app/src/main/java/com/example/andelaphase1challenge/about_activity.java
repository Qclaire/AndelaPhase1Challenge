package com.example.andelaphase1challenge;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.ProgressBar;

public class about_activity extends AppCompatActivity {
    WebView myWebView; ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_activity);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);

        myWebView = findViewById(R.id.webview);
        String URL = "http://andela.com/alc";
        myWebView.setWebViewClient(new WebViewClientByPassingSSLErrors(){
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.INVISIBLE);


            }
        }); // to compel the page to load in-app
        myWebView.loadUrl(URL);
        progressBar.setVisibility(View.VISIBLE);

    }
    /* Andela.com has SSL certification issues as reported by the WebViewClient
       this causes loading to fail and the page remains blank.
        This class will extend the WebViewClient class and instruct it to ignore
        the error and continue to load. Without it, pages like google and my
        personal website load but not andela.com or its sub-pages
    */
    private class WebViewClientByPassingSSLErrors extends WebViewClient {
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

    }
}
