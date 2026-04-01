import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        // Keep track of original indexes
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        // Sort robots by position
        Arrays.sort(robots, Comparator.comparingInt(r -> r.pos));

        Stack<Robot> stack = new Stack<>();

        for (Robot robot : robots) {
            if (robot.dir == 'R') {
                stack.push(robot);
            } else { // robot.dir == 'L'
                while (!stack.isEmpty() && stack.peek().dir == 'R') {
                    Robot rightRobot = stack.peek();
                    if (rightRobot.health == robot.health) {
                        // Both die
                        stack.pop();
                        robot.health = 0;
                        break;
                    } else if (rightRobot.health > robot.health) {
                        // Left robot dies, right robot loses 1 health
                        rightRobot.health -= 1;
                        robot.health = 0;
                        break;
                    } else { 
                        // Right robot dies, left robot loses 1 health
                        stack.pop();
                        robot.health -= 1;
                    }
                }
                if (robot.health > 0) {
                    stack.push(robot);
                }
            }
        }

        // Collect results in original order
        int[] result = new int[n];
        Arrays.fill(result, 0); // 0 means robot died
        for (Robot r : stack) {
            result[r.index] = r.health;
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (result[i] > 0) {
                resList.add(result[i]);
            }
        }
        return resList;
    }

    static class Robot {
        int pos;
        int health;
        char dir;
        int index;

        Robot(int pos, int health, char dir, int index) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
            this.index = index;
        }
    }
}