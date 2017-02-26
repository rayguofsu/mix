
public class User {
   private name;  //
   public void pressButton(int toFloor) {
       Request req = new Request( toFloor);
       RequestProcessCenter  center = RequestProcessCenter.getInstance();
       center.addRequest(req);
   }
}

public class Request {
    private int toFloor;
    public Request(int _toFloor) {
        toFloor = _toFloor;
    }

    public int getToFloor() {
        return toFloor;
    }
}


public class Elevator {
    public static Elevator instance = null;
    private int currentFloor;
    public static Elevator() {
        if (instance == null) {  // late loading and eager loading
                    // connection pool
            synchronized (Elevator.class) {
                instance = new Elevator();
            }
        }
        //return instance;
    }

    public static Elevator getInstance() {
        if (instance == null) {
                synchronized (SingletonDemo.class) {
                    instance = new Elevator();
                }
        }
        return instance;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveToTargetFloor(int toFloor) {
        currentFloor = toFloor;
    }
    public void moveUp(){
        currentFloor += 1;
    }
    public void moveDown(){
        currentFloor -= 1;
    }
}
/////////////////Below is multiple thread
//　　在程序开发中只要是多线程肯定永远以实现Runnable接口为主，因为实现Runnable接口相比继承Thread类有如下好处：
//->避免点继承的局限，一个类可以继承多个接口; ->适合于资源的共享
public class RequestProcessCenter implements Runnable {
    private LinkedList<Request> queue;
    public RequestProcessCenter( ) {
        queue = new LinkedList<Request>( );
    }
    public static RequestProcessCenter getInstance() {
      if (instance == null) {
         synchronized(RequestHandler.class) {
            if (instance == null) {
               instance = new RequestHandler();
            }
         }
      }
      return instance;
   }
    public void run() {
        while ( true ) {
            processRequest( )
        }
    }
    public void addRequest(Request request) {
        queue.add(request);
    }
    public void removeRequest(Request request) {
        queue.remove(request);
    }
    public Request getNextRequest( ) {
        Request shortestReq = null;
        int shortest = Integer.MAX_VALUE;
        int curFloor = Elevator.getInstance( ).getCurrentFloor( );
        for (Request item : queue) {
            int distance = Math.abs(curFloor - item.getToFloor( ) );
            if (distance < shortest) {
                shortest = distance;
                shortestReq = item;
            }
        }
        return shortestReq;
    }
    public void processRequest( ) {
        Request req = getNextRequest( );
        if (req != null) {
            int toFloor = req.getToFloor( );
            Elevator.getInstance.moveToTargetFloor( toFloor);
            queue.remove(req);
        }
    }
}

