public class Main {

    //This method loops through every string in the array to print all the values
    public static void printArray(String[] array){
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
        return updatedArr; //returning the updated array
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
        for (int i = 0; i < originalArr.length + 1; i++){ //Loop must be 1 more because new array is 1 more on length
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
        System.out.println("This is a short story about my fridge.\nIn the beginning I started with a simple fridge.");
        String[] fridge = {"Milk", "Eggs", "Juice", "Bread", "Butter"};
        printArray(fridge);
        System.out.println("I then bought some ham and cheese.");
        fridge = addToArray(fridge, "Ham");
        fridge = addToArray(fridge, "Cheese");
        printArray(fridge);
        System.out.println("But I got so excited that I ate all my cheese!");
        fridge = removeFromArray(fridge);
        printArray(fridge);
        System.out.println("Eating all that cheese gave me the power to travel back in time and add Parmigiano-Reggiano Cheese after my past self bought eggs.");
        fridge = insertToArray(fridge, "Parmigiano-Reggiano Cheese", 2);
        printArray(fridge);
    }
}