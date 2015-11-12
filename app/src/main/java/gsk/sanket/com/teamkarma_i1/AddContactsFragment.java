package gsk.sanket.com.teamkarma_i1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sanket on 9/11/15.
 */
public class AddContactsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate layout for this fragment:
        View v = layoutInflater.inflate(R.layout.addcontacts, container, false);
        return v;
    }


}
