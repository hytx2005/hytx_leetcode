package year2026.month04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D05L657 {
    public boolean judgeCircle(String moves) {
        Map<Character, Character> map = Map.of('U', 'D', 'D', 'U', 'L', 'R', 'R', 'L');
        char[] sc = moves.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        count.put('U', 0);
        count.put('D', 0);
        count.put('L', 0);
        count.put('R', 0);
        for (char c : sc) {
            Character friend = map.get(c);
            if (count.get(friend) > 0) {
                count.put(friend, count.get(friend) - 1);
            } else {
                count.put(c, count.get(c) + 1);
            }
        }
        for (Character c : count.keySet()) {
            if (count.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
