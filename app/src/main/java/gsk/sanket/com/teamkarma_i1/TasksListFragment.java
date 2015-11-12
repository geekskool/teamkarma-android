package gsk.sanket.com.teamkarma_i1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanket on 9/11/15.
 */
public class TasksListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageButton staticRoundAddButton;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate){
        View v = inflater.inflate(R.layout.tasklist_fragment, container, false);
        staticRoundAddButton = (ImageButton) v.findViewById(R.id.staticRoundAddButton_tl);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.Rlv_tasksList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        String[] set = {"Item1","Item1","Item1","Item1"};
        ArrayList<CardDetails> list = new ArrayList<>(9);
        list.add(new CardDetails("Task 1", "some info...", R.drawable.a_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.b_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.c_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.d_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.e_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.f_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.g_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.h_r));
        list.add(new CardDetails("Task 1", "some info...", R.drawable.i_r));
        mAdapter = new MyAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onResume(){
        super.onResume();
        staticRoundAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateTask.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getActivity(), "TOuch Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }
}
