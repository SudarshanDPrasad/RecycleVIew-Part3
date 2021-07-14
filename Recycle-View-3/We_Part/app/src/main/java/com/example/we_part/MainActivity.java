package com.example.we_part;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {


    private ArrayList<Employee> employeeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEditCardView;
    private EditText mEtName;
    private EditText mEtAdress;
    private EditText mEtAge;
    private Button mbtnDone;
    private EmployeeAdapter employeeAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intidviews();
        buildEmployee();
        setRecycleView();
    }

    private void setRecycleView() {
        employeeAdapter = new EmployeeAdapter(employeeList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    private void buildEmployee() {
        for (int i = 0; i < 50; i++) {
            Employee employee = new Employee("sudarshan", 27, "Mysore" + i);
            employeeList.add(employee);
        }
    }

    private void intidviews() {
        recyclerView = findViewById(R.id.recycleview);
        mEditCardView = findViewById(R.id.editCardView);
        mEtAdress = findViewById(R.id.etAddress);
        mEtAge = findViewById(R.id.etAge);
        mEtName = findViewById(R.id.etName);
        mbtnDone = findViewById(R.id.btnDone);
    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        mEditCardView.setVisibility(View.VISIBLE);
        mEtName.setText(employee.getName());
        mEtAge.setText(employee.getAge()+" ");
        mEtAdress.setText(employee.getAddress());
        mbtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditCardView.setVisibility(View.GONE);
                Employee new_employee = new Employee(mEtName.getText().toString(),Integer.parseInt(mEtAge.getText().toString()),
                        mEtAdress.getText().toString());
                // too add or change the list //
                employeeList.set(position,new_employee);
                employeeAdapter.notifyDataSetChanged();

                // to remove te element
                employeeList.remove(employee);

            }
        });
    }
}