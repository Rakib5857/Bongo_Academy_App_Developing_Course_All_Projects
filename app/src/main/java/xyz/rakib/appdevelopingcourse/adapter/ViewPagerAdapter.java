package xyz.rakib.appdevelopingcourse.adapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import xyz.rakib.appdevelopingcourse.fragment.Fragment_Kobita;
import xyz.rakib.appdevelopingcourse.UponnasListFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new UponnasListFragment(); // "উপন্যাস" tab
           case 1:
               return new Fragment_Kobita(); // "কবিতা" tab
            //case 2:
            //    return new AnotherFragment(); // "সাহিত্য" tab
            default:
                return new UponnasListFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of tabs
    }
}
