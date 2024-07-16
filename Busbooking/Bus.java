import java.util.*;
class Bus{
    public static void main(String[] args) {
        ArrayList<setc>  buses =new ArrayList<>();
        ArrayList<Booking>bookings=new ArrayList<>();

        Scanner scan = new Scanner (System.in);
        buses.add(new setc(1,100,true));
        buses.add(new setc(2,50,false));


        for(setc bus: buses){
            bus.display();
            


        }
     
        System.out.println("Enter your choices !!");
        System.out.println("1------>Bookings");
        System.out.println("2------>show booking details");
        System.out.println("3------>cancel");

        int choice = scan.nextInt();
         switch (choice) {
            case 1:
            Booking b =new Booking();
            
                break;
                case 2:

                break;
                case 3 :
                break;

         
            default:
                break;
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
    public int getcapacity(int capcity){
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
    void seatbooking(){

    }
}