package patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseIterator implements Iterator {
    private ArrayList<MenuItem> items;
    private int position = 0;

    public PancakeHouseIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        return position < items.size();
    }
}
