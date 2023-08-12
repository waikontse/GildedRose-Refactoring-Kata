package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NormalItemTest: BasicItemRequirementTest("normal") {

    @Test
    fun `normal items test`() {
        // Arrange
        val sellInDay = 10
        val quality = 20
        val item = Item(itemName, sellInDay, quality)
        val normalItem = listOf(item)
        val app = GildedRose(normalItem)

        val expectedValues: List<Pair<Int, Int>> = listOf(
            10 to 20,
            9 to 19,
            8 to 18,
            7 to 17,
            6 to 16,
            5 to 15,
            4 to 14,
            3 to 13,
            2 to 12,
            1 to 11,
            0 to 10,
            -1 to 8,
            -2 to 6,
            -3 to 4,
            -4 to 2,
            -5 to 0
        )

        // Act
        expectedValues.forEach {
            assertEquals(item.sellIn, it.first)
            assertEquals(item.quality, it.second)

            app.updateQuality()
        }

        // Assert
    }

}