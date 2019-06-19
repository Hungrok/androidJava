package com.hungrok.myfirebase3;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;


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
    public static PageFragment1 newInstance(int page) {

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

        fireBaseAuthGetInstance() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("onCreateView-1 \n") ;
        View view = null ;
        // Inflate the layout for this fragment
        switch (mPage) {
            case 1 :
                view = inflater.inflate(R.layout.fragment_page1, container, false);
                break ;
            case 2 :
                view = inflater.inflate(R.layout.fragment_page2, container, false);
                break ;
            case 3 :
                view = inflater.inflate(R.layout.fragment_page3, container, false);
                break ;


        }



        return view ;
    }

    /* For Firebase Auth field */
    private String myemail = null ;
    private String mypassword = null ;
    private EditText emailid ;
    private EditText passwdid ;


    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        emailid = view.findViewById(R.id.email);
        passwdid = view.findViewById(R.id.passwd);
        Button breg = view.findViewById(R.id.button1);
        Button blogin = view.findViewById(R.id.button2);
        Button bchange = view.findViewById(R.id.button3);
        Button breset = view.findViewById(R.id.button4);
        Button blogout = view.findViewById(R.id.button5);
        Button bunreg = view.findViewById(R.id.button6);

        TextWatcher et1 = new TextWatcher(){ // registration
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Fires right as the text is being changed (even supplies the range of text)
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Fires right before text is changing
            }

            @Override
            public void afterTextChanged(Editable s) {
                myemail = emailid.getText().toString() ;
                System.out.printf("email=%s \n",myemail) ;
            }

        };
        TextWatcher et2 = new TextWatcher(){ // registration
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Fires right as the text is being changed (even supplies the range of text)
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Fires right before text is changing
            }

            @Override
            public void afterTextChanged(Editable s) {
                mypassword = passwdid.getText().toString() ;
                System.out.printf("email=%s \n",mypassword) ;
            }

        };

        View.OnClickListener btreg= new View.OnClickListener(){// registration
            @Override
            public void onClick(View view){
                if ((myemail!=null)&&(mypassword!=null))
                    fireBaseAuthCreateUsrWithEmail(myemail,mypassword) ;
            }
        };
        View.OnClickListener btlogin= new View.OnClickListener(){// login
            @Override
            public void onClick(View view){
                if ((myemail!=null)&&(mypassword!=null))
                    fireBaseAuthSignInWithEmail(myemail,mypassword) ;
            }
        };
        View.OnClickListener btchange= new View.OnClickListener(){// change password
            @Override
            public void onClick(View view){
                fireBaseAuthUpdatePassword("test") ;
            }
        };
        View.OnClickListener btreset = new View.OnClickListener(){ // reset password
            @Override
            public void onClick(View view){
                fireBaseAuthResetPassword(null) ;
            }
        };
        View.OnClickListener btlogout= new View.OnClickListener(){ // logout
            @Override
            public void onClick(View view){
                fireBaseAuthSIgnOut() ;
            }
        };
        View.OnClickListener btunreg= new View.OnClickListener(){ // unreg
            @Override
            public void onClick(View view){
                fireBaseAuthDelete() ;
            }
        };

        emailid.addTextChangedListener(et1);
        passwdid.addTextChangedListener(et2);
        breg.setOnClickListener(btreg);
        blogin.setOnClickListener(btlogin);
        bchange.setOnClickListener(btchange);
        breset.setOnClickListener(btreset);
        blogout.setOnClickListener(btlogout);
        bunreg.setOnClickListener(btunreg);

        if (fireBaseGetAuthState()==1){
            breg.setTextColor(Color.GREEN);
            emailid.setText(fireBaseGetRegisteredEmail()) ;
        }
        fireBaseSetRegButton(breg);
        fireBaseSetLoginButton(blogin);

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

    /* FirebaseAuth common code by KHR */
    private FirebaseAuth mAuth;
    private FirebaseUser loginUser ;
    private Integer fbAuthState = 0;
    private String regEmailName ;
    private String regEmailSavedName ;
    private Button regButton ;
    private Button loginButton ;

    OnCompleteListener<AuthResult> createcom = new OnCompleteListener<AuthResult>(){
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
               System.out.printf("FBAuth Create User success \n") ;
                fbAuthState = 1 ;
                regButton.setTextColor(Color.GREEN);
                saveRegEmailName(regEmailName) ;
            } else {
                Toast.makeText(getContext(), "FBAuth Create User failed.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    OnCompleteListener<AuthResult> signincom = new OnCompleteListener<AuthResult>(){
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                System.out.printf("FBAuth Login success \n") ;
                fbAuthState = 2 ;
                loginButton.setTextColor(Color.GREEN);
                fireBaseAuthGetCurrentUser() ;
            } else {
                Toast.makeText(getContext(), "FBAuth Login failed.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
    OnCompleteListener  regoutcom = new OnCompleteListener(){
        @Override
        public void onComplete(@NonNull Task task) {
            if (task.isSuccessful()) {
                System.out.printf("FBAuth Reg. out success \n") ;
                fbAuthState = 0 ;
                regButton.setTextColor(Color.BLACK);
                loginButton.setTextColor(Color.BLACK);
                saveRegEmailName("none") ;
            } else {
                Toast.makeText(getContext(), "FBAuth reg. out failed.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
    OnCompleteListener  resetpwdcom = new OnCompleteListener(){
        @Override
        public void onComplete(@NonNull Task task) {
            if (task.isSuccessful()) {
                System.out.printf("FBAuth Reset password success \n") ;

            } else {
                Toast.makeText(getContext(), "FBAuth Reset password failed.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    void fireBaseSetRegButton (Button regbt){
        regButton = regbt ;
    }
    void fireBaseSetLoginButton (Button regbt){
        loginButton = regbt ;
    }
    Integer fireBaseGetAuthState(){
        return fbAuthState ;
    }
    String fireBaseGetRegisteredEmail(){
        return regEmailSavedName ;
    }
    void saveRegEmailName(String email){

        regEmailSavedName = email ;
        SharedPreferences sp = getContext().getSharedPreferences("fbauth",getContext().MODE_PRIVATE) ;
        SharedPreferences.Editor ed = sp.edit() ;
        ed.putString("email",regEmailSavedName) ;
        ed.putInt("state",fbAuthState) ;
        ed.apply() ;
        System.out.printf("Save state=%d,saveRegEmailName=%s \n",fbAuthState,regEmailSavedName) ;
    }
    void fireBaseAuthGetInstance(){
        mAuth = FirebaseAuth.getInstance();

        SharedPreferences sp = getContext().getSharedPreferences("fbauth",getContext().MODE_PRIVATE) ;
        regEmailSavedName = sp.getString("email",null) ;
        int state = sp.getInt("state",0) ;
        if (state >= 1)
            fbAuthState = 1 ;
        System.out.printf("Retrieve state=%d,saveRegEmailName=%s \n",state,regEmailSavedName) ;
    }
    void fireBaseAuthCreateUsrWithEmail(String email, String passwd) {
        if(fbAuthState==0) {
            Task<AuthResult> ar = mAuth.createUserWithEmailAndPassword(email, passwd);
            regEmailName = email ;
            ar.addOnCompleteListener(getActivity(), createcom);
        }
    }
    void fireBaseAuthSignInWithEmail(String email, String name) {
        if(fbAuthState==1) {
            Task<AuthResult> ar = mAuth.signInWithEmailAndPassword(email, name);
            ar.addOnCompleteListener(getActivity(), signincom);
        }
    }
    void fireBaseAuthResetPassword(String sendemail) {
        if(fbAuthState==1) {
            Task ar = mAuth.sendPasswordResetEmail(regEmailSavedName);
            ar.addOnCompleteListener(getActivity(), resetpwdcom) ;
        }
    }
    void fireBaseAuthSIgnOut() {
        if(fbAuthState==2) {
            mAuth.signOut();
            fbAuthState = 1 ;
            loginButton.setTextColor(Color.BLACK);
            loginUser = null ;
        }
    }
    private FirebaseUser fireBaseAuthGetCurrentUser(){
        if(fbAuthState==2) {
            loginUser = mAuth.getCurrentUser();
            return loginUser;
        }
        return null ;
    }
    void fireBaseAuthUpdatePassword(String passwd){
        if(fbAuthState ==2 ) {
            //loginUser.updatePassword(passwd);
        }
    }
    void fireBaseAuthUpdateEmail(String email){
        if(fbAuthState ==2 ) {
            //loginUser.updateEmail(email);
        }
    }
    void fireBaseAuthDelete(){
        if(fbAuthState ==2 ) {
            Task ar =loginUser.delete();
            ar.addOnCompleteListener(getActivity(), regoutcom) ;
        }
    }



}
