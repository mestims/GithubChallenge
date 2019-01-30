package br.com.githubchallenge.feature.main

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import br.com.githubchallenge.service.model.Item
import kotlinx.android.synthetic.main.item_repo.view.*

class RepositoryViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(repo: Item?) {
        itemView.repository_name.text = repo?.name
        itemView.description.text = repo?.description
        itemView.fork_count.text = repo?.forksCount?.toString()
        itemView.stars_count.text = repo?.stargazersCount?.toString()
        itemView.owner_name.text = repo?.owner?.login
    }
}