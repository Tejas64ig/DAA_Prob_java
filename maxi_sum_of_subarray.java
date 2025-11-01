class Result { // store the result...
    int st;
    int end;
    int maxsum;
    Result(int st, int end, int maxsum) {
        this.st = st;
        this.end = end;
        this.maxsum = maxsum;
    }
}
public class maxi_sum_of_subarray {
    public static Result findMaxSubarray(int[] arr, int left, int right) {
        if (left == right) {
            return new Result(left, right, arr[left]);
        }
        int mid = left + (right - left) / 2;
        Result leftResult = findMaxSubarray(arr, left, mid);
        Result rightResult = findMaxSubarray(arr, mid + 1, right);
        Result crossResult = findMaxCrossingSubarray(arr, left, mid,
                right);
        if (leftResult.maxsum >= rightResult.maxsum && leftResult.maxsum >=
                crossResult.maxsum) {
            return leftResult;
        } else if (rightResult.maxsum >= leftResult.maxsum &&
                rightResult.maxsum >= crossResult.maxsum) {
            return rightResult;
        } else {
            return crossResult;
        }
    }
    private static Result findMaxCrossingSubarray(int[] arr, int low, int
            mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;

                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid + 1;
        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }
    public static void main(String[] args) {
        int[] arr = {2, -4, 3, 5, -1, 2, -6, 4};
        Result r = findMaxSubarray(arr, 0, arr.length - 1);
        System.out.println("Max Subarray Sum: " + r.maxsum);
        System.out.println("Start: " + r.st);
        System.out.println("End : " + r.end);
    }
}