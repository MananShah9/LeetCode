// Design Circular Queue


// Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

// One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

// Implementation the MyCircularQueue class:

// MyCircularQueue(k) Initializes the object with the size of the queue to be k.
// int Front() Gets the front item from the queue. If the queue is empty, return -1.
// int Rear() Gets the last item from the queue. If the queue is empty, return -1.
// boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
// boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
// boolean isEmpty() Checks whether the circular queue is empty or not.
// boolean isFull() Checks whether the circular queue is full or not.
 

// Example 1:

// Input
// ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
// [[3], [1], [2], [3], [4], [], [], [], [4], []]
// Output
// [null, true, true, true, false, 3, true, true, true, 4]

// Explanation
// MyCircularQueue myCircularQueue = new MyCircularQueue(3);
// myCircularQueue.enQueue(1); // return True
// myCircularQueue.enQueue(2); // return True
// myCircularQueue.enQueue(3); // return True
// myCircularQueue.enQueue(4); // return False
// myCircularQueue.Rear();     // return 3
// myCircularQueue.isFull();   // return True
// myCircularQueue.deQueue();  // return True
// myCircularQueue.enQueue(4); // return True
// myCircularQueue.Rear();     // return 4
 

// Constraints:

// 1 <= k <= 1000
// 0 <= value <= 1000
// At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.
 

// Follow up: Could you solve the problem without using the built-in queue? 

// Code :


class QueueNode{
    int val;
    QueueNode next=null;
    public QueueNode(int val){
        this.val=val;
    }
    public void setNext(QueueNode next){
        this.next=next;
    }
}
class MyCircularQueue {
    QueueNode head=null; 
    int currentLength=0;
    int maxLength;
    public MyCircularQueue(int k) {
        this.maxLength=k;
        // System.out.println("Created MyCircularQueue successfully");
    }
    
    public boolean enQueue(int value) {
        if(currentLength!=maxLength){
            if(head==null){
                head=new QueueNode(value);
                head.setNext(head);
                // System.out.println("Enqueue as head");
            }
            else{
                QueueNode temp=head;
                while(temp.next!=head){
                    temp=temp.next;
                }
                temp.next=new QueueNode(value);
                temp.next.setNext(head);
                // System.out.println("Enqueue as normal");
            }
            currentLength++;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean deQueue() {
        if(head==null){
            // System.out.println("Dequeue as head");
            return false;
        }
        else if(head.next==head){
            head=null;
            currentLength--;
            // System.out.println("Dequeue as head is only node");

            return true;
        }
        else{
            QueueNode temp=head;
                while(temp.next!=head){
                    temp=temp.next;
                }
            temp.next=head.next;
            head=head.next;
            currentLength--;
            // System.out.println("Dequeue as normal");

            return true;
        }
    }
    
    public int Front() {
        if(head==null){
            return -1;
        }
        // System.out.print("Returning front as ");
        // System.out.println(head.val);

        return head.val;
    }
    
    public int Rear() {
        if(head==null){
            return -1;
        }
        else{
            QueueNode temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            // System.out.print("Returning rear as ");
            // System.out.println(temp.val);
            return temp.val;
        }
        
    }
    
    public boolean isEmpty() {
        if(head==null){
            // System.out.println("Returning empty ");
            return true;
        }
        // System.out.println("Returning not empty ");
        return false;
    }
    
    public boolean isFull() {
        if (currentLength==maxLength){
            // System.out.println("Returning full ");
            return true;
        }
         // System.out.println("Returning not full ");

        return false;
    }
}
