package ke.co.binbrick.recyclerviewdemo;

import android.widget.Toast;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import ke.co.binbrick.recyclerviewdemo.data.DataSourceInterface;
import ke.co.binbrick.recyclerviewdemo.data.ListItem;
import ke.co.binbrick.recyclerviewdemo.logic.Controller;
import ke.co.binbrick.recyclerviewdemo.view.ViewInterface;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    /**
     * test double
     * specifically a "mock"
     */

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " +
                    "and opinions of experts in your field",
            R.color.RED
    );

    @Before
    public void setUpTest (){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);

    }

    @Test
    public void onGetlistDataSuccessful() {
        //setup any data we need for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //setup our mocks to return the data we want
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        //call the method (unit) we are testing
        controller.getListFromDataSource();

        //check how the tested class responds to the data it receives
        //or test it's behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);

    }


    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateandTime(),
                testItem.getMessage(),
                testItem.getColorResource());
    }

    //assignment to test if list of data has not been returned
//    @Test
//    public void onGetlistDataUnsuccessful(){
//        ArrayList<ListItem> listOfData = new ArrayList<>();
//        listOfData.add(testItem);
//
//        Mockito.when(dataSource.getListOfData())
//                .then(Toast.makeText(ControllerUnitTest.this, "This is my Toast message!", Toast.LENGTH_LONG).show();
//
//
//    }
}