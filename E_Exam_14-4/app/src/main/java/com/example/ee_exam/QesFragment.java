package com.example.ee_exam;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.ee_exam.SecActivity.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class QesFragment extends Fragment {

    private OnFragmentInteractionListener listener;
    private String value;
    public static Question question;
    RandomNum randomNum;


    public QesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) ;
        listener = (OnFragmentInteractionListener) context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qes, container, false);

        TextView textViewQues = view.findViewById(R.id.text_view_ques);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group);
        final RadioButton rb1 = view.findViewById(R.id.rb1);
        final RadioButton rb2 = view.findViewById(R.id.rb2);
        final RadioButton rb3 = view.findViewById(R.id.rb3);
        final RadioButton rb4 = view.findViewById(R.id.rb4);
        Button buttonNext = view.findViewById(R.id.button_next);

        randomNum = new RandomNum();


        question = SecActivity.questions.get(randomQuestions[Score.indexMCQ]);
        String[] options = new String[]{question.getOption_1(), question.getOption_2(), question.getOption_3(), question.getOption_4()};
        int[] randomOptions = randomNum.createRD(0, 3);

        textViewQues.setText(question.getQuestion());
        rb1.setText(options[randomOptions[0]]);
        rb2.setText(options[randomOptions[1]]);
        rb3.setText(options[randomOptions[2]]);
        rb4.setText(options[randomOptions[3]]);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb1:
                        value = rb1.getText().toString();
                        break;
                    case R.id.rb2:
                        value = rb2.getText().toString();
                        break;
                    case R.id.rb3:
                        value = rb3.getText().toString();
                        break;
                    case R.id.rb4:
                        value = rb4.getText().toString();
                        break;

                }
            }
        });


        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        listener.onFragmentInteraction(value);
                    }
                });

        radioGroup.clearCheck();

        return view;
    }

    public static QesFragment newInstance() {

        QesFragment q1Fragment = new QesFragment();

        return q1Fragment;
    }

}





