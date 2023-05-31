public class Date {
    private int day=1;
    private int month=1;
    private int year=0;
    private final int MIN_DAY = 1;
    private final int MAX_DAY = 31;
    private final int MIN_MONTH = 1;
    private final int MAX_MONTH = 12;
    private final int MIN_YEAR = -3999;
    private final int MAX_YEAR = 3999;
    public Date(int day, int month, int year){
        if (day >= MIN_DAY && day <= MAX_DAY) this.day = day;
        if (month >= MIN_MONTH && month <= MAX_MONTH) this.month = month;
        if (year >= MIN_YEAR && year <= MAX_YEAR) this.year = year;
    }
}
