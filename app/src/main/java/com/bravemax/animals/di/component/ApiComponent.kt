package com.bravemax.animals.di.component

import com.bravemax.animals.di.modules.ApiModule
import com.bravemax.animals.model.service.AnimalApiService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: AnimalApiService)
}