package projects.android.my.listfragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by User on 16-10-2017.
 */

public class FragmentList extends Fragment
{
    LayoutSelected callBack;
    View fragmentLayout;
    String[] layouts = {"Layout 1","Layout 2","Layout 3","Layout 4","Layout 5","Layout 6","Layout 7","Layout 8","Layout 9","Layout 10"};

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try
        {
           callBack= (LayoutSelected) activity;
        }
        catch (ClassCastException e)
        {
            Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //get the view for the fragment
        fragmentLayout = inflater.inflate(R.layout.fragment_list,null);

        //Adapter to populate the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,layouts);

        ListView lists = (ListView) fragmentLayout.findViewById(R.id.layoutLists);

        lists.setAdapter(adapter);

        //Register for click event
        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //pass data back to the main activity which inturn passes to the details fragment
                callBack.onLayoutSelected(layouts[position]);
            }
        });
        return fragmentLayout;
    }




}
