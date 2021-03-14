import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author AceDJH
 * @Date 2021/3/14 16:29
 */
public class M_210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0){
            return new int[0];
        }
        // 保存i节点的所有后继节点
        // HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // 保留各节点的入度
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        // int[] inDegree = new int[numCourses];
        // for (int[] p : prerequisites) {
        //     adj[p[1]].add(p[0]);
        //     inDegree[p[0]]++;
        // }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            res[count++] = temp;
            for(Integer successor : adj[temp]){
                inDegree[successor]--;
                if (inDegree[successor] == 0){
                    queue.add(successor);
                }
            }
        }
        if (count == numCourses){
            return res;
        }
        return new int[0];
    }
}
