import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int[] positives = Arrays.stream(nums).filter(i -> i > 0).toArray();
        boolean[] isThere = new boolean[positives.length];
        Arrays.fill(isThere, false);

        for (int current : positives) {
            if (current < positives.length) {
                isThere[current] = true;
            }
        }

        for (int i = 0; i < isThere.length; i++) {
            if (!isThere[i]) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
