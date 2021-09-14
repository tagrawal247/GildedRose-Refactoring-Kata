package com.gildedrose;

public class ItemTypeFactory {
    
	private static final String AGED_BRIE = "Aged Brie";
	private static final String LEGENDARY_SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String CONJURED = "Conjured";
	
	public ItemType getItemType(String name) {
		if(name.toLowerCase().contains(AGED_BRIE.toLowerCase()))
			return new AgedBrieItem();
		if(name.toLowerCase().contains(LEGENDARY_SULFURAS.toLowerCase()))
			return new LegendaryItem();
		if(name.toLowerCase().contains(BACKSTAGE_PASSES.toLowerCase()))
			return new BackstagePassesItem();
		if(name.toLowerCase().contains(CONJURED.toLowerCase()))
			return new ConjuredItem();
		return new NormalItem();
	}

}
