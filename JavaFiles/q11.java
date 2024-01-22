public class q11 {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(15);
        Date date3 = new Date(20, 6);
        Date date4 = new Date(7, 4, 2022);

        System.out.println("Date 1: ");
        System.out.print("CurrDate: ");
        date1.printDate();
        System.out.print("PrevDay: ");
        date1.getPreviousDay().printDate();
        System.out.print("NextDay: ");
        date1.getNextDay().printDate();

        System.out.println("\nDate 2: ");
        System.out.print("CurrDate: ");
        date2.printDate();
        System.out.print("PrevDay: ");
        date2.getPreviousDay().printDate();
        System.out.print("NextDay: ");
        date2.getNextDay().printDate();

        System.out.println("\nDate 3: ");
        System.out.print("CurrDate: ");
        date3.printDate();
        System.out.print("PrevDay: ");
        date3.getPreviousDay().printDate();
        System.out.print("NextDay: ");
        date3.getNextDay().printDate();

        System.out.println("\nDate 4: ");
        System.out.print("CurrDate: ");
        date4.printDate();
        System.out.print("PrevDay: ");
        date4.getPreviousDay().printDate();
        System.out.print("NextDay: ");
        date4.getNextDay().printDate();
    }
}

class Date {
    private int year;
    private int month;
    private int day;

    Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    Date(int day) {
        this.day = day;
        this.month = 1;
        this.year = 1970;
    }

    Date(int day, int month) {
        this.day = day;
        this.month = month;
        this.year = 1970;
    }

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Date getPreviousDay() {
        Date previousDay = new Date(this.day, this.month, this.year);
        if (this.day > 1) {
            previousDay.day -= 1;
        } else {
            if (this.month > 1) {
                previousDay.month -= 1;
                previousDay.day = this.daysInMonth();
            } else {
                previousDay.year -= 1;
                previousDay.month = 12;
                previousDay.day = this.daysInMonth();
            }
        }

        return previousDay;
    }

    public Date getNextDay() {
        Date nextDay = new Date(this.day, this.month, this.year);
        if (this.day < this.daysInMonth()) {
            nextDay.day += 1;
        } else {
            if (this.month < 12) {
                nextDay.month += 1;
                nextDay.day = 1;
            } else {
                nextDay.year += 1;
                nextDay.month = 1;
                nextDay.day = 1;
            }
        }

        return nextDay;
    }

    public void printDate() {
        System.out.println(this.day + "/" + this.month + "/" + this.year);
    }

    private int daysInMonth() {
        switch (this.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }
}