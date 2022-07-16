package com.example.githubrepos.ui.github_repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.githubrepos.databinding.FragmentRepoListBinding
import com.example.githubrepos.ui.adapter.RepoListAdapter
import com.example.githubrepos.ui.adapter.ReposLoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubReposFragment : Fragment() {

    private val viewModel: GithubReposViewModel by viewModel()

    private val repoAdapter: RepoListAdapter by lazy {
        RepoListAdapter(requireContext())
    }

    private var _binding: FragmentRepoListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRepoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvRepoList.adapter = repoAdapter.withLoadStateFooter(
                ReposLoadStateAdapter(requireContext())
            )
        }

        lifecycleScope.launchWhenStarted {
            viewModel.repoPagingData.collectLatest {
                repoAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}