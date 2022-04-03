package com.pieter.limittesting

import androidx.lifecycle.ViewModel

class ViewModelWithDependency(private val dependency: Dependency) : ViewModel() {

    fun retrieveApiDataFromDependency(): String {
        return dependency.getDataFromApi()
    }

    fun retrieveCachedDataFromDependency(): String {
        return dependency.getCachedData()
    }
}

class Dependency {

    fun getCachedData(): String {
        return "Local cache"
    }

    fun getDataFromApi(): String {
        return "Json data from api"
    }
}
