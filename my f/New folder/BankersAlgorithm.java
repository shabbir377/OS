import java.util.*;
class BankersAlgorithm{
    int[] [] allocation;
    int [] [] max;
    int [] available;
    int [] [] need;
    int [] safeSequence;
    public void calculateNeedMatrix() {
        for (int i=0;i<allocation.length;i++){
            for (int j=0;j<allocation[0].length;j++){
                need[i][j]=max[i][j]-allocation[i][j];
            }
        }
    }
    boolean isSafe(){
        boolean[] finish=new boolean[allocation.length];
        int[] work =Arrays.copyOf(available,available.length);
        int count=0;
        while(count<allocation.length){
            boolean found=false;
            for (int i=0;i<allocation.length;i++){
                if(!finish[i]&& isNeedLessThanOrEqualWork(i,work)){
                    for (int j=0;j<allocation[0].length;j++){
                        work[j] += allocation[i][j];
                    }
                    safeSequence[count++]=i;
                    finish[i]=true;
                    found=true;
                }
            }
            if(!found){
                break;
            }
        }
        return count == allocation.length;
    }
    boolean isNeedLessThanOrEqualWork(int processIndex,int[] work){
        for (int i=0;i<allocation[0].length;i++){
            if (need[processIndex][i]>work[i]){
                return false;
            }
        }
        return true;
        
    }
    public void printSafeSequence(){
        if(isSafe()){
            System.out.println("Safe Sequence");
            for(int i=0;i<safeSequence.length;i++){
                System.out.print("P"+safeSequence[i]);
                if (i !=safeSequence.length-1 ){
                    System.out.print("->");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("No Safe Sequence Exists");
        }
    }
    void printResourceDetails(){
        System.out.println("Resource Details");
        System.out.println("+---+-------------+-------------+-------------+-------------+");
        System.out.println("  P | Allocation  |  Max        |  Available  |  Need       |");
        System.out.println("+---+-------------+-------------+-------------+-------------+");
        
        for(int i=0;i<allocation.length;i++){
            System.out.print("|"+i+"|");
            for (int j=0;j<allocation[0].length;j++){
                System.out.print(allocation[i][j]+"");
            }
            System.out.print("|");
            for (int j=0;j<max[0].length;j++){
                System.out.print(max[i][j]+"");
            }
            System.out.print("|");
            if(i==0){
                System.out.print(Arrays.toString(available)+"");
            }
            else{
                System.out.print("");
            }
            System.out.print("|");
            for (int j=0;j<need[0].length;j++){
                System.out.print(need[i][j]+"");
            }
            System.out.println("|");
            
        }
            System.out.println("+---+-------------+-------------+-------------+-------------+");
    }
    public static void main(){
        int[] [] allocation ={{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
        int[] [] max={{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
        int[] available={3,3,2};
        BankersAlgorithm obj= new BankersAlgorithm();
        obj.allocation=allocation;
        obj.max=max;
        obj.available=available;
        obj.need= new int[allocation.length][allocation[0].length];
        obj.safeSequence= new int [allocation.length];
        obj.calculateNeedMatrix();
        obj.printResourceDetails();
        obj.printSafeSequence();
        System.out.println("----------------");
    }
}

