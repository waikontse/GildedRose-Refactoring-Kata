package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

abstract class BasicItemRequirementTest(val itemName: String) {
    @Test
    fun `ensure that item quality never drops below 0 after updating`() {
        // Arrange
        val item = Item(itemName, 1, 1)
        val app = GildedRose(listOf(item))

        // Act
        // Assert
        app.updateQuality()
        assertTrue(item.quality >= 0)
        app.updateQuality()
        assertTrue(item.quality >= 0)
    }

    @Test
    fun `ensure that item quality never not go above 50 after updating`() {
        val item = Item(itemName, 2, 50)
        val app = GildedRose(listOf(item))

        // Act
        app.updateQuality()

        // Assert
        assertTrue(item.quality <= 50)
    }

    @Test
    fun `ensure throws when updating quality with item below 0`() {
        val item = Item(itemName, 2, -1)
        val app = GildedRose(listOf(item))

        // Act
        val exception = assertThrows(IllegalArgumentException::class.java) { app.updateQuality() }

        // Assert
        assertEquals(exception.message, "Item: ${item.name} should have a non-negative quality value")
    }
}
