package projects.android.my.listfragments;

/**
 * Created by User on 16-10-2017.
 */

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
import android.widget.TextView;

public class DetailsFragment extends Fragment
{
    View detailsView;
    TextView layoutName;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //get the view for the fragment
        detailsView = inflater.inflate(R.layout.fragment_details,null);
        //find the textview
        layoutName = (TextView) detailsView.findViewById(R.id.txtLayoutName);
        return  detailsView;
    }

    public void DisplayLayoutName(String lName)
    {
        //Display data
        layoutName.setText(lName);
    }
}