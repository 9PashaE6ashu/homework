package ru.techpark.homework1;


import android.graphics.Color;
import android.os.Bundle;

import ru.techpark.homework1.Data.CommonConst;
import ru.techpark.homework1.Fragments.FirstFragment;
import ru.techpark.homework1.Fragments.SecondFragment;
import ru.techpark.homework1.Interfaces.OnItemSelectedListener;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_acticity);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment first = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (first == null) {
                transaction.add(R.id.fragment_container, new FirstFragment());
            }
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1) {
            moveTaskToBack(false);
        }
        else {
            super.onBackPressed();
        }
    }

    public void onItemSelected(String numberItem) {
        SecondFragment newFragment = new SecondFragment();
        Bundle args = new Bundle();
        int i = Integer.parseInt(numberItem);
        args.putInt(CommonConst.EXTRA_NUMBER, i);
        int color = (i % 2 == 0) ? Color.RED : Color.BLUE;
        args.putInt(CommonConst.EXTRA_NUMBER_COLOR, color);
        newFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit();
    }

}
