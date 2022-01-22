package com.example.daggerhilt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggerhilt.HomeViewModel
import com.example.daggerhilt.R
import com.example.daggerhilt.databinding.FragmentHomeBinding
import com.example.daggerhilt.qualifier.ApiKey
import javax.inject.Inject

class HomeFragment @Inject constructor(
    @ApiKey private val apiKey: String
) : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvApiName.text = apiKey
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}