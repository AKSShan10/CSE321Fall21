import java.util.*;
public class roundRobin {
    public static void main(String [] args)
    {
        Scanner var = new Scanner(System.in);
        int sum;
        System.out.println("Enter number of process:");
        int n = var.nextInt();

        int [] process = new int [n];
        int [] burtstTime = new int[n];//?bt
        int [] waitingTime = new int[n];
        int [] turnAroundTime  = new int[n];
        int [] a = new int[n];
        int [] storedBurstTime = new int[n];

        for(int i=0;i<n;i++){
            System.out.print("Please enter process_"+(i+1)+" burst time: ");
            burtstTime[i] = var.nextInt();
            process[i] = i+1;
            storedBurstTime[i] = burtstTime[i];
        }

        System.out.print("Please enter time quantum:");
        int q = var.nextInt();

        for(int i = 0; i<n; i++){
            a[i] = burtstTime[i];
        }

        for(int i=0; i<n; i++) {
            waitingTime[i] = 0;
        }

        do{
            for( int i=0; i<n; i++){
                if(burtstTime[i] > q){
                    burtstTime[i] = burtstTime[i]-q;

                    for(int j=0; j<n; j++){
                        if((j!=i) && (burtstTime[j]!=0))
                            waitingTime[j] = waitingTime[j]+q;
                    }
                }
                else {
                    for(int j=0; j<n; j++){

                        if((j!=i)&&(burtstTime[j]!=0))
                            waitingTime[j] = waitingTime[j]+burtstTime[i];
                    }
                    burtstTime[i]=0;
                }
            }

            sum = 0;
            for(int i = 0; i < n; i++)
                sum = sum+burtstTime[i];
        }


        while(sum != 0);
        for(int i = 0; i < n; i++) {
            turnAroundTime[i] = waitingTime[i] + a[i];
        }
        float avgWaitingTime = 0;
        float avgTurnAroundTime = 0;

        System.out.println("Process No | Burst time | Waiting Time| Turnaround Time");
        System.out.println("---------------------------------------------------------");


        for(int i = 0;i < n; i++){
            System.out.println("  "+process[i]+"\t\t\t\t"+storedBurstTime[i]+"\t\t\t  "+waitingTime[i]+"\t\t\t\t"+turnAroundTime[i]);
            avgWaitingTime+=waitingTime[i];
            avgTurnAroundTime+=turnAroundTime[i];
            System.out.println("-----------|------------ |------------|------------------");
        }

        avgWaitingTime= avgWaitingTime/n;
        avgTurnAroundTime = avgTurnAroundTime/n;



        System.out.println("Average waiting time "+avgWaitingTime);
        System.out.println("Average turn around time "+avgTurnAroundTime);
    }
}
