import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> text = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            text.add(line);
        }
        br.close();

        boolean quit = false;

        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("To exit the program type 'q' or 'e'. To search for a word, enter the word you wish to search for: ");
            String userInput = scan.next();
            if (userInput.equals("q") || userInput.equals("e")){
                quit = true;
            } else{
                ArrayList<Integer> wordFoundIndexPositions = searchWord(text, userInput);
            }
        } while(!quit);

    }

    // Requires: text as an arraylist of strings (lines). Also, requires the word that will be searched as a string
    // Modifies: nothing
    // Effects: goes through each string (line) of the given text and returns every index the word was found as an arraylist of integers
    public static ArrayList<Integer> searchWord(ArrayList<String> text, String word){
        int currentIndex = 0;
        int wordFoundCount = 0;
        int wordLength = word.length();
        ArrayList<Integer> foundIndexPositions = new ArrayList<>();

        for (String line : text){
            for (int i = 0; i < line.length(); i++){
                if (i <= line.length() - wordLength && (line.substring(i, i+wordLength).equals(word))){
                    wordFoundCount ++;
                    foundIndexPositions.add(currentIndex);
                    System.out.println(wordFoundCount + ". Found '" + word + "' at line " + currentIndex);
                }
            }
            currentIndex ++;
        }
        System.out.println("Found '" + word + "' a total of " + wordFoundCount + " times.");
        System.out.println("Here are the index positions of the lines where '"+ word + "' was found: " + foundIndexPositions);

        return foundIndexPositions;
    }
}