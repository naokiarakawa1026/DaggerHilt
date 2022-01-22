package com.example.daggerhilt

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.daggerhilt.qualifier.ApiKey
import com.example.daggerhilt.qualifier.DatabaseName
import com.example.daggerhilt.ui.HomeFragment
import com.example.daggerhilt.ui.MainFragment
import javax.inject.Inject

class AppFragmentFactory @Inject constructor(
    @DatabaseName private val databaseName: String,
    @ApiKey private val apiKey: String
) : FragmentFactory()  {

    // insで表示される
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            MainFragment::class.java.name -> {
                MainFragment(databaseName)
            }
            HomeFragment::class.java.name -> {
                MainFragment(apiKey)
            }
            else -> {
                super.instantiate(classLoader, className)
            }
        }
    }
}