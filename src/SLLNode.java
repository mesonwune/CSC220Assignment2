/**
 * Created by mesomaesonwune on 9/25/17.
 */
public class SLLNode {

    public double data;
    public SLLNode next;

    public SLLNode() {
        this.data = 0;
        this.next = null;
    }

    public SLLNode(double info) {
        this.data = info;
        this.next = null;
    }

    /*public SLLNode getNext() {
        return next;
    }

    public double getData() {
        return data;
    }

    *//*public static void printList(SLLNode start) {
        if (start == null) {
            return;
        }
        SLLNode walk = start;
        while (walk != null) {
            System.out.print(walk.next + " -> ");
            walk = walk.next;
        }
        System.out.println("null");*//*
    }*/
}
