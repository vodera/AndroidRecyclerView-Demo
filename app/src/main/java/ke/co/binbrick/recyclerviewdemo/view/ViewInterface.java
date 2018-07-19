package ke.co.binbrick.recyclerviewdemo.view;

import java.util.List;

import ke.co.binbrick.recyclerviewdemo.data.ListItem;

/**
 * Created by vodera on 19/07/2018.
 */
public interface ViewInterface {

    void startDetailActivity(String dateandTime, String messages, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);


}
