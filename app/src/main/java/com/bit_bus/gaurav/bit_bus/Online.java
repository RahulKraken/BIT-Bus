package com.bit_bus.gaurav.bit_bus;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Gaurav on 01-09-2016.
 */
public class Online extends Fragment {
    ProgressBar progressBar;
    TextView tv;
    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ativity_online,container,false);
        progressBar=(ProgressBar)v.findViewById(R.id.progressBar);
        tv=(TextView)v.findViewById(R.id.online_tv);
        if(isNetworkStatusAvialable(getContext())!=false){
        WebView myWebView = (WebView)v.findViewById(R.id.webview);
        myWebView.loadUrl("http://m.bitbus.in");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        WebViewClientDemo m=new WebViewClientDemo();
        myWebView.setWebViewClient(m);}
        else {
            progressBar.setVisibility(View.GONE);
            progressBar.setProgress(100);
            Toast.makeText(getContext(), "Check your Internet Connection!!", Toast.LENGTH_LONG).show();
            tv.setBackgroundResource(R.drawable.onl);
        }
        return v;
    }
    private class WebViewClientDemo extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar.setProgress(100);
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }
    }



}
