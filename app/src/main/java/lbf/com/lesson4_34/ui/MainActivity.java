package lbf.com.lesson4_34.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import kotlin.jvm.internal.PropertyReference0Impl;
import lbf.com.lesson4_34.R;
import lbf.com.lesson4_34.data.models.Film;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getFilms();

        viewModel.films.observe(this, new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                Log.d("TAG", "onChanged: ");
            }
        });
    }


}