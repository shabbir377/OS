class RRR{
    static void findWaitingTime(int processes[],int n,int bt[],int wt[],int quantam){
        int rem_bt[]=new int[n];
        int counter =0;
        int GT[]=new int[70];
        GT[0]=0;
        for (int i=0;i<n;i++)
            rem_bt[i]=bt[i];
        int t=0;
        while(true){
            boolean done=true;
            for(int i=0;i<n;i++){
                if(rem_bt[i]>0){
                    done=false;
                    if(rem_bt[i]>quantam){
                        System.out.print("P"+processes[i]+" | ");
                        t += quantam;
                        rem_bt[i] -= quantam; 
                    }
                    else{
                        System.out.print("P"+processes[i]+" | ");
                        t += rem_bt[i];
                        wt[i]=t-bt[i];
                        rem_bt[i]=0;
                    }
                    GT[counter+1]=t;
                    counter= counter +1;                    
                }
            }
            if(done)
            break;
        }
        System.out.println();
        for(int aa=0;aa<counter+1;aa++){
            System.out.print(GT[aa]+"   ");
        }
        System.out.println();
    }
    static void findTurnAroundTime(int processes[],int n,int bt[],int wt[],int tat[]){
        for(int i=0;i<n;i++){
            tat[i]=bt[i]+wt[i];
        }
    }
    static void findAvgTime(int processes[],int n,int bt[],int quantam){
        int wt[]=new int[n];
        int tat[]=new int[n];
        int total_wt=0,total_tat=0;
        findWaitingTime(processes,n,bt,wt,quantam);
        findTurnAroundTime(processes,n,bt,wt,tat);
        System.out.println("\n");
        System.out.println("Execution Table:");
        System.out.println("---------------------------------------------------------");
        System.out.println("| Process | Burst Time | Waiting Time | Turnaround Time |");
        System.out.println("---------------------------------------------------------");
        
        for (int i=0;i<n;i++){
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.print("| P"+processes[i]+"     |       "+bt[i]+"      |     "+wt[i]+"     |      "+tat[i]+"        |      "+"\n");
        }
            System.out.println("---------------------------------------------------------");
            System.out.println("average waiting time="+(float)total_wt/n);
            System.out.println("average turnaround time="+(float)total_tat/n);   
    }
    public static void main(String[] args){
        System.out.println("Gantt Chart:");
        int processes[]={1,2,3,4,5};
        int n=5;
        int burst_time[]={8,7,6,5,9};
        int quantam=5;
        findAvgTime(processes,n,burst_time,quantam);
    }
}