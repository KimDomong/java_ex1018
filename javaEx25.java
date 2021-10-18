import java.util.Random;
import java.util.Scanner;

public class javaEx25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		Place placeView = new Place();   
		Location locaView = new Location();  
		//Fishing fishView = new Fishing();

		placeView.place(rand);                  
		locaView.location(placeView.arr);
		//fishView.fishing(placeView.arr);
		sc.close();
	}
}

class Place {                   
        int arr[][] = new int[5][5];
        int[][] place(Random rand) {
            for(int i =0; i<3; i++){	
                int fishplace1 = rand.nextInt(5);
                int fishplace2 = rand.nextInt(5);		
                if(arr[fishplace1][fishplace2] == 1)
                    i--;
                else
					arr[fishplace1][fishplace2] = 1; 
        }
			return arr;
    }
}

class Location { 
	int[][] location(int[][] arr){
	    Scanner sc = new Scanner(System.in);
		//int loca1 = 0, loca2 = 0, count = 3;
		int loca1 = 0, loca2 = 0, count = 3, f1=0, f2=0;
		while(true){
			System.out.print("던질위치 입력(2개 수(0~4)) : ");
			loca1 = sc.nextInt();
			loca2 = sc.nextInt();
			if(loca1 < 0 || loca1 > 4 || loca2 < 0 || loca2 > 4) {
				System.out.println("범위를 넘어갔습니다 다시 입력하세요");
			} else{
            	if(arr[loca1][loca2] == 1){ 
            		arr[loca1][loca2] = 0;           
            		System.out.printf("남은 물고기 : %d\n", --count);
         	    }
            break;
            }
		}
		//return arr;
	//}
//}

//class Fishing{
	//void fishing(int[][] arr) {
//		int loca1 = 0, loca2 = 0, count = 3, f1=0, f2=0;
	//	Scanner sc = new Scanner(System.in);
			
		while(true){
        	for(f1=0; f1<5; f1++){
                for(f2=0; f2<5; f2++){
					if(f1 == loca1 && f2 == loca2) 
                        System.out.print(" ◎ ");
                    else if(arr[f1][f2] == 1)
                        System.out.print(" ■ ");
                    else
                        System.out.print(" □ ");
                }
                System.out.println();
            }
        	 System.out.print("방향 입력(1.위 2.아래 3.왼쪽 4. 오른쪽) : ");
             int dr = sc.nextInt();
             //1,2,3,4 다른값 이면 다시 입력(잘못입력 방지)
             if(dr > 4 || dr < 0){
                 continue;
             }
             switch (dr) {
             case 1: // 위
            	 loca1 -- ;
            	 if(loca1 <0)
            	 {
            		 System.out.println("더이상 위로 움직일 수 없습니다.");
            		 loca1 = 0;
            	 }
            	 break;
             case 2: // 아래
            	 loca1 ++ ;
            	 if(loca1 > 4)
            	 {
            		 System.out.println("더이상 아래로 움직일 수 없습니다.");
            		 loca1 = 4;
            	 }
            	 break;
             case 3: // 왼쪽
            	 loca2 -- ;
            	 if(loca2 <0)
            	 {
            		 System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
            		 loca2 = 0;
            	 }
            	 break;
             case 4: // 오른쪽
            	 loca2 ++ ;
            	 if(loca2 >4)
            	 {
            		 System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
            		 loca2 = 4;
            	 }
            	 break;
             default :
            	 System.out.println("잘못된 입력입니다.");
            	 break;
             }
             //물고기 체크
             if(arr[loca1][loca2] == 1)
        	 {
            	 arr[loca1][loca2] = 0;
        		 System.out.printf("남은 물고기 : %d\n", --count);
        	 }
             if(count <= 0)
             {
            	 System.out.println("모든 물고기를 잡았습니다.");
            	 break;
             }
        }
		return arr;
	}
}
