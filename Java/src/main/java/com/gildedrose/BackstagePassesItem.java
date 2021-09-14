package com.gildedrose;

public class BackstagePassesItem implements ItemType {

	/* Backstage Passes Item Type
	 * 1) SellIn decrease by 1
	 * 2) Quality increases by 1
	 * 3) Quality increases by 2 if item's selling date is Less than 10
	 * 4) Quality increases by 3 if item's selling date is Less than 5
	 * 5) Quality is zero if concert date has passed (negative sellIn)
	 */
	@Override
	public void updateItem(Item item) {
		updateSellIn(item,1);
		int sellInDays = item.sellIn;
		if(sellInDays<0)
			updateQuality(item,-item.quality);		
		else if(sellInDays<5) 
			updateQuality(item, 3);
		else if(sellInDays<10) 
			updateQuality(item, 2);
		else
			updateQuality(item,1);
	}

}


