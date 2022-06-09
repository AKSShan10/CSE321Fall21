import java.util.*;
public class srjPreemption {
    public static void main(String [] args){
        Scanner var = new Scanner(System.in);
        System.out.println("Please enter no of process:");
        int n = var.nextInt();

        int [] processId = new int[n];
        int [] arrivalTime  = new int[n];
        int [] burstTime  = new int[n];
        int [] completeTime  = new int[n];
        int [] turnAroundTime  = new int[n];
        int [] waitingTime  = new int[n];
        int [] flag  = new int[n];
        int [] storedBurstTime = new int[n];

        int st = 0, tot = 0;//tot means total number of process
        double avgWaitingTime = 0.0;
        double avgTurnAroundTime = 0.0;

        for(int i = 0; i < n; i++){
            System.out.print("Please enter process_"+(i+1)+" arrival time: ");
            arrivalTime[i] = var.nextInt();
            //System.out.println();
            System.out.print("Please enter process_"+ (i+1)+ " burst time: ");
            burstTime[i] = var.nextInt();

            processId[i] = i+1;
            storedBurstTime[i] = burstTime[i];
            flag[i] = 0;
        }

        boolean a = true;
        while(true){
            int c = n, min = 999;
            if( tot==n )
                break;

            for (int i=0; i<n; i++) {
                if ((arrivalTime[i] <= st) && (flag[i] == 0) && (burstTime[i] < min)) {
                    min = burstTime[i];
                    c=i;
                }
            }

            if ( c==n )
                st++;

            else {
                burstTime[c]--;
                st++;
                if(burstTime[c]==0){
                    completeTime[c]= st;
                    flag[c]=1;
                    tot++;
                }
            }

        }
        for(int i=0; i<n; i++) {
            turnAroundTime[i] = completeTime[i] - arrivalTime[i];
            waitingTime[i] = turnAroundTime[i] - storedBurstTime[i];
            avgWaitingTime+= waitingTime[i];
            avgTurnAroundTime+= turnAroundTime[i];
        }

        System.out.println("\nprocessId | Arrival time | Brust time| Complete time | Turnaround time | Waiting time");
        System.out.println("-----------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++) {
            System.out.println("   "+processId[i]+"\t\t\t\t"+arrivalTime[i]+"\t\t\t"+storedBurstTime[i]+"\t\t\t\t"+completeTime[i]+"\t\t\t\t"+turnAroundTime[i]+"\t\t\t\t"+waitingTime[i]);
            System.out.println("----------|--------------|------------|--------------|-----------------|---------------");
        }

        avgTurnAroundTime = avgTurnAroundTime/n;
        avgWaitingTime = avgWaitingTime/n;

        System.out.println ("Average turn around time:  "+ avgTurnAroundTime);
        System.out.println ("Average waiting Time: "+avgWaitingTime);


    }
}

