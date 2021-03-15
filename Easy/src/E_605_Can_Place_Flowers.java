/**
 * @Author AceDJH
 * @Date 2021/3/15 15:21
 */
public class E_605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0){
            return false;
        }
        if (flowerbed.length == 1 && n == 1){
            return flowerbed[0] == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0){
                return true;
            }
            if (flowerbed[i] == 0){
                if (i == 0){
                    if (flowerbed[1] == 0){
                        flowerbed[i] = 1;
                        --n;
                    }
                }else if (i == flowerbed.length - 1){
                    if (flowerbed[flowerbed.length - 2] == 0){
                        flowerbed[i] = 1;
                        --n;
                    }
                }else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        --n;
                    }
                }
            }
        }
        return n == 0;
    }
}
