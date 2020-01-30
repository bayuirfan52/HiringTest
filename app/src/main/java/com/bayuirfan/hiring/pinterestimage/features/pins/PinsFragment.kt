package com.bayuirfan.hiring.pinterestimage.features.pins


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager

import com.bayuirfan.hiring.pinterestimage.R
import com.bayuirfan.hiring.pinterestimage.adapter.PinsAdapter
import com.bayuirfan.hiring.pinterestimage.model.pins.Pins
import kotlinx.android.synthetic.main.fragment_pins.*

class PinsFragment : Fragment(), PinsView {
    private lateinit var adapter: PinsAdapter
    private val presenter = PinsPresenter(this)
    private val pins = mutableListOf<Pins>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_pins, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(activity as AppCompatActivity){
            adapter = PinsAdapter(this, pins as ArrayList<Pins>)
            rv_pins.setHasFixedSize(true)
            rv_pins.adapter = adapter
            rv_pins.layoutManager = GridLayoutManager(this,2)
        }

        srl_refresh.setOnRefreshListener {
            presenter.getAllPins()
        }

        presenter.getAllPins()
    }

    override fun setPins(pins: ArrayList<Pins>) {
        this.pins.clear()
        this.pins.addAll(pins)
        adapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
        rv_pins.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
        rv_pins.visibility = View.VISIBLE
        srl_refresh.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        context?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.perhatian))
                .setMessage(errorMessage)
                .setPositiveButton("ok"){
                    dialog, _ -> dialog.dismiss()
                }
                .show()}
    }
}
