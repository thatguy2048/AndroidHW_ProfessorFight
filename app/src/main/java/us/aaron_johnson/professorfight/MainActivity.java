package us.aaron_johnson.professorfight;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    public ExpandableListView professorListView;

    private static void LOG(String value){
        Log.v("PF_MAIN",value);
    }

    BaseExpandableListAdapter populateAdapter(){
        ProfessorListViewAdapter adapter = new ProfessorListViewAdapter(MainActivity.this);

        Resources resc = getResources();
        String[] names = resc.getStringArray(R.array.professor_names);
        String[] descriptions = resc.getStringArray(R.array.professor_descriptions);
        for(int i = 0; i < names.length; ++i){
            int iri = R.drawable.farnsworth;
            if(names[i].compareTo("Wernstrom") == 0){
                iri = R.drawable.wernstrom;
            }else if(names[i].compareTo("Tate") == 0){
                iri = R.drawable.tate;
            }
            adapter.addProfessor(names[i], descriptions[i], iri);
        }

        adapter.selectedText = resc.getString(R.string.selected_label);

        return adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LOG("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        professorListView = (ExpandableListView) findViewById(R.id.ListView);
        professorListView.setAdapter(populateAdapter());
    }

    @Override
    protected void onRestart() {
        LOG("onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        LOG("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LOG("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LOG("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LOG("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LOG("onDestroy");
        super.onDestroy();
    }
}
