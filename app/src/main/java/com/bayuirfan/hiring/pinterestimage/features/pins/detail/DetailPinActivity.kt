package com.bayuirfan.hiring.pinterestimage.features.pins.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bayuirfan.hiring.pinterestimage.R
import com.bayuirfan.hiring.pinterestimage.util.Constant.DESCRIPTION
import com.bayuirfan.hiring.pinterestimage.util.Constant.URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_pin.*

class DetailPinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detail_pin)
        val url = intent.getStringExtra(URL)
        val description = intent.getStringExtra(DESCRIPTION)

        Glide.with(this)
            .load(url)
            .into(img_pin_detail)

        txt_description.text = description
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}
