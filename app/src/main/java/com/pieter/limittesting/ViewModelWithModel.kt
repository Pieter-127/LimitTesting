package com.pieter.limittesting

import androidx.lifecycle.ViewModel

class ViewModelWithModel(private val something: Something) : ViewModel() {

    fun complicatedBusinessLogic() = "${something.foo}${something.bar}"
}

data class Something(val foo: String, val bar: String)