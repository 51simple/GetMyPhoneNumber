package com.yukang.getmyphonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static com.yukang.getmyphonenumber.R.id.tvName;
import static com.yukang.getmyphonenumber.R.id.tvNumber;

/**
 * Created by simple on 17-3-11.
 */

public class MyAdapter extends BaseAdapter {

    private List<PhoneInfo> lists;
    private Context context;
    private LinearLayout layout;

    public MyAdapter(List<PhoneInfo> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        layout = (LinearLayout) inflater.inflate(R.layout.item, null);
//        TextView tvName = (TextView) layout.findViewById(R.id.tvName);
//        TextView tvNumber = (TextView) layout.findViewById(R.id.tvNumber);
//        tvName.setText(lists.get(position).getName());
//        tvNumber.setText(lists.get(position).getNumber());
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(tvName);
            holder.tvNumber = (TextView) convertView.findViewById(tvNumber);
            holder.tvName.setText(lists.get(position).getName());
            holder.tvNumber.setText(lists.get(position).getNumber());
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView tvName;
        TextView tvNumber;
    }
}
