import java.util.Random;
import java.util.Scanner;

public class java_ex29{
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	int  com, user, result;

	
	int woncnt = 0, drawncnt = 0, lostcnt = 0;                      
	while(true){
		won womview = new won();     
		drawn drawview = new drawn();           
		lost lostview = new lost(); 

		System.out.print("가위바위보 숫자로 입력[가위(1), 바위(2), 보(3), 결과보기(4)] : ");
		user = sc.nextInt();     
		if((user != 1) && (user != 2) && (user != 3) && (user != 4)) {  
			continue;
		} else if((user == 1) || (user == 2) || (user == 3)){
			com = rand.nextInt(3) + 1;     
		           
			result = womview.wonprint(com, user);           
			if (result == 5) {                          
				woncnt++;                              
				continue;                              
			}                                  
			result = drawview.drawnprint(com, user);           
			if (result == 6) {                          
				drawncnt++;                                
				continue;                               
			}                                  
			result = lostview.lostprint(com, user); 
			if (result == 7) {
				lostcnt++; 
				continue;                                      
			}
		} else if(user == 4) {             
			System.out.println( "user 결과 : " + woncnt + "승 " + drawncnt + "무 " + lostcnt + "패" );
			sc.close();
			break;
			}	
		}
	}
}
class won {                         
	int wonprint(int com, int user) {           
		int result;                           
		if ((com == 1 && user == 2) || (com == 2 && user == 3) || (com == 3 && user == 1)){                           
			System.out.println("이겼습니다.");
			result = 5;
		} else {                                
			result = 0;                     
		} return result;
	}
}
class drawn {                              
	int drawnprint(int com, int user) {           
		int result;                         
		if (com == user) {                   
			result = 6;                    
			System.out.println(" 비겼습니다.");
		} else {                              
			result = 0;                     
		} return result;
	}
} 
class lost {                         
	int lostprint(int com, int user) {          
		int result;
		if ((com == 1 && user == 3) || (com == 2 && user == 1) || (com == 3 && user == 2)){     
			result = 7;                       
		System.out.println(" 졌습니다.");
		} else {                              
			result = 0;                     
		} return result;
	}
}

