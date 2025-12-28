/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l=0, n=mountainArr.length(), h=n-1;
        while(l<h){
            int mid=(l+h)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                h=mid;
            }else{
                l=mid+1;
            }
        }
        int peek=l;

        int index=binarySearch(mountainArr, target, 0, peek, true); 
        if(index!=-1) return index;

        return binarySearch(mountainArr, target, peek+1, n-1, false);
    }
     public int binarySearch( MountainArray mountainArr, int target, int l, int h, boolean asc) {
        while(l<=h){
            int mid=(l+h)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            if(asc){
                if(mountainArr.get(mid)>target) h=mid-1; 
                else l=mid+1;
            }else{
                if(mountainArr.get(mid)>target) l=mid+1;
                else h=mid-1;
            }
        }
        return -1;
    }
}
