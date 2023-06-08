public class DateTime extends Date{
    /**
     * This class represents a date and a time.
     * Consists of additional 2 integers, which resemble the hour, minute components of the time.
     */
    private int hour=0, minute=0;
    private static final int MIN_HOUR = 0;
    private static final int MAX_HOUR = 23;
    private static final int MIN_MINUTE = 0;
    private static final int MAX_MINUTE = 59;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        if (hour >= MIN_HOUR && hour <= MAX_HOUR) this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute >= MIN_MINUTE && minute <= MAX_MINUTE) this.minute = minute;
    }

    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if (hour >= MIN_HOUR && hour <= MAX_HOUR) this.hour = hour;
        if (minute >= MIN_MINUTE && minute <= MAX_MINUTE) this.minute = minute;
    }
    /**
     * Overrides Date.equals().
     * @param dt a given object.
     * @return true if dt and this object are equal, false otherwise.
     */
    @Override
    public boolean equals(Object dt) {
        if (dt == this)
            return true;
        else if (!(dt instanceof DateTime))
            return false;
        return this.hashCode() == dt.hashCode();
    }
    /**
     * Overrides Date.hashCode().
     * @return a unique identifier (hash code) for the current object.
     */
    @Override
    public int hashCode() {
        return (getYear() + MAX_YEAR + 1) * (MAX_MONTH*MAX_DAY*MAX_HOUR*MAX_MINUTE) +
                getMonth() * (MAX_DAY*MAX_HOUR*MAX_MINUTE) +
                getDay() * (MAX_HOUR*MAX_MINUTE) +
                getHour() * MAX_MINUTE +
                getMinute();
    }
    /**
     * Overrides Date.toString()
     * @return a string which represents this DateTime object.
     */
    @Override
    public String toString() {
        String ret = super.toString() + " ";
        if (hour/10 == 0) ret += "0" + hour + ":";
        else ret += hour + ":";
        if (minute/10 == 0) ret += "0" + minute;
        else ret += minute;
        return ret;
    }
}
