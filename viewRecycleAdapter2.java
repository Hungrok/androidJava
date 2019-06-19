package com.hungrok.viewspractice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecycleAdapter2 extends RecyclerView.Adapter<MyRecycleAdapter2.MyViewHolder> {
    //private String[] mDataset;
    private ArrayList<StudentMini2> mDataset; //data source of the list adapter

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ImageView mIconView ;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;

        /*
        public MyViewHolder(String[] v) {
            super(v);
            mTextView = v;
        }
        */
        public MyViewHolder(View view) {
            super(view);

            //mIconView = (ImageView) view.findViewById(R.id.imageview);
            mTextView1 = (TextView) view.findViewById(R.id.name);
            mTextView2 = (TextView) view.findViewById(R.id.title);
            mTextView3 = (TextView) view.findViewById(R.id.addr);
            mTextView4 = (TextView) view.findViewById(R.id.email);

        }

        public TextView getMyTextView1(){ return mTextView1 ;}
        public TextView getMyTextView2(){ return mTextView2 ;}
        public TextView getMyTextView3(){ return mTextView3 ;}
        public TextView getMyTextView4(){ return mTextView4 ;}

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
    public MyRecycleAdapter2(ArrayList<StudentMini2> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyRecycleAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_rview_cview_row_items, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //holder.mTextView.setText(mDataset[position]); // original

        StudentMini2 currentItem = mDataset.get(position) ;

        //sets the text for item name and item description from the current item object
        //holder.getMyImageView().setImageResource(currentItem.getIcon());
        holder.getMyTextView1().setText(currentItem.getName());
        holder.getMyTextView2().setText(currentItem.getTitle());
        holder.getMyTextView3().setText(currentItem.getAddress());
        holder.getMyTextView4().setText(currentItem.getEmail());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //return mDataset.length;
        return mDataset.size();
    }
}