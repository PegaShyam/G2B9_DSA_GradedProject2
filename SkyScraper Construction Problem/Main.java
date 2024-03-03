import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the total no of floors in the building :");
        Integer levels = scan.nextInt();

        Skyscraper obj = new Skyscraper(levels);
        obj.PlaceFloors();

    }
}

class Skyscraper {
    public int levels;
    ArrayList<Integer> l1 = new ArrayList<>();

    public Skyscraper(int levels) {
        this.levels = levels;
        FloorSize();
    }

    void FloorSize()
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < levels; i++) {
            System.out.println("Enter the floor size given on day : " + (i + 1));
            l1.add(scan.nextInt());
        }
    }

    public void PlaceFloors()
    {
        int unusedfloors = levels;
        
        System.out.println("");
        System.out.println("The order of construction is as follows :");
        System.out.println("");
        
        for (int i = 0; i < levels; i++) {
            System.out.println("Day: " + (i + 1));
            List<Integer> sublist = l1.subList(0, (i + 1));

            for (int j = 0; j <= i; j++) {
                if (sublist.contains(unusedfloors)) {
                    System.out.print(unusedfloors + " ");
                    l1.set(l1.indexOf(unusedfloors), null);
                    unusedfloors--;
                }
            }
            System.out.println();
        }
    }
}
