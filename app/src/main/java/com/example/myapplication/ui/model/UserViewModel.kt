package com.example.myapplication.ui.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.NewsDataResponse
import com.example.myapplication.repo.UserRepository
import com.example.myapplication.utils.Constant.ERROR_MESSAGE
import com.example.myapplication.utils.Resource
import com.example.myapplication.utils.setError
import com.example.myapplication.utils.setLoading
import com.example.myapplication.utils.setSuccess
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DashBoardViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var _userResponse = MutableLiveData<Resource<NewsDataResponse>>()
    val UserResponseLiveData: LiveData<Resource<NewsDataResponse>> get() = _userResponse


    val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { a, throwable ->
            println("##Error>${throwable.localizedMessage}")
            _userResponse.setError(ERROR_MESSAGE)

        }

    fun callNewsListApi(page:Int) {
        _userResponse.setLoading()

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            repository.getNewsData(
                query = "Tesla",
                page = page,
                key = "x-j927IGDXhVYRrm2Orx2SICQw-toHv9TQHeEkqqzNg"
            ).let {
                if (it.isSuccessful) {
                    it.body()?.let { data ->
                        if (data.status == "ok") {
                            _userResponse.setSuccess(it.body()!!)
                        } else {
                            _userResponse.setError(it.body()!!)
                        }
                    }
                } else {
                    _userResponse.setError(it.body()!!)
                }
            }


        }
    }
}
