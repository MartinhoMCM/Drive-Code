package app.in.bluetech.myapplication.contents_signal;

public class SPerigo {


    String content;
    private  final int imageRes;

    public SPerigo(String content, int imageRes) {
        this.imageRes = imageRes;
        this.content =content;
    }

    public String getContent() {
        return content;
    }

    public int getImageRes() {
        return imageRes;
    }
}
