import java.util.Scanner;

/**
 * Created by mesomaesonwune on 9/25/17.
 */
public class Testing {

    public static void main(String [] args) {
        Scanner reader = new Scanner(System.in);
        char choice = 'a';
        //does the user want to use single or double linked list
        System.out.println("a. Single Linked List   b. Double Linked List");
        System.out.print("What kind of list do you want to work with? (a/b) ");
        choice = reader.next().charAt(0);
        if (choice == 'a') {
            SLL list1;
            //does head hold any data?
            System.out.print("Do you want to store a value? (y/n) ");
            choice = reader.next().charAt(0);
            if (choice == 'y') {
                //if yes, then create list that holds data in head
                list1 = new SLL(needDoubleValue(reader));
                list1.printList(list1.getHead());
            } else {
                //or create list with head.data == null
                list1 = new SLL();
                list1.printList(list1.getHead());
            }
            //the menu the user can choose from
            while (choice != 'q') {
                System.out.println("a. pushFront    b. popFront    c.pushBack\n"
                        + "d. popBack    e. insert    f. size\n"
                        + "g. delete Duplicates     h.reverseList  i. mtoLastElement\n"
                        + "j. mergeList     q. Quit");

                System.out.print("Please type in the letter of the function you want: ");
                choice = reader.next().charAt(0);

                //based on what the user chooses, run the method or break the loop
                switch (choice) {
                    case 'a':
                        list1.pushFront(needDoubleValue(reader));
                        list1.printList(list1.getHead());
                        break;
                    case 'b':
                        list1.popFront();
                        list1.printList(list1.getHead());
                        break;
                    case 'c':
                        list1.pushBack(needDoubleValue(reader));
                        list1.printList(list1.getHead());
                        break;
                    case 'd':
                        list1.popBack();
                        list1.printList(list1.getHead());
                        break;
                    case 'e':
                        //ask for user input for the value and index
                        System.out.print("Please choose an index: ");
                        int index = reader.nextInt();
                        System.out.print("Please choose a value: ");
                        double value = reader.nextDouble();
                        list1.insert(index, value);
                        list1.printList(list1.getHead());
                        break;
                    case 'f':
                        System.out.println("List size: " + list1.size());
                        break;
                    case 'g':
                        //ask for user input for the value
                        System.out.println("Need a value.");
                        value = needDoubleValue(reader);
                        list1.deleteDuplicates(value);
                        list1.printList(list1.getHead());
                        break;
                    case 'h':
                        list1.reverseList();
                        list1.printList(list1.getHead());
                        break;
                    case 'i':
                        //ask for user input for the index
                        System.out.println("Need an index.");
                        index = reader.nextInt();
                        list1.mtoLastElement(index);
                        list1.printList(list1.getHead());
                        break;
                    case 'j':
                        //create a new list so we can merge
                        SLL list2 = new SLL();
                        value = 0;
                        System.out.println("Keep entering values. To exit, enter -1.");
                        //have loop run to add values to list
                        while (value != -1) {
                            value = reader.nextDouble();
                            if (value != -1) {
                                list2.pushBack(value);
                            } else {
                                break;
                            }
                        }
                        //show the lists,  merge them, and show the final list
                        System.out.print("List 1: ");
                        list1.printList(list1.getHead());
                        System.out.print("List 2: ");
                        list2.printList(list2.getHead());

                        list1.mergeLists(list1, list2);
                        list1.printList(list1.getHead());
                        break;
                    case 'q':
                        break;
                }

            }
        } else if (choice == 'b') {
            DLL list1;
            //does head hold any data?
            System.out.print("Do you want to store a value? (y/n) ");
            choice = reader.next().charAt(0);
            if (choice == 'y') {
                //if yes, then create list with data
                list1 = new DLL(needIntValue(reader));
                list1.printList(list1.getHead());
            } else {
                //or create list with head.data == null
                list1 = new DLL();
                list1.printList(list1.getHead());
            }
            //the menu the user can choose from
            while (choice != 'q') {
                System.out.println("a. pushFront    b. popFront    c.pushBack\n"
                        + "d. popBack    e. insert    f. size\n"
                        + "g. delete Duplicates     h.reverseList  i. mtoLastElement\n"
                        + "j. mergeList     k. printList     q. Quit");

                System.out.print("Please type in the letter of the function you want: ");
                choice = reader.next().charAt(0);

                //based on what the user chooses, run the method or break the loop
                switch (choice) {
                    case 'a':
                        list1.pushFront(needIntValue(reader));
                        list1.printList(list1.getHead());
                        break;
                    case 'b':
                        list1.popFront();
                        list1.printList(list1.getHead());
                        break;
                    case 'c':
                        list1.pushBack(needIntValue(reader));
                        list1.printList(list1.getHead());
                        break;
                    case 'd':
                        list1.popBack();
                        list1.printList(list1.getHead());
                        break;
                    case 'e':
                        //ask for user input for the value and index
                        System.out.print("Please choose an index: ");
                        int index = reader.nextInt();
                        System.out.print("Please choose a value: ");
                        int value = reader.nextInt();
                        list1.insert(index, value);
                        list1.printList(list1.getHead());
                        break;
                    case 'f':
                        System.out.println("List size: " + list1.size());
                        break;
                    case 'g':
                        //ask for user input for the value
                        System.out.println("Need a value.");
                        value = needIntValue(reader);
                        list1.deleteDuplicates(value);
                        list1.printList(list1.getHead());
                        break;
                    case 'h':
                        list1.reverseList();
                        list1.printList(list1.getHead());
                        break;
                    case 'i':
                        //ask for user input for the index
                        System.out.println("Need an index.");
                        index = reader.nextInt();
                        list1.mtoLastElement(index);
                        list1.printList(list1.getHead());
                        break;
                    case 'j':
                        //create a new list so we can merge
                        DLL list2 = new DLL();
                        value = 0;
                        System.out.println("Keep entering values. To exit, enter -1.");
                        //have loop run to add values to list
                        while (value != -1) {
                            value = reader.nextInt();
                            if (value != -1) {
                                list2.pushBack(value);
                            } else {
                                break;
                            }
                        }

                        //show the lists,  merge them, and show the final list
                        System.out.print("List 1: ");
                        list1.printList(list1.getHead());
                        System.out.print("List 2: ");
                        list2.printList(list2.getHead());

                        list1.mergeLists(list1, list2);
                        list1.printList(list1.getHead());
                        break;
                    case 'q':
                        break;

                }

            }
        }
    }

    //a method to call a int value so I don't repeat code
    public static int needIntValue(Scanner scanner)
    {
        System.out.print("Please type in a number");
        int value = scanner.nextInt();
        return value;
    }

    //a method to call a double value so I don't repeat code
    public static double needDoubleValue(Scanner scanner)
    {
        System.out.print("Please type in a number");
        double value = scanner.nextDouble();
        return value;
    }


    /*public static void printList(SLLNode start) {
        if (start == null) {
            return;
        }
        SLLNode walk = start;
        while (walk != null) {
            System.out.print(walk.next + " -> ");
            walk = walk.next;
        }
        System.out.println("null");
    }*/

}
