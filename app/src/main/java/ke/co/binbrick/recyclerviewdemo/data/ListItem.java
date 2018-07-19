package ke.co.binbrick.recyclerviewdemo.data;

/**
 *
 * Created by vodera on 19/07/2018.
 */
public class ListItem {

    private String dateandTime;
    private String message;
    private int colorResource;


    public ListItem(String dateandTime, String message, int colorResource) {
        this.dateandTime = dateandTime;
        this.message = message;
        this.colorResource = colorResource;
    }

    public String getDateandTime() {
        return dateandTime;
    }

    public void setDateandTime(String dateandTime) {
        this.dateandTime = dateandTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }
}
