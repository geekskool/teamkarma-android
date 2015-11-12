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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanket on 11/11/15.
 */
public class ProjectsListFragment extends Fragment {
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
        View v = inflater.inflate(R.layout.projectlist_fragment, container, false);
        staticRoundAddButton = (ImageButton) v.findViewById(R.id.staticRoundAddButton_pl);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.Rlv_projectList);
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
//        staticRoundAddButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), CreateTask.class);
//                startActivity(intent);
//            }
//        });
//        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(getActivity(), "TOuch Registered", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), ChatActivity.class);
//                startActivity(intent);
//                return false;
//            }
//        });
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

class MyAdapter_ProjectList extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<CardDetails> cardDetailsList;
    public static class ViewHolder_PL extends RecyclerView.ViewHolder{
        TextView title;
        LinearLayout linearLayout;
        TextView bottom_text;
        ImageView image;
        Button button;
        public ViewHolder_PL(View v){
            super(v);
//            if(v instanceof RelativeLayout) {
            if(v instanceof LinearLayout) {
                linearLayout = (LinearLayout)v;
                title = (TextView) linearLayout.findViewById(R.id.thetextview_c);
                image = (ImageView) linearLayout.findViewById(R.id.imageView_c);
                bottom_text = (TextView) linearLayout.findViewById(R.id.bottom_textView_c);
                button = (Button) linearLayout.findViewById(R.id.buttonR_c);
            }
        }
    }

    //Constructor
    public MyAdapter_ProjectList(List<CardDetails> cardDetailsList){
        this.cardDetailsList = cardDetailsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return null;
    }

//    @Override
//    public MyAdapter_ProjectList.ViewHolder_PL onCreateViewHolder(ViewGroup parent, int viewType){
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent,false);//changed here
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
//    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vh, int position){
        vh.title.setText(cardDetailsList.get(position).title);
//        vh.image.setImageResource((cardDetailsList.get(position).image));
//        vh.bottom_text.setText(cardDetailsList.get(position).bottom_text);
//        vh.button.setBackgroundResource((cardDetailsList.get(position).button));//(cardDetailsList.get(position).button));
    }
    @Override
    public int getItemCount(){
        return cardDetailsList.size();
    }
}

class CardDetails_ProjectList{
    String title;
//    String bottom_text;
//    int image;
//    int button;
    CardDetails_ProjectList(String title, String bottom_text, int image){
        this.title = title;
//        this.bottom_text = bottom_text;
//        this.image = image;
//        this.button = R.drawable.rarrow_r;
    }
}

