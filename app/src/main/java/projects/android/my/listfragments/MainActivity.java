package projects.android.my.listfragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  LayoutSelected {

    DetailsFragment dFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the fragment Manager
        FragmentManager fManager = getSupportFragmentManager();

        //Create the object of 1st fragment to display list view
        FragmentList fList = new FragmentList();
        //Load the 1st fragment
        fManager.beginTransaction().add(R.id.a,fList).commit();

        //Create the object of 2st fragment to display details of item selected
        dFrag = new DetailsFragment();
        fManager.beginTransaction().add(R.id.fragmentDetails,dFrag).commit();
    }

    @Override
    public void onLayoutSelected(String layoutName)
    {
        //Listener to click events in the 1st fragments
        Toast.makeText(this,layoutName,Toast.LENGTH_SHORT).show();
        //Send the value to the 2nd fragment to display
        dFrag.DisplayLayoutName(layoutName);
    }
}
