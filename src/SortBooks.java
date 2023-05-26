import java.util.Arrays;
import java.util.Scanner;

public class SortBooks {

    private int shelves;
    private int size;
    private int bigBook;
    private int midBook;
    private int smalBook;

    public SortBooks (int shelves,int size,int bigBook,int midBook, int smalBook){
        this.shelves = shelves;
        this.size = size;
        this.bigBook = bigBook;
        this.midBook = midBook;
        this.smalBook = smalBook;
    }

    public void getTheShelves (){
        int [] bigArray = makeBigBookArray(bigBook);
        int [] midArray = makeMidBookArray(midBook);
        int [] smalArray = makeSmalBookArray(smalBook);

        int[] spaceLeft = placeBigBooks(bigArray, shelves, size);
        int[] spaceLeft1 = placeMidBooks(midArray,spaceLeft);
        int[] spaceLeft2 = placeSmallBooks(smalArray, spaceLeft1);

        System.out.println(shelves);


    }
    private int [] makeSmalBookArray(int smalBooks) {
        int[] smal = new int[smalBooks];
        Arrays.fill(smal, 1);
        return smal;
    }

    private int [] makeMidBookArray(int midBooks) {
        int[] mid = new int[midBooks];
        Arrays.fill(mid, 2);
        return mid;
    }

    private int [] makeBigBookArray(int bigBooks) {
        int[] big = new int[bigBooks];
        Arrays.fill(big, 3);
        return big;
    }

    private int [] placeBigBooks (int [] bigBooks, int shelves , int size){
        int[] remainingSpace = new int[shelves];
        Arrays.fill(remainingSpace, size);
        int currentShelf = 0;

        for (int book : bigBooks) {
            if (book > remainingSpace[currentShelf]) {
                currentShelf++;
                if (currentShelf == this.shelves) {
                    remainingSpace = Arrays.copyOf(remainingSpace, this.shelves+1);
                    remainingSpace[currentShelf] = size;
                    this.shelves++;
                }
            }
            remainingSpace[currentShelf] -= book;
        }
        return remainingSpace;
    }

    private int[] placeMidBooks(int[] midBooks, int[] remainingSpace) {
        int currentShelf = 0;

        for (int book : midBooks) {
            while (currentShelf < remainingSpace.length && book > remainingSpace[currentShelf]) {
                currentShelf++;
            }
            if (currentShelf == remainingSpace.length) {
                this.shelves++;
                remainingSpace = Arrays.copyOf(remainingSpace, this.shelves);
                remainingSpace[currentShelf] = size;
            }

            remainingSpace[currentShelf] -= book;
        }

        return remainingSpace;
    }
    private int[] placeSmallBooks(int[] smallBooks, int[] remainingSpace) {
        int currentShelf = 0;
        for (int book : smallBooks) {
            while (currentShelf < remainingSpace.length && book > remainingSpace[currentShelf]) {
                currentShelf++;
            }
            if (currentShelf == remainingSpace.length) {
                this.shelves++;
                remainingSpace = Arrays.copyOf(remainingSpace, this.shelves);
                remainingSpace[currentShelf] = size;
            }
            remainingSpace[currentShelf] -= book;
        }
        return remainingSpace;
    }
    // main is here only for submitting in open kattis !
    /*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int smal = scan.nextInt();
        int mid = scan.nextInt();
        int big= scan.nextInt();
        int size = scan.nextInt();
        SortBooks sort = new SortBooks(2,size,big,mid,smal);
        sort.getTheShelves();
    }
     */
}
