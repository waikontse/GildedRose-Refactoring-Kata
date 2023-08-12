package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BackPassesItemTest : BasicItemRequirementTest("Backstage passes to a TAFKAL80ETC concert") {

    @Test
    fun `backstage passes test`() {
        // Arrange
        val item = Item(itemName, 10, 30)
        val app = GildedRose(listOf(item))
        val expectedValues: List<Pair<Int, Int>> = listOf(
            10 to 30,
            9 to 32,
            8 to 34,
            7 to 36,
            6 to 38,
            5 to 40,
            4 to 43,
            3 to 46,
            2 to 49,
            1 to 50,
            0 to 50,
            -1 to 0,
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