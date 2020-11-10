package com.wlazrad.txt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static List<String> main() {
        try {
            File myObj = new File("src/main/resources/files/nounSortedList.txt");
            Scanner myReader = new Scanner(myObj);
            List<String> wordList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                wordList.add(data);
            }
            myReader.close();
            return wordList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
