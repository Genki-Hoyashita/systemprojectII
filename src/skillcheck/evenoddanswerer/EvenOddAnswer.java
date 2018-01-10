package skillcheck.evenoddanswerer;

import java.util.ArrayList;
import java.util.List;

public class EvenOddAnswer{

    private int number = 0;
    private int judge = 0;

    public void setNumber(int number){
        this.number = number;
    }

    public void execute() {
      this.judge = number % 2;
    }
    public String getAnswer(){
        if(judge == 0) return "Even";
        else return "Odd";

    }
}
