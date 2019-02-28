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
        String full = "";
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            full+=line+'\n';
            //System.out.println(line);//hopefully you can do other things with the line
        }
        System.out.println(full);
        System.out.println(arrayToString(stringToArray(full)));
    }
  public static char[][] stringToArray(String s){
    int r=0;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='\n'){
        r++;
      }
    }
    int c=s.length()/r;
    char[][] ans = new char[r][c];
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
        ans[i][j]='_';
      }
    }
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
        ans[i][j]=s.charAt(i*c+j);
      }
    }
    return ans;
  }
  public static String arrayToString(char[][] ary){
    String ans="";
    for(int i=0;i<ary.length;i++){
      for(int j=0;j<ary[0].length;j++){
        if(ary[i][j]!='\n'){
          ans+=ary[i][j];
        }
        else{
          ans+='n';
          ans+=ary[i][j];
        }
      }
    }
    return ans;
  }
}
