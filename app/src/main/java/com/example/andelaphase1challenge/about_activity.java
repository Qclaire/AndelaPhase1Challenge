package com.example.andelaphase1challenge;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class about_activity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_activity);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClientByPassingSSLErrors()); // to compel the page to load in-app
        myWebView.loadUrl("http://andela.com/alc");
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
