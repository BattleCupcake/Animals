package com.bravemax.animals.di.component

import com.bravemax.animals.di.modules.ApiModule
import com.bravemax.animals.di.modules.AppModule
import com.bravemax.animals.di.modules.PrefsModule
import com.bravemax.animals.viewmodel.ListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, PrefsModule::class, AppModule::class])
interface ViewModelComponent {
    fun inject(viewModel: ListViewModel)
}