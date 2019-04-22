import java.util.Scanner;

//public class Array {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите количество элементов: ");
//        int n = in.nextInt();
//        int s[] = new int[n];
//        System.out.println("Введите элементы: ");
//        for (int i = 0; i < n; i++)
//            s[i] = in.nextInt();
//        System.out.println("Элементы, которые равны полусумме соседних эле¬ментов: ");
//        for (int i = 1; i < n-1; i++) {
//            if(s[i]==(double)(s[i-1]+s[i+1])/2){
//                System.out.println(s[i]);
//            }
//        }
//    }
//}

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество элементов: ");
        int n = in.nextInt();
        double s[] = new double[n];
        System.out.println("Введите элементы: ");
        for (int i = 0; i < n; i++)
            s[i] = in.nextDouble();
        System.out.println("Элементы, которые равны полусумме соседних эле¬ментов: ");
        for (int i = 1; i < n-1; i++) {
            if(s[i]==(s[i-1]+s[i+1])/2){
                System.out.println(s[i]);
            }
        }
    }
}


