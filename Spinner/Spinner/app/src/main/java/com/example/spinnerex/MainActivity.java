package com.example.spinnerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner, TextView 객체 선언 및 activity_main의 위젯과 연결
        Spinner spinner = findViewById(R.id.spinner);
        TextView tv_res = findViewById(R.id.tv_res);

        // String 배열 선언 및 내부에 스피너에 할당할 값을 지정
        String[] values = {"대덕", "소프트웨어", "마이스터", "고등학교", "안드로이드", "화이팅"};

        /* Spinner 배경과 값을 매칭 시켜줄 ArrayAdapter(배열 어댑터) 생성, 파라미터 값 :
        1. 현재 액티비티,2. Spinner의 배경을 보여줄 레이아웃, 3. Spinner 내부 값 지정 */
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (MainActivity.this,
                        android.R.layout.simple_spinner_item,
                        values);

        // Spinner를 펼쳤을 때 보여줄 배경의 레이아웃 지정
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 설정한 Adapter를 Spinner에 할당
        spinner.setAdapter(arrayAdapter);

        // Spinner에 OnItemSelectedListener 지정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Spinner 안의 아이템 선택 시 실행
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long id) {

                /* Spinner에서 선택된 아이템의 index(position)을 가진
                values 값을 tv_res TextView에 할당*/
                tv_res.setText(values[position]);

            }
            
            // Spinner의 아이템을 선택하지 않았을 시 실행
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                tv_res.setText("default");

            }

        });

    }

}