package com.hungrok.dialog;

//import android.app.AlertDialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;


public class DialFragment3 extends DialogFragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private OnFragmentInteractionListener mListener;
    AlertDialog.Builder builder;
    AlertDialog alert ;

    private DatePickerDialog.OnDateSetListener dsListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        }
    };


    public DialFragment3() {
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
    public static DialFragment3 newInstance(int page) { // For ListView by KHR

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        DialFragment3 fragment = new DialFragment3();
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
        System.out.printf("onCreateView-3, page=%d  \n",mPage) ;
        View view = null ;
        // Inflate the layout for this fragment
        switch (mPage) {
            case 3 :
                view = inflater.inflate(R.layout.fragment_page3, container, false);
                break ;
        }

        return view ;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        System.out.printf("onViewCreated-3, page=%d  \n",mPage) ;


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        System.out.printf("onCreateDialog-3, page=%d  \n",mPage) ;
        Context context = getContext() ;

        DatePickerDialog dialog = new DatePickerDialog(context, dsListener, 2019, 02, 02);

        return dialog  ;
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


