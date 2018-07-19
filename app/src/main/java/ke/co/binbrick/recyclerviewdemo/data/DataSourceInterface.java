package ke.co.binbrick.recyclerviewdemo.data;

import java.util.List;

/**
 * this is a contract between classes that dictate how they can talk to each other without giving implementation details
 * Created by vodera on 19/07/2018.
 */
public interface DataSourceInterface {

    List<ListItem> getListOfData();
}
