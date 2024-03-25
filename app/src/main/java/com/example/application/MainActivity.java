package com.example.application;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Employee employee = new Employee("Иванов  Сергей Сергеевич", "Менеджер", 28, "icon.png");
        createEmployeeFragment(employee, R.id.lin1);

        Employee employee1 = new Employee("Петров Иван Иванович", "Программист", 32, "icon1.png");
        createEmployeeFragment(employee1, R.id.lin2);
    }

    public void createEmployeeFragment(Employee emp, int containerViewId){
        EmployeeInfoFragment fragment = new EmployeeInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Employee", emp);

        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(containerViewId, fragment).commit();
    }
}