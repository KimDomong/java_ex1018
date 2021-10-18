import java.util.Scanner;

public class java_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번쨰 정수 입력 : ");
        int num1 = sc.nextInt();
        System.out.println("연산자 선택(1.덧셈, 2.뺄셈, 3.곱셈, 4.나눗셈 : ");
        int op = sc.nextInt();
        System.out.println("두번쨰 정수 입력 : ");
        int num2 = sc.nextInt();
        IAdd op1 = new Calculator();
        ISub op2 = new Calculator();
        IMul op3 = new Calculator();
        IDiv op4 = new Calculator();
        switch(op){
            case 1 : 
            op1.add(num1, num2);
            break;
            case 2 : 
            op2.sub(num1, num2);
            break;
            case 3 : 
            op3.mul(num1, num2); 
            break;
            case 4 : 
            op4.div(num1, num2);
            break;
        }
        sc.close();
    }
}

    interface IAdd{
        public abstract void add(int num1, int num2);
    }
    interface ISub{    
        public abstract void sub(int num1, int num2);  
    }
    interface IMul{
        public abstract void mul(int num1, int num2);  
    }
    interface IDiv{      
        public abstract void div(int num1, int num2);    
    }

    class Calculator implements IAdd,ISub,IMul,IDiv{ //다중상속
        
        @Override
        public void add(int num1, int num2){
            double result = num1+num2;
            System.out.println("result : " + result);
        }

        @Override
        public void sub(int num1, int num2){
            double result = num1-num2;
            System.out.println("result : " + result);
        }

        @Override
        public void mul(int num1, int num2){
            double result = num1*num2;
            System.out.println("result : " + result);
        }

        @Override
        public void div(int num1, int num2){
            double result = num1/num2;
            System.out.println("result : " + result);
        }
    }

