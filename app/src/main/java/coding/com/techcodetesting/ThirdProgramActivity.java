package coding.com.techcodetesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The ThirdProgramActivity is for program 3 : Write a calculator which takes in a number of string input and perform calculation. The input can accept a number of operators.
 */
public class ThirdProgramActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etInput;
    private TextView txtOutput;
    private Button btnRunProgram;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_program);
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
            stringInput = stringInput.replaceAll("\\s","");
            if (stringInput.contains("--")) {
                stringInput = stringInput.replace("--", "+");
            }

            if (stringInput.contains("/0")) {
                txtOutput.setText(getString(R.string.error_division_by_zero));
            } else {
                try {
                    int another = (int) computeAnother(stringInput);
                    txtOutput.setText(another + "");
                } catch (NumberFormatException ex) {
                    txtOutput.setText(getString(R.string.error_syntax_error));
                }
            }
        }
    }

    /**
     * This method will compute the math expression in string format and return double value
     *
     * @param equation String equation
     * @return double calculated result
     * @throws NumberFormatException throws if number format exception occurs
     */
    double computeAnother(String equation) throws NumberFormatException {
        double result = 0.0;
        try {
            if(equation.startsWith("-")|| equation.startsWith("+") ){
                equation = "0" + equation;
            }

            String noMinus = equation.replace("-", "+-");
            String[] byPluses = noMinus.split("\\+");

            for (String multipl : byPluses) {
                String[] byMultipl = multipl.split("\\*");
                double multiplResult = 1.0;
                for (String operand : byMultipl) {
                    if (operand.contains("/")) {
                        String[] division = operand.split("\\/");
                        double divident = Double.parseDouble(division[0]);
                        for (int i = 1; i < division.length; i++) {
                            divident /= Double.parseDouble(division[i]);
                        }
                        multiplResult *= divident;
                    } else if (operand.contains("%")) {
                        String[] division = operand.split("\\%");
                        double remainder = Double.parseDouble(division[0]);
                        for (int i = 1; i < division.length; i++) {
                            remainder %= Double.parseDouble(division[i]);
                        }
                        multiplResult *= remainder;
                    } else {
                        multiplResult *= Double.parseDouble(operand);
                    }
                }
                result += multiplResult;
            }
        } catch (NumberFormatException ex) {
            throw ex;
        }
        return result;
    }
}
