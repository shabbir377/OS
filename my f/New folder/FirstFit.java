class FirstFit
{
    static void firstfit(int blockSize[], int m, int processSize[], int n)
    {
        
        int alloction[] = new int[n];
        
        for(int i = 0; i< alloction.length; i++)
        {
            alloction[i] = -1;
        }
        
        for (int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(blockSize[j] >= processSize[i] && alloction[j]==-1)
                {
                    alloction[i] = j;
                    blockSize[j] -= processSize[i];
                    System.out.println(j);
                    break;
                }
            }
            
        }
        
        System.out.println("\nProcess No. \tProcess Size\tAllocated Block no.");
        for(int i = 0; i<n; i++)
        {
            System.out.print(" "+(i + 1) + "\t\t" + processSize[i]+"\t\t");
            if(alloction[i] != -1)
            {
                System.out.print(alloction[i] + 1 +"\t\t");
            }
            else
            {
                System.out.print("not allocated");
            }
            System. out.println ();
        }
    }
    
    public static void main (String[] args)
    {
        int blockSize[]={100,500,200,300,600,300};
        int processSize[]={212,417,112,426,100};
        int m = blockSize.length;
        int n=processSize.length;
        
        System.out.println("Block sizes:");
        for (int i=0;i<m;i++)
        {
            System.out.println("Block"+(i+1)+":"+blockSize[i]);
        }
        System.out.println("Process sizes:");
        for (int i=0;i<n;i++)
        {
            System.out.println("Process"+(i+1)+":"+processSize[i]);
        }
        System.out.println();
        firstfit(blockSize, m, processSize, n);

    }
}