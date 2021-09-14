package com.gildedrose;

/* Default Item Type
 * 1) SellIn decrease by 1
 * 2) Quality decrease by 1
 * 3) Quality decrease by 2 if item's selling date has passed (negative sellIn)
 */

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
