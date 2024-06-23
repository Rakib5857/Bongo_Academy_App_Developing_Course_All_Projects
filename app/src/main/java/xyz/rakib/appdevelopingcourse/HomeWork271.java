package xyz.rakib.appdevelopingcourse;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import xyz.rakib.appdevelopingcourse.adapter.ViewPagerAdapter;

public class HomeWork271 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work271);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("উপন্যাস");
                            break;
                        case 1:
                            tab.setText("কবিতা");
                            break;
                        case 2:
                            tab.setText("সাহিত্য");
                            break;
                    }
                }).attach();
    }

    public static class MyTripFragment extends Fragment {
        // Define MyTripFragment content
    }

    public static class AlertsFragment extends Fragment {
        // Define AlertsFragment content
    }


}
