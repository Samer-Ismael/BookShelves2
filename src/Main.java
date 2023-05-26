import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int smal = scan.nextInt();
        int mid = scan.nextInt();
        int big= scan.nextInt();
        int size = scan.nextInt();
        SortBooks sort = new SortBooks(2,size,big,mid,smal);
        sort.getTheShelves();
    }
}