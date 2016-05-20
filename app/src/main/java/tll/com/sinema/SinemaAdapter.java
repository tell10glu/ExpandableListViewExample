package tll.com.sinema;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by abdullahtellioglu on 20/05/16.
 */
public class SinemaAdapter extends BaseExpandableListAdapter {


    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Bitmap[]>> _listDataChild;

    public SinemaAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<Bitmap[]>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Bitmap[] image = (Bitmap[]) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_view_child_element, null);
        }
        ImageView view1 = (ImageView)convertView.findViewById(R.id.list_view_child_image1);
        ImageView view2 = (ImageView)convertView.findViewById(R.id.list_view_child_image2);
        ImageView view3 = (ImageView)convertView.findViewById(R.id.list_view_child_image3);
        if(image[0]==null){
            view1.setVisibility(View.GONE);
        }else{
            view1.setVisibility(View.VISIBLE);
            view1.setImageBitmap(image[0]);
        }
        if(image[1]==null){
            view2.setVisibility(View.GONE);
        }else{
            view2.setVisibility(View.VISIBLE);
            view2.setImageBitmap(image[1]);
        }
        if(image[2]==null){
            view3.setVisibility(View.GONE);
        }else{
            view3.setVisibility(View.VISIBLE);
            view3.setImageBitmap(image[2]);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_view_header, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.header_id);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
