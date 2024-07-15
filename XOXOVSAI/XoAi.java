package XOXOVSAI;
import java.util.*;

public class XoAi {
    public static void main(String[] args) {
        
      Game n = new Game();
      Human ab = new Human("Arjun", 'X');
      Ai ba= new Ai("Ai", 'O');

      player ch;
      ch=ab;
      while (true) {
        try{
        n.display();
        System.out.println(ch.name+" turn ");
        ch.input();
        if(n.rowwin()|| n.colwin()){
            n.display();
            System.out.println(ch.name+" has won");
            break;
        
        }
         if(ch==ab){
            ch=ba;
            

        }else{
            ch=ab;
        }
    }catch(Exception e){
        System.out.println("**************$rror  Oops! Entered invalid move !  please enter valid move ! play again--> ");

    }
        
      }

       
      



        

    }
    
}
abstract class player{
    String name;
    char mark;
    abstract void input();
 boolean validinput(int row,int col){
        if( Game.board[row][col]==' ')
 {
     return true;
 
 }
 return false;
 
     }
 }


class Human extends player{
    Human(String name,char mark){
        this.name=name;
        this.mark=mark;

    }
   
    void input(){
        Scanner scan = new Scanner(System.in);
        int row,col;
        do{
            System.out.println("Enter your row and col");
        row=scan.nextInt();
        col=scan.nextInt();
        }while(!validinput(row, col));
        Game.placemark(row,col,mark);

        


    }
}
class Ai extends player{
    
    Ai(String name,char mark){
        this.name=name;
        this.mark=mark;


    }
    void input(){
        Random r = new Random();
        int row,col;
        do{
            row=r.nextInt(0,3);
            col=r.nextInt(0,3);

        }while(!validinput(row,col));
        Game.placemark(row, col, mark);

        
    
    }
}
    
class Game{
   static char board[][];
    Game(){
        board=new char [3][3];
        space();
    }
   
   static void placemark(int row,int col,char mark){
        board[row][col]= mark ;
        
    }
    void space(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }
    }
    boolean rowwin(){
        for(int i=0;i<3;i++){
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){

                return true ;


            }

        }
        return false;

    }
    boolean colwin(){
        for(int i=0;i<3;i++){
            if( board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return true;

            }
        }
        return false;
    }

  
    void display(){
        System.out.println("----------------------");
        for(int i=0;i<3;i++){
            System.out.print("  |  ");
            for(int j=0;j<3;j++){

                System.out.print(board[i][j]+"  |  ");
            }
            System.out.println();
            System.out.println("----------------------");

        }
        
      
       
    }
}
