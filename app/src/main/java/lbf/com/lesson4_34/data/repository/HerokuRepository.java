package lbf.com.lesson4_34.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import lbf.com.lesson4_34.App;
import lbf.com.lesson4_34.common.Resource;
import lbf.com.lesson4_34.data.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class HerokuRepository {

    public MutableLiveData<Resource<Post>> putPost(String id, Post post) {
        MutableLiveData<Resource<Post>> putLivedata = new MutableLiveData<>();
        putLivedata.setValue(Resource.loading(null));
        App.hApi.putPost("0", post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    putLivedata.setValue(Resource.success(response.body()));
                } else {
                    putLivedata.setValue(Resource.error(response.errorBody().toString(), null));
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                putLivedata.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
        return putLivedata;
    }

    public MutableLiveData<Resource<Post>> createPost(Post post){
        MutableLiveData<Resource<Post>> responseLiveData = new MutableLiveData<>();
        responseLiveData.setValue(Resource.loading(null));
        App.hApi.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null){
                    responseLiveData.setValue(Resource.success(response.body()));
                }else {
                    responseLiveData.setValue(Resource.error(response.errorBody().toString(),null));
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                responseLiveData.setValue(Resource.error(t.getLocalizedMessage(),null));

            }
        });
        return responseLiveData;
    }

    public MutableLiveData<List<Post>> getPost(){
        MutableLiveData<List<Post>> listMutableLiveData = new MutableLiveData<>();
        App.hApi.getPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                ArrayList<Post> list = (ArrayList<Post>) response.body();
                if (response.isSuccessful() && response.body()!=null){
                    listMutableLiveData.setValue((ArrayList<Post>) response.body());
                }
                else {
                    listMutableLiveData.setValue((List<Post>) response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("TAG", "onFailure:sdaglhdsaughuiwqiuiuqbiuqeburbqiuerqiu "  );

            }
        });
        return listMutableLiveData;
    }
}
