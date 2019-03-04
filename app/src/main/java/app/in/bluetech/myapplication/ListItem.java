package app.in.bluetech.myapplication;

/**
 * Created by martinhocorreiamussamba on 25/12/18.
 */

public class ListItem {

    public String head;
    public String desc;
    private final int imageResource;

    public ListItem(String head, String desc, int imageResource) {
        this.head = head;
        this.desc = desc;
        this.imageResource = imageResource;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageResource() {
        return imageResource;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
