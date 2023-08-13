package com.gildedrose

import com.gildedrose.Constants.MAX_QUALITY
import com.gildedrose.Constants.MIN_QUALITY
import kotlin.math.max
import kotlin.math.min

sealed class UpdatableItem(val item: Item) {
    init {
        require(item.quality >= 0) { "Item: ${item.name} quality should be non-negative." }
    }

    fun updateSellInAndQuality() {
        decreaseSellInValue()
        updateQuality()
    }

    protected open fun decreaseSellInValue() {
        item.decreaseSellInValue()
    }

    protected abstract fun updateQuality()
}

class NormalItem(item: Item) : UpdatableItem(item) {
    override fun updateQuality() {
        when {
            item.sellIn.isPositive() -> item.decreaseQualityBy(1)
            else -> item.decreaseQualityBy(2)
        }
    }
}

class LegendaryItem(item: Item) : UpdatableItem(item) {
    override fun updateQuality() {
        // Ignore legendary items
    }

    override fun decreaseSellInValue() {
        // Legendary items do not need to update sellIn values
    }
}

class AgingItem(item: Item) : UpdatableItem(item) {
    override fun updateQuality() {
        when {
            item.sellIn.isPositive() -> item.increaseQualityBy(1)
            else -> item.increaseQualityBy(2)
        }
    }
}

class BackstagePassesItem(item: Item) : UpdatableItem(item) {
    override fun updateQuality() {
        when {
            item.sellIn < 0 -> item.decreaseQualityBy(Int.MAX_VALUE)
            item.sellIn < 5 -> item.increaseQualityBy(3)
            item.sellIn < 10 -> item.increaseQualityBy(2)
            else -> item.increaseQualityBy(1)
        }
    }
}

class ConjuredItem(item: Item) : UpdatableItem(item) {
    override fun updateQuality() {
        when {
            item.sellIn.isPositive() -> item.decreaseQualityBy(2)
            else -> item.decreaseQualityBy(4)
        }
    }
}

object Constants {
    const val MIN_QUALITY: Int = 0
    const val MAX_QUALITY: Int = 50
}

private fun Int.isPositive() = this >= 0

private fun Item.increaseQualityBy(quantity: Int) {
    require(quantity.isPositive())

    this.quality = min(this.quality.plus(quantity), MAX_QUALITY)
}

private fun Item.decreaseQualityBy(quantity: Int) {
    require(quantity.isPositive())

    this.quality = max(this.quality.minus(quantity), MIN_QUALITY)
}

private fun Item.decreaseSellInValue() {
    this.sellIn = this.sellIn.dec()
}
