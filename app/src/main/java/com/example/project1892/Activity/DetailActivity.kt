package com.example.project1892.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.project1892.Domain.ItemDomain
import com.example.project1892.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private var binding: ActivityDetailBinding? = null
    private var `object`: ItemDomain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        intentExtra
        setVariable()
    }

    private fun setVariable() {
        binding!!.titleTxt.text = `object`?.title
        binding!!.priceTxt.text = "$" + `object`?.price
        binding!!.backBtn.setOnClickListener { finish() }
        binding!!.bedTxt.text = "" + `object`?.bed
        binding!!.durationTxt.text = `object`?.duration
        binding!!.distanceTxt.text = `object`?.distance
        binding!!.descriptionTxt.text = `object`?.description
        binding!!.addressTxt.text = `object`?.address
        binding!!.ratingTxt.text = "${`object`?.score} Rating"
        binding!!.ratingBar.rating = `object`?.score?.toFloat() ?: 0f

        Glide.with(this)
            .load(`object`?.pic)
            .into(binding!!.pic)

        binding!!.addToCartBtn.setOnClickListener {
            val intent = Intent(this, TicketActivity::class.java)
            intent.putExtra("object", `object`)
            startActivity(intent)
        }
    }

    private val intentExtra: Unit
        get() {
            `object` = intent.getSerializableExtra("object") as ItemDomain?
        }
}
