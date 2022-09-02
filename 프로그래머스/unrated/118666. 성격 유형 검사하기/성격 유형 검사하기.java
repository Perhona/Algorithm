class Solution {
    public String solution(String[] survey, int[] choices) {
    String[] eachServey = {"RT", "CF", "JM", "AN"};
    int[] allChoices = {0, 0, 0, 0, 0, 0, 0, 0};
    int[] checkChoices = {0, 0, 0, 0};

    for (int i = 0; i < survey.length; i++) {
      if (choices[i] < 4) {
        int n = checkServey(survey[i].charAt(0));
        switch (choices[i]){
          case 3:
            allChoices[n] = allChoices[n]+1;
                break;
          case 2:
            allChoices[n] = allChoices[n]+2;
                break;
          case 1:
            allChoices[n] = allChoices[n]+3;
                break;
        }
      } else if (choices[i] > 4) {
        int n = checkServey(survey[i].charAt(1));
        allChoices[n] = allChoices[n] + choices[i] - 4;
      }
    }
    int m = 0;
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < 4; j++) {
      if (allChoices[m] < allChoices[m + 1]) {
        checkChoices[j]++;
      }
      sb.append(eachServey[j].charAt(checkChoices[j]));
      m += 2;
    }
    String answer = String.valueOf(sb);
    return answer;
  }

  public int checkServey(char c) {
    int n=0;
    switch (c) {
      case 'R':
        n= 0;
      break;
      case 'T':
        n= 1;
      break;
      case 'C':
        n= 2;
      break;
      case 'F':
        n= 3;
      break;
      case 'J':
        n=4;
      break;
      case 'M':
        n= 5;
      break;
      case 'A':
        n= 6;
      break;
      case 'N':
        n= 7;
      break;
    }
    return n;
  }
}