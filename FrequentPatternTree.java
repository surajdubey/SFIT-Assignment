import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class FrequentPatternTree {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ar[][] = {
                {1,2,5} ,
                {2,4} ,
                {2,3} ,
                {1,2,4} ,
                {1,3} ,
                {1,3} ,
                {1,3,2,5} , 
                {1,3} ,
                {1,2,3}
        };
        
        System.out.println("Initial Array is");
        display(ar);
        
        int count [] = new int[6];
        
        for(int tp[] : ar)
        {
            for(int t : tp)
                count[t]++;
        }
        
        System.out.println("C1 : ");
        System.out.println("Items \t Support");
        for(int i=1;i<count.length;i++)
        {
            System.out.println("  "+i+"   \t   "+count[i]);
        }
        
        System.out.println("Enter Minimum Suppport");
        int sup = Integer.parseInt(br.readLine());
        
        
        for(int i=1;i<count.length;i++)
        {
            if(count[i]<sup)
            {
                count[i] = -1;
            }
        }
        System.out.println("\n L1 : ");
        System.out.println("Items \t Support");
        for(int i=1;i<count.length;i++)
        {
            if(count[i]!=-1)
            {
                System.out.println("  "+i+"   \t   "+count[i]);
            }
        }
        
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[i].length;j++)
            {
                if(count[ar[i][j]]==-1)
                {
                    ar[i][j] = -1;
                }
            }
        }
        
 
        for(int i=0;i<ar.length;i++)
        {
            //Arrays.sort(ar[i] , Collections.reverseOrder());
            Arrays.sort(ar[i]);
            if(ar[i][0] == -1)
            {
                for(int j=1;j<ar[i].length;j++)
                    ar[i][j-1] = ar[i][j];
                ar[i][ar[i].length-1] = -1;
            }
            
        }
        
        System.out.println("\n Updated Table is ");
        display(ar);
        
        System.out.println("\n Pattern Tree");
         for(int i=0;i<ar.length;i++)
            {
                System.out.println("Root");
                for(int j=0;j<ar[i].length;j++)
                {
                    if(ar[i][j]!=-1)
                    {
                        int c = 1;

                        for(int kl = 0;kl<i;kl++)
                        {
                            if(j<ar[kl].length)
                            {
                                    if(ar[kl][j] == ar[i][j])
                                    c++;
                                
                            }
                        }

                        System.out.println(" | \n Item "+ar[i][j]+" with count "+c);
                    }
                }
                System.out.println("");
            }
           
        
    }
    
    static void display(int ar[][])
    {
        int k = 1;
        for(int tp [] : ar)
        {
            System.out.print("T"+k+":\t");
            k++;
            for(int t : tp)
            {
                if(t!=-1)
                System.out.print(t+"\t");
            }
            System.out.println("");
        }
    }
}

/* OUTPUT
Initial Array is
T1:	1	2	5	
T2:	2	4	
T3:	2	3	
T4:	1	2	4	
T5:	1	3	
T6:	1	3	
T7:	1	3	2	5	
T8:	1	3	
T9:	1	2	3	
C1 : 
Items 	 Support
  1   	   7
  2   	   6
  3   	   6
  4   	   2
  5   	   2
Enter Minimum Suppport
4

 L1 : 
Items 	 Support
  1   	   7
  2   	   6
  3   	   6

 Updated Table is 
T1:	1	2	
T2:	2	
T3:	2	3	
T4:	1	2	
T5:	1	3	
T6:	1	3	
T7:	1	2	3	
T8:	1	3	
T9:	1	2	3	

 Pattern Tree
Root
 | 
 Item 1 with count 1
 | 
 Item 2 with count 1

Root
 | 
 Item 2 with count 1

Root
 | 
 Item 2 with count 2
 | 
 Item 3 with count 1

Root
 | 
 Item 1 with count 2
 | 
 Item 2 with count 2

Root
 | 
 Item 1 with count 3
 | 
 Item 3 with count 2

Root
 | 
 Item 1 with count 4
 | 
 Item 3 with count 3

Root
 | 
 Item 1 with count 5
 | 
 Item 2 with count 3
 | 
 Item 3 with count 1

Root
 | 
 Item 1 with count 6
 | 
 Item 3 with count 4

Root
 | 
 Item 1 with count 7
 | 
 Item 2 with count 4
 | 
 Item 3 with count 2

*/
