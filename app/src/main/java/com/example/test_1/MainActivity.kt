package com.example.test_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val web : WebView = findViewById(R.id.WebView)
        val urlDefault = "https://google.com/"

        val home : Button = findViewById(R.id.btn_home)
        val alamat : EditText = findViewById(R.id.edit)
        val tekan : Button = findViewById(R.id.tekan)

        web.settings.javaScriptEnabled

        web.loadUrl(urlDefault)

        tekan.setOnClickListener(View.OnClickListener() {
            web.loadUrl(alamat.text.toString())
        })

        home.setOnClickListener {
            web.loadUrl(urlDefault)
        }

        web.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java", ReplaceWith("false")) // ini bisa dihapus
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                alamat.setText(url)
                return false
            }

            override fun onPageFinished(WebView: WebView?, url: String?) {
                if (WebView != null) {
                    supportActionBar?.setTitle(WebView.title)
                }
                super.onPageFinished(WebView, url)
            }
        }
    }
}