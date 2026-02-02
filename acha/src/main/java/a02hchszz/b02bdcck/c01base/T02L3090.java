package a02hchszz.b02bdcck.c01base;

 class T02L3090 {
    public int maximumLengthSubstring(String s) {
        int res = 0;
        // 数据初步处理 转数组
        char[] sChar = s.toCharArray();
        int l = sChar.length;
        // 使用int数组记录出现次数
        int[] count = new int[128];

        // 记录右边界
        int right = -1;
        for(int i = 0 ; i < l ; i++){
            // 入
            while(right+1<l && count[sChar[right+1]] < 2){
                count[sChar[right+1]]++;
                right++;
            }
            // 更新
            res = Math.max(res,right-i+1);

            // 出
            count[sChar[i]]--;
        }
        return res;
    }
}
