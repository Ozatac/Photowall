package com.tunahanozatac.photowall.features.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunahanozatac.photowall.data.model.photos.PhotosList
import com.tunahanozatac.photowall.data.model.random.RandomModel
import com.tunahanozatac.photowall.data.repository.RandomRepository
import com.tunahanozatac.photowall.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val repository: RandomRepository
) : ViewModel() {

    var cryptoList = mutableStateOf<List<RandomModel>>(listOf())
    var photosList = mutableStateOf<List<PhotosList?>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(true)

    /*init {
        loadRandomPhoto(Constants.API_KEY)
    }*/

    fun loadRandomPhoto(clientId: String) {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.getRandom(clientId)) {
                is Resource.Success -> {
                    errorMessage.value = ""
                    isLoading.value = false
                    cryptoList.value += result.data!!
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }
    }

    fun getPhotosList(clientId: String) {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.getPhotosList(clientId)) {
                is Resource.Success -> {
                    errorMessage.value = ""
                    isLoading.value = false
                    photosList.value += result.data
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }
    }
}