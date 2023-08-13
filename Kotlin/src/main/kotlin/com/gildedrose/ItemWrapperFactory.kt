package com.gildedrose

object ItemWrapperFactory {
    fun wrapItemWithCorrectType(item: Item): UpdatableItem =
        when {
            item.name.contains("Aged") -> AgingItem(item)
            item.name.contains("Backstage passes") -> BackstagePassesItem(item)
            item.name.contains("Sulfuras") -> LegendaryItem(item)
            item.name.contains("Conjured") -> ConjuredItem(item)
            else -> NormalItem(item)
        }
}
