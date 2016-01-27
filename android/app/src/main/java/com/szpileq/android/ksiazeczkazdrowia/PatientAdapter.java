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

import java.util.ArrayList;

public class PatientAdapter extends ArrayAdapter<PatientBasic> {

    private Activity activity;
    private ArrayList<PatientBasic> lPatientBasics;
    private static LayoutInflater inflater = null;

    public PatientAdapter (Activity activity, int textViewResourceId,ArrayList<PatientBasic> _lPatientBasics) {
        super(activity, textViewResourceId);
        try {
            this.activity = activity;
            this.lPatientBasics = _lPatientBasics;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return lPatientBasics.size();
    }

    public Activity getActivity(){
        return this.activity;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_firstname;
        public TextView display_surname;
        public TextView display_pesel;
        public Button   more_button;

    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.listview_association, null);
                holder = new ViewHolder();

                holder.display_firstname = (TextView) vi.findViewById(R.id.childNameText);
                holder.display_surname = (TextView) vi.findViewById(R.id.childSurnameText);
                holder.display_pesel = (TextView) vi.findViewById(R.id.childPeselText);
                holder.more_button = (Button) vi.findViewById(R.id.moreButton);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }


            holder.display_firstname.setText(lPatientBasics.get(position).getChildInfo().getFirstname());
            holder.display_surname.setText(lPatientBasics.get(position).getChildInfo().getSurname());
            holder.display_pesel.setText(lPatientBasics.get(position).getChildInfo().getPesel());
            holder.more_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("childID", lPatientBasics.get(position).get_id());

                    Intent i = new Intent(activity, ChildActivity.class);
                    i.putExtras(bundle);

                    activity.startActivity(i);
                }
            });


        } catch (Exception e) {


        }
        return vi;
    }

}
