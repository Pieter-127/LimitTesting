package com.pieter.limittesting

import org.junit.Assert
import org.junit.Test

class MathTest {

    lateinit var systemUnderTest: Math

    @Test
    fun additionTest() {
        systemUnderTest = Math()
        val expected = 3

        val result = systemUnderTest.addition(1, 2)

        Assert.assertEquals(expected, result)
    }

    @Test
    fun businessLogicTest() {
        systemUnderTest = Math()
        val expected = 3

        val result = systemUnderTest.complexBusinessLogic(2)

        Assert.assertEquals(expected, result)
    }
}