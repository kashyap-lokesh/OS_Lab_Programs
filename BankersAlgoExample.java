import java.util.Scanner;

class BankersAlgoExample {

    static void findNeedValue(int needArray[][], int maxArray[][], int allocationArray[][], int totalProcess,
            int totalResources) {
        for (int i = 0; i < totalProcess; i++) {
            for (int j = 0; j < totalResources; j++) {
                needArray[i][j] = maxArray[i][j] - allocationArray[i][j];
            }
        }
    }

    static boolean checkSafeSystem(int processes[], int availableArray[], int maxArray[][], int allocationArray[][],
            int totalProcess, int totalResources) {
        int[][] needArray = new int[totalProcess][totalResources];

        findNeedValue(needArray, maxArray, allocationArray, totalProcess, totalResources);

        boolean[] finishProcesses = new boolean[totalProcess];

        int[] safeSequenceArray = new int[totalProcess];

        int[] workArray = new int[totalResources];
        for (int i = 0; i < totalResources; i++)
            workArray[i] = availableArray[i];

        int counter = 0;

        while (counter < totalProcess) {
            boolean foundSafeSystem = false;
            for (int m = 0; m < totalProcess; m++) {
                if (finishProcesses[m] == false) {
                    int j;
                    for (j = 0; j < totalResources; j++)
                        if (needArray[m][j] > workArray[j])
                            break;
                    if (j == totalResources) {
                        for (int k = 0; k < totalResources; k++)
                            workArray[k] += allocationArray[m][k];
                        safeSequenceArray[counter++] = m;
                        finishProcesses[m] = true;
                        foundSafeSystem = true;
                    }
                }
            }
            if (foundSafeSystem == false) {
                System.out.print("The system is not in the safe state because lack of resources");
                return false;
            }
        }

        System.out.print("The system is in safe sequence and the sequence is as follows: ");
        for (int i = 0; i < totalProcess; i++)
            System.out.print("P" + safeSequenceArray[i] + " ");

        return true;
    }

    // main() method start
    public static void main(String[] args) {
        int numberOfProcesses, numberOfResources;

        // create scanner class object to get input from user
        Scanner sc = new Scanner(System.in);

        // get total number of resources from the user
        System.out.println("Enter total number of processes");
        numberOfProcesses = sc.nextInt();

        // get total number of resources from the user
        System.out.println("Enter total number of resources");
        numberOfResources = sc.nextInt();

        int processes[] = new int[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++) {
            processes[i] = i;
        }

        int availableArray[] = new int[numberOfResources];
        for (int i = 0; i < numberOfResources; i++) {
            System.out.println("Enter the availability of resource" + i + ": ");
            availableArray[i] = sc.nextInt();
        }

        int maxArray[][] = new int[numberOfProcesses][numberOfResources];
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                System.out.println("Enter the maximum resource" + j + " that can be allocatd to process" + i + ": ");
                maxArray[i][j] = sc.nextInt();
            }
        }

        int allocationArray[][] = new int[numberOfProcesses][numberOfResources];
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                System.out.println("How many instances of resource" + j + " are allocated to process" + i + "? ");
                allocationArray[i][j] = sc.nextInt();
            }
        }

        // call checkSafeSystem() method to check whether the system is in safe state or
        // not
        checkSafeSystem(processes, availableArray, maxArray, allocationArray, numberOfProcesses, numberOfResources);
        sc.close();
    }
}
