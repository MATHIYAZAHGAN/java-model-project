import java.util.*;
class Bus{
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        ArrayList<setc>  buses =new ArrayList<>();
        ArrayList<Booking>bookings=new ArrayList<>();

        buses.add(new setc(1,100,true));
        buses.add(new setc(2,50,false));
        while(true){


        for(setc b: buses){
            b.display();
            


        }
        System.out.println();
        System.out.println("---------------------------------------");

        System.out.println(" ---------Enter your choices----------");
        System.out.println("---------------------------------------");
        System.out.println("|   1 ------>Bookings                 |");
        System.out.println("---------------------------------------");

        System.out.println("|   2 ------>cancel                   |");
        System.out.println("---------------------------------------");

        System.out.println("|   3 ------>show booking details     |");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");


        int choice = scan.nextInt();
        System.out.println("---------------------------------------");

         switch (choice) {
            case 1:
            Booking b =new Booking();
            if(b.seatbooking(buses)){
                bookings.add(b);
                System.out.println("****************");
                System.out.println(" ----BOOKED ----");
                System.out.println("****************");
                System.out.println();

            }else{
                System.out.println("**************************");
                System.out.println("|--> NOT ENOUGH SEATS <--|");
                System.out.println("**************************");
                System.out.println();



            }
            
                break;
                case 2:
                scan.nextLine();
                System.out.println("**************************");
                System.out.println("|-->ENTER NAME TO CANCEL..");
                System.out.println("**************************");

                String name = scan.nextLine();
                if (Booking.cancle(name,bookings,buses)){
                    System.out.println("*****************************");
                    System.out.println("|-------> CANCELED <-------|");
                    System.out.println("*****************************");

                }else{
                    System.out.println("****************************");
                    System.out.println("|----> INVALID BOOKING <----|");
                    System.out.println("****************************");

                }
                break;
                case 3 :
                if(bookings.isEmpty()){
                    System.out.println("****************************");
                    System.out.println("|-->  NO BOOKING FOUND  <--|");
                    System.out.println("****************************");

                }else{
                    for(Booking book : bookings){
                        book.display();
                    }
                 

                }
               
                
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
        System.out.println("---------------------------------------");
        System.out.println("| BUSNO : " +busNo+" | CAPACITY "+capcity+" |  AC "+ ac+" |" );
        System.out.println("---------------------------------------");

    }

}
class Booking{
    String name;
    int busNo;
    int seats;
    Booking(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your name :");
        System.out.println("---------------------------------------");

        name= scan.nextLine();
        System.out.println("---------------------------------------");

        System.out.println("Enter your Busno ");
        System.out.println("---------------------------------------");

        busNo=scan.nextInt();
        System.out.println("---------------------------------------");

        System.out.println("Enter your seat ");
        System.out.println("---------------------------------------");

        seats=scan.nextInt();
        System.out.println();


    }
    static boolean cancle (String name , ArrayList<Booking> bookings, ArrayList<setc> buses){
        for (Booking b : bookings){
            if (b.name.equalsIgnoreCase(name)){
                for (setc bus: buses){
                    if (b.busNo == bus.getbusNo()){
                        bus.setcapacity(bus.getcapacity() + b.seats);
                        bookings.remove(b);
                        return true;
                    }
                }
            }
        }


        return false;
    }
    void display(){
        System.out.println("**************************************************************");
        System.out.println("| NAME : "+name+"  || BUS NO : " +busNo+" || BOOKEDSEATS "+seats+" |");
        System.out.println("**************************************************************");

    }

    boolean seatbooking(ArrayList<setc>  buses){
   
        for(setc b :buses){
            if(b.getbusNo()==busNo){
            if(b.getcapacity()>seats){

                b.setcapacity(b.getcapacity()-seats);
                return true;
            }
            }

        }
        return false;
}
}