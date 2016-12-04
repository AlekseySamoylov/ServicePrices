package com.alekseysamoylov.serviceprices.model.widget;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.activities.work.SingleItemView;
import com.alekseysamoylov.serviceprices.model.work.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Adapter for works listView
 */
public class WorkListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Work> worksList = null;
    private ArrayList<Work> arraylist;

    public WorkListViewAdapter(Context context, List<Work> worksList) {
        mContext = context;
        this.worksList = worksList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Work>();
        this.arraylist.addAll(worksList);
    }

    public class ViewHolder {
        TextView price;
        TextView title;
        TextView details;
    }

    @Override
    public int getCount() {
        return worksList.size();
    }

    @Override
    public Work getItem(int position) {
        return worksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final WorkListViewAdapter.ViewHolder holder;
        if (view == null) {
            holder = new WorkListViewAdapter.ViewHolder();
            view = inflater.inflate(R.layout.work_list_view_item, null);
            // Locate the TextViews in listview_item.xml
            holder.price = (TextView) view.findViewById(R.id.workPrice);
            holder.title = (TextView) view.findViewById(R.id.workTitle);
            //holder.details = (TextView) view.findViewById(R.id.details);
            view.setTag(holder);
        } else {
            holder = (WorkListViewAdapter.ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.price.setText(worksList.get(position).getPrice().toPlainString());
        holder.title.setText(worksList.get(position).getTitle());
        // holder.details.setText(worksList.get(position).getdetails());
        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                System.out.println(worksList.get(position).getPrice().toString());
                // Pass all data price
                intent.putExtra("price", worksList.get(position).getPrice().toString());
                // Pass all data title
                intent.putExtra("title", (worksList.get(position).getTitle()));
                // Pass all data details
                intent.putExtra("details", (worksList.get(position).getDetails()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worksList.clear();
        if (charText.length() == 0) {
            worksList.addAll(arraylist);
        } else {
            for (Work wp : arraylist) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    worksList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}