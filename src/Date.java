public class Date {
    /**
     * This class represents a date (DD/MM/YYYY)
     * Consists of 3 integers, which resemble the day, month and year of the date.
     */
    private int day=1, month=1, year = 0;
    protected static final int MIN_DAY = 1;
    protected static final int MAX_DAY = 31;
    protected static final int MIN_MONTH = 1;
    protected static final int MAX_MONTH = 12;
    protected static final int MIN_YEAR = -3999;
    protected static final int MAX_YEAR = 3999;
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

    /**
     * Overrides Object.hashCode().
     * @return a unique identifier (hash code) for the current object.
     */
    @Override
    public int hashCode() {
        return (year + MAX_YEAR + 1)*(MAX_DAY*MAX_MONTH) + month*MAX_DAY + day;
    }

    /**
     * Overrides Objects.equals().
     * @param d a given object.
     * @return true if d and this object are equal, false otherwise.
     */
    @Override
    public boolean equals(Object d) {
        if (d == this)
            return true;
        else if (!(d instanceof Date))
            return false;
        return this.hashCode() == d.hashCode();
    }

    /**
     * Overrides Object.toString()
     * @return a string which represents this Date object.
     */
    @Override
    public String toString() {
        String ret = "";
        int[] arrDayMonth = {day, month};
        for (int i : arrDayMonth) {
            if (i/10 == 0) ret += "0" + i + "/";
            else ret += i + "/";
        }
        int tempYear = year, divisor = 1000;
        while (divisor != 1) {
            if (year/divisor != 0)
                break;
            ret += 0;
            divisor /= 10;
        }
        ret += year;
        return ret;
    }
}
