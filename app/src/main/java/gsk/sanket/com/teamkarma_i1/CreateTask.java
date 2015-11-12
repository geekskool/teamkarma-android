package gsk.sanket.com.teamkarma_i1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sanket on 1/11/15.
 */
public class CreateTask extends ActionBarActivity {
    private Button mAddContact;
    private final int PICK_CONSTANT = 1;
    private boolean flag_ButtonReplaced = false;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);//ActionBar.DISPLAY_HOME_AS_UP |
        setContentView(R.layout.create__task);
    }

    @Override
    public void onResume(){
        super.onResume();
        if(!flag_ButtonReplaced){
            mAddContact = (Button)findViewById(R.id.button_addContact);
            if(mAddContact == null)Log.i("Look:","True");
            mAddContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pickone = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                    pickone.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                    startActivityForResult(pickone, PICK_CONSTANT);
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        if(requestCode == PICK_CONSTANT){
            Log.i("Look:", data.toString());
            if(responseCode == RESULT_OK) {
                byte[] contactPic_byteArr = null;
                View button = findViewById(R.id.button_addContact);
                ViewGroup parent = (ViewGroup) button.getParent();
                int index = parent.indexOfChild(button);
                parent.removeView(button);

                button = getLayoutInflater().inflate(R.layout.misc, parent, false);
//                parent.addView(button);
                parent.addView(button, index);

                Uri contact_uri = data.getData();
                String[] projections = {ContactsContract.CommonDataKinds.Phone.PHONETIC_NAME, ContactsContract.CommonDataKinds.Phone.PHOTO_FILE_ID, ContactsContract.CommonDataKinds.Phone.PHOTO_URI, ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI, ContactsContract.CommonDataKinds.Phone.PHOTO_ID};


                Cursor cursor = getContentResolver().query(contact_uri, projections, null, null, null);

                if(cursor.moveToFirst()){
                    int col1 = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_FILE_ID);
                    int col2 = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHONETIC_NAME);
                    String contactName = "NotNull";
                    Bitmap conatctPic_bitmap = null;
                    ImageView contactImage = (ImageView) findViewById(R.id.contactImage);


                if (col1 != -1&& (contactPic_byteArr = cursor.getBlob(col1))!=null) {

//                    if(contactPic_byteArr != null) {
                        conatctPic_bitmap = BitmapFactory.decodeByteArray(contactPic_byteArr, 0, contactPic_byteArr.length);
                        contactImage.setImageBitmap(conatctPic_bitmap);
//                    }
//                    else{
//                        contactImage.setImageResource(R.drawable.ec_r);
//                    }
                }
                else {
                    contactImage.setImageResource(R.drawable.ec_r);
                }

                    if(col2 != -1) {
                        Log.i("Look:",cursor.getString(col2));
                        contactName = cursor.getString(col2);
                    }
                    TextView tv = (TextView) findViewById(R.id.contactName);
                    tv.setText(contactName);

                }


            }
        }
        flag_ButtonReplaced = true;
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
}
