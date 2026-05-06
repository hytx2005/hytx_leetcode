package a10huisu;

import java.util.ArrayList;
import java.util.List;

public class T05L22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2]; // 所有括号长度都是一样的 2n
        allSort(0, 0, n, path, ans); // 一开始没有填括号
        return ans;
    }

    private void allSort(int left, int right, int n, char[] path, List<String> ans) {
        if(right == n){ // 右括号已经填满了
            ans.add(new String(path));
            return;
        }
        if(left < n){ // 左括号还没有填满
            path[left + right] = '('; // 填左括号
            allSort(left + 1, right, n, path, ans); // 继续
        }
        if(right < left){ // 右括号还没有填满，并且右括号数量小于左括号数量
            path[left + right] = ')'; // 填右括号
            allSort(left, right + 1, n, path, ans); // 继续
        }
    }

}
