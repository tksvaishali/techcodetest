package coding.com.techcodetesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The FirstProgramActivity is for program 1 : Given an input with a string, use recursion to find the first position letter a is on.
 */
public class FirstProgramActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etInput;
    private TextView txtOutput;
    private Button btnShowresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_program);
        initUI();
    }

    /**
     * Initialise UI
     */
    private void initUI() {
        etInput = findViewById(R.id.etInput);
        txtOutput = findViewById(R.id.txtOutput);
        btnShowresult = findViewById(R.id.btnFindChar);

        btnShowresult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnShowresult) {
            String stringInput = etInput.getText().toString();

            int charIndex = findCharacter('a', stringInput, 0);
            if (charIndex == -1) {
                txtOutput.setText(getString(R.string.position_at) + " " + getString(R.string.n_a));
            } else {
                txtOutput.setText(getString(R.string.position_at) + " " + (charIndex + 1));
            }
        }
    }

    /**
     * This method will find character in the input string and returns the first index if found using recursion
     *
     * @param ch          Character to find in given string
     * @param inputString the given input string
     * @param currentIdx  current index to start search
     * @return index of first occurence of character in given string if found
     */
    private int findCharacter(char ch, String inputString, int currentIdx) {
        if (inputString.isEmpty()) {
            return -1;
        }
        return inputString.charAt(0) == ch ? currentIdx : findCharacter(ch, inputString.substring(1), ++currentIdx);
    }
}
