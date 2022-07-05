import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputMenu = -1;
        while (inputMenu != 11) {
            System.out.println("============= MENU =============");
            System.out.println("1. Check if the month exist");
            System.out.println("2. Show all months in selected season");
            System.out.println("3. Show all months with same days count");
            System.out.println("4. Show all months with min days count");
            System.out.println("5. Show all months with max days count");
            System.out.println("6. Show next season name");
            System.out.println("7. Show preview season name");
            System.out.println("8. Show all months with pair days count");
            System.out.println("9. Show all months with non-pair days count");
            System.out.println("10. Check do the month have pair days count");
            System.out.println("11. Exit");
            System.out.println("================================");
            System.out.print("---> ");
            inputMenu = sc.nextInt();
        }
    }
}
