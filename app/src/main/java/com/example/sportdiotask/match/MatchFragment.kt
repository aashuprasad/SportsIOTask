package com.example.sportdiotask.match

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sportdiotask.databinding.FragmentMatchBinding

class MatchFragment : Fragment() {

    private val viewModel: MatchViewModel by lazy {
        ViewModelProvider(this).get(MatchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMatchBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the MatchViewModel
        binding.viewModel = viewModel

        binding.recyclerView
        viewModel.navigateToSelectedMatch.observe(viewLifecycleOwner, Observer{
            if (null != it) {
                this.findNavController().navigate(MatchFragmentDirections.actionMatchFragment(it))
                viewModel.displayMatchDetailsComplete()
            }
        })
        return binding.root
    }
}
