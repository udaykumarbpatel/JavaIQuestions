package javaclasses;

public class SnakeSequence {
	static int[][] arr = { { 1, 3, 2, 6, 8 }, { -9, 7, 1, -1, 2 },
			{ 1, 5, 0, 1, 9 } };
	static boolean bip = true;
	static boolean bis = true;
	static boolean bjp = true;
	static boolean bjs = true;

	static void snake(int i, int j)
           	{
		        
		        
		        String s = "";
           		if(bip && i < arr.length-1  &&  Math.abs(arr[i][j] - arr[i+1][j]) == 1 )
           		{
           			s =s+arr[i][j];
           			System.out.println(s);
           			 bis=false;
           			 bip=true;
    		         bjp=true;
    		         bjs=true;
           			snake(i+1,j);
           		}
           		if ( bis && Math.abs(arr[i][j] - arr[Math.abs(i-1)][j]) == 1)
           		{
           			s =s+arr[i][j];
           			System.out.println(s);
           			bip=false;
           		    bis=true;
   		            bjp=true;
   		            bjs=true;
           			snake(Math.abs(i-1),j);
           			
           		}
           			if (bjp && j<4  &&  Math.abs(arr[i][j] - arr[i][j+1]) == 1)
           			{
           				s =s+arr[i][j];
               			System.out.println(s);
               		   bjs = false;
               		   bip=true;
   		               bis=true;
   		               bjp=true;
   		         
               		   snake(i,j+1);
           				
           			}
           				if ( bjs && Math.abs(arr[i][j] - arr[i+1][Math.abs(j-1)]) == 1)
           				{
           					s =s+arr[i][j];
                   			System.out.println(s);
                   			bjp =false;
                   			bip=true;
           		            bis=true;
           		            bjs=true;
                   			snake(i,Math.abs(j-1));		
           				}
           				else 
           				{
           					if(i==0&&j==0)
           					{
           						snake(i,j+1);
           					}
           						else 
           						{System.out.println(arr[i][j]);
           							System.exit(0);
           							}		
           				}
           					
           	}

	public static void main(String[] args) throws Exception {
		snake(0, 0);
	}
}
