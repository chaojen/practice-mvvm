package com.chaojen.mvvmpatternpractice.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.chaojen.mvvmpatternpractice.databinding.FragmentRepoBinding
import com.chaojen.mvvmpatternpractice.model.data.Repo
import com.chaojen.mvvmpatternpractice.viewmodel.GithubViewModelFactory
import com.chaojen.mvvmpatternpractice.viewmodel.RepoViewModel

class RepoFragment : Fragment() {

    companion object {
        const val TAG = "RepoFragment"
    }

    private lateinit var binding: FragmentRepoBinding
    private val factory = GithubViewModelFactory()
    private lateinit var viewModel: RepoViewModel
    private val repoAdapter = RepoAdapter(mutableListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRepoBinding.inflate(inflater, container, false)
        binding.btnSearch.setOnClickListener { doSearch() }
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = repoAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(RepoViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.repos.observe(this, Observer<MutableList<Repo>> { t -> repoAdapter.swapItems(t)})
    }

    private fun doSearch() {
        val query = binding.edtQuery.text.toString()
        if (TextUtils.isEmpty(query)) {
            repoAdapter.clearItems()
            return
        }
        viewModel.searchRepo(query)
    }
}