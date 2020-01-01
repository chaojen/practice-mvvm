package com.chaojen.mvvmpatternpractice.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chaojen.mvvmpatternpractice.databinding.ItemRepoBinding
import com.chaojen.mvvmpatternpractice.model.data.Repo

class RepoAdapter(val items: MutableList<Repo>) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = items[position]
        holder.bind(repo)
    }

    fun clearItems() {
        val size = items.size
        items.clear()
        notifyItemRangeRemoved(0, size)
    }

    fun swapItems(newItems: MutableList<Repo>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = this@RepoAdapter.items.size
            override fun getNewListSize() = newItems.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = items[oldItemPosition].owner.login == newItems[newItemPosition].owner.login
            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = items[oldItemPosition].owner.avatarUrl == newItems[newItemPosition].owner.avatarUrl && items[oldItemPosition].owner.contributions == newItems[newItemPosition].owner.contributions
        })
        this@RepoAdapter.items.clear()
        this@RepoAdapter.items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    class RepoViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
         fun bind(repo: Repo) {
             binding.repo = repo
             binding.executePendingBindings() // 立即更新畫面
         }
    }
}