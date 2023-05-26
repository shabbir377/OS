import java.util.Scanner;
public class FCFS_WITHAT {
    
        
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of processes:");
            int n = sc.nextInt();
    
            int Pi[] = new int[n];
            int bt[] = new int[n];
            int ar[] = new int[n];
            int wt[] = new int[n];
            int ct[] = new int[n];
            int ta[] = new int[n];
    
            int temp;
    
            float avgwt = 0, avgta = 0;
    
            for (int i = 0; i < n; i++) {
                System.out.println("Enter process " + (i + 1) + " burst time and arrival time :");
                bt[i] = sc.nextInt();
                ar[i] = sc.nextInt();
                Pi[i] = i + 1;
            }
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - (i + 1); j++) {
                    if (ar[j] > ar[j + 1]) {
                        temp = ar[j];
                        ar[j] = ar[j + 1];
                        ar[j + 1] = temp;
    
                        temp = bt[j];
                        bt[j] = bt[j + 1];
                        bt[j + 1] = temp;
    
                        temp = Pi[j];
                        Pi[j] = Pi[j + 1];
                        Pi[j + 1] = temp;
                    }
                }
            }
    
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ct[i] = ar[i] + bt[i];
                } else {
                    if (ar[i] > ct[i - 1]) {
                        ct[i] = ar[i] + bt[i];
                    } else {
                        ct[i] = ct[i - 1] + bt[i];
                    }
                }
    
                ta[i] = ct[i] - ar[i];
                wt[i] = ta[i] - bt[i];
                avgwt += wt[i];
                avgta += ta[i];
            }
    
            System.out.println("\nPi\tburst\tarrival\twaiting\tturnaround");
            for (int i = 0; i < n; i++) {
                System.out.println(Pi[i] + "\t" + bt[i] + "\t" + ar[i] + "\t" + wt[i] + "\t" + ta[i]);
            }
    
            System.out.println("\nAverage waiting time: " + (avgwt / n));
            System.out.println("Average turnaround time: " + (avgta / n));
    
            // Generate Gantt chart
            System.out.println("\nGantt chart:");
    
           
            
        
        int current_time=0;
        for (int i=0;i<n;i++){
            wt[i]=current_time;
            current_time+=bt[i];
            ta[i]=current_time;
            System.out.printf("| P%d ",i+1);
        }
        System.out.println("|");
        System.out.print(ta[0]);
        for (int i=0; i<n; i++){
            System.out.print("---");
            System.out.print(ta[i]);
        }
        }
    }