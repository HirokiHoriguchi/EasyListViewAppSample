package com.example.easylistviewsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {


//    名前保持のためのクラス
    class CellData{
        String imageComment;
        int imageDrawableID;

        CellData(String imageComment, int imageDrawableID){
            this.imageComment = imageComment;
            this.imageDrawableID = imageDrawableID;
        }
    }

    private Integer[] imageDrawables = {
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_close_clear_cancel,
            android.R.drawable.ic_menu_compass,
            android.R.drawable.ic_menu_crop,
            android.R.drawable.ic_menu_delete,
            android.R.drawable.ic_menu_directions,
            android.R.drawable.ic_menu_directions,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_edit,
            android.R.drawable.ic_menu_help
    };


    private String[] imageComments = {
            "call", "cancel", "compass", "crop", "delete", "directions","directions", "gallery","edit","help"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CellData> list = new ArrayList<>();

        for (int i = 0; i < imageDrawables.length; i++){
            CellData data = new CellData(imageComments[i], imageDrawables[i]);
            list.add(data);
        }

        setListAdapter(new ListViewAdapter(this, R.layout.list, list));
    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    class ListViewAdapter extends ArrayAdapter<CellData>{
        private LayoutInflater layoutInflater;
        private int itemLayout;
        CellData cellData;

        ListViewAdapter(Context context, int itemLayout, List<CellData> list){
            super(context, 0, list);
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.itemLayout = itemLayout;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null){
                convertView = layoutInflater.inflate(itemLayout, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.textView = convertView.findViewById(R.id.textview);
                viewHolder.imageView = convertView.findViewById(R.id.imageView);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            cellData = getItem(position);
            if (cellData != null){
                viewHolder.textView.setText(cellData.imageComment);
                viewHolder.imageView.setImageResource(cellData.imageDrawableID);
            }

            return convertView;
        }
    }



}
