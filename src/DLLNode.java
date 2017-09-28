/**
 * Created by mesomaesonwune on 9/27/17.
 */
public class DLLNode {
    public int data;
    public DLLNode next;
    public DLLNode prev;

    public DLLNode() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    public DLLNode(int info) {
        this.data = info;
        this.next = null;
        this.prev = null;
    }

    public DLLNode getNext() {
        return next;
    }

    public DLLNode getPrev() {
        return prev;
    }

    /*public double getData() {
        return data;
    }*/
}
