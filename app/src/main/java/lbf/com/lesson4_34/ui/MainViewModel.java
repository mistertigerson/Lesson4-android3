package lbf.com.lesson4_34.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lbf.com.lesson4_34.App;
import lbf.com.lesson4_34.data.models.Film;

public class MainViewModel extends ViewModel {

    public  LiveData<List<Film>> films;

    void getFilms() {
        films = App.repository.getFilms();
    }
}
