package binary_search;

//treat 2D matrix as 1D array only
public class search_element_in_2d_array {
  
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0;i<matrix.length;i++){
            if(matrix[i][n-1]>=target){
                return solve(target, matrix[i]);
            }
        }
        return false;
    }

    public static boolean solve (int target, int[]arr){
        int l = 0;
        int r= arr.length;
        while(l<=r){
            int mid = l+(r-l)/2;

            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]>target){
                r = mid-1;
            }
            else if(arr[mid]<target){
                 l=mid+1;
            }
        }
        return false;
    }


public static void main(String[] args) {
  int[][] matrix={{1,1}};
  System.out.println(searchMatrix(matrix, 5));
}
}
