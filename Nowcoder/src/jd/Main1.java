package jd;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/11 8:07 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, x, y, z;
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        Map<Character, AbstractMap.SimpleEntry<Integer, Integer>> map = new HashMap<>();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                chars[i][j] = s.charAt(j);
                map.put(chars[i][j], new AbstractMap.SimpleEntry<>(i, j));
            }
        }
        String target = scanner.next();
        int sumTime = 0;
        int startRow = 0;
        int startLine = 0;
        for (int i = 0; i < target.length(); i++) {
            sumTime += minTime(target.charAt(i), startRow, startLine, map, x, y, z);
            AbstractMap.SimpleEntry<Integer, Integer> integerIntegerSimpleEntry = map.get(target.charAt(i));
            startRow = integerIntegerSimpleEntry.getKey();
            startLine = integerIntegerSimpleEntry.getValue();
        }
        System.out.println(sumTime);
    }

    public static int minTime(Character a, int startRow, int startLine, Map<Character, AbstractMap.SimpleEntry<Integer, Integer>> map,
                       int x, int y, int z){
        AbstractMap.SimpleEntry<Integer, Integer> integerIntegerSimpleEntry = map.get(a);
        int endRow = integerIntegerSimpleEntry.getKey();
        int endLine = integerIntegerSimpleEntry.getValue();
        int time = 0;
        int distance = Math.abs(startRow - endRow) + Math.abs(startLine - endLine);
        time += x * distance;
        if (startRow != endRow && startLine != endLine){
            time += y;
        }
        time += z;
        return time;
    }
}
