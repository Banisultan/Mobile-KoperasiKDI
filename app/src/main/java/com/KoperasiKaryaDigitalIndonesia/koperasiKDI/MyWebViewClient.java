package com.KoperasiKaryaDigitalIndonesia.koperasiKDI;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String hostname;

        //Masukkin host name contoh (google.com)
        hostname = "banisultan.com";

        Uri uri = Uri.parse(url);
        if (url.startsWith("file:") || uri.getHost() != null && uri.getHost().endsWith(hostname)) {
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}