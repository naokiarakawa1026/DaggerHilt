package com.example.daggerhilt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggerhilt.MainViewModel
import com.example.daggerhilt.R
import com.example.daggerhilt.databinding.FragmentMainBinding

class MainFragment (
    private val databaseName: String
        ) : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDaName.text = databaseName

        binding.btnMainFragment.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_fragment_container, HomeFragment::class.java, null)
                ?.addToBackStack("MainActivitiy")
                ?.commit()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}