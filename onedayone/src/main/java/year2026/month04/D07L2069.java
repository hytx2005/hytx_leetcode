package year2026.month04;

public class D07L2069 {
    static class Robot {
        int width;
        int height;
        int x,y;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int d;
        int mod = 1;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.mod = 2 * (width + height) - 4;
            this.x = 0;
            this.y = 0;
            this.d = 0;
        }

        public void step(int num) {
            num = num % mod;
            if(num == 0){
                if(x + y == 0){
                    d = 3;
                }
                return;
            }
            while (num > 0){
                switch (d) {
                    case 0 -> {
                        int cur = Math.min(x + num, width - 1);
                        num -= cur - x;
                        if (num > 0) {
                            d = (d + 1) % 4;
                        }
                        x = cur;
                    }
                    case 1 -> {
                        int cur = Math.min(y + num, height - 1);
                        num -= cur - y;
                        if (num > 0) {
                            d = (d + 1) % 4;
                        }
                        y = cur;
                    }
                    case 2 -> {
                        int cur = Math.max(x - num, 0);
                        num -= x - cur;
                        if (num > 0) {
                            d = (d + 1) % 4;
                        }
                        x = cur;
                    }
                    case 3 -> {
                        int cur = Math.max(y - num, 0);
                        num -= y - cur;
                        if (num > 0) {
                            d = 0;
                        }
                        y = cur;
                    }
                    default -> {
                        break;
                    }
                }
            }
        }

        public int[] getPos() {
            return new int[]{x,y};
        }

        public String getDir() {
            return switch (d) {
                case 0 -> "East";
                case 1 -> "North";
                case 2 -> "West";
                case 3 -> "South";
                default -> "";
            };
        }
    }
}
