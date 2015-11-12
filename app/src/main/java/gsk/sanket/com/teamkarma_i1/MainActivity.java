package gsk.sanket.com.teamkarma_i1;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;


public class MainActivity extends /*ActionBarActivity{*/FragmentActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private final int NUM_PAGES = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the options to display icon on the action bar.
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);//ActionBar.DISPLAY_HOME_AS_UP |
        setContentView(R.layout.activity_main);

        mViewPager =(ViewPager)findViewById(R.id.main_viewpager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);




//        FragmentManager mfragmentManager = getFragmentManager();
//        FragmentTransaction mFragmentTransaction = mfragmentManager.beginTransaction();
//        Fragment fragment = new TasksListFragment();
//        mFragmentTransaction.replace(android.R.id.content, new ProjectsListFragment());
//        mFragmentTransaction.commit();

//        //Initialising the RecyclerView:
//        mRecyclerView = (RecyclerView)findViewById(R.id.Rlv_projectList);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
////        String[] set = {"Item1","Item1","Item1","Item1"};
//        ArrayList<CardDetails> list = new ArrayList<>(9);
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.a_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.b_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.c_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.d_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.e_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.f_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.g_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.h_r));
//        list.add(new CardDetails("Task 1", "some info...", R.drawable.i_r));
//        mAdapter = new MyAdapter(list);
//        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();

//        //TODO:write an click listener for the image button.
//        ImageButton staticRoundAddButton = (ImageButton) findViewById(R.id.staticRoundAddButton);
//        staticRoundAddButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), CreateTask.class);
//                startActivity(intent);
//            }
//        });
//        //TODO: write onclick listener for each card to start the chatui activity
//        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(getApplicationContext(), "TOuch Registered", Toast.LENGTH_SHORT    ).show();
//                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
//                startActivity(intent);
//                return false;
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }
        else{
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter{
        public ScreenSlidePagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            Fragment fragment = null;
            switch(position){
                case 0: fragment = new ProjectsListFragment(); break;

                case 1: fragment = new TasksListFragment(); break;

                case 2: fragment = new ChatFragment(); break;

                default: fragment = new TasksListFragment(); break;
            }
            return fragment;
        }

        @Override
        public int getCount(){
            return NUM_PAGES;
        }
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<CardDetails> cardDetailsList;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        LinearLayout linearLayout;
        TextView bottom_text;
        ImageView image;
        Button button;
        public ViewHolder(View v){
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
    public MyAdapter(List<CardDetails> cardDetailsList){
        this.cardDetailsList = cardDetailsList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent,false);//changed here
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder vh, int position){
        vh.title.setText(cardDetailsList.get(position).title);
        vh.image.setImageResource((cardDetailsList.get(position).image));
        vh.bottom_text.setText(cardDetailsList.get(position).bottom_text);
        vh.button.setBackgroundResource((cardDetailsList.get(position).button));//(cardDetailsList.get(position).button));
    }
    @Override
    public int getItemCount(){
        return cardDetailsList.size();
    }
}

class CardDetails{
    String title;
    String bottom_text;
    int image;
    int button;
    CardDetails(String title, String bottom_text, int image){
        this.title = title;
        this.bottom_text = bottom_text;
        this.image = image;
        this.button = R.drawable.rarrow_r;
    }
}

