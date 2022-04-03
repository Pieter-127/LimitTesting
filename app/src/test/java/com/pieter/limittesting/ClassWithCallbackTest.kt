package com.pieter.limittesting

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.verify

class ClassWithCallbackTest {

    private lateinit var systemUnderTest: ClassWithCallback

    @Mock
    private lateinit var mockedCallback: ClassWithCallback.ApiResult

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun synchronousCallbackTest() {
        systemUnderTest = ClassWithCallback()
        val expected = "foobar"

        var result = ""
        var hasBeenCalled = false

        systemUnderTest.invokeApiCall {
            result = it
            hasBeenCalled = true
        }
        assertEquals(expected, result)
        assertEquals(true, hasBeenCalled)
    }

    @Test
    fun callbackCaptorTest() {
        systemUnderTest = ClassWithCallback()

        assertEquals(systemUnderTest.successValue, "foo")
        assertEquals(systemUnderTest.errorValue, "bar")

        val successModel = ClassWithCallback.CallbackClassModel(true)
        systemUnderTest.invokeApiCall(successModel, mockedCallback)

        argumentCaptor<String>().apply {
            verify(mockedCallback).onSuccess(capture())
            assertEquals(firstValue, "foo")
        }

        val failureModel = ClassWithCallback.CallbackClassModel(false)
        systemUnderTest.invokeApiCall(failureModel, mockedCallback)

        argumentCaptor<String>().apply {
            verify(mockedCallback).onError(capture())
            assertEquals(firstValue, "bar")
        }
    }
}