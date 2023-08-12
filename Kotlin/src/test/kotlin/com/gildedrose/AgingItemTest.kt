package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AgingItemTest : BasicItemRequirementTest("Aged Brie") {
    @Test
    fun `aging item test`() {
        // Arrange
        val item = Item(itemName, 10, 20)
        val app = GildedRose(listOf(item))
        val expectedValues: List<Pair<Int, Int>> = listOf(
            10 to 20,
            9 to 21,
            8 to 22,
            7 to 23,
            6 to 24,
            5 to 25,
            4 to 26,
            3 to 27,
            2 to 28,
            1 to 29,
            0 to 30,
            -1 to 32,
            -2 to 34,
            -3 to 36,
            -4 to 38,
            -5 to 40,
            -6 to 42,
            -7 to 44,
            -8 to 46,
            -9 to 48,
            -10 to 50,
        )

        // Act
        // Assert
        expectedValues.forEach {
            assertEquals(item.sellIn, it.first)
            assertEquals(item.quality, it.second)

            app.updateQuality()
        }
    }
}