package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;



class TestClass {
    private static int[] expertiseCountContainer;

    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        int numberOfWorkerN = Integer.parseInt(reader.readLine());

        char[] totalExpertiseS1 = reader.readLine().toCharArray();

        expertiseCountContainer = totalAvailiableExpertiseCount(
                totalExpertiseS1, numberOfWorkerN);

        int numberOfOrderM = Integer.parseInt(reader.readLine());

        StringBuilder outputCombination = new StringBuilder(numberOfOrderM);

        for (int i = 0; i < numberOfOrderM; i++) {
            char[] recievedOrderDetails = reader.readLine().toCharArray();
            long possibleWaysOfTeam = totalNoOfPossibleTeams(recievedOrderDetails);
            outputCombination.append(possibleWaysOfTeam + "\n");
        }

        System.out.println(outputCombination);
    }

    private static long totalNoOfPossibleTeams(char[] recievedOrderDetails) {


        if (expertiseCountContainer[(recievedOrderDetails[0] - 'A')] == 0
                || expertiseCountContainer[(recievedOrderDetails[1] - 'A')] == 0
                || expertiseCountContainer[(recievedOrderDetails[2] - 'A')] == 0) {
            return 0;
        }
        long totalWays = 1;
        for (int i = 0; i < 3; i++) {
            int currentExpertiseCount = expertiseCountContainer[(recievedOrderDetails[i] - 'A')];
            totalWays = totalWays * currentExpertiseCount;
            if(currentExpertiseCount>=1){
                expertiseCountContainer[(recievedOrderDetails[i] - 'A')]--;
            }
        }

        return (totalWays % 1000000007);
    }

    private static int[] totalAvailiableExpertiseCount(char[] totalExpertiseS1,
                                                       int numberOfWorkerN) {
        int[] expertiseContainer = new int[26];
        for (int i = 0; i < numberOfWorkerN; i++) {
            char tempExpertise = totalExpertiseS1[i];
            expertiseContainer[tempExpertise - 'A']++;
        }

        return expertiseContainer;
    }

}