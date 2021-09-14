package com.gildedrose;

public class BackstagePassesItem implements ItemType {

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


