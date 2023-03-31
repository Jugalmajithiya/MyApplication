package com.example.myapplication.utils

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T){
    postValue(
        Resource(
            Status.SUCCESS,
            data
        )
    )
}

fun <T> MutableLiveData<Resource<T>>.setLoading() = postValue(Resource(Status.LOADING))

fun <T> MutableLiveData<Resource<T>>.setSuccess() = postValue(Resource(Status.SUCCESS))

fun <T> MutableLiveData<Resource<T>>.setError(throwable: Throwable? = null) {
    postValue(
        Resource(
            Status.ERROR,
            throwable = throwable
        )
    )
}

fun <T> MutableLiveData<Resource<T>>.setError(data: T) {
    postValue(
        Resource(
            Status.ERROR,
            data
        )
    )
}

fun <T> MutableLiveData<Resource<T>>.setError(message: String) {
    postValue(
        Resource(
            Status.ERROR,
            message
        )
    )
}