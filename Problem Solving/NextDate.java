import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class NextDate {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DateTimeFormatter format=DateTimeFormatter.ofPattern("d/M/yyyy");
        String str=in.nextLine();
        try{
            LocalDate date=LocalDate.parse(str,format);
            date=date.plusDays(1);
            System.out.println(date.format(format));
        }
        catch(DateTimeParseException e){
            System.out.println(e.getMessage());
        }
        in.close();
    }
}
