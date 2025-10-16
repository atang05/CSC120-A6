import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ShopTest {

    // computer tests

    /*
     * This method tests whether the computer constructor passes all the values of the variables.
     */
    @Test
    public void test_computer_constructor(){
        Computer myComputer = new Computer(
            "2019 MacBook Pro", 
            "Intel", 
            256, 
            20, 
            "High Sierra", 
            2019, 
            1000);
        assertEquals("2019 MacBook Pro", myComputer.description); // checks whether the constructor processes the information correctly
        assertEquals("Intel", myComputer.processorType);
        assertEquals(256, myComputer.hardDriveCapacity);
        assertEquals(20, myComputer.memory);
        assertEquals("High Sierra", myComputer.operatingSystem);
        assertEquals(2019, myComputer.yearMade);
        assertEquals(1000, myComputer.price);
    }

    /*
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


    /*
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

    /*
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
    /*
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

    /*
     * This method tests whether the resales shop constructor initialize the item in the store properly
     */
    @Test
    public void test_ResalesShop_constructor(){
        ResaleShop myShop = new ResaleShop(); 
        assertEquals(1, myShop.inventory.size()); // checks if the size is correct
        Computer computer = myShop.inventory.get(0);
        assertEquals("2019 MacBook Pro", computer.description); // checks if the computer in the inventory is the one we set
    }


    /*
     * This method tests whether the store can store the information of a new computer properly.
     */
    @Test
    public void test_buy() throws Exception{
        ResaleShop myShop = new ResaleShop(); 

        Computer newComp = new Computer("2020 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        myShop.buy(newComp); // adds a new computer

        assertEquals(2, myShop.inventory.size()); // checks if the number of computers in the inventory is correct after buying.
        
        boolean found = false;
        for (Computer comp : myShop.inventory) {
            if (comp.description.equals("2020 MacBook Pro")) { // checks if the new computer is in the inventory
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test(expected = Exception.class)
    public void test_buy_same()throws Exception{
        ResaleShop shop=new ResaleShop();
        Computer computer = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(computer);
    }

    /*
     * This method tests if the store can remove the sold computers from the inventory properly.
     */
    @Test
    public void test_sell() throws Exception{
        ResaleShop myShop = new ResaleShop(); 
        Computer computer = myShop.inventory.get(0);
        myShop.sell(computer);
        assertEquals(0, myShop.inventory.size()); // checks if the size of the inventory is 0 after removing the only computer in the inventory.
    }

    @Test
    public void test_sell_OutOfInventory() throws Exception{
        ResaleShop myShop = new ResaleShop(); 
        Computer computer = new Computer("PC", "Intel", 128, 6, "Windows", 2012, 200);
        myShop.sell(computer);
        assertEquals(0, myShop.inventory.size()); // checks if the size of the inventory is 0 after removing the only computer in the inventory.
    }

    @Test(expected = Exception.class)
    public void test_sell_out()throws Exception{
        ResaleShop shop=new ResaleShop();
        Computer computer = new Computer("PC", "Intel", 128, 6, "Windows", 2012, 200);
        shop.sell(computer);
    }

    /*
     * This method tests if the inventory can be printed out appropriately with all items or print correct message if the inventory is empty. 
     */
    @Test
    public void test_printInventory(){
        ResaleShop myShop = new ResaleShop(); 
        Computer comp1 = new Computer("2020 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        myShop.inventory.add(comp1); // adds a new computer to the inventory to check if the method works for multiple computers

        ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // because the return is void for the method, we need this to capture the printed output
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        myShop.printInventory(); // uses the method

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("2020 MacBook Pro")); // checks if the output contains correct description for the computers
        assertTrue(outContent.toString().contains("2019 MacBook Pro"));
    }

    /*
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

        assertTrue(outContent.toString().contains("Inventory is empty")); 
    }


    /*
     * This method tests if the refurbish method throws appropriate exception when the called computer is not in the store.
     */
    @Test(expected = Exception.class) // tests for exception
    public void test_NA_refurbish() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer notInShop = new Computer("PC", "Intel", 128, 6, "Windows", 2012, 200);

        myShop.refurbish(notInShop, "Windows 11"); 
    }

    @Test
    public void test_refurbish_2000() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer("PC", "Intel", 128, 6, "Windows", 1999, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        assertEquals(0, newComp.price);
    }


    @Test
    public void test_refurbish_2012() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer("PC", "Intel", 128, 6, "Windows", 2011, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        assertEquals(250, newComp.price);
    }

    @Test
    public void test_refurbish_2018() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer("PC", "Intel", 128, 6, "Windows", 2017, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        assertEquals(550, newComp.price);
    }

    @Test
    public void test_refurbish_2019() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer("PC", "Intel", 128, 6, "Windows", 2020, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        assertEquals(1000, newComp.price);
    }

    @Test
    public void test_refurbish_update_OS_none() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer("PC", "Intel", 128, 6, "Windows", 2020, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "None");
        assertEquals("Windows", newComp.operatingSystem); // lacks exception if the input is none
    }

    @Test
    public void test_refurbish_update_OS_new() throws Exception {
        ResaleShop myShop = new ResaleShop();
        Computer newComp = new Computer("PC", "Intel", 128, 6, "Windows", 2020, 200);
        myShop.inventory.add(newComp);
        myShop.refurbish(newComp, "New OS");
        assertEquals("None", newComp.operatingSystem); // recognizes correctly
    }



}
