public class Main {
    public static void main(String[] args) {
        boolean[] checkSelfNum = new boolean[10001];    // index값이 셀프넘버인지 표시해 줄 배열

        for (int i=1;i<=10001;i++){     // 1부터 10000까지 반복하며
            int n = d(i);               // i는 n의 생성자. d(i)로 만들어 지지 않는 n을 찾는 것

            if (n<10001){               // 생성자로서 만들어진 n은 해당 인덱스 값을 true로 변경하여 표시
                checkSelfNum[n] = true;
            }
        }

        for (int j=1;j<10001;j++){
            if (!checkSelfNum[j]){
                System.out.println(j);
            }
        }
    }

    static int d(int n) {

        if (n < 10) {
            return n + n;
        } else if (n < 100) {
            return n + n % 10 + (n / 10) % 10;
        } else if (n < 1000) {
            return n + n % 10 + (n / 10) % 10 + (n / 100) % 10;
        } else if (n < 10000) {
            return n + n % 10 + (n / 10) % 10 + (n / 100) % 10 + (n / 1000) % 10;
        } else {
            return n + 1;
        }
    }
}
