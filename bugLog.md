## Bug 1
Brief description: The Computer constructor ignores memory parameter and always sets memory to 16.
Failed unit test: test_computer_constructor()

## Bug 2
Brief description: The Computer constructor ignores price parameter and always sets price to 0.
Failed unit test: test_computer_constructor()

## Bug 3
Brief description: The setOS method always sets the operating system to none. Thus, the user cannot setOS freely as they wish. 
Failed unit test: test_set_OS()

## Bug 4
Brief description: The buy method in the resalsshop did not take user input and store it. Rather, it creates a new computer and always stores that computer.
Failed unit test: test_buy()

## Bug 5
Brief description: the buy method did not throw appropriate exception when the computer is already in the inventory.
Failed unit test: test_buy_same()

## Bug 6
Brief description: The sell method failed to remove a computer that is not inventory. 
Failed unit test: test_sell_OutOfInventory()

## Bug 7
Brief description: The sell method fails to throw appropriate exception when the computer that user wants to remove is not in the inventory.
Failed unit test: test_sell_out()

## Bug 8
Brief description: The for loop in printInventory method uses <= instead of <, causing the IndexOutOfBoundsException, which means the for loop runs more time than the numbers of computers that exists in the inventory. There are not as many computers to be printed.
Failed unit test: test_printInventory()

## Bug 9
Brief description: The correct price for a computer of yearMade between 2000 and 2012 is 250 instead of 2500. The typo in the code leads to the wrong price.
Failed unit test: test_refurbish_2012

## Bug 10
Brief description: sell did not throw an exception when the computer wasn't in inventory (duplicate of Bug 5 but logged separately as it caused two failing tests depending on test style).
Failed unit test: test_sell_OutOfInventory()