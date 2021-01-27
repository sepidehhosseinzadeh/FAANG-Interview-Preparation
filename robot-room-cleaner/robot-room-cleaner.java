/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[] dx = new int[] {0,1,0,-1};
    int[] dy = new int[] {1,0,-1,0};
    public void cleanRoom(Robot b) {
        go(b, 0,0, 0,new HashSet<>());
    }
    void go(Robot b, int x, int y, int dir, HashSet<String> vis) {
        b.clean();
        vis.add(x+","+y);
        for(int i = 0; i < 4; i++) {
            int td = (i+dir)%4;
            int tx = x+dx[td], ty = y+dy[td];
            if(!vis.contains(tx+","+ty) && b.move()) {
                go(b, tx, ty, (i+dir)%4, vis);
                goback(b);
            }
            b.turnRight();
        }
    }
    void goback(Robot b) {
        b.turnRight();
        b.turnRight();
        b.move();
        b.turnRight();
        b.turnRight();
    }
}