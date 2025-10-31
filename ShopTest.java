import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShopTest {

    // computer tests

    /**
     * This method tests whether the computer constructor passes the description of computer correctly.
     */
    @Test
    public void test_computer_constructor_description(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks whether the input description is stored correctly to the myComputer object
        assertEquals("2019 MacBook Pro", myComputer.description); // returns true if the description matches the expected output
    }

    /**
     * This method tests whether the computer constructor passes the processor type of computer correctly.
     */
    @Test
    public void test_computer_constructor_processorType(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the processor type stored with object myComputer is the same as input value.
        assertEquals("Intel", myComputer.processorType);
    }

    /**
     * This method tests whether the computer constructor passes the hard drive capacity of computer correctly.
     */
    @Test
    public void test_computer_constructor_hardDriveCapacity(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks the hard drive capacity
        assertEquals(256, myComputer.hardDriveCapacity);
    }

    /**
     * This method tests whether the computer constructor passes the memory of computer correctly.
     */
    @Test
    public void test_computer_constructor_memory(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the stored memory is same as input value
        assertEquals(20, myComputer.memory);
    }

    /**
     * This method tests whether the computer constructor passes the operating system of computer correctly.
     */
    @Test
    public void test_computer_constructor_operatingSystem(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the stored operating system is same as the input one
        assertEquals("High Sierra", myComputer.operatingSystem);
    }

    /**
     * This method tests whether the computer constructor passes the year computer was made correctly.
     */
    @Test
    public void test_computer_constructor_yearMade(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the stored yearMade is same as input value
        assertEquals(2019, myComputer.yearMade);
    }

    /**
     * This method tests if the method throws appropriate exception when the year made is extremely small or large
     */
    @Test(expected = IllegalArgumentException.class) 
    // checks whether the method throws exception when the value for year that's logically invalid.
    public void test_constructor_getYear_exception() {
        new Computer(
        "2019 MacBook Pro", 
        "Intel", 
        256, 
        20, 
        "High Sierra", 
        100, 
        1000);
    }

    /**
     * This method tests whether the computer constructor passes the price of computer correctly.
     */
    @Test
    public void test_computer_constructor_price(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the price of computer is stored as inputted.
        assertEquals(1000, myComputer.price);
    }

    /**
     * This test methods tests if the setPrice method change the price properly for a computer.
     */
    @Test 
    public void test_set_price(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        myComputer.setPrice(1500);
        assertEquals(1500, myComputer.price); // checks whether the method updates the price of computer to 1500
    }

    /**
     * This method checks if the setprice method can throw appropriate exception when the user inputs invalid prices.
     */
    @Test(expected=Exception.class)
    public void test_setPrice_exception() {
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        // checks if the setPrice method throws appropriate exception when the value of price is unusual.
        myComputer.setPrice(-1000);
    }

    /**
     * This method tests if the setOS method can successfully update the operating system of a computer.
     */
    @Test 
    public void test_set_OS(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        myComputer.setOS("Monterey");
        assertEquals("Monterey", myComputer.operatingSystem); //checks whether the method updates operating system properly
    }

    /**
     * This method tests whether the getYear method returns the year computer was made correctly.
     */
    @Test
    public void test_getYear(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        assertEquals(2019, myComputer.yearMade); // checks whether the year computer was made matches the return
    }

    @Test
    /**
     * This method tests whether the toString method returns the expected output.
     */
    public void test_toString(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        String s = myComputer.toString();
        assertTrue(s.contains("2019 MacBook Pro")); // checks whether all the important information is included in the string
        assertTrue(s.contains("Intel"));
        assertTrue(s.contains("High Sierra"));
        assertTrue(s.contains("256"));
        assertTrue(s.contains("16"));
        assertTrue(s.contains("2019"));
        assertTrue(s.contains("0")); // because we're testing whether toString converts the information to an appropriate string, we will test for 0 since it's the price info stored.
    }



    // resaleshop tests

    /**
     * This method tests whether the resales shop constructor initialize the item in the store properly
     */
    @Test
    public void test_ResalesShop_constructor(){
        ResaleShop myShop = new ResaleShop(); 
        assertEquals(1, myShop.inventory.size()); // checks if the size is correct
        Computer computer = myShop.inventory.get(0);
        assertEquals("2019 MacBook Pro", computer.description); // checks if the computer in the inventory is the one we set
    }


    /**
     * This method tests whether the store can store the information of a new computer properly.
     */
    @Test
    public void test_buy() throws Exception{
        ResaleShop myShop = new ResaleShop(); 

        Computer newComp = new Computer(
            "2020 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        myShop.buy(newComp); // adds a new computer

        // checks if the number of computers in the inventory is correct after buying.
        assertEquals(2, myShop.inventory.size()); 
        
        // checks if the new computer is in the inventory
        boolean found = false;
        for (Computer comp : myShop.inventory) {
            if (comp.description.equals("2020 MacBook Pro")) { 
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    /**
     * This method tests if the buy method will throw appropriate exception if the user attempts to add the computer that is already in the inventory.
     */
    @Test(expected = Exception.class)
    public void test_buy_same()throws Exception{
        ResaleShop shop=new ResaleShop();
        Computer computer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        shop.buy(computer); // buys a computer that is exactly same as the one already stored
    }

    /**
     * This method tests if the store can remove the sold computers from the inventory properly.
     */
    @Test
    public void test_sell() throws Exception{
        ResaleShop myShop = new ResaleShop(); 
        Computer computer = myShop.inventory.get(0);
        myShop.sell(computer);
        assertEquals(0, myShop.inventory.size()); // checks if the size of the inventory is 0 after removing the only computer in the inventory.
    }

    /**
     * This method tests if the sell method throws appropriate exception when the user tries to remove a computer that is not in the inventory. 
     */
    @Test(expected = Exception.class)
    public void test_sell_out()throws Exception{
        ResaleShop shop=new ResaleShop();
        Computer computer = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            2012, 
            200);
        // sells a computer that is not stored in the inventory.
        shop.sell(computer);
    }

    /**
     * This method tests if the inventory can be printed out appropriately with all items or print correct message if the inventory is empty. 
     */
    @Test
    public void test_printInventory(){
        ResaleShop myShop = new ResaleShop(); 
        Computer comp1 = new Computer(
            "2020 MacBook Pro", 
            "Intel", 
            256, 
            16, 
            "High Sierra", 
            2019, 
            1000);
        myShop.inventory.add(comp1); // adds a new computer to the inventory to check if the method works for multiple computers

        ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // because the return is void for the method, we need this to capture the printed output
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        myShop.printInventory(); // uses the method

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("2020 MacBook Pro")); // checks if the output contains correct description for the computers
        assertTrue(outContent.toString().contains("2019 MacBook Pro"));
    }

    /**
     * This method tests if a correct message is printed when the inventory is empty.
     */
    @Test
    public void test_empty_printInventory(){
        ResaleShop myShop = new ResaleShop(); 
        myShop.inventory.clear();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // because the return is void for the method, we need this to capture the printed output
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        myShop.printInventory(); // uses the method

        System.setOut(originalOut);

        // checks if the printed message is correct
        assertTrue(outContent.toString().contains("Inventory is empty")); 
    }


    /**
     * This method tests if the refurbish method throws appropriate exception when the called computer is not in the store.
     */
    @Test(expected = Exception.class) // tests for exception
    public void test_NA_refurbish() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer notInShop = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            2012, 
            200);
        // checks if the appropriate exception was throwed if trying to refurbish a computer that is not in the inventory.
        myShop.refurbish(notInShop, "Windows 11"); 
    }

    /**
     * This method tests if the price of a computer made earlier than 2000 is refurbished to a correct price. 
     */
    @Test
    public void test_refurbish_2000() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            1999, 
            200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        // checks if the updated price of a old computer made before 2000 is 0
        assertEquals(0, newComp.price);
    }


    /**
     * This method tests if the price of a computer made earlier than 2012 and later than 2000 is refurbished to a correct price. 
     */
    @Test
    public void test_refurbish_2012() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            2011, 
            200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        // checks if the updated price of a old computer made before 2012, after or at 2000 is 250
        assertEquals(250, newComp.price);
    }

    /**
     * This method tests if the price of a computer made earlier than 2018 and later than 2012 is refurbished to a correct price. 
     */
    @Test
    public void test_refurbish_2018() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            2017, 
            200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        // checks if the updated price of a computer made at or after 2012 and before 2018 is 550.
        assertEquals(550, newComp.price);
    }

    /**
     * This method tests if the price of a computer made later than 2018 is refurbished to a correct price. 
     */
    @Test
    public void test_refurbish_2019() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 2020, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        // checks if the updated price of a computer made at or after 2018 is 1000.
        assertEquals(1000, newComp.price);
    }

    /**
     * This method tests if the operating system is not updated after refurbishing if the newOS is none. 
     */
    @Test
    public void test_refurbish_update_OS_none() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            2020, 
            200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "None");
        // checks if the updated operating system is not updated when the newOS is none.
        assertEquals("Windows", newComp.operatingSystem); 
    }

    /**
     * This method tests if the operating system is updated appropriately after refurbishing if the newOS is none. 
     */
    @Test
    public void test_refurbish_update_OS_new() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer(
            "PC", 
            "Intel", 
            128, 
            6, 
            "Windows", 
            2020, 
            200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        // checks if the operating system is updated through setOS if the newOS is not none.
        assertEquals("None", newComp.operatingSystem);
    }

}
