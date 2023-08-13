package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConjuredItemTest : BasicItemRequirementTest("Conjured Gryffindor socks") {

    @Test
    fun `conjured items test`() {
        // Arrange
        val sellInDay = 10
        val quality = 30
        val item = Item(itemName, sellInDay, quality)
        val normalItem = listOf(item)
        val app = GildedRose(normalItem)

        val expectedValues: List<Pair<Int, Int>> = listOf(
            10 to 30,
            9 to 28,
            8 to 26,
            7 to 24,
            6 to 22,
            5 to 20,
            4 to 18,
            3 to 16,
            2 to 14,
            1 to 12,
            0 to 10,
            -1 to 6,
            -2 to 2,
            -3 to 0,
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
