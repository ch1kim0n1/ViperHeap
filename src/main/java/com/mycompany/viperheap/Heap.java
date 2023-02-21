package com.mycompany.viperheap;

import java.util.ArrayList;
import static java.lang.System.*;

public class Heap
{
    private ArrayList<Integer> list;

    public Heap()
    {
        list = new ArrayList<Integer>();
    }
    
    public void swapUp(int bot)
    {
        if (bot <= 0) {
            return; // Base case: reached the root of the tree
        }
        int parent = (bot - 1) / 2; // Get the parent index
        if (list.get(bot) > list.get(parent)) {
            swap(bot, parent);
            swapUp(parent); // Recursively swap with parent until the new item is in the proper location or it finds that the new item is not larger than its current parent
        }
    }

    public void swapDown(int top)
    {
        int left = top * 2 + 1; // Get the left child index
        int right = top * 2 + 2; // Get the right child index
        int largest = top; // Initialize largest as the root
        if (left < list.size() && list.get(left) > list.get(largest)) {
            largest = left;
        }
        if (right < list.size() && list.get(right) > list.get(largest)) {
            largest = right;
        }
        if (largest != top) {
            swap(top, largest);
            swapDown(largest); // Recursively swap with the larger child until the bottom of the tree is reached or there are no children larger than the current parent
        }
    }


    public void add(int value)
    {
        list.add(value);
        swapUp(list.size()-1);
    }

    public void remove( )
    {
        if (list.isEmpty()) {
            return;
        }
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        swapDown(0);
    }

    private void swap(int start, int finish)
    {
        int temp = list.get(start);
        list.set(start, list.get(finish));
        list.set(finish, temp);
    }

    public void print() {
    out.println("\n\nPRINTING THE HEAP!\n\n");

    int height = (int) (Math.log(list.size()) / Math.log(2));
    int index = 0;

    for (int i = 0; i <= height; i++) {
        int levelNodes = (int) Math.pow(2, i);
        int preSpaces = (int) Math.pow(2, height - i) - 1;
        int betweenSpaces = (int) Math.pow(2, height - i + 1) - 1;

        printSpaces(preSpaces);

        for (int j = 0; j < levelNodes && index < list.size(); j++) {
            out.print(list.get(index));
            printSpaces(betweenSpaces);
            index++;
        }

        out.println();
    }
}

private void printSpaces(int count) {
    for (int i = 0; i < count; i++) {
        out.print(" ");
    }
}


    public String toString()
    {
        return list.toString();
    }
}
