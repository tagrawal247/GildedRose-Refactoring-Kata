package com.gildedrose;


/* Newly added Item Type
 * 1) SellIn decrease by 1
 * 2) Quality decrease by 2 (twice as normal)
 * 3) Quality decrease by 4 if item's selling date has passed (negative sellIn)
 */

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
