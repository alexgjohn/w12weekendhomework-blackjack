package Players;
import Card.*;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends Person{

    private String name;


    public Player(String name){
       super();
       this.name = name;
    }

    public String getName() {
        return this.name;
    }


}
