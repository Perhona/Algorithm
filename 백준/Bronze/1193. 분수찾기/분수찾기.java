import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        /* 주어진 그림을 90도 돌려보면 피라미드 같은 모양이 된다. 그 상태에서 생각해본다.
         * 1행: 블록갯수 - 1개, 분자(a) + 분모(b) = 2
         * 2행: 2개, 3 , 블록 진행방향 - 왼쪽
         * 3행: 3개, 4 , 오른쪽 ...
         * ===> n행: 블록갯수 n개, a+b = n+1, 진행방향 - 짝:왼, 홀:오
         * x번째 블록의 분수를 구하기 위해, 해당 블록이 몇행의 몇번째 값인지 구한다.
         * */
        int n = 0;
        int allBlocks = 0;
        int lineBlocks = 0;

        while (x > allBlocks) {
            // 각 행의 블록갯수를 전부 더해주면서 몇번째 행일 때 x이상이 되는지 확인한다.
            n++;
            allBlocks += n;
        }

        /* x가 n번째 속한다는 것을 알았다. n - (allBlocks - x) 는 각 행의 몇번째 값인지 알 수 있다.
        n이 짝수인지, 홀수인지에 따라 값을 출력한다.
        * 짝수라면 분자가 1, 분모가 n부터 시작
        * 홀수라면 분자가 n, 분모가 1부터 시작*/
        int index = n - (allBlocks - x);
        if (n % 2 == 0) {
            System.out.println(index + "/" + (n - index + 1));
        } else {
            System.out.println((n - index + 1) + "/" + index);
        }
    }
}
