class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ind = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ind[i] = i;
            ans.add(0);
        }
        solve(ind, 0, n-1, ans, nums);
        return ans;
    }
    private void solve(int[] ind, int l, int r, List<Integer> list, int[] nums) {
        if(l>=r) return;
        int mid = l + (r-l)/2;
        solve(ind, l, mid, list, nums);
        solve(ind, mid+1, r, list, nums);
        helper(ind, l, mid, r, list, nums);
    }
    private void helper(int[] ind, int l, int m, int r, List<Integer> list, int[] nums) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        System.arraycopy(ind, l, left, 0, n1);
        System.arraycopy(ind, m+1, right, 0, n2);
        int i=0, j=0, k=l;
        while(i < n1 && j < n2) {
            if(nums[left[i]] <= nums[right[j]]) {
                ind[k++] = left[i];
                list.set(left[i], list.get(left[i])+j);
                i++;
            } else ind[k++] = right[j++];
        }
        while(i < n1) {
            ind[k++] = left[i];
            list.set(left[i], list.get(left[i])+j);
            i++;
        }
        while(j < n2) {
            ind[k++] = right[j++];
        }
    }
}