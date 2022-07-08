import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputMenu = -1;
        while (inputMenu != 11) {
            System.out.println(ConsoleColors.GREEN + "================= MENU =================" + ConsoleColors.RESET);
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
            System.out.println(ConsoleColors.RED + "11. Exit" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "========================================" + ConsoleColors.RESET);
            System.out.print("---> ");
            inputMenu = sc.nextInt();

            if (inputMenu == 1) {
                checkMonthExist();
            } else if (inputMenu == 2) {
                showAllMonthsSelectedSeason();
            } else if (inputMenu == 3) {
                showAllMonthsWithSameDay();
            } else if (inputMenu == 4) {
                showAllMonthsMinDays();
            } else if (inputMenu == 5) {
                showAllMonthsMaxDays();
            } else if (inputMenu == 6) {
                showNextSeason();
            } else if (inputMenu == 7) {
                showPreviewSeason();
            } else if (inputMenu == 8) {
                showMonthsWithPairDays();
            } else if (inputMenu == 9) {
                showMonthsWithNonPairDays();
            } else if (inputMenu == 10) {
                showMonthHavePairDays();
            } else if (inputMenu == 11) {
                System.out.println(ConsoleColors.YELLOW + "Good luck. Thanks for all." + ConsoleColors.RESET);
            } else {
                System.out.println(ConsoleColors.RED + "Error. Bad input." + ConsoleColors.RESET);
            }
        }
    }

    private static void showMonthHavePairDays () {
        System.out.print("Please input month to check:");
        Scanner sc2 = new Scanner(System.in);
        String inputMonth = sc2.nextLine().toUpperCase();
        for (Months value : Months.values()) {
            if (inputMonth.equals(value.name())) {
                if (value.getDays() % 2 == 0) {
                    System.out.println(value.name() + " have pair days count");
                }
                else {
                    System.out.println(value.name() + " have non-pair days count");
                }
            }
        }
        pause();
    }

    private static void showMonthsWithNonPairDays() {
        for (Months value : Months.values()) {
            if (value.getDays() % 2 != 0) {
                System.out.println(value.name());
            }
        }
        pause();
    }

    private static void showMonthsWithPairDays() {
        for (Months value : Months.values()) {
            if (value.getDays() % 2 == 0) {
                System.out.println(value.name());
            }
        }
        pause();
    }

    private static void showPreviewSeason() {
        System.out.print("Please input season name:");
        Scanner sc2 = new Scanner(System.in);
        String inputSeason = sc2.nextLine().toUpperCase();
        Seasons[] arrSeason = Seasons.values();
        // Find input season and get next season name from array
        for (Seasons value : Seasons.values()) {
            if (inputSeason.equals(value.name())) {
                if (value.ordinal() == 0) {
                    System.out.println("Preview season is: " + arrSeason[Seasons.values().length-1]);
                } else {
                    System.out.println("Preview season is: " + arrSeason[value.ordinal()-1]);
                }
                break;
            }
        }
        pause();
    }

    private static void showNextSeason() {
        System.out.print("Please input season name:");
        Scanner sc2 = new Scanner(System.in);
        String inputSeason = sc2.nextLine().toUpperCase();
        Seasons[] arrSeason = Seasons.values();
        // Find input season and get next season name from array
        for (Seasons value : Seasons.values()) {
            if (inputSeason.equals(value.name())) {
                if (value.ordinal() == Seasons.values().length-1) {
                    System.out.println("Next season is: " + arrSeason[0]);
                } else {
                    System.out.println("Next season is: " + arrSeason[value.ordinal()+1]);
                }
                break;
            }
        }
        pause();
    }

    private static void showAllMonthsMaxDays() {
        // Find max days
        int maxDays = Months.JANUARY.getDays();
        for (Months value : Months.values()) {
            if (maxDays < value.getDays()) {
                maxDays = value.getDays();
            }
        }
        System.out.println("Maximum days in database: " + maxDays);
        // Find all months with max days
        for (Months value : Months.values()) {
            if (maxDays == value.getDays()) {
                System.out.println(value.name());
            }
        }
        pause();
    }

    private static void showAllMonthsMinDays() {
        // Find min days
        int minDays = Months.JANUARY.getDays();
        for (Months value : Months.values()) {
            if (minDays > value.getDays()) {
                minDays = value.getDays();
            }
        }
        System.out.println("Minimal days in database: " + minDays);
        // Find all months with min days
        for (Months value : Months.values()) {
            if (minDays == value.getDays()) {
                System.out.println(value.name());
            }
        }
        pause();
    }

    private static void showAllMonthsWithSameDay() {
        System.out.print("Please input days count for check: ");
        Scanner sc2 = new Scanner(System.in);
        int inputDays = sc2.nextInt();
        boolean checkDays = false;
        for (Months value : Months.values()) {
            if (inputDays == value.getDays()) {
                System.out.println(value.name());
                checkDays = true;
            }
        }
        if (!checkDays) {
            System.out.println(ConsoleColors.RED + "There is no MONTHS with same days count! Maybe some error." + ConsoleColors.RESET);
        }
        pause();
    }

    private static void showAllMonthsSelectedSeason() {
        System.out.print("Please input season name for show all months: ");
        Scanner sc2 = new Scanner(System.in);
        String inputSeason = sc2.nextLine().toUpperCase();
        boolean checkSeason = false;
        for (Months value : Months.values()) {
            if (inputSeason.equals(value.getSeason().name())) {
                System.out.println(value.name());
                checkSeason = true;
            }
        }
        if (!checkSeason) {
            System.out.println(ConsoleColors.RED + "There is no MONTHS in this season! Maybe some error." + ConsoleColors.RESET);
        }
        pause();
    }

    private static void checkMonthExist() {
        System.out.print("Please input month name for check: ");
        Scanner sc = new Scanner(System.in);
        String inputMonth = sc.nextLine().toUpperCase();
        boolean checkMonth = false;
        for (Months value : Months.values()) {
            if (inputMonth.equals(value.name())) {
                checkMonth = true;
                break;
            }
        }
        if (checkMonth) {
            System.out.println("Yes! This month exist in database.");
        }
        else {
            System.out.println("No! This month not exist in database.");
        }
        pause();
    }

    private static void pause() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press ENTER to back");
        sc.nextLine();
    }
}
