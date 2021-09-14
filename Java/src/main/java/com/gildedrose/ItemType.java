package com.gildedrose;


public interface ItemType {

 void updateItem(Item item) ;

 //UpdateBy will be negative if quality needs to be decreased
 default void updateQuality(Item item, int updateBy) {
	    int quality = item.quality;
	    if( (updateBy<0 && quality>0) || (updateBy > 0 && quality<50) || (updateBy == -quality) )
	    	item.quality = quality + updateBy; 
	}

//decreaseBy will be negative if sellIn needs to be increased. (currently its never required to increase SellIn)
 default void updateSellIn(Item item, int decreaseBy) {
		item.sellIn = item.sellIn - decreaseBy;
	}
}
