package com.example.sportdiotask.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportdiotask.databinding.FragmentMatchDetailBinding

class MatchDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentMatchDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val match = MatchDetailFragmentArgs.fromBundle(requireArguments()).selectedMatch
        val viewModelFactory = DetailViewModelFactory(match, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java)
       /* binding.team1RV.layoutManager = LinearLayoutManager(requireActivity())
        binding.team1RV.adapter = MatchDetailAdapter(requireActivity(), null)
        */
        return binding.root
    }
}
