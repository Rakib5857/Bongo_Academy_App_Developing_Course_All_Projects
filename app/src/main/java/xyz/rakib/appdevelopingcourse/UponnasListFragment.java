package xyz.rakib.appdevelopingcourse;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import xyz.rakib.appdevelopingcourse.adapter.UponnasBookAdapter;
import xyz.rakib.appdevelopingcourse.model.UponnasBook;

public class UponnasListFragment extends Fragment {

    private RecyclerView recyclerView;
    private UponnasBookAdapter uponnasBookAdapter;
    private List<UponnasBook> uponnasBookList;

    public UponnasListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_book, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        uponnasBookList = new ArrayList<>();
        // Add sample books to the list
        uponnasBookList.add(new UponnasBook("Book Title 1", "Author 1", "Genre 1", "Price 1", "Publish Date 1", "Description 1"));
        uponnasBookList.add(new UponnasBook("Book Title 2", "Author 2", "Genre 2", "Price 2", "Publish Date 2", "Description 2"));
        // Add more books as needed

        uponnasBookAdapter = new UponnasBookAdapter(uponnasBookList);
        recyclerView.setAdapter(uponnasBookAdapter);
        return view;
    }
}
