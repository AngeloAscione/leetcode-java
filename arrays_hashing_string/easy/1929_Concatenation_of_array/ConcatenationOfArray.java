public class ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {

        if (nums.length < 1 || nums.length > 1000)
            return null;

        int[] concatenation = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > 1000) return null;
            concatenation[i] = nums[i];
            concatenation[i + nums.length] = nums[i];
        }

        return concatenation;
    }

    public static void main(String ...args){

        int[] nums = new int[]{1,4,1,2};
        int[] output = getConcatenation(nums);
        for (int i : output) {
            System.out.println(i);
        }

    }
    
    
}
