package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

abstract class BasicItemRequirementTest(val itemName: String) {
    @Test
    fun `ensure that item quality does not drop below 0`() {
        // Arrange
        val item = Item(itemName, 1, 1)
        val app = GildedRose(listOf(item))

        // Act
        app.updateQuality()
        app.updateQuality()

        // Assert
        assertTrue(item.quality >= 0)
    }

    @Test
    fun `ensure that item quality does not go above 50`() {
        val item = Item(itemName, 2, 50)
        val app = GildedRose(listOf(item))

        // Act
        app.updateQuality()

        // Assert
        assertTrue(item.quality <= 50)
    }
}