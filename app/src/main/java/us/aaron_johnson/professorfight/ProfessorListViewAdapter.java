package us.aaron_johnson.professorfight;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by combu on 9/28/2017.
 */

public class ProfessorListViewAdapter extends BaseExpandableListAdapter {
    public String selectedText = "Selected";
    Context context;
    List<ProfessorInformation> info = new ArrayList<>();

    public ProfessorListViewAdapter(Context context) {
        this.context = context;
    }

    void addProfessor(String name, String description){
        info.add(new ProfessorInformation(name,description));
    }

    void addProfessor(String name, String description, int imageResourceId){
        info.add(new ProfessorInformation(name, description, imageResourceId));
    }

    @Override
    public int getGroupCount() {
        return info.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return info.get(i).name;
    }

    @Override
    public Object getChild(int i, int i1) {
        return info.get(i).description;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.professor_list, null);
        }

        ((TextView)view.findViewById(R.id.textView)).setText(info.get(i).name);
        if(info.get(i).imageResourceId != -1) {
            ((ImageView) view.findViewById(R.id.imageView)).setImageResource(info.get(i).imageResourceId);
        }
        return view;
    }

    @Override
    public View getChildView(final int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.professor_list_item, null);
        }

        final String nam = info.get(i).name;
        ((TextView)view.findViewById(R.id.textDescription)).setText(info.get(i).description);
        ((Button)view.findViewById(R.id.selectButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, selectedText+" "+nam, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), BattleActivity.class);
                intent.putExtra("selected_professor_name", nam);
                intent.putExtra("selected_professor_image_id", info.get(i).imageResourceId);
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
