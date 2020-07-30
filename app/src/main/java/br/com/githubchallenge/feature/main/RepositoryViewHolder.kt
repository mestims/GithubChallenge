package br.com.githubchallenge.feature.main

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.view.View
import br.com.githubchallenge.service.model.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_repo.view.*

class RepositoryViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(repo: Item?) {
        itemView.repository_name.text = repo?.name
        itemView.description.text = repo?.description
        itemView.fork_count.text = repo?.forksCount?.toString()
        itemView.stars_count.text = repo?.stargazersCount?.toString()
        itemView.owner_name.text = repo?.owner?.login
//        Picasso.with(itemView.context).load(repo?.)
    }
}