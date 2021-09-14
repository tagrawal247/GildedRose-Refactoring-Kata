package com.gildedrose;

public class AgedBrieItem implements ItemType {

	/* Aged Brie Item Type
	 * 1) SellIn decrease by 1
	 * 2) Quality increases by 1
	 * 3) Quality increases by 2 if item's selling date has passed (negative sellIn)
	 */
	@Override
	public void updateItem(Item item) {
		updateSellIn(item,1);
		if(item.sellIn<0)
			updateQuality(item,2);
		else
			updateQuality(item,1);
	}
	
	


}
