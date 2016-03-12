package edu.stanford.kaseypb.foodtrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class CurrentTimeSlotsActivity extends AppCompatActivity {

    private ArrayList<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
    private TimeSlotsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_time_slots);
        setTimeSlotsListViewSettings();
        findTimeSlots();
    }

    private void setTimeSlotsListViewSettings() {
        adapter = new TimeSlotsListAdapter (
                this,
                timeSlots
        );
        final ListView timeSlotsListView = (ListView) findViewById(R.id.timeSlotsListView);
        timeSlotsListView.setAdapter(adapter);
        timeSlotsListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CurrentTimeSlotsActivity.this, "Time Slot Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //get time slots
    public void findTimeSlots() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery(TimeSlot.parseClassName);

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> timeSlotsPfObjects, ParseException e) {
                if (e == null) {
                    Toast.makeText(CurrentTimeSlotsActivity.this, "Time Slots Loaded", Toast.LENGTH_SHORT).show();
                    Log.d("findTimeSlots", "Retrieved " + timeSlotsPfObjects.size() + " time slots");
                    for (ParseObject pfObj : timeSlotsPfObjects) {
                        CurrentTimeSlotsActivity.this.timeSlots.add(new TimeSlot(pfObj));
                    }
                    CurrentTimeSlotsActivity.this.adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(CurrentTimeSlotsActivity.this, "ERROR!", Toast.LENGTH_SHORT).show();
                    Log.d("findTimeSlots", "Error: " + e.getMessage());
                }
            }
        });
    }
}
