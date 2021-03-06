import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
      animate = false;
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      String full = "";
      while(inf.hasNextLine()){
          String line = inf.nextLine();
          full+=line+'\n';
      }
      maze = ReadFile.stringToArray(full);
    }
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            int r=0;
            int c=0;
            //find the location of the S.
            for(int i=0;i<maze.length;i++){
              for(int j=0;j<maze[0].length;j++){
                if(maze[i][j]=='S'){
                  r=i;
                  c=j;
                }
              }
            }
            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
            return solve(r,c,0);
    }
    public String toString(){
      return ReadFile.arrayToString(maze);
    }
    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int r, int c, int i){ //you can add more parameters since this is private
        if(maze[r][c]=='E'){
          return 0;
        }
        if(maze[r+1][c]!='.'&&maze[r+1][c]!='@'&&maze[r+1][c]!='#'){
          maze[r][c]='@';
          int s=solve(r+1,c,i+1);
          if(s!=-1){
            return s+1;
          }
        }
        if(maze[r][c+1]!='.'&&maze[r][c+1]!='@'&&maze[r][c+1]!='#'){
          maze[r][c]='@';
          int s=solve(r,c+1,i+1);
          if(s!=-1){
            return s+1;
          }
        }
        if(maze[r-1][c]!='.'&&maze[r-1][c]!='@'&&maze[r-1][c]!='#'){
          maze[r][c]='@';
          int s=solve(r-1,c,i+1);
          if(s!=-1){
            return s+1;
          }
        }
        if(maze[r][c-1]!='.'&&maze[r][c-1]!='@'&&maze[r][c-1]!='#'){
          maze[r][c]='@';
          int s=solve(r,c-1,i+1);
          if(s!=-1){
            return s+1;
          }
        }
        maze[r][c]='.';
        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(200);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
    }

}
