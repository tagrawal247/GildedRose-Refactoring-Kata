package com.gildedrose;


public interface ItemType {

 void updateItem(Item item) ;

 //Update by will be negative if quality needs to be decreased
 default void updateQuality(Item item, int updateBy) {
	    int quality = item.quality;
	    if( (updateBy<0 && quality>0) || (updateBy > 0 && quality<50) || (updateBy == -quality) )
	    	item.quality = quality + updateBy; 
	}

 default void updateSellIn(Item item, int decreaseBy) {
		item.sellIn = item.sellIn - decreaseBy;
	}
}
