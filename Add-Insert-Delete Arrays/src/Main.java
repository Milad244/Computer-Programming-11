import java.util.Scanner;

public class Main {

    //This method loops through every string in the array to print all the values
    public static void printArray(String[] array){
        System.out.println("Your fridge:");
        for (int i = 0; i < array.length; i++){ //Loop ends when it has gone through every item (array.length)
            System.out.println(array[i]); //Prints each individual string
        }
        System.out.println("\n");
    }

    //This method adds a new string to the end of the array
    public static String[] addToArray(String[] originalArr, String newValue){
        String[] updatedArr = new String[originalArr.length + 1]; //updatedArr wil be the new array that has the new string to the end.
        //Since we are adding a new string, updatedArr must be able to contain 1 more than the original array.
        for (int i = 0; i < originalArr.length + 1; i++){ //Loop includes the 1 extra value by increasing length of original array by 1
            if (i == originalArr.length){ //If the current iteration of the loop equals the last loop, then we add the new string
                updatedArr[i] = newValue;
            }else {
                updatedArr[i] = originalArr[i]; //Otherwise we copy the original array like normal
            }
        }
        return updatedArr; //Returning the updated array
    }

    //This method removes the last item of the array
    public static String[] removeFromArray(String[] originalArr){
        String[] updatedArr = new String[originalArr.length - 1]; //Length of the new array needs to be one less because we are losing a value
        for (int i = 0; i < originalArr.length - 1; i++){ //The loop must also be 1 less because new array is 1 less
                updatedArr[i] = originalArr[i];
                //We copy like normal except that the loop will end one iteration early leaving the updated array without the last value
        }
        return updatedArr; //returning the updated array
    }

    //This method adds a string in a specific index position
    public static String[] insertToArray(String[] originalArr, String newValue, int insertPosition){
        String[] updatedArr = new String[originalArr.length + 1]; //Since we are adding a value to the array we must add one to the length
        boolean addedNewValue = false; //This boolean will track whether we have added the new string or not
        for (int i = 0; i < originalArr.length + 1; i++){ //Loop must be 1 more because new array is 1 more in length
            if (i == insertPosition){ //Checks if the iteration of the loop is equal to the index position that the new string must go
                updatedArr[i] = newValue; //If it is, then we will insert the new string into that position
                addedNewValue = true; //Must tell the program that we have now added the new value
            }else {
                if (!addedNewValue){ //When we haven't inserted the new string the array can copy like normal
                    updatedArr[i] = originalArr[i];
                } else{
    //When we have inserted the new value we must subtract 1 from the original array because the current iteration of loops is ahead by one
                    updatedArr[i] = originalArr[i - 1];
                }
            }
        }
        return updatedArr; //returning the updated array
    }

    public static void main(String[] args) {
        // Story Mode

        System.out.println("This is a short story about my fridge.\nIn the beginning I started with a simple fridge.");
        String[] fridge = {"Milk", "Eggs", "Juice", "Bread", "Butter"}; // Initiating the initial array
        printArray(fridge); // Printing all items in my array using the "printArray" function I made

        System.out.println("I then bought some ham and cheese.");
        // Adding item to the end of the array using the "addToArray" function I made. I give the array and item name as params for the function
        fridge = addToArray(fridge, "Ham");
        fridge = addToArray(fridge, "Cheese");
        printArray(fridge); // Printing all items in my array using the "printArray" function I made

        System.out.println("But I got so excited that I ate all my cheese!");
        // Removing last item of the array using the "removeFromArray" function I made. I give the array as a param for the function
        fridge = removeFromArray(fridge);
        printArray(fridge); // Printing all items in my array using the "printArray" function I made

        System.out.println("Eating all that cheese gave me the power to travel back in time and add Parmigiano-Reggiano Cheese after my past self bought eggs.");
        // Inserting an item to the array using the "insertToArray" function I made. I give the array, item name, and position as params for the function
        fridge = insertToArray(fridge, "Parmigiano-Reggiano Cheese", 2);
        printArray(fridge); // Printing all items in my array using the "printArray" function I made

        //Play Mode

        System.out.println("Now you can control the fridge!");
        System.out.println("Type 'add' to add an item to the front of your fridge.\n" +
                "Type 'remove' to remove the most upfront item in your fridge.\n" +
                "Type 'insert' to insert an item to a specified location in your fridge.\n" +
                "Type 'quit' to exit this program"); // Instructions for user input

        boolean quit = false; // Variable to keep track of whether to quit the program or not
        Scanner scan = new Scanner(System.in); // Initializing scanner
        String itemName; // Variable to store the name of the item added
        String stringItemPosition; // Variable to store user input of array position to insert new item in
        int itemPosition; // Variable to store the array position to insert new item in

        do{ //Loop start
            System.out.println("Input: ");
            String playerChoice = scan.next(); // Getting user input
            switch (playerChoice){
                case "add": // If user input is "add"
                    System.out.println("What item are you adding your fridge: "); // Getting new item value
                    itemName = scan.next();
                    fridge = addToArray(fridge, itemName); // Adding to new item to fridge
                    printArray(fridge); // Printing all items in my array using the "printArray" function I made
                    break;
                case "remove": // If user input is "remove"
                    fridge = removeFromArray(fridge); // Removing last item in fridge
                    printArray(fridge); // Printing all items in my array using the "printArray" function I made
                    break;
                case "insert": // If user input is "insert"
                    System.out.println("What item are you adding your fridge: "); // Getting new item value
                    itemName = scan.next();
                    // Getting index to insert new item value into
                    System.out.println("What fridge position do you want to insert your new item in: ");
                    stringItemPosition = scan.next();
                    itemPosition = Integer.parseInt(stringItemPosition); // Changing index value to an int from string
                    // Inserting new item value to the fridge at the index position selected by the user
                    fridge = insertToArray(fridge, itemName, itemPosition);
                    printArray(fridge); // Printing all items in my array using the "printArray" function I made
                    break;
                case "quit": // If user input is "quit"
                    quit = true; // Making quit variable true so that loop ends
                    break;
                default:
                    System.out.println("Invalid input"); // If none of the case values were typed then invalid input
            }
        }while(!quit); // Ending the loop when quit variable equals true
    }
}