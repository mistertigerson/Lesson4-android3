package lbf.com.lesson4_34;

import android.app.Application;

import lbf.com.lesson4_34.data.remote.GhibliApi;
import lbf.com.lesson4_34.data.remote.HerokuApi;
import lbf.com.lesson4_34.data.remote.RetrofitClient;
import lbf.com.lesson4_34.data.repository.GhibliRepository;
import lbf.com.lesson4_34.data.repository.HerokuRepository;

public class App extends Application {

    public static GhibliApi api;
    public static GhibliRepository repository;
    public static HerokuApi hApi;
    public static HerokuRepository hRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient client = new RetrofitClient();
        api = client.provideGhibliApi();
        repository = new GhibliRepository();
        hApi = client.provideHerokuApi();
        hRepository = new HerokuRepository();
    }
}
