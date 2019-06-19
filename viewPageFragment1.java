package com.hungrok.viewspractice;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PageFragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment1 extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private OnFragmentInteractionListener mListener;


    public PageFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageFragment1 newInstance(int page) { // For ListView by KHR

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment1 fragment = new PageFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

        /*
        ListView listView=(ListView) getView().findViewById(R.id.listview);
        ArrayList<StudentMini> data = StudentMini.buildStudentMini() ;
        Context context = getContext() ; // KHR comment, not sure this is right way
        BaseAdapter adapter = new CustomListAdapter(context, data) ;
        listView.setAdapter(adapter);
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.printf("onCreateView-1, page=%d  \n",mPage) ;
        View view = null ;
        // Inflate the layout for this fragment
        switch (mPage) {
            case 1 :
                view = inflater.inflate(R.layout.fragment_page1, container, false);
                break ;
        }
        ListView listView=(ListView) view.findViewById(R.id.listview);
        ArrayList<StudentMini> data = StudentMini.buildStudentMini() ;
        Context context = getContext() ; // KHR comment, not sure this is right way
        BaseAdapter adapter = new CustomListAdapter(context, data) ;

        listView.setAdapter(adapter);



        AdapterView.OnItemClickListener icl = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 System.out.printf("OnItemClick position=%d \n",position) ;
            }
        };

        listView.setOnItemClickListener(icl);

        return view ;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        System.out.println("onDetach-1 \n") ;
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }

    public class CustomListAdapter extends BaseAdapter {
        private Context context; //context
        private ArrayList<StudentMini> items; //data source of the list adapter

        //public constructor
        public CustomListAdapter(Context context, ArrayList<StudentMini> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size(); //returns total of items in the list
        }

        @Override
        public Object getItem(int position) {
            return items.get(position); //returns list item at the specified position
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // inflate the layout for each list row
            if (convertView == null) {
                convertView = LayoutInflater.from(context).
                        inflate(R.layout.layout_list_view_row_items, parent, false);
            }

            // get current item to be displayed
            StudentMini currentItem = (StudentMini) getItem(position);

            // get the TextView for item name and item description
            TextView textViewItemName = (TextView)
                    convertView.findViewById(R.id.textview);

            ImageView imageViewItemIcon = (ImageView)
                    convertView.findViewById(R.id.imageview);

            //sets the text for item name and item description from the current item object
            textViewItemName.setText(currentItem.getName());
            imageViewItemIcon.setImageResource(currentItem.getIcon());

            // returns the view for the current row
            return convertView;
        }
    }



}

class StudentMini {
    private int icon;
    private String name;

    public StudentMini(int icon, String name) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public int getIcon() {
        return this.icon;
    }

    public static ArrayList<StudentMini> buildStudentMini(){
        ArrayList<StudentMini> stdlist = new ArrayList() ;
        StudentMini st = null ;
        int icon = R.drawable.ic_sentiment_satisfied_black_24dp ;
        String name = "Hong Gildong" ;
        for (Integer i=0 ; i<20 ; i++){
            String s2 = name.concat(i.toString() );
            st = new StudentMini(icon, s2) ;
            stdlist.add(st) ;
        }
        return stdlist ;
    }
}
