import java.util.Scanner;
public class FCFS{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=50;
        System.out.print("Enter the number of processes:");
        n=sc.nextInt();
        int[] waiting_time=new int[n];
        int[] turnaround_time=new int[n];
        int total_waiting_time=0;
        int total_turnaround_time=0;
        int[] bt=new int[n];
        System.out.println("Collecting the burst time for each process:");
        
        for (int i=0; i<n; i++){
            System.out.printf("Enter the burst time for process %d: ", i+1);
            bt[i]=sc.nextInt();
        }
        waiting_time[0]=0;
        turnaround_time[0]=bt[0];
        
        //Step 3: Print header for the output table and Gantt Chart
      
        
        int current_time=0;
        for (int i=0;i<n;i++){
            waiting_time[i]=current_time;
            current_time+=bt[i];
            turnaround_time[i]=current_time;
            System.out.printf("| P%d ",i+1);
        }
        System.out.println("|");
        System.out.print(waiting_time[0]);
        for (int i=0; i<n; i++){
            System.out.print("---");
            System.out.print(turnaround_time[i]);
        }
        System.out.println("");
        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        
        for (int i=0; i<n; i++){
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\n", i+1, bt[i], waiting_time[i],turnaround_time[i]);
            total_waiting_time+=waiting_time[i];
            total_turnaround_time+=turnaround_time[i];
        }
        
        float avg_waiting_time=(float) total_waiting_time/n;
        float avg_turnaround_time=(float) total_turnaround_time/n;
        
        System.out.printf("Average Waiting Time:%.2f\n",avg_waiting_time);
        System.out.printf("Average Turnaround Time:%.2f\n", avg_turnaround_time);
        sc.close();
    }
}