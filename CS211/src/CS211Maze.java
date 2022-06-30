import java.util.*;
public class CS211Maze
{
    public static void main(String[] args){
        int lives = 100;
        String[] input = new String[20];
        input[ 0]="XXX XXXXXXX XXXXXX X";
        input[ 1]="XXX XXXXXXX XXXXXX X";
        input[ 2]="XXX      XX XXXX   X";
        input[ 3]="XXXXXXX XXXXXXXXXXXX";
        input[ 4]="XXXXXXX XX      XXXX";
        input[ 5]="XXX  XXXXX XXXX XXXX";
        input[ 6]="XX  X XXXX   XX XXXX";
        input[ 7]="XXX XXXXXXXX XX XXXX";
        input[ 8]="XX  X  XXXXX XX XXXX";
        input[ 9]="XXXXXX       XX XXXX";
        input[10]="X XXXX XX  XXXX XXXX";
        input[11]="     XXXX  XXXX XXXX";
        input[12]="XXXXXXXXXXXXXXX XXXX";
        input[13]="XXXXXX  XXXX    XXXX";
        input[14]="XX XX XXXXXX XX XXXX";
        input[15]="X  XX XXXXXX XX XXXX";
        input[16]="XX XX X  X   XX XX  ";
        input[17]="X  XXXXXXX XXXX XX X";
        input[18]="XX XXXXXXX XXXXXXX X";
        input[19]="XX XXXXXXX XXXXXXX X";
        /*
        input[ 0]="X XXXXXX XXXXXXX XXX";
        input[ 1]="X XXXXXX XXXXXXX XXX";
        input[ 2]="X   XXXX XX      XXX";
        input[ 3]="XXXXXXXXXXXX XXXXXXX";
        input[ 4]="XXXX      XX XXXXXXX";
        input[ 5]="XXXX XXXX XXXXX  XXX";
        input[ 6]="XXXX XX   XXXX X  XX";
        input[ 7]="XXXX XX XXXXXXXX XXX";
        input[ 8]="XXXX XX XXXXX  X  XX";
        input[ 9]="XXXX XX       XXXXXX";
        input[10]="XXXX XXXX  XX XXXX X";
        input[11]="XXXX XXXX  XXXX     ";
        input[12]="XXXX XXXXXXXXXXXXXXX";
        input[13]="XXXX    XXXX  XXXXXX";
        input[14]="XXXX XX XXXXXX XX XX";
        input[15]="XXXX XX XXXXXX XX  X";
        input[16]="  XX XX   X  X XX XX";
        input[17]="X XX XXXX XXXXXXX  X";
        input[18]="X XXXXXXX XXXXXXX XX";
        input[19]="X XXXXXXX XXXXXXX XX";
        */
        int posX=10;
        int posY=10;

        boolean[][] maze = new boolean[20][20];
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(input[i].charAt(j)=='X'){
                    maze[i][j]=false;
                }else{
                    maze[i][j]=true;
                }
            }
        }
        System.out.println(posX+" "+posY);
        printboard(maze,posX,posY);
        Brain myBrain = new Brain();


        while(lives>0){
            String move =myBrain.getMove(maze[posX-1][posY],maze[posX+1][posY],maze[posX][posY+1],maze[posX][posY-1]);
            if(move.equals("north")&&maze[posX-1][posY]){
                posX--;
            }else if(move.equals("south")&&maze[posX+1][posY]){
                posX++;
            }else if(move.equals("east")&&maze[posX][posY+1]){
                posY++;
            }else if(move.equals("west")&&maze[posX][posY-1]){
                posY--;
            }
            System.out.println(posX+" "+posY+" "+lives);
            printboard(maze,posX,posY);
            lives--;
            if(posY%19==0||posX%19==0){
                System.out.println(posX+","+posY);
                System.exit(0);
            }
        }
        System.out.println("You died in the maze!");
    }


    public static void printboard(boolean[][] board, int posX, int posY){
        for(int y=0;y<20;y++){
            for(int x=0;x<20;x++){
                if(x==posX&&y==posY){
                    System.out.print(":)");
                }else{
                    if(board[x][y]==true){
                        System.out.print("  ");
                    }else{
                        System.out.print("■ ");
                    }
                }
            }
            System.out.println();
        }
        try{
            Thread.sleep(100);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}

class Brain
{
    public static boolean firstMove = true;
    public static String lastMove = "";
    public static String nextMove = "";
    public static boolean backTrack = false;
    public String getMove(boolean north, boolean south, boolean east, boolean west)
    {
        /*                        how the directions work:
        north is actually west (left)                      west
        south is actually east (right)            north             south
        west is actually north (up)                        east
        east is actually south (down)

        my method to get out of the maze is to stick to the left wall
         */
        if(firstMove==true)//first move
        {
            firstMove=false;
            if(north==true)//try to go left
            {
                lastMove = "north";
                return "north";
            }
            else if(west==true)//else go up
            {
                lastMove = "west";
                return "west";
            }
            else if(east==true)//else go down
            {
                lastMove = "east";
                return "east";
            }
            else//if all else fails go to the right
            {
                lastMove = "south";
                return "south";
            }
        }
        else if(backTrack==true)//true when i hit a dead end
        {
            if(lastMove == "west")//if i was facing west (north/up) at the dead end north is the left side south is the right
            {
                if(north== true)//if i can go left set last move to north and set back track to false
                {
                    lastMove = "north";
                    backTrack = false;
                    nextMove="north";
                }
                else if(south==true)//second option
                {
                    lastMove = "south";
                    backTrack = false;
                    nextMove="south";
                }
                else//if i cant go right or left keep back tracking
                {
                    nextMove="east";
                }
            }
            else if(lastMove == "east")//if i was facing east at the dead end south is my left and north is my right
            {
                if(south== true)//south would be the best first option
                {
                    lastMove = "south";
                    backTrack = false;
                    nextMove="south";
                }
                else if(north==true)//second option
                {
                    lastMove = "north";
                    backTrack = false;
                    nextMove="north";
                }
                else//keep going back if i cant turn
                {
                    nextMove="west";
                }
            }
            else if(lastMove== "north")//if i was facing north at the dead end east is to the left and west is to the right
            {
                if(east== true)
                {
                    lastMove = "east";
                    backTrack = false;
                    nextMove="east";
                }
                else if(west==true)
                {
                    lastMove = "west";
                    backTrack = false;
                    nextMove="west";
                }
                else
                {
                    nextMove="south";
                }
            }
            else//south
            {//if i was facing south at the dead end west is at my left and east is at my right
                if(west== true)
                {
                    lastMove = "west";
                    backTrack = false;
                    nextMove="west";
                }
                else if(east==true)
                {
                    lastMove = "east";
                    backTrack = false;
                    nextMove="east";
                }
                else
                {
                    nextMove = "north";
                }
            }
            return nextMove;
        }
        else //rest of the moves
        {
            if (lastMove == "west" && west == true)//finish the path its on
            {
                lastMove = "west";
                nextMove = "west";
            }
            else if(lastMove == "west" && west == false)//if i cant keep going west pick a new direction
            {
                if(north==true)//north is best because it is at my left when i am facing west
                {
                    lastMove = "north";
                    nextMove="north";
                }
                else if(south==true)
                {
                    lastMove = "south";
                    nextMove="south";
                }
                else//i will get to this point if i am stuck at a dead end
                {
                    //lastMove = "east";
                    backTrack=true;
                    nextMove = "east";
                }
            }
            else if (lastMove == "north" && north == true)//finish the path its on
            {
                nextMove = "north";
            }
            else if(lastMove == "north" && north == false)//if i cant keep going north pick a new direction
            {
                if(east==true)//east is best because it is at my left when i am facing north
                {
                    lastMove = "east";
                    nextMove="east";
                }
                else if(west==true)
                {
                    lastMove = "west";
                    nextMove="west";
                }
                else//i will get to this point if i am stuck at a dead end
                {
                    //lastMove = "south";
                    backTrack=true;
                    nextMove = "south";
                }
            }
            else if (lastMove == "south" && south == true)//finish the path its on
            {
                nextMove = "south";
            }
            else if(lastMove == "south" && south == false)//if i cant keep going south pick a new direction
            {
                if(west==true)//west is best because it is at my left when i am facing south
                {
                    lastMove = "west";
                    nextMove="west";
                }
                else if(east==true)
                {
                    lastMove = "east";
                    nextMove="east";
                }
                else//i will get to this point if i am stuck at a dead end
                {
                    //lastMove = "north";
                    backTrack=true;
                    nextMove = "north";
                }
            }
            else if (lastMove == "east" && east == true)//finish the path its on
            {
                nextMove = "east";
            }
            else if(lastMove == "east" && east == false)//if i cant keep going east pick a new direction
            {
                if(south==true)//south is best because it is at my left when i am facing east
                {
                    lastMove = "south";
                    nextMove="south";
                }
                else if(north==true)
                {
                    lastMove = "north";
                    nextMove="north";
                }
                else//i will get to this point if i am stuck at a dead end
                {
                    //lastMove = "west";
                    backTrack=true;
                    nextMove = "west";
                }
            }
            return nextMove;
        }
    }
}
