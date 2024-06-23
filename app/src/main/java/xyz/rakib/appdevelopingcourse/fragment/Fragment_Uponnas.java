package xyz.rakib.appdevelopingcourse.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import xyz.rakib.appdevelopingcourse.PdfViewerActivity;
import xyz.rakib.appdevelopingcourse.R;

public class Fragment_Uponnas extends Fragment {
    private RecyclerView recyclerView;
    private PdfUrlAdapter pdfUrlAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uponnas, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> pdfUrls = Arrays.asList(
                "https://programmervai.000webhostapp.com/pdf/haruki_murakami_by_humayun_ahmed.pdf"
        );

        pdfUrlAdapter = new PdfUrlAdapter(pdfUrls, getContext().getApplicationContext());
        recyclerView.setAdapter(pdfUrlAdapter);

        return view;
    }

    public class PdfUrlAdapter extends RecyclerView.Adapter<PdfUrlAdapter.PdfUrlViewHolder> {
        private List<String> pdfUrlList;
        private Context context;

        public PdfUrlAdapter(List<String> pdfUrlList, Context context) {
            this.pdfUrlList = pdfUrlList;
            this.context = context;
        }

        @NonNull
        @Override
        public PdfUrlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pdf, parent, false);
            return new PdfUrlViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PdfUrlViewHolder holder, int position) {
            String pdfUrl = pdfUrlList.get(position);
            holder.pdfTitle.setText("PDF " + (position + 1));

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, PdfViewerActivity.class);
                intent.putExtra("PDF_URL", pdfUrl);
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return pdfUrlList.size();
        }

        public class PdfUrlViewHolder extends RecyclerView.ViewHolder {
            TextView pdfTitle;

            public PdfUrlViewHolder(@NonNull View itemView) {
                super(itemView);
                pdfTitle = itemView.findViewById(R.id.pdf_title);
            }
        }
    }
}
