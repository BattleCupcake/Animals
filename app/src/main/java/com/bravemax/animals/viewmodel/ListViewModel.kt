package com.bravemax.animals.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bravemax.animals.di.modules.CONTEXT_APP
import com.bravemax.animals.di.modules.TypeOfContext
import com.bravemax.animals.model.Animal
import com.bravemax.animals.model.service.AnimalApiService
import com.bravemax.animals.util.SharedPreferencesHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListViewModel(application: Application) : AndroidViewModel(application) {

    constructor(application: Application, test: Boolean = true) : this(application) {
        injected = true
    }

    val animals by lazy { MutableLiveData<List<Animal>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }
    private val disposable: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var apiService: AnimalApiService

    @Inject
    @field: TypeOfContext(CONTEXT_APP)
    lateinit var prefs: SharedPreferencesHelper
    private var invalidApiKey = false
    private var injected = false

    fun inject() {
        if (!injected) {

        }
    }

    fun refresh() {
        inject()
        loading.value = true
        invalidApiKey = false
        val key = prefs.getApiKey()
        if (key.isNullOrEmpty()) {
            getKey()
        } else {
            getAnimals(key)
        }
    }

    fun hardRefresh() {
        inject()
        loading.value = true
        getKey()
    }

    private fun getKey() {
        disposable
    }

    private fun getAnimals(key: String) {

    }
}