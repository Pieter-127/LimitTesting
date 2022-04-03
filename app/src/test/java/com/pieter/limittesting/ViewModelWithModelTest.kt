package com.pieter.limittesting

import org.junit.Assert.assertEquals
import org.junit.Test

class ViewModelWithModelTest {

    lateinit var systemUnderTest: ViewModelWithModel

    @Test
    fun additionTest() {
        val expected = "foobar"

        val model = Something("foo", "bar")
        systemUnderTest = ViewModelWithModel(model)

        val result = systemUnderTest.complicatedBusinessLogic()
        assertEquals(expected, result)
    }
}