package com.example.daggerhilt.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.daggerhilt.MainActivity.Companion.TAG
import com.example.daggerhilt.MainViewModel
import com.example.daggerhilt.R
import com.example.daggerhilt.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainFragment(
    private val databaseName: String
) : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()
    private val stringBuilder : StringBuilder by lazy {
        StringBuilder()
    }

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


        binding.btnMainFragment.setOnClickListener {
            Log.d(TAG, "tapped button")
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_fragment_container, HomeFragment::class.java, null)
                ?.addToBackStack("MainActivity")
                ?.commit()
        }

        getDatabaseName()
        getUsers()
    }

    private fun getDatabaseName() {
        viewModel.databaseName.observe(viewLifecycleOwner, {
            binding.tvDaName.text = it
        })
    }

    private fun getUsers() {
        viewModel.userList.observe(viewLifecycleOwner, { userList ->
            userList.forEach {
                stringBuilder.append(it)
                stringBuilder.append(",")
            }
            binding.txtUserList.text = stringBuilder
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}