package arrays;
import java.util.*;
public class spiral_matrix {

  static public List<Integer> spiralOrder(int[][] matrix) {
        int n =matrix.length;
        int m=matrix[0].length;
        int left=0, right=m-1;
        int top=0, bottom=n-1;
        List<Integer> list=new ArrayList<>();
        while(left<=right && top<=bottom){
        //left to right
        for(int i=left;i<=right;i++){
          list.add(matrix[top][i]);
        }
        top++;

        //top to bottom
        for(int i=top;i<=bottom;i++){
          list.add(matrix[i][right]);
        }
        right--;

        //right to left
        if(top<=bottom){
        for(int i=right;i>=left;i--){
          list.add(matrix[bottom][i]);
        }
        bottom--;
        }

        //bottom to top
        if(left<=right){
        for(int i=bottom;i>=top;i--){
          list.add(matrix[i][left]);
        }
        left++;
        }
       }
       //Collections.reverse(list);
       return list;
     }
  public static void main(String[] args) {
    int[][] matrix={{1,2,3,10},{4,5,6,11},{7,8,9,12}};
    List<Integer> list=new ArrayList<>();
    list=spiralOrder(matrix);
    System.out.println(list);
  }
}
