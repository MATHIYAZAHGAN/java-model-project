import java.util.*;
class Bus{
    public static void main(String[] args) {
        ArrayList<setc>  buses =new ArrayList<>();
        ArrayList<Booking>bookings=new ArrayList<>();

        Scanner scan = new Scanner (System.in);
        buses.add(new setc(1,100,true));
        buses.add(new setc(2,50,false));
        while(true){


        for(setc bus: buses){
            bus.display();
            


        }
     
        System.out.println("Enter your choices !!");
        System.out.println("1------>Bookings");
        System.out.println("2------>cancel");
        System.out.println("3------>show booking details");

        int choice = scan.nextInt();
         switch (choice) {
            case 1:
            Booking b =new Booking();
            if(b.seatbooking(buses)){
                System.out.println(" BOOKED ");
            }else{
                System.out.println("NOT ENOUGH SEATS");
            }
            
                break;
                case 2:
                scan.nextLine();
                System.out.println("enter name to cancle...");
                String name = scan.nextLine();
                if (Booking.cancle(name,bookings,buses)){
                    System.out.println("cancled...");
                }
                break;
                case 3 :
             
                
                break;

         
            default:
            System.out.println("INVLID CREDENTIALS !!");
                break;
         }
        }

        

        
    }
}

class setc{

    int busNo;
    int capcity;
    boolean ac;
    setc(int busNo,int capacity,boolean ac){
        this.busNo=busNo;
        this.capcity=capacity;
        this.ac=ac;

    }

    public void setbusNo(int busNo){
        this.busNo=busNo;

    }
    public int getbusNo(){
        return busNo;
    }
    public void setcapacity(int capcity){
        this.capcity=capcity;

    }
    public int getcapacity(){
        return capcity;
    }
    public void setac(boolean ac){
        this.ac=ac;
    }
    public boolean getac(){
        return ac;

    }

    void display(){
        System.out.println("BusNO : " +busNo+" | capacity "+capcity+" |  ac "+ ac );
    }

}
class Booking{
    Scanner scan = new Scanner(System.in);
    String name;
    int BusNo;
    int seat;
    Booking(){
        System.out.println("Enter your name :");
        name= scan.nextLine();
        System.out.println("Enter your Busno ");
        BusNo=scan.nextInt();
        System.out.println("Enter your seat ");
        seat=scan.nextInt();


    }
    static boolean cancle (String name , ArrayList<Booking> bookings, ArrayList<setc> buses){
        for (Booking b : bookings){
            if (b.name.equalsIgnoreCase(name)){
                for (setc bus: buses){
                    if (b.BusNo == bus.getbusNo()){
                        bus.setcapacity(bus.getcapacity() + b.seat);
                        bookings.remove(b);
                        return true;
                    }
                }
            }
        }


        return false;
    }

    boolean seatbooking(ArrayList<setc>  buses){
   
        for(setc b :buses){
            if(b.getbusNo()==BusNo){
            if(b.getcapacity()>seat){

                b.setcapacity(b.getcapacity()-seat);
                return true;
            }
            }

        }
        return false;
}
}