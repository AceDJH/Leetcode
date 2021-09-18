package xhw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/8 8:20 下午
 * module2
 * module2,10,module1
 * module1,10
 *
 * 20
 */
public class Main9_8C {
    static HashMap<String, LinkedList<String>> map;
    static int result = 0;
    static HashMap<String, Boolean> visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        map = new HashMap<>();
        visited = new HashMap<>();
        while (in.hasNextLine()){
            String nextLine = in.nextLine();
            if(nextLine.length() == 0) break;
            String[] temp = nextLine.split(",");
            LinkedList<String>  list = new LinkedList<>();
            for(int i = 1; i < temp.length; i++){
                list.add(temp[i]);
            }
            map.put(temp[0], list);
            visited.put(temp[0], false);
        }
        dfs(str,0);
        System.out.println(result);
    }
    public static void dfs(String module, int time){
        LinkedList<String>  list = map.get(module);
        if(list == null || visited.get(module)) {
            result = -1;
            return;
        }
        if(list.size() == 1) {
            result = result == -1 ? -1 : Math.max(result, time + Integer.parseInt(list.get(0)));
            return;
        }

        visited.put(module, true);
        for(int i = 1; i < list.size(); i++){
            dfs(list.get(i), time + Integer.parseInt(list.get(0)));
        }
        visited.put(module, false);
    }

}
