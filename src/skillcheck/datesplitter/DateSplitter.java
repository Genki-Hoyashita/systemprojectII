package skillcheck.datesplitter;

public class DateSplitter {
  private String date;
  private int year = 0;
  private int month = 0;
  private int day = 0;


  public void setDate(String date) {
    this.date = date;
  }

  public void execute() {
    String[] dates = date.split("-");
    this.year = Integer.parseInt(dates[0]);
    this.month = Integer.parseInt(dates[1]);
    this.day = Integer.parseInt(dates[2]);
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
}
