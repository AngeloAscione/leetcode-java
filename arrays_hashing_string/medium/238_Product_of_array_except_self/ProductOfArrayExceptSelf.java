import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        // Per una soluzione a bruteforce si può creare un array di risultati
        // Prendere ogni elemento in nums e moltiplicarlo con ongi altro elemento diverso da se stesso e salvare il
        // risultato all'interno di result

        // Soluzione a O(N^2)
        // int[] result = new int[nums.length];
        // Arrays.fill(result, 1);
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i != j) {
        //             result[j] *= nums[i]; 
        //         }
        //     }
        // }

        // Il precedente funziona ma è estremamamente lento. Possiamo fare di meglio
        // Potrebbe essere utile calcolare in un array di prefissi, il prodotto di tutti gli elementi prima di quello i-esimo
        // e poi moltiplocare ogni posizione di quell'array con gli elementi contenuti in un altro array di postfix che contiene
        // tutti i prodotti dopo l'elemento i-esimo

        int numLength = nums.length;
        int[] result = new int[numLength];

        // Possiamo usare result come array di appoggio per i prefissi
        result[0] = 1; //Impostato = 1 perché a sinistra del primo elemento non c'è nulla

        // Si scorre da sinistra verso destra
        for (int i = 1; i < numLength; i++) {
            result[i] = result[i - 1] * nums[i - 1]; //Per ogni posizione di result, calcoliamo il prodotto degli elementi che vengono prima di i-esimo
        }

        
        int postfix = 1; //Analogamente a prima, impostiamo = 1 perché a destra dell'ultimo elemento non c'è nulla  
        
        // Si scorre da destra verso sinistra
        for (int i = numLength - 1; i >= 0; i--) {
            result[i] *= postfix; //Postfix mantiene il running product di tutti gli elemetni a destra di i-esimo 
            postfix *= nums[i]; //Incrementiamo il valore di postfix
        }

        return result;
    }

    public static void main(String ...args) {
        int[] nums  = new int[]{1,2,4,6};
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}