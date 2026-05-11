import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek d = date.getDayOfWeek();
        return d.toString().substring(0,1) +
               d.toString().substring(1).toLowerCase();
    }
}