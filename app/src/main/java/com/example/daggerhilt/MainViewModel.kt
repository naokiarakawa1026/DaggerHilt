package com.example.daggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepositoryImpl
): ViewModel() {

    private val _databaseName: MutableLiveData<String> = MutableLiveData()
    val databaseName : LiveData<String> get() = _databaseName

    private val _userList : MutableLiveData<List<String>> = MutableLiveData()
    val userList : LiveData<List<String>> get() = _userList

    init {
        getDatabaseName()
        getUserList()

    }

    private fun getDatabaseName() {
        viewModelScope.launch {
            _databaseName.value = userRepository.getDatabaseName()
        }
    }

    private fun getUserList() {
        viewModelScope.launch {
            _userList.value = userRepository.getUserList()
        }
    }
}