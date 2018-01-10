package skillcheck.multiplechecker;

public class MultipleChecker {
  private int integer = 0;
  private int multiple = 0;


  public void setInteger(int integer) {
    this.integer = integer;
  }

  public void setMultiple(int multiple) {
    this.multiple = multiple;
  }

  public boolean check() {
    int checker = integer % multiple;
    if (checker == 0) return true;
    else return false;
  }

}
