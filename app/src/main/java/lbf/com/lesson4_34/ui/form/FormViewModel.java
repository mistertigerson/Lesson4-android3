package lbf.com.lesson4_34.ui.form;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lbf.com.lesson4_34.App;
import lbf.com.lesson4_34.common.Resource;
import lbf.com.lesson4_34.data.models.Post;

public class FormViewModel extends ViewModel {

    public LiveData<Resource<Post>> postLiveData;
    public LiveData<List<Post>> listLiveData;
    public LiveData<Resource<Post>> putLiveData;

    void createPost(Post post) {
        postLiveData = App.hRepository.createPost(post);
    }

    void getList(){
        listLiveData = App.hRepository.getPost();
    }

    void putPost(String id, Post post){
        putLiveData = App.hRepository.putPost(id, post);
    }



}
