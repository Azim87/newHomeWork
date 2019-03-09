package com.geektech.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geektech.myapplication.R;
import com.geektech.myapplication.interfaces.IOnCloseDetails;
import com.geektech.myapplication.models.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskDetailsFragment extends Fragment {

    TextView taskTitle;
    TextView taskDescription;
    ImageView imageView;

    Task task;

    public static TaskDetailsFragment instance(Task task) {
        TaskDetailsFragment fragment = new TaskDetailsFragment();
        fragment.task = task;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task_details, container, false);
        taskTitle = v.findViewById(R.id.task_details_title);
        taskDescription = v.findViewById(R.id.task_details_description);
        imageView = v.findViewById(R.id.task_details_image);
        Button btn = v.findViewById(R.id.task_details_close);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof IOnCloseDetails) {
                    ((IOnCloseDetails) activity).onCloseDetails();
                } else {
                    Log.d("ololo", "Must implement IOnCloseDetails");
                }
            }
        });

        taskTitle.setText(task.title);
        taskDescription.setText(task.description);

       List<String> imageUrl = new ArrayList<>();
                imageUrl.add("http://i.imgur.com/DvpvklR.png");
                imageUrl.add("https://bipbap.ru/wp-content/uploads/2017/04/000000843.jpg");
                imageUrl.add("https://namobilu.com/u/img/ib/466/165/165466-1.jpg");
                imageUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSytRCvPHeKINeQK_-koJVepYZ5Bfb5Sbzy08XrYzBdFpT6lDGJ");
                imageUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ763lFpXvwH8f2k_F9l2jx3QxPFwEJqiXDFO89_5jhBqCQxwmBjQ");
                String  list =  imageUrl.get(new Random().nextInt(imageUrl.size()));
                Picasso.get().load(list).into(imageView);
        return v;
    }
}
