package com.example.project1892.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.project1892.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    var binding: ActivityIntroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.introBtn.setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this@IntroActivity,
                    MainActivity::class.java
                )
            )
        }
    }
}