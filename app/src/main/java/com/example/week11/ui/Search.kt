package com.example.week11.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import com.example.week11.databinding.ActivitySearchBinding

class Search : BaseActivity<ActivitySearchBinding>() {
    override val LOG_TAG: String="SEARCH_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivitySearchBinding=ActivitySearchBinding::inflate
    override fun setUp() {}
    override fun callback() {
        binding?.apply {
                goToMain.setOnClickListener {
                val intent =Intent(Intent.ACTION_VIEW)
                intent.data= Uri.parse("match:")
                startActivity(intent)
            }
        }
    }
}