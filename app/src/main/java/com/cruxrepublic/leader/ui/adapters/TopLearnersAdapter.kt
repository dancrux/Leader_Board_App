package com.cruxrepublic.leader.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cruxrepublic.leader.R
import com.cruxrepublic.leader.api.model.TopLearnersResponse
import org.w3c.dom.Text

class TopLearnersAdapter(): RecyclerView.Adapter<TopLearnersAdapter.TopLearnersViewHolder>(){
    private var items = ArrayList<TopLearnersResponse>()

    fun addItems(learnersList: List<TopLearnersResponse>){
        this.items.addAll(learnersList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopLearnersViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.learner_item, parent, false)
        return TopLearnersViewHolder((itemView))
    }



    override fun onBindViewHolder(holder: TopLearnersViewHolder, position: Int) {
       val item = items[position]
        holder.name.text = item.name
        holder.hours.text = item.hours.toString()
        holder.country.text = item.country

//        val badgeUrl = item.badgeUrl
        Glide.with(holder.badge)
            .load(item.badgeUrl)
            .centerCrop()
            .placeholder(R.drawable.top_learner_badge)
            .into(holder.badge)
    }

    override fun getItemCount(): Int = items.size

    inner class TopLearnersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.iqNameTextView)
        var hours: TextView = itemView.findViewById(R.id.hoursTextView)
        var country: TextView = itemView.findViewById(R.id.iqCountryTextView)
        var badge: ImageView = itemView.findViewById(R.id.learnersImage)

    }
}