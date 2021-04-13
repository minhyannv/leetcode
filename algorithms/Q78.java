import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */

public class Q78 {

    /**
     * 非递归方法
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(); //初始化空子集集
        res.add(list);
        for (int num : nums) {
            List<List<Integer>> subSets = new ArrayList<>();//子集集合
            for (List<Integer> re : res) {
                List<Integer> subSet = new ArrayList<>(re); //复制所有子集
                subSet.add(num);//更新子集
                subSets.add(subSet);
            }
            res.addAll(subSets);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Q78 q = new Q78();
        List<List<Integer>> ans = q.subsets(nums);
        System.out.println(ans);
    }
}


