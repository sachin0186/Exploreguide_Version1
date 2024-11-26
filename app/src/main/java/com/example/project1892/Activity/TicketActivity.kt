package com.example.project1892.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.project1892.Domain.ItemDomain
import com.example.project1892.databinding.ActivityTicketBinding

class TicketActivity : BaseActivity() {
    private var binding: ActivityTicketBinding? = null
    private var `object`: ItemDomain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        intentExtra
        setVariable()
    }

    private fun setVariable() {
        Glide.with(this)
            .load(`object`?.pic)
            .into(binding!!.pic)

        Glide.with(this)
            .load(`object`?.tourGuidePic)
            .into(binding!!.profile)

        binding!!.backBtn.setOnClickListener { finish() }
        binding!!.titleTxt.text = `object`?.title
        binding!!.durationTxt.text = `object`?.duration
        binding!!.tourGuideTxt.text = `object`?.dateTour
        binding!!.timeTxt.text = `object`?.timeTour
        binding!!.tourGuideNameTxt.text = `object`?.tourGuideName

        binding!!.callBtn.setOnClickListener {
            val phone = `object`?.tourGuidePhone
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("sms:$phone")
                putExtra("sms_body", "type your message")
            }
            startActivity(intent)
        }

        binding!!.messageBtn.setOnClickListener {
            val phone = `object`?.tourGuidePhone
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }
    }

    private val intentExtra: Unit
        get() {
            `object` = intent.getSerializableExtra("object") as ItemDomain?
        }
}
