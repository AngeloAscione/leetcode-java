import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequence {
    
    public static int longestConsecutive(int[] nums) {

        // La prima soluzione che mi è venuta in mente è quella di utilizzare una PriorityQueue che mi
        // Consentisse di tenere ordinati gli elementi

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for (int n : nums) {
        //     minHeap.add(n);
        // }

        // int maxConsecutive = 0;
        // int running = 1;

        // while (minHeap.size() != 0) {

        //     Integer head = minHeap.poll();
        //     Integer newHead = minHeap.peek();

        //     if (newHead == null) break;
        //     if (newHead == head) continue;

        //     if (newHead - head == 1) {
        //         running++;
        //         if (running > maxConsecutive)
        //             maxConsecutive = running;
        //     } else {
        //         running = 1;
        //     }
        // }

        // L'algoritmo precedente funziona ma è lento O(N log N). Sarebbe uguale a sortare l'array di partenza
        // Per migliorare l'efficienza posso utilizzare un HashSet, riducendo il costo delle operazioni
        // a O(1)

        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            hashSet.add(n);
        }
        int consecutive = 0;
        //ora controllo per ogni numero se esiste il suo consecutivo
        for (int n : nums) {
            if (!hashSet.contains(n - 1)) { //Faccio in modo di skippare quelli già considerati e cerco solo inizio di sequenza
                int runningCount = 1;
                while (hashSet.contains(n + runningCount)) {
                    runningCount++;
                }
                consecutive = Math.max(runningCount, consecutive);
            }
        }
        return consecutive;
    }


}
