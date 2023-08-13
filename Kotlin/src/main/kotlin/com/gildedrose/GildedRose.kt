package com.gildedrose

import com.gildedrose.Constants.MAX_QUALITY

class GildedRose(private var items: List<Item>) {

    fun updateQuality() {
        items.forEach {
            checkPreConditions(it)

            val wrappedItem = ItemWrapperFactory.wrapItemWithCorrectType(it)
            wrappedItem.updateSellInAndQuality()

            checkPostConditions(wrappedItem)
        }
    }

    private fun checkPreConditions(item: Item) {
        require(item.quality >= 0) { "Item: ${item.name} should have a non-negative quality value" }
    }

    private fun checkPostConditions(item: UpdatableItem) {
        ensureQualityIsNotBelowZero(item)
        ensureQualityIsNotOverFifty(item)
    }

    private fun ensureQualityIsNotBelowZero(item: UpdatableItem) {
        with(item) {
            require(this.item.quality >= 0) { "Item ${this.item.name} quality cannot be below 0" }
        }
    }

    private fun ensureQualityIsNotOverFifty(item: UpdatableItem) {
        // Skip legendary items
        if (item !is LegendaryItem) {
            with(item) {
                require(this.item.quality <= MAX_QUALITY) {
                    "Item ${this.item.name} quality cannot be over $MAX_QUALITY"
                }
            }
        }
    }
}
