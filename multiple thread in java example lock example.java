Difference between lock and synchronized:
A ReentrantLock is unstructed, can hold a lock across methods, e.g.
private ReentrantLock lock;
public void foo(){
  ...
  lock.lock();
  ...
}
public void bar(){
...
  lock.unlock();
...
}

Lock has more features, such as
1). Interruptable locking;
When one thread acquires lock, and other thread can send a signal to it asking for release the lock
2). TimeOut locking by tryLock();
When one thread acquires one lock and try to acquire a 2nd lock, after some time, if it still cannot aquire,
it will release the first lock to avoid deadlock and re-request for two locks;
3). accorss method locking as shown in e.g. above.

=======================================
   
A race condition occurs when two or more threads can access shared data and they try to change it at the same time. 
Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the threads will attempt to access the shared data. Therefore, the result of the change in data is dependent on the thread scheduling algorithm, i.e. both threads are "racing" to access/change the data.

Problems often occur when one thread does a "check-then-act" (e.g. "check" if the value is X, then "act" to do something that depends on the value being X) and another thread does something to the value in between the "check" and the "act". E.g:

if (x == 5) // The "Check"
{
   y = x * 2; // The "Act"

   // If another thread changed x in between "if (x == 5)" and "y = x * 2" above,
   // y will not be equal to 10.
}
The point being, y could be 10, or it could be anything, depending on whether another thread changed x in between the check and act. You have no real way of knowing.

In order to prevent race conditions from occurring, you would typically put a lock around the shared data to ensure only one thread can access the data at a time. This would mean something like this:

// Obtain lock for x
if (x == 5)
{
   y = x * 2; // Now, nothing can change x until the lock is released. 
              // Therefore y = 10
}
// release lock for x
simplified version:
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static class Register implements Runnable {
    private int count = 0;
    final Lock lock = new ReentrantLock();  
    @Override
    public void run() {
       addMember();
    }
    public void addMember() {//if make it public synchronized void addMember(), then no need to have lock
      lock.lock();
      try { 
         System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
         System.out.println("Processing...");
         count++;
         System.out.println("new count is " + count);
         Thread.sleep(20);
      } catch (InterruptedException e) {
           e.printStackTrace();
      } finally {
         System.out.println(Thread.currentThread().getName() + ": Lock released.");
         lock.unlock();
      }
      System.out.println();
    }
  }
  
  
  public static void main(String[] args)throws InterruptedException {
        Register r = new Register();
        Thread t1 = new Thread(r, "t1");
        t1.start();
        Thread t2 = new Thread(r, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
    
        System.out.println("final count is " + r.count);
  }

}

LoNG VERSION:
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static class Group{
    private int count = 0;
    final Lock lock = new ReentrantLock();  
    public void addMember() {  // ----> make it public synchronized void addMember().. then no need to have lock
      lock.lock();
      try { 
         System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
         System.out.println("Processing...");
         count++;
         System.out.println("new count is " + count);
         Thread.sleep(2000);
      } catch (InterruptedException e) {
           e.printStackTrace();
      } finally {
         System.out.println(Thread.currentThread().getName() + ": Lock released.");
         lock.unlock();
      }
      System.out.println();
    }
  } 
  public static class Register implements Runnable {
    private Group g;
    public Register(Group group){
       this.g = group;
    }
    @Override
    public void run() {
        g.addMember();
    }
  }
  
  
  public static void main(String[] args)throws InterruptedException {
        Group group = new Group();
        Thread t1 = new Thread(new Register(group), "t1");
        t1.start();
        Thread t2 = new Thread(new Register(group), "t2");
        t2.start();
        Thread t3 = new Thread(new Register(group), "t3");
        t3.start();
        Thread t4 = new Thread(new Register(group), "t4");
        t4.start();
        Thread t5 = new Thread(new Register(group), "t5");
        t5.start();
        Thread t6 = new Thread(new Register(group), "t6");
        t6.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
    
        System.out.println("final count is " + group.count);
  }

}


