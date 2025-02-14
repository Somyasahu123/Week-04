package unchecked;

public class ArithmeticAndMisMatchInput {

    public static void divideTwoNumber(String a,String b){

        try{
            int num1 = Integer.parseInt(a);
            int num2 = Integer.parseInt(b);
            double divide = (double) num1/num2;
            System.out.println("Division is : " + divide);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

        divideTwoNumber("5","0");
        divideTwoNumber("5","abc");
        divideTwoNumber("5","5");
    }
}
