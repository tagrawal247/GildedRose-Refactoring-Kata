package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	/* 
	 * Test cases :
	1) Once the sell by date has passed, Quality degrades twice as fast
	2) The Quality of an item is never negative
	3) "Aged Brie" actually increases in Quality the older it gets
	4) The Quality of an item is never more than 50
	5) "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	6) "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	   a) Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	   b) Quality drops to 0 after the concert
    7) "Conjured" items degrade in Quality twice as fast as normal items
	
	 */
	
	
    @Test
    void dateHasPassedQualityShouldDecreaseByTwoTest() {
        Item[] items = new Item[] { new Item("foo", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
    
    @Test
    void qualityCantBeNegativeTest() {
        Item[] items = new Item[] { new Item("foo", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void agedBrieQualityShouldIncreaseTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }
    
    @Test
    void qualityCantBeMoreThanFiftyTest() {
    	 Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
         GildedRose app = new GildedRose(items);
         app.updateQuality();
         assertEquals("Aged Brie", app.items[0].name);
         assertEquals(4, app.items[0].sellIn);
         assertEquals(50, app.items[0].quality);
     }
    
    @Test
    void agedBrieSellInLessThanTenTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void agedBrieSellInLessThanFiveTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void agedBrieSellInIsZeroTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void agedBrieSellInLessThanZeroTest() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void legendaryItemDoesNotChangeSellInOrQualityTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void backstageQualityShouldIncreaseTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }
    
    @Test
    void backstageSellInLessThanTenTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void backstageSellInLessThanFiveTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    void backstageSellInIsZeroTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void backstageSellInLessThanZeroTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void conjuredDecreasesQualityTwiceTest() {
        Item[] items = new Item[] { new Item("conjured", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void conjuredDecreasesQualityTwiceAfterExpireTest() {
        Item[] items = new Item[] { new Item("conjured", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

}
