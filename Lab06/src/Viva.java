//package banker;
/*
!!!!!!!!!!!!!!!!!!!!!!!!!!! --------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Name: Justin
Course: CS5550 Operating System
Date: Conversion from I/O I wrote to array data so that I can run it on online compiler
Project 3
Summary: This program implements a simulation of a function of an Operating System to check if system is
safe or unsafe state using the Banker's algorithm. It will read an input file and use the data from
the input file to calculate the result using Banker's algorithm.

*/


import java.util.Scanner;
import java.util.Arrays;
/*
import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
*/

public class Viva
//Banker name generates error on this jdoodle.com
//public class Banker
{

    public static int Allocation[][];
    public static int Max[][];
    public static int Need[][];
    public static int Total[];
    public static int Available[];
    public static int Work[];
    public static boolean Finish[];
    public static int Processes[];
    public static int row=0; //processes
    public static int col=0; //resources
    public static String line="";





    public static int [][] init(int array[][],int value)
    {
        //System.out.println("row: "+array.length);
        //System.out.println("col: "+array[0].length);
        if(array!=null)
        {

            for(int r=0;r<array.length;r++)
                for(int c=0;c<array[0].length;c++)
                    array[r][c]=value;
        }
        return array;
    }

    //Tracking number of row in array so use row
    public static int [] init(int array[], int value)
    {
        if(array!=null)
        {
            for(int r=0;r<array.length;r++)
                array[r]=value;
        }
        return array;
    }


    public static void print(int array[])
    {
        if(array!=null)
        {
            for(int r=0;r<array.length;r++)
                System.out.print(array[r]+" ");
        }
    }

    public static void print(boolean array[])
    {
        if(array!=null)
        {
            for(int r=0;r<array.length;r++)
                System.out.print(array[r]+" ");
        }
    }

    public static void print(int array[][],int r)
    {
        if(array!=null)
        {
            for(int c=0;c<array[0].length;c++)
                System.out.print(array[r][c]+" ");
        }
    }

    public static void printArray(int arr[])
    {

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void printArray(int arr[][])
    {

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }



    public static int [][] copyArray(int array[][], int array2[][])
    {
        //System.out.println("row: "+array.length);
        //System.out.println("col: "+array[0].length);

        if(array2!=null)
        {
            for(int r=0;r<array2.length;r++)
                for(int c=0;c<array2[0].length;c++)
                    array[r][c]=array2[r][c];
        }
        return array;
    }

    public static int [] copyArray(int array[], int array2[])
    {
        array=new int[array2.length];
        if(array2!=null)
        {

            for(int c=0;c<array2.length;c++)
                array[c]=array2[c];
        }
        return array;
    }





    public static void addAllocationToWork(int r)
    {

        for(int c=0;c<Work.length;c++)
            Work[c]=Work[c]+Allocation[r][c];

    }




    //Check if Need < Work
    public static boolean tryAcquireResource(int n[][],int w[],int r)
    {
        //Check current row -- c+0,c+1,c+2

        //boolean result=false;
        boolean result=true;
        int countTrue=0;
        for(int c=0;c<n[0].length;c++)
        {
            /*
			//if (n[r][c] < w[c]) //problem here. Solved below
			if (n[r][c] <= w[c])
			{
				//We assume Work[c]=Work[c]-Need
				//Allocation[r][c] = Allocation[r][c] + Need[c]
				//--later Need[c]=Need[c]-Request[c]
				//Work[c]=Work[c]+Allocation[r][c]
				countTrue++;
			}*/
            if (n[r][c] > w[c])
            {
                result = false;
                break;
            }
        }
        /*

		//if countTrue < col, we know that NOT all is true. So it is still false
		if(countTrue==col)
		{
			//System.out.println("countTrue==col"+countTrue+"=="+col);
			result=true;
		}
		*/
        return result;

    }


    public static boolean isAllFinished()
    {
        boolean result=true;
        if(Finish!=null)
        {
            for(int r=0;r<Finish.length;r++)
            {
                if(Finish[r]==false)//if one is false, return false
                    result=false;

            }
        }
        return result;

    }
    public static void setFinish(int r,boolean b)
    {
        Finish[r]=b;

    }


    public static boolean getFinish(int r)
    {
        return Finish[r];
    }

    public static int isDone()
    {
        int countTrue=0;
        if(Finish !=null)
        {
            for(int r=0;r<Finish.length;r++)
            {
                if(Finish[r]==true)//if one is false, return false
                {
                    //System.out.print(Finish[r]+" ");
                    countTrue++;
                }
            }
        }
        //System.out.println("isDone? Finish countTrue: "+countTrue);
        return countTrue; //When counTrue is == row count it must be all true

    }



    public static void prepareData()
    {
        System.out.println("**************************************************************************");
        System.out.println("");
        int r=0;
        int c=0;


        Allocation = new int[][]
                {
                        {0,1,0},
                        {2,0,0},
                        {3,0,2},
                        {2,1,1},
                        {0,0,2}
                };

        Max = new int[][]
                {
                        {7,5,3},
                        {3,2,2},
                        {9,0,2},
                        {2,2,2},
                        {4,3,3}
                };

        Total=new int[]{10, 5,7};
        Available=new int[]{3, 3, 2};

        row=5;
        col=3;
        Need = new int[row][col];
        Need=init(Need,0);
        Processes= new int[row];
        Processes=init(Processes,-1);


        //init
        //Need = Max - Allocation

        for(r=0;r<row;r++)
        {
            for(c=0;c<col;c++)
            {
                Need[r][c]=Max[r][c]-Allocation[r][c];
                //System.out.print(""+Need[r][c]+" ");
            }
            //System.out.println("");
        }


        System.out.println("Number of Resource Types: "+row);
        System.out.println();

        System.out.println("Number of Processes: "+col);
        System.out.println();

        System.out.println("Max");
        printArray(Max);
        System.out.println();

        System.out.println("Allocation");
        printArray(Allocation);
        System.out.println();

        System.out.println("Processes");
        printArray(Processes);
        System.out.println();

        System.out.println("Need");
        printArray(Need);
        System.out.println();

        System.out.println("Total");
        printArray(Total);
        System.out.println();

        System.out.println("Available");
        printArray(Available);
        System.out.println();

		/*
		for(c=0;c<Available.length;c++)
			W[c]=Available[c];//new int[]{3, 3, 2};

		printArray(W);
		for(c=0;c<Available.length;c++)
			Work[c]=Available[c];//new int[]{3, 3, 2};
		*/


        System.out.println("Work - Copy from Available");
        Work=new int[Available.length];
        Work=copyArray(Work,Available);
        printArray(Work);

        System.out.println();





        //Finish = false
        Finish = new boolean [row];
        System.out.println("Finish");
        for(r=0;r<row;r++)
        {
            Finish[r]=false;
            System.out.print(""+Finish[r]+" ");
        }
        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------");
    }

/*

	public static void prepareDataFromInputFile()// throws IOExceptionmFileNotFoundException
	{
		System.out.println("**************************************************************************");
		System.out.println("");
		int r=0;
		int c=0;


		String pattern1="Processes: ";//+1 character to get 5
		//Save the value 5 to row

		String pattern2="Types: ";//+1 character to get 3
		//Save the value 3 to col


		//Skip line if empty

		//Initializes ALLOCATION[][], MAX[][], Total[], Available[]
		//Create NEED[][] matrix by using NEED[][]=MAX[][][]-ALLOCATION[][]

		//If CURRENT line is Allocation, prepare Allocation[][] to loop row*5 and inner loop col * 3
		String pattern3="Allocation";//If CURRENT line is Allocation, prepare to loop number of row *5 and col * 3
		//If CURRENT line is Max, prepare Max[][] to loop row*5 and inner loop col * 3
		String pattern4="Max";
		//If CURRENT line is Total, prepare total[] to loop col * 3
		String pattern5="Total";
		//If CURRENT line is Available, prepare Available[] to loop col * 3
		String pattern6="Available";


		File file = new File("inputfile.txt");
		try
		{
			Scanner scanner = new Scanner(file);


			int lineNum = 0;

			while (scanner.hasNextLine())
			{
				line = scanner.nextLine();
				lineNum++;
				//System.out.println(line);

			    //Number of Processes: 5
				//row value
				if(line.contains(pattern1))
				{
					System.out.println("Found: "+pattern1);

					//The beginning index+the last index is the new beginning index of the target character -- 3
					int begIndex=line.lastIndexOf (pattern1)+pattern1.length();
					//System.out.println("begIndex: "+begIndex);

					String s=line.substring(begIndex);
					StringTokenizer st = new StringTokenizer(s);

					//Number of Resource Types: 3
					row = Integer.parseInt(st.nextToken());
					System.out.println("Row is: "+ row+"\n");

				}

				//col value
				if(line.contains(pattern2))
				{
					System.out.println("Found: "+pattern2);

					//The beginning index+the last index is the new beginning index of the target character -- 5
					int begIndex=line.lastIndexOf (pattern2)+pattern2.length();

					//System.out.println("begIndex: "+begIndex);
					String s=line.substring(begIndex);
					StringTokenizer st = new StringTokenizer(s);

					//Types
					col = Integer.parseInt(st.nextToken());
					System.out.println("Col is: "+ col+"\n");
				}

				//Allocation[][] value
				if(line.contains (pattern3))
				{
					Allocation = new int [row][col];

					System.out.println("Found: "+pattern3+". Look for next line. Will loop for 5 row times and 3 col times");
					line = scanner.nextLine();


					StringTokenizer st = new StringTokenizer(line);

					for(r=0;r<row;r++)
					{
						c=0;
						while(st.hasMoreTokens())
						{
							Allocation[r][c]=Integer.parseInt(st.nextToken());
							System.out.print(""+Allocation[r][c]+" ");
							//System.out.print(st.nextToken()+" ");

							c++;

						}
						line = scanner.nextLine();
						st =  new StringTokenizer(line);
						System.out.println("");
					}

					System.out.println("");

				}

				//Max[][] value
				if(line.contains(pattern4))
				{
					Max = new int [row][col];

					System.out.println("Found: "+pattern4+". Look for next line. Will loop for 5 row times and 3 col times");
					line = scanner.nextLine();

					StringTokenizer st = new StringTokenizer(line);

					for(r=0;r<row;r++)
					{
						c=0;
						while(st.hasMoreTokens())
						{
							Max[r][c]=Integer.parseInt(st.nextToken());
							System.out.print(""+Max[r][c]+" ");
							c++;

						}
						line = scanner.nextLine();
						st =  new StringTokenizer(line);
						System.out.println("");
					}

					System.out.println("");
				}

				//Total[] value
				if(line.contains (pattern5))
				{
					Total =  new int [col];

					System.out.println("Found: "+pattern5+"");
					line = scanner.nextLine();

					StringTokenizer st = new StringTokenizer(line);

					c=0;
					while(st.hasMoreTokens())
					{
						Total[c]=Integer.parseInt(st.nextToken());
						System.out.print(""+Total[c]+" ");
						c++;

					}
					System.out.println("\n");

				}

				//Available[] value
				//Work = Available

				if(line.contains (pattern6))
				{
					Available = new int [col];
					Work = new int [col];

					System.out.println("Found: "+pattern6+"");
					line = scanner.nextLine();

					StringTokenizer st = new StringTokenizer(line);

					c=0;
					while(st.hasMoreTokens())
					{
						Available[c]=Integer.parseInt(st.nextToken());
						Work[c]=Available[c];
						System.out.print(""+Available[c]+" ");
						c++;

					}
					System.out.println("\n");


					System.out.println("Work=Available");
					for (c=0; c< col; c++)
					{
						System.out.print(""+Work[c]+" " );
					}
					System.out.println("\n");
				}
			}


			Need = new int[row][col];
			Need=init(Need,0);
			Processes= new int[row];
			Processes=init(Processes,-1);

			//init
			//Need = Max - Allocation
			System.out.println("Need");
			for(r=0;r<row;r++)
			{
				for(c=0;c<col;c++)
				{
					Need[r][c]=Max[r][c]-Allocation[r][c];
					System.out.print(""+Need[r][c]+" ");
				}
				System.out.println("");
			}

			System.out.println("");


			//Finish = false
			Finish = new boolean [row];
			System.out.println("Finish");
			for(r=0;r<row;r++)
			{
				Finish[r]=false;
				System.out.print(""+Finish[r]+" ");
			}
			System.out.println("\n");
		}
		catch(FileNotFoundException e)
		{
			//handle this
		}

		System.out.println("--------------------------------------------------------------------------");


	}
*/

    public static void main(String[]args)
    {

        //Getting data from input file - Use this if copy from file
        //prepareDataFromInputFile();

        //I changed this to local arrays
        prepareData();
        row=5;
        col=3;


        int r=0; //loop each process
        int c=0; //loop each resource type

        int processOrderCount=0;
        int Work_temp[]= new int [col];

        //double the loop + 1  meaning, the loop will search for the same array if it is allowed to acquire
        //the available process. First time might fail, second time might still fail, however the last one we insert
        //the possibly deadlock notification. Ig might not be neccessary deadklock but there is a possibility it
        //might happened.
        int maxLoop=row*2+1;
        int m=0;


        do
        {
            //prevent a/the process(es) that has not done yet or deadlock from keeping forever loop. Example 7 4 5 <? 7 4 3, use < or <=
            //Say for example, the last processor request is 10 15 20 and  the total resource is only 10 15 18
            //It is obvious that we cannot grant the resource to that processor. So to prevent a forever loop, we have to quit this loop
            //to report unsafe state. For safe state it will quit automatically to the maxium number of processes requests.
            if(m==maxLoop)
                break;

            //if r==5 reset it back to 0 so that we can check if any Need < Work to be processed
            if(r==5)
                r=0;


            System.out.println("\nCurrent row is :"+r);
            if(isDone()==row)//Break the loop early after it is done
                break;


            //If true it means Need < Work with current index r, else wait for later
            if(Finish[r]==false)
            {
                //r is the current process at Need thus it is actually Need[r] < Work
                if(tryAcquireResource(Need,Work,r)==true)


                {
                    System.out.print("Need["+r+"]=");print(Need[r]);System.out.print("<=");print(Work);System.out.print("=Work");
                    System.out.println();

                    Work_temp=copyArray(Work_temp,Work);
                    addAllocationToWork(r); //Work = Work+Allocation

                    System.out.print("Work = Work+Allocation");System.out.println();
                    print(Work);System.out.print("=");print(Work_temp);System.out.print("+");print(Allocation,r);
                    System.out.println();

                    Processes[processOrderCount]=r; //Add which r is processed first
                    processOrderCount++;//Only if it is clear increase process order count;

                    Finish[r]=true; //Set each row Finished[r] to true

                    System.out.print("Finish[r]=");print(Finish);System.out.println();
                    System.out.print("Safe Sequence Processes[r]=");print(Processes);System.out.println();

                    System.out.println();
                }
                else
                {
                    //Technically it is prefrabley to have each process has its own tracker like my other program but I just want
                    //to make it simple. It is supposed to be something like processesTracker[r]+1 so each process track differently
                    //Deadlock detection
                    if(m > (row+1))
                    {
                        System.out.println("Possible Deadlock on Need["+r+"]");
                    }
                    if(m > (row*2+1))
                    {
                        System.out.println("Deadlock on Need["+r+"]");
                    }
					/*//Deadlock Recovery
					if(m > (row*3+1))
					{
						System.out.println("Kill process on Need["+r+"] to avoid deadlock");
						//Free Allocated resource to Work
					}
					*/


                    System.out.println("Wait Need["+r+"]");
                    System.out.print("Need["+r+"]=");print(Need[r]);System.out.print(">");print(Work);System.out.print("=Work");
                    System.out.println();
                }
            }
            else
            {
                System.out.println("This Need["+r+"] is done");
                System.out.print("Need["+r+"]=");print(Need[r]);System.out.print("<=");print(Work);System.out.print("=Work");
                System.out.println("\n");
            }
            m++;
            r++;

        }while (isAllFinished()==false); //If Finished is all true quit loop, Safe state

        System.out.println("");

        //Check if final Work[] values which is also total free available resources
        //is similar to Total[] free available resoures
        if (Arrays.equals(Work,Total))
            System.out.println("Safe");
        else
            System.out.println("UnSafe");

        if(isAllFinished())
        {
            System.out.print("The safe state sequence is: ");print(Processes);
        }
        else
        {
            System.out.print("Not safe state since it has -1 on at least one process: ");print(Processes);
        }

        System.out.println("\n");

    }
}