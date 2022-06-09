import java.util.*;
public class Task02 {
    public static void main(String [] args) {
        Scanner var = new Scanner(System.in);
        System.out.println("Please enter no of process:");
        int n = var.nextInt();

        int [] process = new int[n];
        int [] processPriority = new int [n];
        //int [] arrivalTime  = new int[n];
        int [] burstTime  = new int[n];
        //int [] completeTime  = new int[n];
        int [] turnAroundTime  = new int[n];
        int [] waitingTime  = new int[n];


        //int st = 0, tot = 0;//tot means total number of process
        int x;
        int avgWaitingTime = 0;
        int avgTurnAroundTime = 0;

        for(int i=0; i<n; i++) {
            //System.out.print("Please enter process_"+(i+1)+" arrival time: ");
            //arrivalTime[i] = var.nextInt();
            System.out.print("Please enter process_"+(i+1)+" burst time: ");
            burstTime[i] = var.nextInt();
            System.out.print("Please enter process_"+ (i+1)+ " process priority: ");
            processPriority[i] = var.nextInt();
            process[i] = i+1;
        }


        for(int i = 0; i< n-1;i++) {

            for(int j=i+1; j<n; j++) {
                if(processPriority[i]>processPriority[j]) {
                    x = processPriority[i];
                    processPriority[i] = processPriority[j];
                    processPriority[j] = x;
                    x = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = x;
                    x = process[i];
                    process[i]= process[j];
                    process[j] = x;
                }
            }
        }
        //ompleteTime[0] = arrivalTime[0]+ burstTime[0];
        waitingTime[0] = 0;
        avgWaitingTime = 0;
        turnAroundTime[0] = burstTime[0];//burstTime[0];
        avgTurnAroundTime = turnAroundTime[0];

        for(int i=1;i<n;i++) {
            //completeTime[i] = burstTime[i]+completeTime[i];
            waitingTime[i] = turnAroundTime[i-1];
            avgWaitingTime = avgWaitingTime+waitingTime[i];
            turnAroundTime[i] = waitingTime[i] + burstTime[i];
            avgTurnAroundTime = avgTurnAroundTime+turnAroundTime[i];
        }


        System.out.println("\nprocessId | Brust time| Process priority | Turnaround time | Waiting time");
        System.out.println("-----------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++) {
            System.out.println("   "+process[i]+"\t\t\t\t"+burstTime[i]+"\t\t\t"+processPriority[i]+"\t\t\t\t"+turnAroundTime[i]+"\t\t\t\t"+waitingTime[i]);
            System.out.println("----------|--------------|------------|--------------|-----------------|---------------");
        }

        double favgTurnAroundTime = (double)(avgTurnAroundTime/n);
        double favgWaitingTime = (double)(avgWaitingTime/n);

        System.out.println ("Average turn around time:  "+ favgTurnAroundTime);
        System.out.println ("Average waiting Time: "+favgWaitingTime);


    }
}

