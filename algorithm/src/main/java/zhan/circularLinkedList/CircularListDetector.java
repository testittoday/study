/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhan.circularLinkedList;

/**
 *
 * Write code to detect if a linked list has a loop
 * Write code to get the start node of a linked list with loop
 * 
 * ref:
 * Floyd's cycle-finding algorithm, also called the "tortoise and the hare" algorithm
 * http://en.wikipedia.org/wiki/Floyd%27s_cycle-finding_algorithm#Tortoise_and_hare
 * 
 *
 *
 * @author mzhan
 */
public class CircularListDetector {
    
    /**
     * main idea:
     *
     * uses two pointers (one slow pointer and one fast pointer). 
     * The slow pointer advances one node at a time, while the fast pointer 
     * traverses twice as fast. If the list has loop in it, eventually the fast 
     * and slow pointer will meet at the same node. On the other hand, if the 
     * loop has no loop, the fast pointer will reach the end of list before the 
     * slow pointer does
     * 
     * @param head
     * @return
     */
    public boolean containCycle(LinkedListNode head) {
        boolean result = false;
        
        LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head;
        
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if(slowPtr == fastPtr) {
                result = true;
            }
        }
        return result;
    }

    /**
     * main idea:
     * 
     * When your slow and fast pointers meet, 
     * number of steps from list head node to loop start node 
     * is equal to 
     * number of steps from slow and fast meeting node to the loop start node
     * 
     * @param head
     * @return 
     */
    public LinkedListNode getCycleStartNode(LinkedListNode head) {
        LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head;

        LinkedListNode meetingNode = null;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if(slowPtr == fastPtr) {
                meetingNode = slowPtr;
                break;
            }
        }

        if (meetingNode == null) {
            return null;
        } else if (meetingNode == head) {
            return head;
        } else {
            LinkedListNode tmp = head;
            while (meetingNode != tmp) {
                tmp = tmp.next;
                meetingNode = meetingNode.next;
            }
            return meetingNode;
        }
        
    }
    
}
