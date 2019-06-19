package com.hungrok.viewspractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment3 extends Fragment { // For ReclyclerView by KHR

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public PageFragment3() {
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
    public static PageFragment3 newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment3 fragment = new PageFragment3();
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
        System.out.printf("onCreateView-3, page=%d \n",mPage) ;
        View view = null ;
        // Inflate the layout for this fragment
        switch (mPage) {
            case 3 :
                view = inflater.inflate(R.layout.fragment_page3, container, false);
                break ;
        }

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<StudentMini2> data = StudentMini2.buildStudentMini() ;
        mAdapter = new MyRecycleAdapter2(data);
        mRecyclerView.setAdapter(mAdapter);

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







}


class StudentMini2 { // just for test ArrayList
    private int icon;
    private String name;
    private String title;
    private String address;
    private String email;

    public StudentMini2(String name, String title, String addr, String email) {
        this.name = name;
        this.title = title ;
        this.address = addr;
        this.email = email ;
    }

    public String getName() {
        return this.name;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAddress() {
        return this.address;
    }
    public String getEmail() {
        return this.email;
    }
    public int getIcon() {
        return this.icon;
    }

    public static ArrayList<StudentMini2> buildStudentMini(){
        ArrayList<StudentMini2> stdlist = new ArrayList() ;
        StudentMini2 st = null ;
        int icon = R.drawable.ic_sentiment_satisfied_black_24dp ;
        String name = "Hong Gildong" ;
        String title = "President" ;
        String addr = "Street 21, Suwon" ;
        String email = "gildong.hong@hanmail.net" ;

        for (Integer i=0 ; i<20 ; i++){
            String s2 = name.concat(i.toString() );
            st = new StudentMini2(s2,title,addr,email) ;
            stdlist.add(st) ;
        }
        return stdlist ;
    }
}
