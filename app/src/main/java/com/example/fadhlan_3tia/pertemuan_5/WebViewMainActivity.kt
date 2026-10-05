package com.example.fadhlan_3tia.pertemuan_5

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.fadhlan_3tia.R
import com.example.fadhlan_3tia.databinding.ActivityMainBinding
import com.example.fadhlan_3tia.databinding.ActivityWebViewMainBinding
import android.webkit.WebViewClient
class WebViewMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWebViewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://otakudesu.blog/")

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Anime"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            //      setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}