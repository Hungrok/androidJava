package com.hungrok.viewspractice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    //private String[] mDataset;
    private ArrayList<StudentMini> mDataset; //data source of the list adapter

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mIconView ;

        /*
        public MyViewHolder(String[] v) {
            super(v);
            mTextView = v;
        }
        */
        public MyViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.textview);
            mIconView = (ImageView) view.findViewById(R.id.imageview);
            // KHR comment, ViewHolder is just cache for save view not to use findView
        }

        public TextView getMyTextView(){
            return mTextView ;
        }
        public ImageView getMyImageView(){
            return mIconView ;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    /*
    public MyRecycleAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
    */
    public MyRecycleAdapter(ArrayList<StudentMini> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_view_row_items, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //holder.mTextView.setText(mDataset[position]); // original

        StudentMini currentItem = mDataset.get(position) ;

        //sets the text for item name and item description from the current item object
        holder.getMyTextView().setText(currentItem.getName());
        holder.getMyImageView().setImageResource(currentItem.getIcon());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //return mDataset.length;
        return mDataset.size();
    }
}