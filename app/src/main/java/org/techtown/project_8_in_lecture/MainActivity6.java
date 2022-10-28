package org.techtown.project_8_in_lecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
/*예제 14, 15*/
/*지정한 폴더의 하위 폴더 및 파일 목록에 접근하기*/

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //위젯 선언
        Button btnFilelist;
        final EditText edtFilelist; // final로 선언하면 뭐가 좋길래, 그러는거지?

        //위젯 연결
        btnFilelist = findViewById(R.id.btnFilelist);
        edtFilelist = findViewById(R.id.edtFilelist);

        //btnFilelist 버튼 클릭이벤트
        btnFilelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();//getAbsolutePath() : 절대경로를 리턴함
                File[] sysFiles = (new File(sysDir).listFiles()); //listFiles() : 디렉토리의 파일 목록을 File 배열로 반환한다.

                String strFname;
                for(int i=0;i<sysFiles.length;i++){
                    if(sysFiles[i].isDirectory() == true) //isDirectory() : 경로에 있는 객체가 Folder 이면 true 리턴, 아니면 false 리턴
                        strFname ="<폴더> "+ sysFiles[i].toString();
                    else
                        strFname = "<파일> " + sysFiles[i].toString();

                    edtFilelist.setText(edtFilelist.getText()+"\n" + strFname);
                }
            }
        });


    }
}