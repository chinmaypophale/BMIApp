package com.bmitestbna.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {
    EditText weight, height;
    Float fW, fH;
    TextView textBmi;
    Button bmiButton, dpbutton;
    Float bmi ;
    Spinner spinner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("BMI");




        View v=inflater.inflate(R.layout.home_fragment, container, false);
        bmiButton = (Button) v.findViewById(R.id.bmibutton);

        weight = (EditText) v.findViewById(R.id.editWeight);    // stores weight
        height = (EditText) v.findViewById(R.id.editHeight);    //stores height

        textBmi = (TextView) v.findViewById(R.id.bmi);
        spinner = (Spinner) v.findViewById(R.id.spinner);
        dpbutton = (Button) v.findViewById(R.id.dpButton);

        bmiButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //do your operation here


                if (weight.getText().toString().equals("")) {
                    weight.setError("Weight cannot be blank");
                    weight.requestFocus();
                    return;
                }

                if (height.getText().toString().equals("")) {
                    height.setError("Height cannot be blank");
                    height.requestFocus();
                    return;
                }

                fW = Float.valueOf(weight.getText().toString());    // converts weight into a float no
                fH = Float.valueOf(height.getText().toString());    // converts height into a float no


                if (fW == 0) {
                    weight.setError("Please enter proper weight");
                    weight.requestFocus();
                    return;
                }

                if (fH == 0) {
                    height.setError("Please enter proper height");
                    height.requestFocus();
                    return;
                }

                bmi = fW/(fH*fH);
                textBmi.setText("Your BMI is "+bmi.toString());



            }
        });

        dpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().equals("None")) {
                    if (bmi < 18.5) {
                        //under
                        Intent intent = new Intent(getActivity(),Underweight.class);
                        getActivity().startActivity(intent);
                    }
                    else if (bmi >= 18.5 && bmi <=24.9) {
                        //normal
                        Intent intent = new Intent(getActivity(),Normal.class);
                        getActivity().startActivity(intent);

                    }
                    else if (bmi > 24.9 && bmi <=30 ) {
                        //over
                        Intent intent = new Intent(getActivity(),Overweight.class);
                        getActivity().startActivity(intent);
                    }
                    else if (bmi > 30) {
                        //obese
                        Intent intent = new Intent(getActivity(),Obese.class);
                        getActivity().startActivity(intent);
                    }
                }   // none

                else if(spinner.getSelectedItem().toString().equals("Anemia")){
                    Intent intent = new Intent(getActivity(),Anaemia.class);
                    getActivity().startActivity(intent);
                }

                else if(spinner.getSelectedItem().toString().equals("Cancer")){
                    Intent intent = new Intent(getActivity(),Cancer.class);
                    getActivity().startActivity(intent);
                }

                else if(spinner.getSelectedItem().toString().equals("Diarrhoea")){
                    Intent intent = new Intent(getActivity(),Diarrhoea.class);
                    getActivity().startActivity(intent);
                }

                else if(spinner.getSelectedItem().toString().equals("Diabetes")){
                    Intent intent = new Intent(getActivity(),Diabetes.class);
                    getActivity().startActivity(intent);

                }

                else if(spinner.getSelectedItem().toString().equals("Food Poisioning")){
                    Intent intent = new Intent(getActivity(),FoodPoisioning.class);
                    getActivity().startActivity(intent);
                }
                else if(spinner.getSelectedItem().toString().equals("Heart Disease")){
                    Intent intent = new Intent(getActivity(),HeartDisease.class);
                    getActivity().startActivity(intent);
                }

                else if(spinner.getSelectedItem().toString().equals("Malnutrition")){
                    Intent intent = new Intent(getActivity(),Malnutrition.class);
                    getActivity().startActivity(intent);
                }

                else if(spinner.getSelectedItem().toString().equals("PCOS")){
                    Intent intent = new Intent(getActivity(),Pcos.class);
                    getActivity().startActivity(intent);
                }

                else if(spinner.getSelectedItem().toString().equals("Thyroid")){
                    Intent intent = new Intent(getActivity(),Thyroid.class);
                    getActivity().startActivity(intent);
                }

            }
        });
        return v;

    }
}