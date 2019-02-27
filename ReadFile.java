import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        //This is generally bad behavior

        File text = new File("Maze1.txt");
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

        //inf stands for the input file
        Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
            String line = inf.nextLine();
            System.out.println(line);//hopefully you can do other things with the line
        }
    }
  public static char[][] stringToArray(String s){
    int r=1;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)='\n'){
        r++;
      }
    }
    int c=s.length()/r;
    char[][] ans = new char[r][c];
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
        char[i][j]=s.charAt(ic+j);
      }
    }
  }
  public static String arrayToString(char[][] ary){
    String ans="";
    for(int i=0;i<ary.length;i++){
      for(int j=0;j<ary[0].length;j++){
        ans+=ary[i][j];
      }
      ans+="\n";
    }
    return ans;
  }
}
