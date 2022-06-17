class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {       
       return  dfs(root) == 0 ? res + 1 : res;//如果父节点是无覆盖状态，那么需要在父节点添加一台摄像机
    }
    public int dfs(TreeNode root) {
        if (root == null)
           return 2;//节点有覆盖
        int left = dfs(root.left);
        int right = dfs(root.right);
        //0表示无覆盖，1表示有相机，2表示有覆盖，左右节点可以组成9种状态
        //(00,01,02,10,11,12,20,21,22)
               
        //只要有一个无覆盖，父节点就需要相机来覆盖这个子节点 00,01,10,20,02
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
         //子节点其中只要有一个有相机，那么父节点就会是有覆盖的状态11,21,12
        if (left == 1 || right == 1) {
            return 2;
        }
        //还有一个就是22，两个子节点都是有覆盖的状态，父节点可以没有相机，可以借助它自己的父节点
        return 0;
    }
}
