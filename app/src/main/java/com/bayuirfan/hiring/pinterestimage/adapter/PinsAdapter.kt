package com.bayuirfan.hiring.pinterestimage.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayuirfan.hiring.pinterestimage.R
import com.bayuirfan.hiring.pinterestimage.features.pins.detail.DetailPinActivity
import com.bayuirfan.hiring.pinterestimage.model.pins.Pins
import com.bayuirfan.hiring.pinterestimage.util.Constant.DESCRIPTION
import com.bayuirfan.hiring.pinterestimage.util.Constant.URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_pins.view.*

class PinsAdapter(private val context: Context,
                  private val pins: ArrayList<Pins>): RecyclerView.Adapter<PinsAdapter.PinsViewHolder>() {

    inner class PinsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(pin: Pins){
            Glide.with(context)
                .load(pin.images.sizeSmall.url)
                .into(itemView.img_pins)

            itemView.setOnClickListener {
                val intent = Intent(context, DetailPinActivity::class.java)
                intent.putExtra(URL, pin.images.sizeMedium.url)
                intent.putExtra(DESCRIPTION, pin.description)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinsViewHolder
        = PinsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pins, parent, false))

    override fun getItemCount(): Int = pins.size

    override fun onBindViewHolder(holder: PinsViewHolder, position: Int) {
        holder.bind(pins[position])
    }
}