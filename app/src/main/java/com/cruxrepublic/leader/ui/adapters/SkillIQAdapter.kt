package com.cruxrepublic.leader.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cruxrepublic.leader.R
import com.cruxrepublic.leader.api.model.TopSkillIQResponse
import kotlinx.android.synthetic.main.learner_item.view.*

class SkillIQAdapter(): RecyclerView.Adapter<SkillIQAdapter.SkillViewHolder>() {
    private var iqItems = ArrayList<TopSkillIQResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.learner_item, parent, false)
        return SkillViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: SkillIQAdapter.SkillViewHolder, position: Int) {
       val item = iqItems[position]
        holder.name.text = item.name
        holder.score.text = "${item.score} skill IQ Score"
        holder.country.text = item.country

//        val badgeUrl = item.badgeUrl
        Glide.with(holder.badge)
            .load(item.badgeUrl)
            .centerCrop()
            .placeholder(R.drawable.top_learner_badge)
            .into(holder.badge)
    }

    override fun getItemCount() = iqItems.size

    inner class SkillViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.nameTextView)
        var score: TextView = itemView.findViewById(R.id.iqScoreTextView)
        var country: TextView = itemView.findViewById(R.id.iqCountryTextView)
        var badge: ImageView = itemView.findViewById(R.id.skillImage)
    }
}