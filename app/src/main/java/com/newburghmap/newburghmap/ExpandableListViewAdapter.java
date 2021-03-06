package com.newburghmap.newburghmap;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    ArrayList<String> type;
    ArrayList<String> location;
    String[][] array2d;
    Context context;

    //ArrayList<ArrayList<String>> subType;

    public ExpandableListViewAdapter(ArrayList<String> location){

        this.location = location;
    }

    public ExpandableListViewAdapter(Context context) {

        this.context = context;
    }

    @SuppressLint("ValidFragment")
    public ExpandableListViewAdapter(Context context,ArrayList<String> types, String[][] array2d) {
        this.type=types;
       // this.subType=subTypes;
        this.context=context;
        this.array2d=array2d;
    }


    @Override
    public int getGroupCount() {
        return type.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return array2d[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return type.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return array2d[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {

        final TextView txtview = new TextView(context);
        txtview.setText(type.get(groupPosition));
        txtview.setPadding(100,0,0,0);
        txtview.setTextColor(Color.BLACK);
        return txtview;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

        final TextView txtView = new TextView(context);
        txtView.setText(array2d[groupPosition][childPosition]);
        txtView.setPadding(100,0,0,0);
        return txtView;


    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
