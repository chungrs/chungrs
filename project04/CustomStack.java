package cmsc256;

/******************************************************
* Programming Project 4 - Custom Stack Implementation
* ---------------------------------------------------
* This is a custom stack that implements the
* StackInterface from the Bridges project. The main
* method sends the data to the Bridges website for
* visualization.
* ---------------------------------------------------
* Roy Chung
* 20200307
* CMSC 256 Section 902
 ******************************************************/

import bridges.base.SLelement;
import bridges.connect.Bridges;

public class CustomStack<E> implements StackInterface<E> {
    //Instance variable topNode is an SLelement<E> object that allows us to keep track of which element is on top
    private SLelement<E> topNode;

    public CustomStack() {
        //default constructor creates an empty stack
        topNode = null;
    }

    @Override
    public void push(E newEntry) {
        //throw error is newEntry is null
        if (newEntry == null)
            throw new IllegalArgumentException();

        //newEntry is passed to stack, and the old topNode is linked
        SLelement newNode = new SLelement(newEntry, topNode);

        //newEntry becomes the new topNode
        topNode = newNode;
    }

    @Override
    public E pop() {
        //top variable temporarily stores topNode before clearing it and making the next element the new top node
        E top = null;
        if (isEmpty()) {
            throw new EmptyStackException("Empty stack.");
        } else {
            assert (topNode != null);
            top = topNode.getValue();
            topNode = topNode.getNext();
        }
        return top;
    }

    @Override
    public E peek() {
        //return the top element
        if (isEmpty()) { //throw error if stack is empty
            throw new EmptyStackException("Empty stack.");
        } else {
            return topNode.getValue();
        }
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        //Clearing the top node without making the next node the new top node effectively kills the whole linked stack
        topNode = null;
    }

    public void display() {
        if (isEmpty()) { //return message if stack is empty
            System.out.println("The stack is empty");
        } else {
            SLelement<E> current = topNode;
            StringBuffer output = new StringBuffer();
            output.append("Top of stack: " + current.getValue() + "\n");

            //iterate through all of the elements connected to current and add parse their values to String
            while(current.getNext() != null) {
                current = current.getNext();

                if (current.getNext() == null) {
                    output.append("Stack bottom: ");
                } else {
                    output.append("              ");
                }

                output.append(current.getValue() + "\n");
            }
            //Print the StringBuffer as a String
            System.out.println(output.toString());
        }
    }

    //Test custom stack implementation
    public static void main(String[] args) {
        //Create Bridges Object
        Bridges bridges = new Bridges(1, "chungrs", "1313147220589");
        bridges.setTitle("Custom Stack Implementation");

        //Instantiate CustomStack object and add elements
        CustomStack stack = new CustomStack<>();
        stack.push(256);
        stack.push(9);
        stack.push(20);
        stack.push(2018);
        stack.push(845);
        stack.push(5278);
        stack.push(727);

        //Send top node to bridges for visualization (sending a node will send all of the subsequent nodes)
        bridges.setDataStructure(stack.topNode);
        try {
            bridges.visualize();
        } catch(Exception exc) {
            System.out.println(exc.getMessage());
        }

        //Notify the user of the above calls of push method
        System.out.println("Pushed 256, 9, 20, 2018, 845, 5278, and 727");

        //Display stack contents
        stack.display();

        //Pop off two elements and display results
        stack.pop();
        stack.pop();
        System.out.println("Called pop twice:");
        stack.display();

        //Test peek method
        System.out.println("A call to peek returns " + stack.peek() + "\n");

        //Pop off remaining elements and display results
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Called pop five times:");
        stack.display();
    }
}
