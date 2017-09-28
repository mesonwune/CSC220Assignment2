import java.lang.reflect.Array;

/**
 * Created by mesomaesonwune on 9/25/17.
 */
public class SLL {

    private SLLNode head;
    private int size;

    //Create a default constructor
    public SLL() {
        this.head = null;
        this.size = 0;
    }


    //Custom constructor that takes in data
    public SLL(double data) {
        this.head = new SLLNode(data);
        size = 1;
    }

    public SLLNode getHead() {
        return head;
    }

    //print list
    public static void printList(SLLNode start) {
        if (start == null) {
            return;
        }
        SLLNode walk = start;
        while (walk != null) {
            System.out.print(walk.data);
            if (walk.next != null) {
                System.out.print(" -> ");
            }
            walk = walk.next;
        }
        System.out.println();
    }

    //inserts a node with data @ the front of the list
    public void pushFront(double data) {
        SLLNode node = new SLLNode(data);
        node.next = this.head;
        this.head = node;
        size++;
    }

    //inserts a node with data @ the back of the list
    public void pushBack(double data) {
        //create a holder node
        SLLNode newNode = new SLLNode(data);
        //if the list is empty, add holder to head
        if (isEmpty()) {
            head = newNode;
        }
        //if not, then traverse through until you hit
        //the end of the list, and add holder node
        //then increase the list size
        else {
            SLLNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    //checks to see if list is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    //deletes node @ front of the list
    public void popFront() {
        if (isEmpty()) {
            return;
        }

        this.head = head.next;
        this.size--;
    }

    //deletes node @ back of the list
    public void popBack() {
        if (isEmpty()) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        SLLNode last = head;
        SLLNode prev = head;

        while (last.next != null) {
            prev = last;
            last = last.next;
        }
        prev.next = null;
        this.size--;
    }

    //gives the size of the list
    public int size() {
        return this.size;
    }

    public void insert(int index, double val) {
        SLLNode newNode = new SLLNode(val);

        //Checking to see if the List is empty
        if (isEmpty()) {
            //if yes, then just add the node to head
            this.head = newNode;
            size++;
            return;
        }
        //Checking to see if index is too big
        else if (index > size) {
            System.out.println("Index is too big");
            return;
        }
        //check to see if the index is 0
        else if (index == 0) {
            //then just run pushFront (I don't have to
            //recopy the code
            pushFront(val);
            return;
        } else {
            //Create pointers to see where I am in the loop
            SLLNode prev = null;
            SLLNode curr = head;

            //go through the list
            for (int i = 0; i < size; i++) {
                //if it equals the index
                if (i == index) {
                    //set previous node's next to newNode
                    //set newNode's next to curr to connect
                    //increase the size and leave the method
                    prev.next = newNode;
                    newNode.next = curr;
                    size++;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void deleteDuplicates(double val) {
        if (isEmpty()) {
            return;
        }

        SLLNode prev = null;
        SLLNode curr = head;
        while (curr != null) {
            if (curr.data == val) {
                if (curr == head) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public double mtoLastElement(int M) {
        if (isEmpty() || M >= size) {
            System.out.println("Not possible.");
            return 0;
        }

        SLLNode curr = head;
        int index = (size - 1) - M;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    public void reverseList() {
        //checking to see that the list isn't empty or only
        //one node
        if (isEmpty() || size == 1) {
            return;
        }

        //keep track of my current, previous, and next node
        SLLNode curr = head;
        SLLNode next;
        SLLNode prev = null;

        //move through nodes changing next to prev
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void mergeLists(SLL one, SLL two) {

        //create finalList
        SLL finalList = new SLL();

        //return if one or both of the lists are empty
        if (one.isEmpty() && two.isEmpty()) {
            return;
        } else if (one.isEmpty() && !two.isEmpty()) {
            head = finalList.head = two.head;
            return;

        } else if (two.isEmpty() && !one.isEmpty()) {
            head = finalList.head = one.head;
            return;
        } else {
            SLLNode pointer1 = one.head;
            SLLNode pointer2 = two.head;

            //make sure that both isn't null, or stop running
            while (pointer1 != null && pointer2 != null) {
                //if pointer1 is bigger, add it
                if (pointer1.data < pointer2.data || pointer2 == null) {
                    finalList.pushBack(pointer1.data);
                    pointer1 = pointer1.next;
                }
                //if pointer2 is bigger, add it
                else if (pointer2.data < pointer1.data || pointer1 == null) {
                    finalList.pushBack(pointer2.data);
                    pointer2 = pointer2.next;
                }
                //if both are equal, add both
                else
                {
                    finalList.pushBack(pointer1.data);
                    finalList.pushBack(pointer2.data);
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
            }
        }
        //point head to finalList's head
        head = finalList.head;
    }
}
