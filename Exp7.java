import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Exp7 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw = new PrintWriter(System.out);
        System.out.println("Enter the operation");

        String str="";
        while(!(str = br.readLine()).equals(""))
        {
            pw.println("LD R0 , "+str.charAt(2));
            int i = 3;
            while(i<str.length())
            {
                pw.println(setTemp(str.charAt(i)) + " R0,R0," + str.charAt(i + 1));
                i = i+2;
            }
            pw.println("ST R0 , "+str.charAt(0));
        }

        pw.flush();

    }

    public static String setTemp(char ch)
    {
        if(ch == '-')
            return "sub";
        if(ch == '+')
            return "add";
        if(ch == '*')
            return "mul";
        if(ch == '/')
            return "div";
        return "";

    }
}

/*OUTPUT

Enter the operation
a=b+c-d
b=e+f
f=d*k/l-g
h=a+b-c*d/e

LD R0 , b
add R0,R0,c
sub R0,R0,d
ST R0 , a
LD R0 , e
add R0,R0,f
ST R0 , b
LD R0 , d
mul R0,R0,k
div R0,R0,l
sub R0,R0,g
ST R0 , f
LD R0 , a
add R0,R0,b
sub R0,R0,c
mul R0,R0,d
div R0,R0,e
ST R0 , h

*/
