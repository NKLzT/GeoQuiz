package com.nik.geoquiz;

import static android.widget.Toast.*;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;

    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
      new Question(R.string.pergunta1, true),
      new Question(R.string.pergunta2, true), new Question(R.string.pergunta3, true),
            new Question(R.string.pergunta4, false), new Question(R.string.pergunta5, false)
    };

    private int mCurrentIndex = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);


            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mPreviousButton = (Button) findViewById(R.id.previuous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

    }

    private void checkAnswer() {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.errada_toast, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }


    private void updateQuestion() {
        if (mQuestionTextView != null) {
            int question = mQuestionBank[mCurrentIndex].getmTextResId();
            mQuestionTextView.setText(question);
        }
    }

    private void checkAnswer(boolean userPassedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTRue();

        int messageResId = 0;

        if(userPassedTrue == answerIsTrue) {
            messageResId = R.string.correta_toast;
        }else {
            messageResId = R.string.errada_toast;
        }

        Toast.makeText(this, messageResId, LENGTH_SHORT)
                .show();
    }
}