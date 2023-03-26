package com.nurdan.caltur;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.nurdan.caltur.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnZero.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "0");
            }
        });


        binding.btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "1");
            }
        });

        binding.btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "2");
            }
        });

        binding.btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "3");
            }
        });

        binding.btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "4");
            }
        });

        binding.btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "5");
            }
        });

        binding.btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "6");
            }
        });

        binding.btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "7");
            }
        });

        binding.btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "8");
            }
        });

        binding.btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText(binding.txtInput.getText() + "9");
            }
        });

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = binding.txtInput.getText().toString();
                if (value.isEmpty()) return;
                binding.txtInput.setText(value.substring(0, value.length() - 1));
            }
        });


        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtInput.setText("");
                binding.txtOutput.setText("");
            }
        });

        binding.btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLastCharNotSymbol()) {
                    binding.txtInput.setText(binding.txtInput.getText() + "%");
                }
            }
        });


        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLastCharNotSymbol()) {
                    binding.txtInput.setText(binding.txtInput.getText() + "/");
                }
            }
        });


        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLastCharNotSymbol()) {
                    binding.txtInput.setText(binding.txtInput.getText() + "*");
                }
            }
        });


        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLastCharNotSymbol()) {
                    binding.txtInput.setText(binding.txtInput.getText() + "-");
                }
            }
        });


        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLastCharNotSymbol()) {
                    binding.txtInput.setText(binding.txtInput.getText() + "+");
                }
            }
        });


        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLastCharNotSymbol()) {
                    binding.txtInput.setText(binding.txtInput.getText() + ".");
                }
            }
        });

        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String operation = binding.txtInput.getText().toString();
                if (operation.isEmpty()) return;


                try {
                    Expression expression = new ExpressionBuilder(operation).build();
                    double result = expression.evaluate();
                    binding.txtOutput.setText(Double.toString(result));
                } catch (Exception e) {
                    binding.txtOutput.setText("Hatali giris!");
                }

            }
        });


    }

    public Boolean checkLastCharNotSymbol() {
        String value = binding.txtInput.getText().toString();

        if (value.isEmpty()) return false;

        String[] symbols = new String[]{".", "+", "-", "*", "/", "%"};
        Boolean result = true;

        if (value.length() == 1) {
            for (int i = 0; i < symbols.length; i++) {
                if (value.equals(symbols[i])) {
                    result = false;
                }
            }
        } else {
            String lastChar = value.substring(value.length() - 1);
            for (int i = 0; i < symbols.length; i++) {
                if (lastChar.equals(symbols[i])) {
                    result = false;
                }
            }
        }
        return result;
    }
}