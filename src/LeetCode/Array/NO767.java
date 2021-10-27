package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NO767 {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length-1;
        int i = 0;
        while (i < bits.length - 1) {
            //碰到1跳两步，碰到0跳一步
            i += bits[i] + 1;
        }

        return i == bits.length - 1;


}
}
