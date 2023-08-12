package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class LegendaryItemTest {
    @Test
    fun `legendary item quality never changes`() {
        // Arrange
        val sellIn = 2
        val quality = 80
        val name = "Sulfuras, Hand of Ragnaros"
        val item = Item(name, sellIn, quality)
        val app = GildedRose(listOf(item))

        // Act
        app.updateQuality()

        // Assert
        assertEquals(80, item.quality)
        app.updateQuality()
        assertEquals(80, item.quality)
        app.updateQuality()
        assertEquals(80, item.quality)
    }

    @Test
    fun `legendary items sellIn value never changes`() {
        // Arrange
        val sellIn = 2
        val quality = 80
        val name = "Sulfuras, Hand of Ragnaros"
        val item = Item(name, sellIn, quality)
        val app = GildedRose(listOf(item))

        // Act
        app.updateQuality()

        // Assert
        assertEquals(2, item.sellIn)
        app.updateQuality()
        assertEquals(2, item.sellIn)
    }
}