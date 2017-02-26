Vehicle类

public abstract class Vehicle {
   protected ParkingSpace pSpace;
   public abstract boolean park(ParkingLot pLot);
   public boolean unpark(ParkingLot pLot){
       if(pSpace!=null){
           pLot.reclaimFreeSpace(pSpace);
           return true;
       }
       return false;
   }
}

Car, Motobike, HandicappedCars 类


public class Cars extends Vehicle{

    @Override
    public boolean park(ParkingLot pLot) {
        if( (pSpace = pLot.allocateFreeSpace(ParkingSpace.ParkingSpaceType.CAR)) !=null)
            return true;
        else
            return false;
    }
}

public class Motorbike extends Vehicle{
    @Override
    public boolean park(ParkingLot pLot) {
        if( (pSpace = pLot.allocateFreeSpace(ParkingSpace.ParkingSpaceType.MOTOBIKE)) !=null)
            return true;
        else
            return false;
    }

}

public class HandicappedCars extends Vehicle{

    @Override
    public boolean park(ParkingLot pLot) {
        if( (pSpace = pLot.allocateFreeSpace(ParkingSpace.ParkingSpaceType.HANDICAPPED)) !=null)
            return true;
        else
            return false;
    }
}

ParkingSpace类

import java.sql.Time;
import java.util.GregorianCalendar;

public class ParkingSpace {

    public enum ParkingSpaceType
    {
        MOTOBIKE, CAR, HANDICAPPED;
    }

    private int id;
    private ParkingSpaceType pSpaceType;
    private ParkingMeter meter;

     public ParkingSpace(int id, ParkingSpaceType pspaceType)
     {
            super();
            this.id = id;
            this.pSpaceType = pspaceType;
     }

     public int getId()
        {
            return id;
        }
       public void setStart()
        {
            meter.start = new GregorianCalendar();
        }
        public void setEnd()
        {
            meter.end = new GregorianCalendar();
        }

     public ParkingSpaceType getpSpaceType(){
         return pSpaceType;
     }

     private class ParkingMeter{
         public GregorianCalendar start;
         public GregorianCalendar end;
     }

      public float getFee()
      {
            return perm.getFee(meter.start, meter.end);
      }

}

ParkingLot类

import java.util.List;

import parking.ParkingSpace.ParkingSpaceType;

public class ParkingLot {

       private List<ParkingSpace> freeRegularSpace;
       private List<ParkingSpace> freeCompactSpace;
       private List<ParkingSpace> freeHandicappedSpace;

       public ParkingLot(){};

       public ParkingSpace allocateFreeSpace(ParkingSpaceType pSpaceType) throws Exception{
           ParkingSpace pSpace = null;

           switch(pSpaceType){
           case MOTOBIKE:
               if(freeRegularSpace.size()==0)
                   return null;
               pSpace = freeRegularSpace.remove(0);
               pSpace.setStart();
               break;

           case HANDICAPPED:
               if(freeHandicappedSpace.size()==0)
                   return null;
               pSpace = freeHandicappedSpace.remove(0);
               pSpace.setStart();
               break;

           case CAR:
               if(freeCompactSpace.size()==0)
                   return null;
               pSpace = freeCompactSpace.remove(0);
               pSpace.setStart();
               break;

           default:
               throw new Exception("Invalid String");
           }
           return pSpace;
      }

     public float reclainFreeSpace(ParkingSpace Space){
               Space.setEnd();
               switch(Space.getpSpaceType()){
               case MOTOBIKE:
                   freeRegularSpace.add(Space);
                   break;

               case CAR:
                   freeCompactSpace.add(Space);
                   break;

               case HANDICAPPED:
                   freeHandicappedSpace.add(Space);
                   break;

               default:
                   break;
               }
               return Space.getFee();
           }
       }
}
