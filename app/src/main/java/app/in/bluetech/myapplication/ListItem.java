package app.in.bluetech.myapplication;

/**
 * Created by martinhocorreiamussamba on 25/12/18.
 */

public class ListItem {

    public String head;
    public String desc;

    public ListItem(String head, String desc) {
        this.head = head;
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
