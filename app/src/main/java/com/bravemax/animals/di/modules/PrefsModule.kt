package com.bravemax.animals.di.modules

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.bravemax.animals.util.SharedPreferencesHelper
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

open class PrefsModule {

    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_APP)
    open fun provideSharedPreferencesHelper(app: Application): SharedPreferencesHelper {
        return SharedPreferencesHelper(app)
    }

    @Provides
    @Singleton
    @TypeOfContext(CONTEXT_ACTIVITY)
    fun provideActivitySharedPreferenceHelper(activity: AppCompatActivity): SharedPreferencesHelper {
        return SharedPreferencesHelper(activity)
    }
}

const val CONTEXT_APP = "Application Context"
const val CONTEXT_ACTIVITY = "Activity Context"

@Qualifier
annotation class TypeOfContext(val type: String)