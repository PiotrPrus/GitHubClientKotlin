package com.example.piotrprus.githubclientkotlin.screen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.piotrprus.githubclientkotlin.R
import com.example.piotrprus.githubclientkotlin.model.Repository
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter: RecyclerView.Adapter<Adapter.Holder>() {

    val repos = ArrayList<Repository>()

    fun setRepositories(list: Collection<Repository>) {
        repos.clear()
        repos.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val repository = repos[position]
        holder.itemView?.item_title!!.text = repository.name
        holder.itemView.item_description.text = repository.description
        holder.itemView.item_stars.text = repository.stars.toString() + " stars"
    }

    class Holder(view: View): RecyclerView.ViewHolder(view)
}