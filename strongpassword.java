import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
          String special = "!@#$%^&*()-+";
          int i;
          int uc=0,lc=0,spec=0,digit=0;
          for(i=0;i<n;i++)
          {
              char ch = password.charAt(i);
              if(ch>='a' && ch<='z')
              {
                  lc++;
              }
              else if(ch>='A' && ch<='Z')
              {
                  uc++;
              }
              else if(special.indexOf(ch)>=0)
              {
                  spec++;
              }
              else if(ch>='0' && ch<='9')
              {
                  digit++;
              }
          }
          int min=0;
          if(lc==0) min++;
          if(uc==0) min++;
          if(digit==0) min++;
          if(spec==0) min++;
          return Math.max(min,6-n);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
