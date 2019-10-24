package com.example.calculateapp;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SciModeFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Button toNumButton;
    private Button sinB, cosB, tanB, lnB, lgB, factB, piB, expB,
            powB, openingB, closingB, sqrtB;

    public SciModeFragment() {
        // Required empty public constructor
    }


    public static SciModeFragment newInstance(String param1, String param2) {
        SciModeFragment fragment = new SciModeFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sci_mode, container, false);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            toNumButton = view.findViewById(R.id.buttonToNum);
            toNumButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int action = R.id.action_scientific_to_basic_mode;
                    Navigation.findNavController(view).navigate(action);
                }
            });
        }
        sinB = view.findViewById(R.id.buttonSin);
        cosB= view.findViewById(R.id.buttonCos);
        tanB= view.findViewById(R.id.buttonTan);
        lnB = view.findViewById(R.id.buttonLn);
        lgB = view.findViewById(R.id.buttonLog);
        factB =  view.findViewById(R.id.buttonFact);
        piB = view.findViewById(R.id.buttonPi);
        expB = view.findViewById(R.id.buttonExp);
        powB = view.findViewById(R.id.buttonPow);
        openingB = view.findViewById(R.id.buttonOpeningBr);
        closingB = view.findViewById(R.id.buttonClosingBr);
        sqrtB = view.findViewById(R.id.buttonSqrt);

        sinB.setOnClickListener(this);
        cosB.setOnClickListener(this);
        tanB.setOnClickListener(this);
        lnB.setOnClickListener(this);
        lgB.setOnClickListener(this);
        factB.setOnClickListener(this);
        piB.setOnClickListener(this);
        expB.setOnClickListener(this);
        powB.setOnClickListener(this);
        openingB.setOnClickListener(this);
        closingB.setOnClickListener(this);
        sqrtB.setOnClickListener(this);

        return view;
    }

    private String appendToText(CharSequence text1, String str2) {
        return new StringBuilder().append(text1).append(str2).toString();
    }

    @Override
    public void onClick(View v) {
        TextView exprTextView = getActivity().findViewById(R.id.textViewBig);
        String expr;
        switch (v.getId()) {

            case R.id.buttonSin:
                expr = appendToText(exprTextView.getText(), "sin(");
                exprTextView.setText(expr);
                break;

            case R.id.buttonCos:
                expr = appendToText(exprTextView.getText(), "cos(");
                exprTextView.setText(expr);
                break;

            case R.id.buttonTan:
                expr = appendToText(exprTextView.getText(), "tan(");
                exprTextView.setText(expr);
                break;

            case R.id.buttonLn:
                expr = appendToText(exprTextView.getText(), "ln(");
                exprTextView.setText(expr);
                break;

            case R.id.buttonLog:
                expr = appendToText(exprTextView.getText(), "log10(");
                exprTextView.setText(expr);
                break;

            case R.id.buttonFact:
                expr = appendToText(exprTextView.getText(), "!");
                exprTextView.setText(expr);
                break;

            case R.id.buttonPi:
                expr = appendToText(exprTextView.getText(), "pi");
                exprTextView.setText(expr);
                break;

            case R.id.buttonExp:
                expr = appendToText(exprTextView.getText(), "e");
                exprTextView.setText(expr);
                break;

            case R.id.buttonPow:
                expr = appendToText(exprTextView.getText(), "^");
                exprTextView.setText(expr);
                break;

            case R.id.buttonOpeningBr:
                expr = appendToText(exprTextView.getText(), "(");
                exprTextView.setText(expr);
                break;

            case R.id.buttonClosingBr:
                expr = appendToText(exprTextView.getText(), ")");
                exprTextView.setText(expr);
                break;

            case R.id.buttonSqrt:
                expr = appendToText(exprTextView.getText(), "sqrt(");
                exprTextView.setText(expr);
                break;

            default:
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
