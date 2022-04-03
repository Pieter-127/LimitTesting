package com.pieter.limittesting

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class ViewModelWithDependencyTest {

    private lateinit var systemUnderTest: ViewModelWithDependency

    @Mock
    lateinit var dependency: Dependency

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        systemUnderTest = ViewModelWithDependency(dependency)
        whenever(dependency.getDataFromApi()).thenReturn("foo")
        whenever(dependency.getCachedData()).thenReturn("bar")
    }

    @Test
    fun testFromCache() {
        val expected = "bar"

        val result = systemUnderTest.retrieveCachedDataFromDependency()
        assertEquals(expected, result)
        verify(dependency).getCachedData()
    }

    @Test
    fun testFromApi() {
        val expected = "foo"

        val result = systemUnderTest.retrieveApiDataFromDependency()
        assertEquals(expected, result)
        verify(dependency).getDataFromApi()
    }
}