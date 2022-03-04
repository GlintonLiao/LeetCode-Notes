/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    MountainArray arr;
    int n;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        arr = mountainArr;
        n = target;
        int peek = findPeek(0, arr.length() - 1);
        int res = findNum(0, peek);
        return res == -1 ? findNum2(peek, arr.length() - 1) : res;
    }
    
    private int findPeek(int l, int r) {
        while (r - l >= 2) {
            int mid = l + r >> 1;
            int x = arr.get(mid);
            int x1 = arr.get(mid - 1);
            int x2 = arr.get(mid + 1);
            if (x1 < x && x < x2) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l + 1;
    }
    
    private int findNum(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (arr.get(mid) >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr.get(l) == n ? l : -1;
    }
    
    private int findNum2(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (arr.get(mid) <= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr.get(l) == n ? l : -1;
    }
}
