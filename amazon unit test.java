
    Define the expected and desired output for a normal case, with correct input.

    Now, implement the test by declaring a class, name it anything (Usually something like TestAddingModule), and add the testAdd method to it (i.e. like the one below) :
        Write a method, and above it add the @Test annotation.
        In the method, run your binary sum and assertEquals(expectedVal,calculatedVal).

        Test your method by running it (in Eclipse, right click, select Run as → JUnit test).

        //for normal addition 
        @Test
        public void testAdd1Plus1() 
        {
            int x  = 1 ; int y = 1;
            assertEquals(2, myClass.add(x,y));
        }

    Add other cases as desired.
        Test that your binary sum does not throw a unexpected exception if there is an integer overflow.

        Test that your method handles Null inputs gracefully (example below).

        //if you are using 0 as default for null, make sure your class works in that case.
        @Test
        public void testAdd1Plus1() 
        {
            int y = 1;
            assertEquals(0, myClass.add(null,y));
        }

