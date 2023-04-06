package ro.pub.cs.systems.eim.practicaltest01var05mainactivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ro.pub.cs.systems.eim.practicaltest01var05mainactivity.databinding.ActivityPracticalTest01Var05SecondaryBinding;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    Button verify_button;
    Button cancel_button;

    private AppBarConfiguration appBarConfiguration;
    private ActivityPracticalTest01Var05SecondaryBinding binding;

    String message;
    int nrClicks = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.verify_button:
                    System.out.println("ok\n");
//                    setResult(RESULT_OK, new Intent().putExtra("sum_label", sum));
                    break;
                case R.id.cancel_button:
                    System.out.println("cancel\n");
                    setResult(RESULT_CANCELED);
                    break;

            }

            finish();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        textView = (TextView) findViewById(R.id.concatme_editText);
        textView2 = (TextView) findViewById(R.id.numberOfClicks_TextView);

        verify_button = (Button) findViewById(R.id.verify_button);
        cancel_button = (Button) findViewById(R.id.cancel_button);

        cancel_button.setOnClickListener(buttonClickListener);
        verify_button.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null) {
            System.out.println("da5\n");
            message = intent.getStringExtra("concateMe");
            nrClicks = intent.getIntExtra("nrClicks", 0);
            System.out.println("got message " + message);
            textView.setText(message);
            textView2.setText(String.valueOf(nrClicks));

        }




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            System.out.println("TOAST!\n");
            if (resultCode == RESULT_OK) {

                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show();
//                sum = intent.getIntExtra("sum_label", 0);
//                System.out.println("OnActivityResult sum = " + sum +  "\n");
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCEL", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_practical_test01_var05_secondary);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}