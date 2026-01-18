class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int w = 0;

        // temp array
        int[] newArr = new int[m + n];

        // merge while both arrays have elements
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                newArr[w] = nums1[i];
                i++;
            } else {
                newArr[w] = nums2[j];
                j++;
            }
            w++;
        }

        // remaining elements of nums1
        while (i < m) {
            newArr[w] = nums1[i];
            i++;
            w++;
        }

        // remaining elements of nums2
        while (j < n) {
            newArr[w] = nums2[j];
            j++;
            w++;
        }

        // copy back to nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = newArr[k];
        }
    }
}
