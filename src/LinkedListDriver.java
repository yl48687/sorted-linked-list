import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Serves as the driver program for the Sorted Singly-Linked List. It provides a command-line
 * interface to interact with the {@code SortedLinkedList}.
 */
public class LinkedListDriver {
    /**
     * The main entry point of the program.
     *
     * @param args Command-line arguments. It should contain the path to the input file.
     */
    public static void main(String[] args) {
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");
        if (args.length < 1) {
            System.out.println("Please provide the path to the input file as a command-line argument.");
            return;
        } // if
        String filePath = args[0];
        SortedLinkedList sortedList = new SortedLinkedList();
        try {
            File inputFile = new File(filePath);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                int number = scanner.nextInt();
                sortedList.insertItem(new ItemType(number));
            } // while
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return;
        } // try
        Scanner inputScanner = new Scanner(System.in);
        char command;
        do {
            System.out.print("Enter a command: ");
            command = inputScanner.next().charAt(0);
            inputScanner.nextLine();
            switch (command) {
            case 'i':
                insertItemCommand(inputScanner, sortedList);
                break;
            case 'd':
                deleteItemCommand(inputScanner, sortedList);
                break;
            case 's':
                searchItemCommand(inputScanner, sortedList);
                break;
            case 'n':
                getNextItemCommand(sortedList);
                break;
            case 'r':
                resetListCommand(sortedList);
                break;
            case 'a':
                deleteAlternateNodesCommand(sortedList);
                break;
            case 'm':
                mergeListCommand(inputScanner, sortedList);
                break;
            case 't':
                intersectionCommand(inputScanner, sortedList);
                break;
            case 'p':
                printAllCommand(sortedList);
                break;
            case 'l':
                getLengthCommand(sortedList);
                break;
            case 'q':
                System.out.println("Exiting the program...");
                break;
            default:
                System.out.println("Invalid command, try again: ");
                break;
            }
        } while (command != 'q');
        inputScanner.close();
    } // main

    /**
     * Handles the insert item command.
     *
     * @param scanner The Scanner object to read user input.
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void insertItemCommand(Scanner scanner, SortedLinkedList sortedList) {
        System.out.print("Enter a number to insert: ");
        int insertNumber = scanner.nextInt();
        System.out.print("Original list : ");
        sortedList.printList();
        sortedList.insertItem(new ItemType(insertNumber));
        if (sortedList.contains(new ItemType(insertNumber))) {
            System.out.print("New list : ");
            sortedList.printList();
        } else {
            System.out.println("Item already exists");
        } // if
    } // insertItemCommand

    /**
     * Handles the delete item command.
     *
     * @param scanner The Scanner object to read user input.
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void deleteItemCommand(Scanner scanner, SortedLinkedList sortedList) {
        System.out.print("Enter a number to delete: ");
        int deleteNumber = scanner.nextInt();
        if (sortedList.isEmpty()) {
            System.out.println("You cannot delete from an empty list");
            return;
        } // if
        if (sortedList.contains(new ItemType(deleteNumber))) {
            System.out.print("Original list : ");
            sortedList.printList();
            sortedList.deleteItem(new ItemType(deleteNumber));
            System.out.print("New list : ");
            sortedList.printList();
        } else if (!sortedList.contains(new ItemType(deleteNumber))) {
            System.out.print("Original list : ");
            sortedList.printList();
            System.out.println("The item is not present in the list");
            System.out.print("New list : ");
            sortedList.printList();
        } // if
    } // deleteItemCommand

    /**
     * Handles the search item command.
     *
     * @param scanner The Scanner object to read user input.
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void searchItemCommand(Scanner scanner, SortedLinkedList sortedList) {
        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();
        System.out.print("Original list : ");
        sortedList.printList();
        if (sortedList.isEmpty()) {
            System.out.println("The list is empty");
            return;
        } // if
        int index = sortedList.searchItem(new ItemType(searchNumber));
        if (index != -1) {
            System.out.println("The item is present at index " + (index + 1));
        } else {
            System.out.println("Item is not present in the list");
        } // if
    } // searchItemCommand

    /**
     * Handles the get next item command.
     *
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void getNextItemCommand(SortedLinkedList sortedList) {
        ItemType nextItem = sortedList.getNextItem();
        if (nextItem != null) {
            System.out.println(nextItem.getValue());
        } // if
    } // getNextItemCommand

    /**
     * Handles the reset list command.
     *
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void resetListCommand(SortedLinkedList sortedList) {
        sortedList.resetList();
        System.out.println("Iterator is reset");
    } // resetListCommand

    /**
     * Handles the delete alternate nodes command.
     *
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void deleteAlternateNodesCommand(SortedLinkedList sortedList) {
        System.out.print("Original list: ");
        sortedList.printList();
        sortedList.deleteAltNodes();
        System.out.print("New list: ");
        sortedList.printList();
    } // deleteAlternateNodesCommand

    /**
     * Handles the merge list command.
     *
     * @param scanner   The Scanner object to read user input.
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void mergeListCommand(Scanner scanner, SortedLinkedList sortedList) {
        System.out.print("Enter the length of the new list: ");
        int length = scanner.nextInt();
        System.out.print("Enter the numbers: ");
        SortedLinkedList newList = new SortedLinkedList();
        for (int i = 0; i < length; i++) {
            int number = scanner.nextInt();
            newList.insertItem(new ItemType(number));
        } // for
        SortedLinkedList mergeList = sortedList.mergeList(newList);
        System.out.print("list 1: ");
        sortedList.printList();
        System.out.print("list 2: ");
        newList.printList();
        System.out.print("Merged list: ");
        mergeList.printList();
    } // mergeListCommand

    /**
     * Handles the intersection command.
     *
     * @param scanner The Scanner object to read user input.
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void intersectionCommand(Scanner scanner, SortedLinkedList sortedList) {
        System.out.print("Enter the length of the new list: ");
        int length = scanner.nextInt();
        System.out.print("Enter the numbers: ");
        SortedLinkedList intersectionList = new SortedLinkedList();
        for (int i = 0; i < length; i++) {
            int num = scanner.nextInt();
            intersectionList.insertItem(new ItemType(num));
        } // for
        System.out.print("list 1: ");
        sortedList.printList();
        System.out.print("list 2: ");
        intersectionList.printList();
        SortedLinkedList result = sortedList.intersection(intersectionList);
        System.out.print("Intersection of lists: ");
        result.printList();
    } // intersectionCommand

    /**
     * Handles the print all command.
     *
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void printAllCommand(SortedLinkedList sortedList) {
        System.out.print("The list is: ");
        sortedList.printList();
    } // printAllCommand

    /**
     * Handles the get length command.
     *
     * @param sortedList The SortedLinkedList object to perform the operation on.
     */
    private static void getLengthCommand(SortedLinkedList sortedList) {
        System.out.println("The length of the list is " + sortedList.getLength());
    } // getLengthCommand
} // LinkedListDriver
