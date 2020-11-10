package com.devforxkill.demo10novembre;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment implements View.OnClickListener {

    // callback
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

    private OnButtonClickedListener callback;

    private EditText entreeuser;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String name;
    private String mParam2;

    // callback

    public InputFragment() {
        // Required empty public constructor, contraintes d'Android
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InputFragment newInstance(String param1, String param2) {
        InputFragment fragment = new InputFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_input, container, false);
        result.findViewById(R.id.fragmentbutton).setOnClickListener(this);
        entreeuser = new EditText(this.getContext());
        entreeuser.setText("toto");
        ((LinearLayout)result.findViewById(R.id.flayout)).addView(entreeuser);
        return result;
    }

    public void onAttach(Context context){
        super.onAttach(context);
        try {
            //Parent activity will automatically subscribe to callback
            callback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            Log.d("FRAGMENT", e.getStackTrace().toString());
        }
    }

    @Override
    public void onClick(View v) {
        Log.d("Fragment in", "on a clické sur le bouton "+ entreeuser.getText() + " end");
        callback.onButtonClicked(v);
    }

    public EditText getEntreeuser() {
        return entreeuser;
    }
}