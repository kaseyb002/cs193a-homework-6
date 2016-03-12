package edu.stanford.kaseypb.foodtrain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kaseybaughan on 3/11/16.
*/
public class TimeSlotsListAdapter extends ArrayAdapter<TimeSlot> {
    public TimeSlotsListAdapter(Context context, ArrayList<TimeSlot> timeSlots) {
        super(context, 0, timeSlots);
    }

    //iOS analogue to table view datasource
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data from ArrayList<GroceryItem>
        final TimeSlot timeSlot = getItem(position);
        //i think this has something to do with reusing a view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.time_slot_layout, parent, false);
        }
        //find TextViews from this row to populate data with
        TextView tvDateDay = (TextView) convertView.findViewById(R.id.dateDayTextView);
        TextView tvTimeWindow = (TextView) convertView.findViewById(R.id.timeWindowTextView);
        TextView tvStores = (TextView) convertView.findViewById(R.id.storesTextView);

        Date timeWindowStart = timeSlot.getStartTime();
        Date timeWindowEnd = timeSlot.getEndTime();
        SimpleDateFormat dt = new SimpleDateFormat("E, MMM d");
        dt.format(timeWindowStart);

        String storesString = timeSlot.getStores().toString();
        storesString = storesString.replace("[", "");
        storesString = storesString.replace("]", "");

        //stick data into TextViews
        tvDateDay.setText(dt.format(timeWindowStart));
        dt = new SimpleDateFormat("hh:mm aaa");
        tvTimeWindow.setText(dt.format(timeWindowStart) + " - " + dt.format(timeWindowEnd));
        tvStores.setText(storesString);

        //return completed view
        return convertView;
    }

}
