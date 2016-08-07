package mandar.capgemini.org.whatsapplistview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TypedArray contact_names;
    TypedArray profile_pics;
    TypedArray status_list;
    TypedArray contact_types;

    private List<RowItem> rowItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_names = getResources().obtainTypedArray(R.array.contactNames);
        profile_pics = getResources().obtainTypedArray(R.array.contactPhotos);
        status_list = getResources().obtainTypedArray(R.array.contactStatus);
        contact_types = getResources().obtainTypedArray(R.array.contactTypes);

        rowItems = new ArrayList<>();

        for (int i = 0; i < contact_names.length(); i++) {
            RowItem item = new RowItem(contact_names.getString(i),
                    contact_types.getString(i), profile_pics.getResourceId(i,
                    -1),
                    status_list.getString(i));
            rowItems.add(item);
        }
        ListView list = (ListView) findViewById(R.id.list);
        WhatsAppListCustomAdapter adapter = new WhatsAppListCustomAdapter
                (this, rowItems);
        list.setAdapter(adapter);
        contact_names.recycle();
        profile_pics.recycle();
        status_list.recycle();
        contact_types.recycle();
    }


}
