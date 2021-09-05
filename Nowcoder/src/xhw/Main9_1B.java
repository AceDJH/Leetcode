package xhw;

import java.util.*;

/**
 * @author AceDJH
 * @date 2021/9/1 7:53 下午
 */
public class Main9_1B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Map<String, Set<String>> subClassMap = new HashMap<>();
        Map<String, Set<String>> instanceMap = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            if(line.contains("subClassOf")){
                String[] subClassOfs = line.split("subClassOf");
                String key = subClassOfs[1].trim();
                Set<String> set = subClassMap.getOrDefault(key, null);
                if (set == null){
                    set = new HashSet<>();
                }
                set.add(subClassOfs[0].trim());
                subClassMap.put(key, set);
            }else{
                String[] instanceOfs = line.split("instanceOf");
                String key = instanceOfs[1].trim();
                Set<String> set = instanceMap.getOrDefault(key, null);
                if (set == null){
                    set = new HashSet<>();
                }
                set.add(instanceOfs[0].trim());
                instanceMap.put(key, set);
            }
        }
        String target = sc.next();
        if ((subClassMap.get(target) == null || subClassMap.get(target).isEmpty())
                && (instanceMap.get(target) == null || instanceMap.get(target).isEmpty())){
            System.out.println("empty");
        }
        List<String> result = new ArrayList<>(num);
        List<String> resultKey = new ArrayList<>(num);
        Set<String> subClassSet = subClassMap.get(target);
        resultKey.add(target);
        while (subClassSet != null && !subClassSet.isEmpty()){
            for (String s1 : subClassSet) {
                resultKey.add(s1);
                subClassSet.remove(s1);
                Set<String> subSet = subClassMap.get(s1);
                if (subSet != null){
                    subClassSet.addAll(subSet);
                }
            }
        }
        for (String s1 : resultKey) {
            Set<String> instances = instanceMap.get(s1);
            result.addAll(instances);
        }
        String[] strings = result.stream().sorted().toArray(String[]::new);
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}
