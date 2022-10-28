package org.techtown.project_8_in_lecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.IOException;
/*예제 11번*/
/*SD 카드에서 파일 읽기*/

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //위젯 생성
        Button btnRead;
        final EditText edtSD;

        //위젯 연결
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);

        //권한 요청
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        Log.d("MainActivity3", "병훈2");


        //버튼 클릭이벤트
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity3", "병훈3");

                try{
                    //FileInputStream 클래스 : 데이터를 읽거나 쓸 수 있다. 파일 설정함
                    FileInputStream inFs = new FileInputStream("raw/test.txt");
                    Log.d("MainActivity3", "병훈1");
                    byte[]txt = new byte[inFs.available()];
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    inFs.close();

                }catch (IOException e){

                }
            }
        });
    }
}