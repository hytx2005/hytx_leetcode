package month202607.week3.day21;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L71 {
    public String simplifyPath(String path) {
        // 上一级
        Deque<String> temp = new ArrayDeque<>();
        String[] paths = path.split("/");
        for(String pathss : paths){
            switch (pathss) {
                case "." -> {
                    continue;
                }
                case ".." -> {
                    if(!temp.isEmpty()){
                        temp.pop();
                    }

                }
                case "" -> {
                }
                case null, default -> temp.push(pathss);
            }
        }
        if(temp.isEmpty()){
            return "/";
        }
        StringBuilder res = new StringBuilder();
        Deque<String> temp1 = new ArrayDeque<>();
        while (!temp.isEmpty()){
            String t = temp.pop();
            temp1.push(t);
        }
        while (!temp1.isEmpty()){
            res.append("/").append(temp1.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String path = "//home/////user";
        String[] paths = path.split("/");
        System.out.println(Arrays.toString(paths));
    }
}
