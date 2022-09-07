import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

class Solution {

  /*
    순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
    각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

    1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
    2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
    3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
    4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
    4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
     */
  public static void main(String[] args) {
//    /* 입출력 1 */
//    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//    String hand = "right";
//    /* 입출력 2 */
//    int[] numbers = {7,0,8,2,8,3,1,5,7,6,2};
//    String hand = "left";
    /* 입출력 3 */
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    String hand = "right";

    System.out.println(solution(numbers, hand));
  }

  public static String solution(int[] numbers, String hand) {
    char handCharacter = hand.toUpperCase(Locale.ROOT).charAt(0);
    strongHand sh = new strongHand();
    if (handCharacter == 'L') {
      sh.setIndex(1);
      sh.setHand('L');
    } else {
      sh.setIndex(2);
      sh.setHand('R');
    }
    StringBuilder sb = new StringBuilder();

    /* 키패드 좌표와 목표지점, 왼손, 오른손 좌표를 입력할 ArrayList */
    ArrayList<int[]> keypad = new ArrayList<>();
    ArrayList<int[]> hands = new ArrayList<>();
    hands.add(new int[]{0, 0});
    hands.add(new int[]{3, 0});
    hands.add(new int[]{3, 2});
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        keypad.add(new int[]{i, j});
      }
    }

    /* 주어진 numbers 배열만큼 반복하며 키패드 누르기 */
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 0) {
        hands.set(0, keypad.get(10));
      } else {
        hands.set(0, keypad.get(numbers[i] - 1));
      }

      System.out.println(i + "번째 for문 hands: ");
      for (int[] num : hands) { //for문을 통한 전체출력
        System.out.print(Arrays.toString(num));
      }
      System.out.println();

      if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {   // 1, 4, 7이면 무조건 왼손이 움직임
        if (numbers[i] == 0) {
          hands.set(1, keypad.get(10));
        } else {
          hands.set(1, keypad.get(numbers[i] - 1));
        }
        sb.append("L");
      } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {  // 3, 6, 9면 무조건 오른손이 움직임
        if (numbers[i] == 0) {
          hands.set(2, keypad.get(10));
        } else {
          hands.set(2, keypad.get(numbers[i] - 1));
        }
        sb.append("R");
      } else {      // 2, 5, 8, 0이면
        int result = findRoute(hands);
        System.out.println("result는 = " + result);
        if (result == -1) {
          if (numbers[i] == 0) {
            hands.set(1, keypad.get(10));
          } else {
            hands.set(1, keypad.get(numbers[i] - 1));
          }
          sb.append("L");
        } else if (result == 1) {
          System.out.println(numbers[i]);
          if (numbers[i] == 0) {
            hands.set(2, keypad.get(10));
          } else {
            hands.set(2, keypad.get(numbers[i] - 1));
          }
          sb.append("R");
        } else { // 0이면(같은 값이 나오면)
          if (numbers[i] == 0) {
            hands.set(sh.index, keypad.get(10));
          } else {
            hands.set(sh.index, keypad.get(numbers[i] - 1));
          }
          sb.append(sh.hand);
        }
      }
    }

    String answer = sb.toString();
    return answer;
  }

  private static int findRoute(ArrayList<int[]> hands) {
    int[] targetNode = hands.get(0);
    int[] leftHand = hands.get(1);
    int[] rightHand = hands.get(2);

    int left = Math.abs(leftHand[0] - targetNode[0]) + Math.abs(leftHand[1] - targetNode[1]);
    int right = Math.abs(rightHand[0] - targetNode[0]) + Math.abs(rightHand[1] - targetNode[1]);
    System.out.println("left: " + left + "right: " + right);
    if (left > right) {        // 거리가 left 가 right보다 많으면 오른손이 움직여야 함
      return 1;
    } else if (left < right) {
      return -1;
    } else {
      return 0;
    }
  }

  public static class strongHand {

    int index;
    char hand;

    public void setIndex(int index) {
      this.index = index;
    }

    public void setHand(char hand) {
      this.hand = hand;
    }
  }
}