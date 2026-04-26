import java.util.HashSet;

public class ContainsDuplicate {
    
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i)) return true;
            hashSet.add(i);
        }
        return false;
    }

    public static void main(String ...args) {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};

        if (containsDuplicate(nums))
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }

}
