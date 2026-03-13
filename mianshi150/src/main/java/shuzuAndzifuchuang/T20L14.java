package shuzuAndzifuchuang;

public class T20L14 {

    /**
     * 横向对比，每次对比两个字符串，得到最长公共前缀，依次类推
     * @param strs
     * @return {@link String }
     */
    public String longestCommonPrefix1(String[] strs) {
        String res = strs[0];
        if (strs.length == 1) {
            return res;
        }
        for (int i = 1; i < strs.length; i++) {
            res = longestPre(res, strs[i]);
        }
        return res;
    }

    public String longestPre(String str1, String str2) {
        	int minLen = Math.min(str1.length(), str2.length());
        	int index = 0;
        	while (index < minLen && str1.charAt(index) == str2.charAt(index)) {
        		index++;
        	}
        	return str1.substring(0, index);
    }

    /**
     * 二分查找，先找到字符串数组中最短的字符串长度，然后对字符串进行二分查找，判断前mid个字符是否相同
     * @param strs
     * @return {@link String }
     */
    public String longestCommonPrefix2(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int left = 0,right = minLen-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isCommonPrefix(strs,left,mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0,left);
    }

    public boolean isCommonPrefix(String[] strs,int begin,int end){
        String str0 = strs[0].substring(begin,end+1);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i].substring(begin,end+1);
            if(!str.equals(str0)){
                return false;
            }
        }
        return true;
    }
}
