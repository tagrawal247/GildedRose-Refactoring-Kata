  
======================================
Refactoring Approach For GildedRose
======================================

Requirement for refactoring can be found at below link:
https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt


Important Behaviours:

1) Once the sell by date has passed, Quality degrades twice as fast
2) The Quality of an item is never negative
3) "Aged Brie" actually increases in Quality the older it gets
4) The Quality of an item is never more than 50
5) "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
6) "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	 a) Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	 b) Quality drops to 0 after the concert
7) "Conjured" items degrade in Quality twice as fast as normal items


Key Take-Aways :

1) We have different kinds of items.
2) Each Item has sellIn and quality/
3) SellIn is the number of days, the item needs to be sold in.
4) Quality of the item can either increase or decrease depending on conditions.
5) Quality Conditions are based on :
    a)Item Type
    b)value of SellIn
6) New items can be added with different behaviour.
7) Item type is one of the decision maker but it has not be defined explicitly. Updating code to add new item and its behaviours or updating existing behaviour is very difficult.
8) There are no proper test cases to check all the conditions.

My Approach:

1) Add all the test cases for different behaviour. 
2) Test existing code against it to make sure our understanding and code behaviour matches.
3) So, to me it seems like best approach would be to create different classes for each Item Type and then define their individual behaviour.
4) To do this, I have created an ItemType interface, which can be used to create current and future ItemTypes.
5) In this interface I have kept default implementation of following updateSellIn and updateQuality. Both of them just add or subtract values for sellIn and quality attributes of Item depending on the argument passed.
6) Another method updateItem will be implemented by different ItemType classes to implement Item specific behaviour.
7) In updateQuality itself we are checking for min and max values of quality before updating it.
8) ItemTypeFactory is created to find out itemType depending on name. In future if we want to have same itemstypes with different item names then that can also be achieved through this.
9) Actual updateQuality method inside GildedRose class will have only for loop which will find out itemType and call respective ItemType implementation to update quality and sellIn attributes.
10)I have changed the for loop to make it little better from readability perspective.

Further improvements which I avoided:
1) I did not created global variables of max quality, min quality or for different updateBy values for each ItemType.
   This could have helped in changing these fields easily later. But as we have segregated items already into different types their individual behaviours are not complex, this seems like an overkill.
2) There is no check on sellIn, quality values while creating items. As according to problem statement we should not touch item class I have not added any restrictions. 
   I believe we could have created an ItemBuilder where we can perform all the checks and use that to build items.
3) May be we need to have some restriction on SellIn attribute as well. 
