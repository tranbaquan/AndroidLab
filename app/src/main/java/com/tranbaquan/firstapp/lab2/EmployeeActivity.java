package com.tranbaquan.firstapp.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.tranbaquan.firstapp.R;
import com.tranbaquan.firstapp.lab2.model.Employee;
import com.tranbaquan.firstapp.lab2.model.FullTimeEmployee;
import com.tranbaquan.firstapp.lab2.model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

import static android.widget.RadioGroup.*;

public class EmployeeActivity extends AppCompatActivity {

    private Button addEmployee;
    private RadioGroup workingType;
    private EditText workingDay;
    private EditText employeeId;
    private EditText employeeName;
    private Employee employee;
    private ListView listView;
    private List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        addEmployee = findViewById(R.id.bt_add_employee);
        workingType = findViewById(R.id.rg_working_type);
        employees = new ArrayList<>();

        workingType.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                doEmployeeTypeChange(id);
            }
        });


        addEmployee.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                employee = new PartTimeEmployee();
                setEmployeeField();
                addToList();
            }
        });
    }

    private void addToList() {
        listView = findViewById(R.id.lv_result);
        employees.add(employee);
        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, employees);
        listView.setAdapter(adapter);
    }

    private void setEmployeeField() {
        workingDay = findViewById(R.id.et_working_day);
        employeeId = findViewById(R.id.et_employee_id);
        employeeName = findViewById(R.id.et_employee_name);

        String num = workingDay.getText().toString();
        int numDay = Integer.parseInt(num);

        employee.setWorkingDay(numDay);
        employee.setEmployeeId(employeeId.getText().toString());
        employee.setEmployeeName(employeeName.getText().toString());
    }

    private void doEmployeeTypeChange(int id) {
        if(id == R.id.rb_part_time) {
            employee = new PartTimeEmployee();
        }else {
            employee = new FullTimeEmployee();
        }
    }
}
