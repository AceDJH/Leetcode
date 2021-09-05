package hw;
import java.util.Scanner;
/**
 * @author AceDJH
 * @date 2021/8/18 8:29 下午
 */
public class HW_3 {
        static  int res=Integer.MAX_VALUE;
        static int[][] dis;
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int m=in.nextInt();
            int n=in.nextInt();
            int[][] arr=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            dis=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
            boolean[][] isVisited=new boolean[m][n];
            for(int[] temp:dis){
                dfs(isVisited,arr,x1+temp[0],y1+temp[1],x2,y2,1,temp);
            }
            System.out.println(res);
        }

        private static void dfs(boolean[][] isVisited, int[][] arr, int x1, int y1, int x2, int y2,int temp,int[] pre) {
            if(x1==x2&&y1==y2){
                res=Math.min(res,temp);
                return;
            }
            if(x1<0||x1>=arr.length||y1<0||y1>=arr[0].length||arr[x1][y1]!=0||isVisited[x1][y1]){
                return;
            }
            isVisited[x1][y1]=true;
            for(int[] d:dis){

                if(pre[0]==d[0]&&pre[1]==d[1]){
                    dfs(isVisited,arr,x1+d[0],y1+d[1],x2,y2,temp,d);
                }else{
                    dfs(isVisited,arr,x1+d[0],y1+d[1],x2,y2,temp+1,d);
                }
            }
            isVisited[x1][y1]=false;
        }
    }
