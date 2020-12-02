package com.sunitrafi.hscquestionbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class agri_english extends AppCompatActivity {

    private WebView webView;
    private ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri_english);
        webView=(WebView)findViewById(R.id.agri_english);
        progressdialog=new ProgressDialog(this);
        progressdialog.setMessage("Please Wait....");
        progressdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressdialog.show();

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(progressdialog.isShowing())
                {
                    progressdialog.dismiss();
                }
            }
        });
        webView.loadUrl("https://drive.google.com/file/d/1VJbQdOJOdccS7NGxTc5gU9uBKpSHvqHY/view?usp=sharing");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
            this.finish();
        }
    }
}