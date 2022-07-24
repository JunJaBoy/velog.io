activity_main

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center"
    tools:context=".MainActivity">

    <!-- 기본형 DatePicker 'datePicker1' 선언 -->
    <DatePicker
        android:id="@+id/datePicker1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0" />

    <!-- spinner형 DatePicker 'datePicker2' 선언 -->
    <DatePicker
        android:id="@+id/datePicker2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="8dp"
        android:calendarViewShown="false"
        android:datePickerMode="spinner"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="@+id/datePicker1"
        app:layout_constraintTop_toBottomOf="@+id/datePicker1" />


    <!-- datePicker1 날짜 표시 -->
    <TextView
        android:id="@+id/tv_datePicker1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="DATE1"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/datePicker2"
        app:layout_constraintTop_toBottomOf="@+id/datePicker1" />

    <!-- datePicker2 날짜 표시 -->
    <TextView
        android:id="@+id/tv_datePicker2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="DATE2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/datePicker2"
        app:layout_constraintTop_toBottomOf="@+id/tv_datePicker1" />

</androidx.constraintlayout.widget.ConstraintLayout>
```



MainActivity

```java
package com.example.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker1, datePicker2; // DatePicker 선언
    private TextView tv_datePicker1, tv_datePicker2; // TextView 선언
//activity_main의 @+id, MainActivity의 변수명은 같은 이름으로 두는 것이 좋음

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위에서 선언한 DatePicker, TextView를 xml 위젯과 연동
        datePicker1 = findViewById(R.id.datePicker1);
        datePicker2 = findViewById(R.id.datePicker2);
        tv_datePicker1 = findViewById(R.id.tv_datePicker1);
        tv_datePicker2 = findViewById(R.id.tv_datePicker2);

        //DatePicker의 선택된 날짜가 변경될 때 반응하는 Listener 선언

        // 기본형 DatePicker(datePicker1)의 날짜가 변경될 때 동작
        datePicker1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) { // y(연), m(월), d(일)이 변경되면 동작
                tv_datePicker1.setText(y + "년 " + (m + 1) + "월 " + d + "일");
            }
        });

        // spinner형 DatePicker(datePicker2)의 날짜가 변경될 때 동작
        datePicker2.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) { // y(연), m(월), d(일)이 변경되면 동작
                tv_datePicker2.setText(y + "년 " + (m + 1) + "월 " + d + "일");
            }
        });
    }
}
```

