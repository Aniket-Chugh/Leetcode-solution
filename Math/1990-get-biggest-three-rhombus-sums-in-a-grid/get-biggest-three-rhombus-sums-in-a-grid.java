class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        TreeSet<Integer> set=new TreeSet<>(Collections.reverseOrder());

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                set.add(grid[i][j]);

                for(int k=1;i-k>=0 && i+k<m && j-k>=0 && j+k<n;k++){

                    int sum=0;

                    int r=i-k,c=j;

                    for(int t=0;t<k;t++) sum+=grid[r++][c++];

                    for(int t=0;t<k;t++) sum+=grid[r++][c--];

                    for(int t=0;t<k;t++) sum+=grid[r--][c--];

                    for(int t=0;t<k;t++) sum+=grid[r--][c++];

                    set.add(sum);
                }
            }
        }

        int size=Math.min(3,set.size());
        int[] res=new int[size];

        int idx=0;
        for(int val:set){
            if(idx==3) break;
            res[idx++]=val;
        }

        return res;
    }
}