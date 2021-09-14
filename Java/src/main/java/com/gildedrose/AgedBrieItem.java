package com.gildedrose;

public class AgedBrieItem implements ItemType {

	@Override
	public void updateItem(Item item) {
		updateSellIn(item,1);
		if(item.sellIn<0)
			updateQuality(item,2);
		else
			updateQuality(item,1);
	}
	
	


}
