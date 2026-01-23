public class Primitive_Operations{
    public static void numbers(){
    int num1 = 2;
    short num2 = 3;
    float deci = 6.7f;

    System.out.println(num1);
    System.out.println(num2);
    System.out.println(deci);

    float mult_num1 = ((float)num1 * deci);
    System.out.println(mult_num1);
    float mult_num2 = ((float)num2 * deci);
    System.out.println(mult_num2);
    int mult_num3 = ((num2 * (int)deci));
    System.out.println(mult_num3);

    char my_letter = 'A';
    System.out.println(my_letter);
    char lower_letter = (char)(my_letter + 32);
    System.out.println(lower_letter);
    }
    public static void main(String[] args){
        numbers();
    }

}