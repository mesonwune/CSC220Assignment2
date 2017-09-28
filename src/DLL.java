/**
 * Created by mesomaesonwune on 9/27/17.
 */
public class DLL {
    private DLLNode head;
    private int size;

    //Create a default constructor
    public DLL() {
        this.head = null;
        this.size = 0;
    }


    //Custom constructor that takes in data
    public DLL(int data) {
        this.head = new DLLNode(data);
        size = 1;
    }

    public DLLNode getHead() {
        return head;
    }

    //print list
    public static void printList(DLLNode start) {
        if (start == null) {
            return;
        }
        DLLNode walk = start;
        while (walk != null) {
            System.out.print(walk.data);
            if (walk.next != null)
            {
                System.out.print(" -> ");
            }
            walk = walk.next;
        }
        System.out.println();
    }

    //inserts a node with data @ the front of the list
    public void pushFront(int data) {
        DLLNode node = new DLLNode(data);
        node.next = this.head;
        this.head = node;
        head.prev = null;
        size++;
    }

    //inserts a node with data @ the back of the list
    public void pushBack(int data) {
        //create a holder node
        DLLNode newNode = new DLLNode(data);
        //if the list is empty, add holder to head
        if (isEmpty()) {
            head = newNode;
        }
        //if not, then traverse through until you hit
        //the end of the list, and add holder node
        //then increase the list size
        else {
            DLLNode last = head;
            DLLNode prev = null;
            while (last.next != null) {
                prev = last;
                last = last.next;
            }
            last.next = newNode;
            last.prev = prev;
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
        head.prev = null;
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

        DLLNode last = head;
        DLLNode prev = head;

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

    public void insert(int index, int val) {
        DLLNode newNode = new DLLNode(val);

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
        }
        else {
            //Create pointers to see where I am in the loop
            DLLNode prev = null;
            DLLNode curr = head;

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

    public void deleteDuplicates(int val) {
        if (isEmpty()) {
            return;
        }

        DLLNode prev = null;
        DLLNode curr = head;
        while (curr != null) {
            if (curr.data == val) {
                if (curr == head)
                {
                    head = head.next;
                }
                else
                {
                    prev.next = curr.next;
                    curr = prev.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public int mtoLastElement(int M) {
        if (isEmpty() || M >= size)
        {
            System.out.println("Not possible.");
            return 0;
        }

        DLLNode curr = head;
        int index = (size - 1) - M;
        int value = 0;
        for (int i = 0; i < index; i++) {
            if (i == index) {
                value = curr.data;
            }

            curr = curr.next;
        }
        return value;
    }

    public void reverseList() {
        //checking to see that the list isn't empty or only
        //one node
        if(isEmpty() || size == 1)
        {
            return;
        }

        //keep track of my current, previous, and next node
        DLLNode curr = head;
        DLLNode next;
        DLLNode prev = null;

        //move through nodes changing next to prev
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void mergeLists(DLL one, DLL two)
    {
        //create finalList
        DLL finalList = new DLL();
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
            DLLNode pointer1 = one.head;
            DLLNode pointer2 = two.head;

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
