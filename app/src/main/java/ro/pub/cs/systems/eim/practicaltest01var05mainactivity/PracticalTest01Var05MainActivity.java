package ro.pub.cs.systems.eim.practicaltest01var05mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private Button top_left_button;
    private Button top_right_button;
    private Button bottom_left_button;
    private Button bottom_right_button;
    private Button center_button;

    private Button buttongo;

    private TextView concate_me_editText;

    String concatMe = "";
    int nrClicks = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button1:
                    System.out.println("da1\n");
                    concatMe += "TopLeft, ";
                    nrClicks++;
                    break;
                case R.id.button2:
                    System.out.println("da2\n");
                    concatMe += "TopRight, ";
                    nrClicks++;
                    break;
                case R.id.button3:
                    System.out.println("da3\n");
                    concatMe += "Center, ";
                    nrClicks++;
                    break;
                case R.id.button4:
                    System.out.println("da4\n");
                    concatMe += "BottomRight, ";
                    break;
                case R.id.button5:
                    System.out.println("da5\n");
                    concatMe += "BottomLeft, ";
                    nrClicks++;
                    break;
                case R.id.buttongo:
                    System.out.println("da6\n");
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                    System.out.println("da3\n");
                    intent.putExtra("concateMe", concatMe);
                    intent.putExtra("nrClicks", nrClicks);
                    startActivityForResult(intent, 1);
            }
            System.out.println(concatMe);
            concate_me_editText.setText(String.valueOf(concatMe));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        top_left_button = (Button) findViewById(R.id.button1);
        top_right_button = (Button) findViewById(R.id.button2);
        center_button = (Button) findViewById(R.id.button5);
        bottom_left_button = (Button) findViewById(R.id.button3);
        bottom_right_button = (Button) findViewById(R.id.button4);
        buttongo = (Button) findViewById(R.id.buttongo);

        top_left_button.setOnClickListener(buttonClickListener);
        top_right_button.setOnClickListener(buttonClickListener);
        center_button.setOnClickListener(buttonClickListener);
        bottom_left_button.setOnClickListener(buttonClickListener);
        bottom_right_button.setOnClickListener(buttonClickListener);

        buttongo.setOnClickListener(buttonClickListener);
        concate_me_editText = (TextView) findViewById(R.id.concate_me_text);



    }
}