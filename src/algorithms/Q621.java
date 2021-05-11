package algorithms;

import java.util.*;

/**
 * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ['A','A','A','B','B','B'], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * <p>
 * 输入：tasks = ['A','A','A','B','B','B'], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ['A','A','A','B','B','B']
 * ['A','B','A','B','A','B']
 * ['B','B','B','A','A','A']
 * ...
 * 诸如此类
 * 示例 3：
 * <p>
 * 输入：tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 */
public class Q621 {

    /**
     * 每次选择剩余任务数最多且处于非冷却期的任务执行
     */
    public int leastInterval(char[] tasks, int n) {

        int ans = 0;
        // <任务,剩余任务数>
        HashMap<Character, Integer> numMap = new HashMap<>();
        //<任务,冷却时间>
        HashMap<Character, Integer> timeMap = new HashMap<>();
        for (char task : tasks) {
            int num = numMap.getOrDefault(task, 0);
            numMap.put(task, num + 1);
            timeMap.put(task, 0);
        }
        while (!numMap.isEmpty()) {
            ans += 1;
            // 每次选择剩余任务数最多并且处于非冷却期的任务执行
            List<Map.Entry<Character, Integer>> list = new ArrayList(numMap.entrySet());
            list.sort((o1, o2) -> (o2.getValue() - o1.getValue())); //按任务数降序排序
            //选择任务数最多并且处于非冷却期的任务
            char taskID = '*';
            for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
                if (timeMap.get(characterIntegerEntry.getKey()) == 0) {
                    taskID = characterIntegerEntry.getKey();
                    break;
                }
            }
            //所有任务都处于冷却期,将所有任务冷却期-1，进入下一次循环
            if (taskID == '*') {
                for (Character character : timeMap.keySet()) {
                    if (timeMap.get(character) > 0) {
                        timeMap.put(character, timeMap.get(character) - 1);
                    }
                }
                continue;
            }
            //执行任务，如果任务为0，则删除任务,否则任务数-1，同时任务进入冷却
            if (numMap.get(taskID) - 1 == 0) {
                numMap.remove(taskID);
                timeMap.remove(taskID);
            } else {
                numMap.put(taskID, numMap.get(taskID) - 1);
                timeMap.put(taskID, n);
            }
            //其他任务如果冷却时间等于0，则不变，否则冷却时间-1
            for (Character character : timeMap.keySet()) {
                if (character != taskID && timeMap.get(character) > 0) {
                    timeMap.put(character, timeMap.get(character) - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
/*        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;*/
        char[] tasks = {'A', 'A', 'A', 'B', 'B'};
        int n = 2;
        Q621 q = new Q621();
        int ans = q.leastInterval(tasks, n);
        System.out.println(ans);
    }
}


