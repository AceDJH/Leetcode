package leetcode.editor.cn;

/**
 * @author AceDJH
 * @date 2021/9/13 4:41 下午
 * 两种格式，判断是否属于
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 32, 6, 45, 9, 87};
        int[] nums2 = new int[]{1, 23, 45, 76, 87, 9};
        int[] nums3 = new int[]{1, 23, 3, 76, 87, 9};
        System.out.println(fun(nums1));
        System.out.println(fun(nums2));
        System.out.println(fun(nums3));
    }

    public static boolean fun(int[] nums){
        return fun1(nums) || fun2(nums);
    }

    public static boolean fun1(int[] nums){
        // 0   1  2   3  4  5
        // 1, 32, 6, 45, 9, 87
        if (nums[0] < 10){
            for (int i = 1; i < nums.length; i++) {
                if (i % 2 == 1){
                    if (nums[i] < 10){
                        return false;
                    }
                }else {
                    if (nums[i] > 10){
                        return false;
                    }
                }
            }
        }else {
            for (int i = 1; i < nums.length; i++) {
                if (i % 2 == 1){
                    if (nums[i] > 10){
                        return false;
                    }
                }else {
                    if (nums[i] < 10){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 1, 23, 45, 76, 87, 9
    public static boolean fun2(int[] nums){
        if (!((nums[0] < 10 && nums[nums.length - 1] < 10) ||
                (nums[0] > 10 && nums[nums.length - 1] > 10))){
            return false;
        }
        if (nums[0] < 10){
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] < 10){
                    return false;
                }
            }
        }else {
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > 10){
                    return false;
                }
            }
        }
        return true;
    }
}
