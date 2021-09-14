package com.gildedrose;

public class NormalItem implements ItemType {

	@Override
	public void updateItem(Item item) {
		updateSellIn(item,1);
		int sellIn = item.sellIn;
		if(sellIn<0)
			updateQuality(item,-2);
		
		else 
			updateQuality(item, -1);
	}

}
