package XOXOHVSH;

import java.util.*;


class xoxo{
    public static void main(String[] args) {
        try {

        Game a = new Game();
        player p1 = new player("arjun",'X');
        player p2 = new player("raju",'O');

      player cp;
      cp = p1;
       while(true){
        a.display();
        System.out.println(cp.name+" turn ");
        cp.input();
        if(a.rowwin() || a.colwin()){
            System.out.println(cp.name+" has won");
            a.display();

            break;
        }
        if(cp==p1){
            cp=p2;

        }else{
            cp=p1;
        }
        
       }
       
        
       } catch (Exception e) {
        System.out.println("Entered invalid input ! otherwise you play again  and again ");
       }
     






        
    }
}
class Game{
   static char board[][];

    Game(){
        board = new char [3][3];
        space();

    }
    void space(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]=' ';

            }
        }
      
    }
     static void mark(int row,int col,char mark){
       
                board[row][col]=mark;
            
        }
        public boolean rowwin(){
            for(int i=0;i<3;i++){
                if(board [i][0] !=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                    return true;

                }
            }
            return false;


        }
        public boolean colwin(){
            for(int i=0;i<3;i++){
                if( board[0][i]!=' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i]){
                    return true;

                }
            }
            return false;

        }

    void display(){
        System.out.println("<- - - - - - - - - - - -> ");
        for(int i=0;i<3;i++){
            System.out.print("  |  ");

            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+"  |  ");
            }
            System.out.println();
            System.out.println("<- - - - - - - - - - - -> ");

        }
            
    }
}
 class player{
        
    String name;
    char mark;
    player(String name,char mark){
        this.name=name;
        this.mark=mark; 
        
    }

    
      void input(){
        Scanner scan =new Scanner(System.in);
        int row,col;
        do{
            System.out.println("ENTER YOUR ROW AND COL");
            row=scan.nextInt();
            col=scan.nextInt();

        }while(!validinput(row, col));
        Game.mark(row,col,mark);

    }




boolean validinput(int row,int col){
if(Game.board[row][col]==' '){
    return true;

}
return false;

}


}

