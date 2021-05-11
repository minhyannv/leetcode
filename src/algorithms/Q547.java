package algorithms;

import java.util.HashMap;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 */
public class Q547 {

    /**
     * 并查集：寻找祖先节点
     * 并查集的「查询」操作会执行「路径压缩」，一边查询一边修改结点指向是并查集的特色
     *
     */
    private int find(int x, HashMap<Integer, Integer> hashMap) {
        int root = x;
        while (hashMap.get(root) != null) {
            root = hashMap.get(root);
        }
        //路径压缩控制树高为2
        while (x != root) {
            int original_father = hashMap.get(x);
            hashMap.put(x, root);
            x = original_father;
        }
        return root;
    }

    /**
     * 并查集：合并
     */
    private void merge(int x, int y, HashMap<Integer, Integer> hashMap, int[] ans) {
        int rootX = find(x, hashMap);
        int rootY = find(y, hashMap);
        if (rootX != rootY) {
            hashMap.put(rootX, rootY);
            ans[0]--;
        }
    }

    /**
     * 并查集：添加新节点
     */
    private void add(int x, HashMap<Integer, Integer> hashMap, int[] ans) {
        if (!hashMap.containsKey(x)) {
            hashMap.put(x, null);
            ans[0]++;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        if (row == 1) {
            return 1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ans = {0};
        for (int i = 0; i < row; i++) {
            this.add(i, hashMap, ans);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    this.merge(i, j, hashMap, ans);
                }
            }
        }
        return ans[0];
    }


    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        Q547 q = new Q547();
        int ans = q.findCircleNum(isConnected);
        System.out.println(ans);

    }
}
