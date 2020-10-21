package com.KoperasiKaryaDigitalIndonesia.koperasiKDI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView WebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView = findViewById(R.id.home_webview);
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebView.setWebViewClient(new MyWebViewClient());

        //Tujuan website fix
        WebView.loadUrl("https://koperasikdi.banisultan.com");


        WebView.setWebViewClient(new MyWebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(WebView.canGoBack()) {
            WebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
