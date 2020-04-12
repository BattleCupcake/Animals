package com.bravemax.animals.model.service

import com.bravemax.animals.model.Animal
import com.bravemax.animals.model.Key
import com.bravemax.animals.model.api.AnimalApi
import io.reactivex.Single
import javax.inject.Inject

class AnimalApiService {

    @Inject
    lateinit var api: AnimalApi

    fun getApiKey(): Single<Key> = api.getApiKey()

    fun getAnimals(key: String): Single<List<Animal>> = api.getAnimals(key)
}