package objects;

import java.util.ArrayList;
import java.util.List;

public class Sac {

    private List<IItems> tab;
    public Sac(){
        this.tab = new ArrayList<>();
    }

    public void addItems(IItems items ){
        tab.add(items);
    }

    public IItems getItems(int index){
        return tab.get(index);
    }

    public int size(){
        return tab.size();
    }

    public IItems removeItems(int index){
        return tab.remove(index);
    }
}

