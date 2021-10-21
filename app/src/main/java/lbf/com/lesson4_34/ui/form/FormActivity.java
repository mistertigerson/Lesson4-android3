package lbf.com.lesson4_34.ui.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import lbf.com.lesson4_34.R;
import lbf.com.lesson4_34.common.Resource;
import lbf.com.lesson4_34.data.models.Post;
import lbf.com.lesson4_34.databinding.ActivityFormBinding;

public class FormActivity extends AppCompatActivity {

    private ActivityFormBinding binding;
    private FormViewModel viewModel;
    private final int userId = 7;
    private final int groupId = 34;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel = new ViewModelProvider(this).get(FormViewModel.class);

        viewModel.getList();
        viewModel.listLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                ArrayList<Post> list = new ArrayList<>();
                list.addAll(posts);
                Log.e("TAG", "onChanged:kjglfdjglkdfsjgl " + list);
            }
        });


        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post post = new Post(
                        binding.etTitle.getText().toString(),
                        binding.etContent.getText().toString(),
                        userId,
                        groupId
                );
                        viewModel.createPost(post);
                        viewModel.postLiveData.observe(FormActivity.this, new Observer<Resource<Post>>() {
                            @Override
                            public void onChanged(Resource<Post> postResource) {
                                switch (postResource.status) {
                                    case LOADING: {
                                        binding.progress.setVisibility(View.VISIBLE);
                                        break;
                                    }
                                    case SUCCESS: {
                                        binding.progress.setVisibility(View.INVISIBLE);
                                        Log.e("TAG", "onChanged: " + postResource.data.toString());
                                        break;
                                    }
                                    case ERROR: {
                                        binding.progress.setVisibility(View.INVISIBLE);
                                        Log.e("TAG", "onChanged: " + postResource.message);
                                        break;
                                    }
                                }
                            }
                        });
                viewModel.putPost("1", post);
                viewModel.putLiveData.observe(FormActivity.this, new Observer<Resource<Post>>() {
                    @Override
                    public void onChanged(Resource<Post> postResource) {
                        switch (postResource.status) {
                            case LOADING: {
                                binding.progress.setVisibility(View.VISIBLE);

                                break;
                            }
                            case SUCCESS: {
                                binding.progress.setVisibility(View.INVISIBLE);
                                Log.e("TAG", "onChanged: " + postResource.data.toString());
                                break;
                            }
                            case ERROR: {
                                binding.progress.setVisibility(View.INVISIBLE);
                                Log.e("TAG", "onChanged: " + postResource.message);
                                break;
                            }
                        }
                    }


                });


            }
        });
    }
}
