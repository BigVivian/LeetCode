package Fight;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {
    private int currentPos;
    private String name;

    public Person(String name){
        this.name = name;
    }

    public void update(Observable o, Object arg)
    {
          System.out.println(this.name + " is in Pos " + currentPos);
    }


    public static void main(String[] args){
        Subject sub = new Subject();

        Person A = new Person("A");
        Person B = new Person("B");

        sub.addObserver(A);
        sub.addObserver(B);
    }
}
