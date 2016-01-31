package com.szpileq.android.ksiazeczkazdrowia;

/**
 * Created by Szpileq on 2016-01-23.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.szpileq.android.ksiazeczkazdrowia.Activities.ChildActivity;
import com.szpileq.android.ksiazeczkazdrowia.Info.VisitInfo;

import java.util.ArrayList;

public class VisitsAdapter extends ArrayAdapter<VisitInfo> {

    private Activity activity;
    private ArrayList<VisitInfo> lVisits;
    private static LayoutInflater inflater = null;

    public VisitsAdapter (Activity activity, int textViewResourceId,ArrayList<VisitInfo> _lVisits) {
        super(activity, textViewResourceId);
        try {
            this.activity = activity;
            this.lVisits = _lVisits;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return lVisits.size();
    }

    public Activity getActivity(){
        return this.activity;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_date;
        public TextView display_drName;
        public Button   more_button;

    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.visits_assotiation, null);
                holder = new ViewHolder();

                holder.display_date = (TextView) vi.findViewById(R.id.visitsListDateText);
                holder.display_drName = (TextView) vi.findViewById(R.id.visitsListDoctorsName);
                holder.more_button = (Button) vi.findViewById(R.id.visitsListMoreButton);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }


            holder.display_date.setText(lVisits.get(position).getDate());
            holder.display_drName.setText(lVisits.get(position).getDoctorSignature());
            holder.more_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


        } catch (Exception e) {


        }
        return vi;
    }

}
