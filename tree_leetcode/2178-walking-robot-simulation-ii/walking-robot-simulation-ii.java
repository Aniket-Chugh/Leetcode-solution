class Robot {
    private int width, height, pos, perimeter;
    private boolean moved;
    private String[] directions = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width - 1) + 2 * (height - 1);
        this.pos = 0;
        this.moved = false;
    }

    public void step(int num) {
        moved = true;
        pos = (pos + num) % perimeter;
    }

    public int[] getPos() {
        if (pos < width) {
            return new int[]{pos, 0};
        } else if (pos < width + height - 1) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos < 2 * width + height - 2) {
            return new int[]{(width - 1) - (pos - (width + height - 2)), height - 1};
        } else {
            return new int[]{0, (height - 1) - (pos - (2 * width + height - 3))};
        }
    }

    public String getDir() {
        if (!moved) return "East";
        
        // Special case: If at (0,0) after moving, direction is South
        if (pos == 0) return "South";
        
        if (pos > 0 && pos < width) {
            return "East";
        } else if (pos >= width && pos < width + height - 1) {
            return "North";
        } else if (pos >= width + height - 1 && pos < 2 * width + height - 2) {
            return "West";
        } else {
            return "South";
        }
    }
}