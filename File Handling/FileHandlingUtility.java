import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== FILE HANDLING UTILITY =====");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    writeFile(sc);
                    break;

                case 2:
                    readFile();
                    break;

                case 3:
                    modifyFile(sc);
                    break;

                case 4:
                    System.out.println("Program Ended");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // Method to write data into file
    static void writeFile(Scanner sc) {

        try {

            FileWriter writer = new FileWriter("data.txt");

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            writer.write(text);
            writer.close();

            System.out.println("Data saved successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Method to read file content
    static void readFile() {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("data.txt"));

            String line;

            System.out.println("\nFile Content:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Method to modify file content
    static void modifyFile(Scanner sc) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("data.txt"));

            String content = "";
            String line;

            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }

            reader.close();

            System.out.print("Enter word to replace: ");
            String oldWord = sc.nextLine();

            System.out.print("Enter new word: ");
            String newWord = sc.nextLine();

            content = content.replace(oldWord, newWord);

            FileWriter writer = new FileWriter("data.txt");
            writer.write(content);
            writer.close();

            System.out.println("File modified successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}