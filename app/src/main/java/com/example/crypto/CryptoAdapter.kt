package com.example.crypto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CryptoAdapter(var dataSet: List<CryptoData>) :
    RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val TextViewPriceUsd: TextView
        val TextViewLastUpdatedDate: TextView
        val TextViewCrypto: TextView
        val layout: ConstraintLayout

        init {
            TextViewPriceUsd = view.findViewById(R.id.textView_dataItem_priceUsd)
            TextViewLastUpdatedDate = view.findViewById(R.id.textView_dataItem_date)
            TextViewCrypto = view.findViewById(R.id.textView_dataItem_name)
            layout = view.findViewById(R.id.layout_dataItem)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_crypto_data, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var context = viewHolder.TextViewPriceUsd.context
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val county = dataSet[position]
        viewHolder.TextViewPriceUsd.text = county.rates.rate.toString()
        viewHolder.TextViewLastUpdatedDate.text = county.rates.time
        viewHolder.TextViewCrypto.text = county.asset_id_base
    }
    override fun getItemCount() = dataSet.size
}