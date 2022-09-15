import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
    List<Integer> basket = new ArrayList<>();
    int removedDolls = 0;

    for (int i = 0; i < moves.length; i++) {      
      for (int j = 0; j < board.length; j++) {    
        int n = moves[i] - 1;                     
        int doll = board[j][n];                   
        if (doll != 0) {
          basket.add(doll);
          board[j][n] = 0;      
          break;                
        }
      }
      int basketSize = basket.size();
      if (basketSize > 1) {
        if (basket.get(basketSize - 1) == basket.get(basketSize - 2)) {
          basket.remove(basketSize - 1);
          basket.remove(basketSize - 2);
          removedDolls += 2;
        }
      }
    }

    int answer = removedDolls;
    return answer;
    }
}