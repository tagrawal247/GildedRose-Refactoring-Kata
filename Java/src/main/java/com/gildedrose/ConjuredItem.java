package com.gildedrose;

public class ConjuredItem implements ItemType {

	@Override
	public void updateItem(Item item) {
		updateSellIn(item,1);
		int sellIn = item.sellIn;
		if(sellIn<0)
			updateQuality(item,-4);
		
		else 
			updateQuality(item, -2);
	}

}
