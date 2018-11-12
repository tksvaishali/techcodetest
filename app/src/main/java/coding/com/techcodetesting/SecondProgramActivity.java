package coding.com.techcodetesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The SecondProgramActivity is for program 2 : Write a program where, given a number of random string, it will output the the calculated result as a report. The equal signs used for the report title also needs to be printed out.
 */
public class SecondProgramActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etInput;
    private TextView txtOutput;
    private Button btnRunProgram;
    private ArrayList<Character> uniqueCharList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_program);
        initUI();
    }

    /**
     * Initialise UI
     */
    private void initUI() {
        etInput = findViewById(R.id.etInput);
        txtOutput = findViewById(R.id.txtOutput);
        btnRunProgram = findViewById(R.id.btnRunProgram);

        btnRunProgram.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnRunProgram) {
            String stringInput = etInput.getText().toString();
            Map mapCharCount = printReport(stringInput);
            int totalCharCount = 0;
            txtOutput.setText(getString(R.string.report));
            for (int i = 0; i < uniqueCharList.size(); i++) {
                totalCharCount += (int) mapCharCount.get(uniqueCharList.get(i));
                txtOutput.setText(txtOutput.getText().toString() + "\n" + uniqueCharList.get(i) + ": " + mapCharCount.get(uniqueCharList.get(i)));
            }
            txtOutput.setText("\n" + txtOutput.getText().toString() + "\n" + getString(R.string.total_character) + " " + totalCharCount);
        }
    }

    /**
     * This method will return Map of character and its count in the given string
     *
     * @param stringInput Input string
     * @return map of character and its count
     */
    private Map<Character, Integer> printReport(String stringInput) {
        char[] stringCharacter = stringInput.toCharArray();
        uniqueCharList = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : stringCharacter) {

            Integer charCount = charMap.get(ch);
            if (charCount == null) {
                uniqueCharList.add(ch);
            }
            int count = (charCount == null ? 1 : charCount + 1);
            charMap.put(ch, count);
        }
        return charMap;
    }
}