package ke.co.binbrick.recyclerviewdemo.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ke.co.binbrick.recyclerviewdemo.R;
import ke.co.binbrick.recyclerviewdemo.data.FakeDataSource;
import ke.co.binbrick.recyclerviewdemo.data.ListItem;
import ke.co.binbrick.recyclerviewdemo.logic.Controller;

/**
 * Created by vodera on 19/07/2018.
 */

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE= "EXTRA_MESSAGE";
    private static final String EXTRA_COLOUR = "EXTRA_COLOUR";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        controller = new Controller(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(String dateandTime, String message, int colorResource) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_DATE_AND_TIME, dateandTime);
        i.putExtra(EXTRA_MESSAGE, message);
        i.putExtra(EXTRA_COLOUR, colorResource);

        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {

        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            //this creates the viewholder
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);

            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            ListItem currentItem =  listOfData.get(i);

            customViewHolder.coloredCircle.setBackgroundResource(
                    currentItem.getColorResource()
            );
            customViewHolder.message.setText(
                    currentItem.getMessage()
            );
            customViewHolder.dateAndTime.setText(
                    currentItem.getDateandTime()
            );



        }

        @Override
        public int getItemCount() {
            //helps the adapter to decide how many items it will need to manage
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


            private View coloredCircle;
            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;


            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.imv_list_item_circle);
                this.dateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.message = (TextView) itemView.findViewById(R.id.lbl_message);
                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );


                controller.onListItemClick(
                        listItem
                );
            }
        }
    }
}
