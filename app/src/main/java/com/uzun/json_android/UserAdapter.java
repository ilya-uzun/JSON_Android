package com.uzun.json_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter< JSONObject> {
    int listLayout;
    ArrayList< JSONObject> list;
    Context context;

    public UserAdapter(Context context, int listLayout, int field ,ArrayList< JSONObject> list){
        super(context,listLayout,field,list);
        this.context=context;
        this.listLayout=listLayout;
        this.list=list;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(listLayout,parent,false);
        TextView name = itemView.findViewById(R.id.textViewName);
        TextView email = itemView.findViewById(R.id.textViewEmail);
        try {
            name.setText(list.get(position).getString("name"));
            email.setText(list.get(position).getString("email"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return itemView;
    }
}