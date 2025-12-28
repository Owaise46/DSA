class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0, h=nums.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]==target){
                int fst=mid;
                int lst=mid;
                while(fst>=1 && nums[fst-1]==target) fst--;
                while(lst<nums.length-1 && nums[lst+1]==target) lst++;
                return new int[]{fst, lst};
            }else if(nums[mid]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return new int[]{-1, -1};
    }
}
