package ru.techpark.homework1.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.techpark.homework1.R;
import ru.techpark.homework1.Data.CommonConst;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.Number);

        Bundle arguments = getArguments();
        if (arguments != null) {
            int number = arguments.getInt(CommonConst.EXTRA_NUMBER);
            int color = arguments.getInt(CommonConst.EXTRA_NUMBER_COLOR);
            textView.setText(number + "");
            textView.setTextColor(color);
        }
    }
}
