import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /*
    * n : 주어진 도착지, count : 1을 중심으로 한겹씩 늘어날 때 마다 최소 방의 갯수(각 겹의 어디든 동일함)
    * countRooms : 1을 중심으로 한겹씩 늘어날 때 마다 각 겹의 방의 갯수(6의 배수)
    * */
    int n = Integer.parseInt(br.readLine());
    int count = 1;
    int countRooms = 1;
    
    /* while문을 통해 주어진 방 n이 몇번째 겹에 있는지 구한다. 
    * 한겹씩 넘어갈때 마다 그전 방갯수 + count*6개 만큼 방이 늘어나고,
    * 주어진 n이 방의 갯수 안에 들어가게 되면 최종 count가 해당 겹 수 이면서 최소 방의 갯수이다.
    * ex) 13은 3번째 겹에 속해있고, 최단 거리는 3이다.
    * */
    while (n > countRooms) {
      countRooms = countRooms + count*6;
      count++;
    }
    System.out.println(count);
  }
}

