import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
    
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

    
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int x = 0, y = 0;
        int direction = 0; 
        int maxDistSq = 0;

        for (int cmd : commands) {
            if (cmd == -1) { 
                
                direction = (direction + 1) % 4;
            } else if (cmd == -2) { 
                
                direction = (direction + 3) % 4; 
            } else {
                
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dirs[direction][0];
                    int nextY = y + dirs[direction][1];
                    
                   
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                       
                        break;
                    }
                }
            }
        }

        return maxDistSq;
    }
}