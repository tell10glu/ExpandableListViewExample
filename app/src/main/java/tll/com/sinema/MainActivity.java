package tll.com.sinema;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private SinemaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ExpandableListView)findViewById(R.id.lvExp);

        adapter = new SinemaAdapter(this,getTestHeader(),getImages());
        listView.setAdapter(adapter);
        for(int i=0; i < adapter.getGroupCount(); i++)
            listView.expandGroup(i);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
    }
    private List<String> getTestHeader(){
        List<String> asdf = new ArrayList<>();
        asdf.add("bugun");
        asdf.add("dun");
        asdf.add("gecen hafta");
        return asdf;
    }
    private HashMap<String,List<Bitmap[]>> getImages(){
        HashMap<String,List<Bitmap[]>> hashMap = new HashMap<>();
        List<Bitmap[]> bitmaps = new ArrayList<>();
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.sin);

        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm,bm,null});
        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm,bm,bm});
        bitmaps.add(new Bitmap[]{bm, bm, bm});
        bitmaps.add(new Bitmap[]{bm, null, null});
        hashMap.put("bugun", bitmaps);
        List<Bitmap[]> bitmaps2 = new ArrayList<>();
        bitmaps2.add(new Bitmap[]{bm,bm,bm});
        bitmaps2.add(new Bitmap[]{bm, bm, bm});
        bitmaps2.add(new Bitmap[]{bm,bm,bm});
        bitmaps2.add(new Bitmap[]{bm,bm,bm});
        bitmaps2.add(new Bitmap[]{bm,bm,null});
        bitmaps2.add(new Bitmap[]{bm, bm, bm});
        hashMap.put("dun", bitmaps2);
        List<Bitmap[]> bitmaps3 = new ArrayList<>();
        bitmaps3.add(new Bitmap[]{bm, bm, bm});
        bitmaps3.add(new Bitmap[]{bm,bm,null});
        hashMap.put("gecen hafta",bitmaps3);
        return hashMap;
    }


}
