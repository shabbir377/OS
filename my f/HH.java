import java.util.Scanner;
import java.util.stream.IntStream;


public class HH {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of processes: ");
        n = scan.nextInt();

        int[] process_id = IntStream.rangeClosed(1, n).toArray();
        int[] start_time = new int[n];
        int[] waiting_time = new int[n];
        int[] turnaround_time = new int[n];
        int total_waiting_time = 0;
        int total_turnaround_time = 0;
        int[] bt = new int[n];
        int[] at = new int[n];

        System.out.println("Collecting the burst time for each process: ");

        for (int i = 0; i < n; i++) {

            System.out.printf("Enter the burst time for process %d: ", i + 1);
            bt[i] = scan.nextInt();

        }

        System.out.println("Collecting the arival time for each process: ");

        for (int i = 0; i < n; i++) {

            System.out.printf("Enter the arival time for process %d: ", i + 1);
            at[i] = scan.nextInt();

        }

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (at[i] > at[j]) {

                    int temp_at = at[i];
                    at[i] = at[j];
                    at[j] = temp_at;

                    int temp_bt = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp_bt;

                    int temp_id = process_id[i];
                    process_id[i] = process_id[j];
                    process_id[j] = temp_id;

                }

            }

        }

        System.out.println("\nSorted Table");
        System.out.println("+-----+---------+-------+");
        System.out.println("| PID | Arrival | Burst |");
        System.out.println("+-----+---------+-------+");

        for (int i = 0; i < n; i++) {

            System.out.printf("| p%-2d | %7d | %5d |\n", process_id[i], at[i], bt[i]);

        }

        System.out.println("+-----+---------+-------+");

        // -----------------------------------------------------------------------------------------------------------------------------------------------------------

        System.out.println("\n");
        turnaround_time[0] = bt[0];

        for (int i = 0; i < n; i++) {

            System.out.print("-----");

        }

        for (int i = 1; i < n; i++) {

            start_time[i] = (start_time[i - 1]) + (bt[i - 1]);
            waiting_time[i] = start_time[i] - at[i];
            turnaround_time[i] = waiting_time[i] + bt[i];

        }

        System.out.println(" ");

        for (int i = 0; i < n; i++) {

            System.out.printf("| P%d ", i + 1);

        }

        System.out.println("|");
        System.out.print(waiting_time[0]);

        for (int i = 0; i < n; i++) {

            if (turnaround_time[i] < 10) {
                System.out.print("----");
            } else if (turnaround_time[i] < 100) {
                System.out.print("---");
            } else {
                System.out.print("--");
            }
            System.out.print(turnaround_time[i]);

        }
        System.out.println("\n");

        System.out.println("Process\t Burst Time\t Arival Time\t Start Time\t Waiting Time\t Turnaround Time");

        for (int i = 0; i < n; i++) {

            System.out.printf("   %d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", process_id[i], bt[i], at[i], start_time[i],
                    waiting_time[i],
                    turnaround_time[i]);
            total_waiting_time += waiting_time[i];
            total_turnaround_time += turnaround_time[i];

        }

        float avg_waiting_time = (float) total_waiting_time / n;
        float avg_turnaround_time = (float) total_turnaround_time / n;

        System.out.printf("\nAverage Waiting Time: %.2f\n", avg_waiting_time);
        System.out.printf("Average Turnaround Time: %.2f\n", avg_turnaround_time);

        scan.close();

    }

}