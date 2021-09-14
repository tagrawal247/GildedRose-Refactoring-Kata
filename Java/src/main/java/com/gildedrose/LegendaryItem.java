package com.gildedrose;


/* Legendary Item Type (eg: Sulfuras)
 * Quality never decreases (quality never changes)
 * Never needs to be sold (SellIn will not changes)
 */
public class LegendaryItem implements ItemType {

	@Override
	public void updateItem(Item item) {
		// do nothing
	}

}
