package com.example.calculateapp;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

public class NumModeFragment extends Fragment implements View.OnClickListener {
    private Button toSciModeButton;
    private Button zeroB, oneB, twoB, threeB, fourB, fiveB, sixB, sevenB,
    eightB, nineB;
    private Button multB, divideB, plusB, minusB, equalB, dotB, delB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_num_mode, container, false);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT ) {
            toSciModeButton = view.findViewById(R.id.buttonToSci);
            if (BuildConfig.FLAVOR.equals("demo") || BuildConfig.FLAVOR.equals("demoDebug")) {
                toSciModeButton.setVisibility(View.GONE);
            }
            toSciModeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int action = R.id.action_basic_to_scientific_mode;
                    Navigation.findNavController(view).navigate(action);
                }
            });
        }
        final TextView exprTextView = getActivity().findViewById(R.id.textViewBig);

        zeroB = view.findViewById(R.id.button0);
        oneB = view.findViewById(R.id.button1);
        twoB = view.findViewById(R.id.button2);
        threeB = view.findViewById(R.id.button3);
        fourB = view.findViewById(R.id.button4);
        fiveB = view.findViewById(R.id.button5);
        sixB = view.findViewById(R.id.button6);
        sevenB = view.findViewById(R.id.button7);
        eightB = view.findViewById(R.id.button8);
        nineB = view.findViewById(R.id.button9);
        multB = view.findViewById(R.id.buttonMult);
        divideB = view.findViewById(R.id.buttonDivide);
        plusB = view.findViewById(R.id.buttonPlus);
        minusB = view.findViewById(R.id.buttonMinus);
        equalB = view.findViewById(R.id.buttonEqual);
        dotB = view.findViewById(R.id.buttonDot);
        delB = view.findViewById(R.id.buttonDelete);

        zeroB.setOnClickListener(this);
        oneB.setOnClickListener(this);
        twoB.setOnClickListener(this);
        threeB.setOnClickListener(this);
        fourB.setOnClickListener(this);
        fiveB.setOnClickListener(this);
        sixB.setOnClickListener(this);
        sevenB.setOnClickListener(this);
        eightB.setOnClickListener(this);
        nineB.setOnClickListener(this);
        multB.setOnClickListener(this);
        divideB.setOnClickListener(this);
        minusB.setOnClickListener(this);
        plusB.setOnClickListener(this);
        equalB.setOnClickListener(this);
        dotB.setOnClickListener(this);
        delB.setOnClickListener(this);
        delB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView exprTextView = getActivity().findViewById(R.id.textViewBig);
                TextView smallTextView = getActivity().findViewById(R.id.textViewSmall);
                exprTextView.setText("");
                smallTextView.setText("");
                return true;
            }
        });

        return view;
    }

    private String appendToText(CharSequence text1, String str2) {
        return text1 + str2;
    }

    @Override
    public void onClick(View v) {
        TextView exprTextView = getActivity().findViewById(R.id.textViewBig);
        TextView smallTextView = getActivity().findViewById(R.id.textViewSmall);
        String expr;
        switch (v.getId()) {

            case R.id.button0:
                expr = appendToText(exprTextView.getText(), "0");
                exprTextView.setText(expr);
                break;

            case R.id.button1:
                expr = appendToText(exprTextView.getText(), "1");
                exprTextView.setText(expr);
                break;

            case R.id.button2:
                expr = appendToText(exprTextView.getText(), "2");
                exprTextView.setText(expr);
                break;

            case R.id.button3:
                expr = appendToText(exprTextView.getText(), "3");
                exprTextView.setText(expr);
                break;

            case R.id.button4:
                expr = appendToText(exprTextView.getText(), "4");
                exprTextView.setText(expr);
                break;

            case R.id.button5:
                expr = appendToText(exprTextView.getText(), "5");
                exprTextView.setText(expr);
                break;

            case R.id.button6:
                expr = appendToText(exprTextView.getText(), "6");
                exprTextView.setText(expr);
                break;

            case R.id.button7:
                expr = appendToText(exprTextView.getText(), "7");
                exprTextView.setText(expr);
                break;

            case R.id.button8:
                expr = appendToText(exprTextView.getText(), "8");
                exprTextView.setText(expr);
                break;

            case R.id.button9:
                expr = appendToText(exprTextView.getText(), "9");
                exprTextView.setText(expr);
                break;

            case R.id.buttonMult:
                expr = appendToText(exprTextView.getText(), "*");
                exprTextView.setText(expr);
                break;

            case R.id.buttonDivide:
                expr = appendToText(exprTextView.getText(), "/");
                exprTextView.setText(expr);
                break;

            case R.id.buttonMinus:
                expr = appendToText(exprTextView.getText(), "-");
                exprTextView.setText(expr);
                break;

            case R.id.buttonPlus:
                expr = appendToText(exprTextView.getText(), "+");
                exprTextView.setText(expr);
                break;

            case R.id.buttonEqual:
                expr = exprTextView.getText().toString();
                double answer = Calculator.calculate(expr);
                String out = isNaN(answer) ? "Wrong Expression" : Double.toString(answer);
                smallTextView.setText(out);
                break;

            case R.id.buttonDot:
                expr = appendToText(exprTextView.getText(), ".");
                exprTextView.setText(expr);
                break;
            case R.id.buttonDelete:
                String str = exprTextView.getText().toString();
                if (!str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    exprTextView.setText(str);
                    if (str.equals("")) {
                        smallTextView.setText("");
                    }
                }

                break;

            default:
                break;
        }

    }
}
