package com.szpileq.android.ksiazeczkazdrowia;

/**
 * Created by Szpileq on 2016-01-23.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientAdapter extends ArrayAdapter<Patient> {

    private Activity activity;
    private ArrayList<Patient> lPatients;
    private static LayoutInflater inflater = null;

    public PatientAdapter (Activity activity, int textViewResourceId,ArrayList<Patient> _lPatients) {
        super(activity, textViewResourceId);
        try {
            this.activity = activity;
            this.lPatients = _lPatients;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return lPatients.size();
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
  //      public Button   more_button;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.listview_association, null);
                holder = new ViewHolder();

                holder.display_firstname = (TextView) vi.findViewById(R.id.displayFirstname);
                holder.display_surname = (TextView) vi.findViewById(R.id.displaySurname);
                holder.display_pesel = (TextView) vi.findViewById(R.id.displayPesel);
               // holder.more_button = (Button) vi.findViewById(R.id.moreButton);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            final Dialog dlgMore;

            holder.display_firstname.setText(lPatients.get(position).getChildInfo().getFirstname());
            holder.display_surname.setText(lPatients.get(position).getChildInfo().getSurname());
            holder.display_pesel.setText(lPatients.get(position).getChildInfo().getPesel());
            /*holder.more_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dlgMore =  new Dialog(ProfileActivity.this);
                }
            });
*/

        } catch (Exception e) {


        }
        return vi;
    }

}
