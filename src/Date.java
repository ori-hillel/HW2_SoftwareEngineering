public class Date {
    protected int day=1, month=1, year = 0;
    private final int MIN_DAY = 1;
    private final int MAX_DAY = 31;
    private final int MIN_MONTH = 1;
    private final int MAX_MONTH = 12;
    private final int MIN_YEAR = -3999;
    private final int MAX_YEAR = 3999;
    public Date(int year, int month, int day){
        if (day >= MIN_DAY && day <= MAX_DAY) this.day = day;
        if (month >= MIN_MONTH && month <= MAX_MONTH) this.month = month;
        if (year >= MIN_YEAR && year <= MAX_YEAR) this.year = year;
    }
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public void setDay(int day) {
        if (day >= MIN_DAY && day <= MAX_DAY)  this.day = day;
    }

    public void setMonth(int month) {
        if (month >= MIN_MONTH && month <= MAX_MONTH)  this.month = month;
    }

    public void setYear(int year) {
        if (year >= MIN_YEAR && year <= MAX_YEAR) this.year = year;
    }
    @Override
    public int hashCode() {
        String ret = "";
        if (day%10==0)
            ret += "90" + day;
        else
            ret += day;

        if (month%10==0)
            ret += "90" + month;
        else
            ret += month;
        ret += year;
        return Integer.parseInt(ret);



    }
    @Override
    public boolean equals(Object d) {
        if (d == this)
            return true;
        else if (!(d instanceof Date))
            return false;
        return this.hashCode() == d.hashCode();
    }
}
