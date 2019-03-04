package app.in.bluetech.myapplication;

/**
 * Created by martinhocorreiamussamba on 24/02/19.
 */

public class IndiceInfo {

     private String mTitle;
     private String  mSubtitle;

    public IndiceInfo(String title, String subtitle)
    {
        mTitle=title;
        mSubtitle=subtitle;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
