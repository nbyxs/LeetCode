package LeetCode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NO54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int bottom=matrix.length;
        int right=matrix[0].length;
        if(bottom==0||right==0)return list;
        --bottom;
        --right;
        int left=0;
        int top=0;
        int number=matrix[bottom>>1][right>>1];
        while (left<=right&&top<=bottom){
            for(int j=left;j<=right;++j){
                list.add(matrix[top][j]);
            }
            for(int i=top+1;i<=bottom;++i){
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    list.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    list.add(matrix[row][left]);
                }
            }


            ++left;
            --right;
            ++top;
            --bottom;
        }

        return list;

    }
}
