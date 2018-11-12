package coding.com.techcodetesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * The MainActivity displays button for different program
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnProgram1, btnProgram2, btnProgram3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     * Initialise UI
     */
    private void initUI() {
        btnProgram1 = findViewById(R.id.btnProgram1);
        btnProgram2 = findViewById(R.id.btnProgram2);
        btnProgram3 = findViewById(R.id.btnProgram3);

        btnProgram1.setOnClickListener(this);
        btnProgram2.setOnClickListener(this);
        btnProgram3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnProgram1) {
            openFirstProgramActivity();
        }
    }

    /**
     * This method will open the First Program activity
     */
    private void openFirstProgramActivity() {
        Intent intent = new Intent(this, FirstProgramActivity.class);
        startActivity(intent);
    }
}
