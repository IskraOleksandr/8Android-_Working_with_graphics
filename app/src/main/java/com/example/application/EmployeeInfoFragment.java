package com.example.application;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeInfoFragment extends Fragment {
    private TextView textName, textAge, textProffesion;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_info, container, false);

        imageView = view.findViewById(R.id.image_employee);
        textName = view.findViewById(R.id.text_employee_name);
        textAge = view.findViewById(R.id.text_employee_age);
        textProffesion = view.findViewById(R.id.text_employee_profession);

        Bundle bundle = getArguments();

        Employee employee = (Employee) bundle.getSerializable("Employee");

        if (employee != null) {
            textName.setText(getResources().getString(R.string.emp_name)+ "\n"+ employee.getName());
            textProffesion.setText(getResources().getString(R.string.emp_position)+ "\n"+ employee.getProffesion());
            textAge.setText(getResources().getString(R.string.emp_age) + employee.getAge());


            try(InputStream inputStream = getActivity().getApplicationContext().getAssets().open(employee.getPhoto())){
                Drawable drawable = Drawable.createFromStream(inputStream, null);
                imageView.setImageDrawable(drawable);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        return view;
    }

}