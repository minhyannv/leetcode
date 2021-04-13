package algorithms;

import java.util.*;

/**
 * 题目描述:
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */


public class Q207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>()); //初始化所有节点的邻居为空
        }
        int[] indegree = new int[numCourses]; //存储节点及其入度
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);//为节点添加邻居
            indegree[prerequisite[0]]++;//节点入度+1
        }
        Queue<Integer> queue = new LinkedList<>(); //存储入度为0的节点
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); //度为0的入队
            }
        }

        int visited = 0; //访问节点数
        while (!queue.isEmpty()) {
            int node = queue.poll(); //出队列
            visited++;
            ArrayList<Integer> neighbor = (ArrayList<Integer>) adjacency.get(node); //节点node的邻居集合
            for (Integer integer : neighbor) {
                indegree[integer]--; //节点邻居度数-1
                if (indegree[integer] == 0) {//度为0的节点入队
                    queue.offer(integer);
                }
            }
        }

        return visited == numCourses;
    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Q207 q = new Q207();
        boolean ans = q.canFinish(numCourses, prerequisites);
        System.out.println(ans);

    }
}
