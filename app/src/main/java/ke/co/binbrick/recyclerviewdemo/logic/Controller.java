package ke.co.binbrick.recyclerviewdemo.logic;

import ke.co.binbrick.recyclerviewdemo.data.DataSourceInterface;
import ke.co.binbrick.recyclerviewdemo.data.ListItem;
import ke.co.binbrick.recyclerviewdemo.view.ViewInterface;

/**
 * Created by vodera on 19/07/2018.
 */
public class Controller {


    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }

    public void onListItemClick(ListItem testItem) {
        view.startDetailActivity(
                testItem.getDateandTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}
