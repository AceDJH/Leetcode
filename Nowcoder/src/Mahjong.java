import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/5 16:31
 * 雀魂启动！
 * https://www.nowcoder.com/question/next?pid=16516564&qid=362291&tid=41570964
 * 时间限制：C/C++ 1秒，其他语言2秒
 * <p>
 * 空间限制：C/C++ 32M，其他语言64M
 * <p>
 * 小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
 * 于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：
 * <p>
 * 总共有36张牌，每张牌是1~9。每个数字4张牌。
 * 你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
 * 14张牌中有2张相同数字的牌，称为雀头。
 * 除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
 * <p>
 * 例如：
 * 1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
 * 1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
 * 1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。
 * <p>
 * 现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
 * <p>
 * 输入描述:
 * 输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。
 * <p>
 * 输出描述:
 * 输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0
 * <p>
 * 输入例子1:
 * 1 1 1 2 2 2 5 5 5 6 6 6 9
 * <p>
 * 输出例子1:
 * 9
 * <p>
 * 例子说明1:
 * 可以组成1,2,6,7的4个刻子和9的雀头
 * <p>
 * 输入例子2:
 * 1 1 1 1 2 2 3 3 5 6 7 8 9
 * <p>
 * 输出例子2:
 * 4 7
 * <p>
 * 例子说明2:
 * 用1做雀头，组123,123,567或456,789的四个顺子
 * <p>
 * 输入例子3:
 * 1 1 1 2 2 2 3 3 3 5 7 7 9
 * <p>
 * 输出例子3:
 * 0
 * <p>
 * 例子说明3:
 * 来任何牌都无法和牌
 */
public class Mahjong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> lists = new ArrayList<>();
        int[] nums = new int[9];
        int[] helpArr = new int[9];
        for(int i = 0; i < 13; i++){
            int num = sc.nextInt();
            nums[num - 1]++;
        }
        for(int i = 0; i < 9; i++){
            if(nums[i] < 4){
                int num = i + 1;
                System.arraycopy(nums, 0, helpArr, 0, 9);
                helpArr[i]++;
                boolean isWin = canHu(helpArr, 14, false);
                if(isWin){
                    lists.add(num);
                }
            }
        }
        if(lists.isEmpty()){
            System.out.print(0);
        }else{
            System.out.print(lists.get(0));
            for(int i = 1; i < lists.size(); i++){
                System.out.print(" " + lists.get(i));
            }
        }
    }
    private static boolean canHu(int[] arr, int total, boolean hasHead){
        if(total == 0){
            return true;
        }
        if(!hasHead){
            for(int i = 0; i < 9; i++){
                if(arr[i] >= 2){
                    arr[i] -= 2;
                    if(canHu(arr, total - 2, true)){
                        return true;
                    }
                    arr[i] += 2;
                }
            }
        }else{
            for(int i = 0; i < 9; i++){
                if(arr[i] > 0){
                    if(arr[i] >= 3){
                        arr[i] -= 3;
                        if(canHu(arr, total - 3, true)){
                            return true;
                        }
                        arr[i] += 3;
                    }
                    if(i + 2 <= 8 && arr[i + 1] > 0 && arr[i + 2] > 0){
                        arr[i]--;
                        arr[i + 1]--;
                        arr[i + 2]--;
                        if(canHu(arr, total - 3, true)){
                            return true;
                        }
                        arr[i]++;
                        arr[i + 1]++;
                        arr[i + 2]++;
                    }
                }
            }
        }
        return false;
    }
}
