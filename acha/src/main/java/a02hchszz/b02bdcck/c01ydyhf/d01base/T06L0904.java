package a02hchszz.b02bdcck.c01ydyhf.d01base;

class T06L0904 {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int left = 0;
        int l = fruits.length;
        int[] count = new int[l];
        int types = 0;
        for (int right = 0; right < l; right++) {

            // 入
            int t = fruits[right];
            if (count[t] == 0) {
                types++;
            }
            count[fruits[right]]++;
            //
            while (types > 2 && left < right){
                // 出
                count[fruits[left]]--;
                System.out.println("次数："+count[fruits[left]]);
                int fruit = count[fruits[left]];
                if (fruit == 0) {
                    types--;
                }
                System.out.println(fruits[left]+"去除,剩余types:"+types);
                left++;
            }
            // 更新
            res = Math.max(res, right-left+1);
            System.out.println("left:" + left+"right:"+right+"res:"+res+"type"+types);
        }
        return res;
    }

     public static void main(String[] args) {
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append((char)('a'+1)+1);
         stringBuilder.append("a1");
         System.out.println(stringBuilder);
     }
}
