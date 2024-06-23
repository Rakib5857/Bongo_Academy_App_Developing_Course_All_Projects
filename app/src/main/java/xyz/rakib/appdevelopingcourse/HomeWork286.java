package xyz.rakib.appdevelopingcourse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.nativead.NativeAd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWork286 extends AppCompatActivity {
    RecyclerView recyclerView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList;
    ArrayList<HashMap<String, String>> finalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work286);

        recyclerView = findViewById(R.id.recyclerView);

        MobileAds.initialize(HomeWork286.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        createMainItem();
        createFinalItem();

        xadapter xadapter = new xadapter();
        recyclerView.setAdapter(xadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private class xadapter extends RecyclerView.Adapter {

        int BOOK_ITEM = 0;
        int VIDEO_ITEM = 1;
        int AD_ITEM = 2;


        private class adViewHolder extends RecyclerView.ViewHolder {
            TemplateView my_template;


            public adViewHolder(@NonNull View itemView) {
                super(itemView);
                my_template = itemView.findViewById(R.id.my_template);
            }

        }


        private class videoViewHolder extends RecyclerView.ViewHolder {
            TextView videoTitle;
            PlayerView playerView;

            public videoViewHolder(@NonNull View itemView) {
                super(itemView);
                videoTitle = itemView.findViewById(R.id.videoTitle);
                playerView = itemView.findViewById(R.id.playerView);

            }

        }

        private class bookViewHolder extends RecyclerView.ViewHolder {
            LinearLayout ll_Book;
            TextView bookName, writer;
            ImageView bookImage;

            public bookViewHolder(@NonNull View itemView) {
                super(itemView);
                ll_Book = itemView.findViewById(R.id.ll_Book);
                bookName = itemView.findViewById(R.id.bookName);
                writer = itemView.findViewById(R.id.writer);
                bookImage = itemView.findViewById(R.id.bookImage);
            }

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();

            if (viewType == BOOK_ITEM) {
                View view = layoutInflater.inflate(R.layout.item_book, parent, false);
                return new bookViewHolder(view);
            } else if (viewType == AD_ITEM) {
                View view = layoutInflater.inflate(R.layout.item_native_ad, parent, false);
                return new adViewHolder(view);
            } else {
                View view = layoutInflater.inflate(R.layout.item_video, parent, false);
                return new videoViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            hashMap = finalArrayList.get(position);
            if (getItemViewType(position) == BOOK_ITEM) {
                bookViewHolder bookHolder = (bookViewHolder) holder;
                String bookName = hashMap.get("bookName");
                String writer = hashMap.get("writer");
                String bookLink = hashMap.get("bookLink");
                String bookImageLink = hashMap.get("bookImageLink");
                bookHolder.bookName.setText(bookName);
                bookHolder.writer.setText(writer);
                Picasso.get().load(bookImageLink).into(bookHolder.bookImage);
                bookHolder.ll_Book.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });


            } else if (getItemViewType(position) == AD_ITEM) {
                adViewHolder adHolder = (adViewHolder) holder;

                AdLoader adLoader = new AdLoader.Builder(HomeWork286.this, "ca-app-pub-3940256099942544/2247696110")
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            @Override
                            public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                                adHolder.my_template.setNativeAd(nativeAd);
                            }
                        })
                        .build();

                adLoader.loadAd(new AdRequest.Builder().build());
            } else if (getItemViewType(position) == VIDEO_ITEM) {
                videoViewHolder videoHolder = (videoViewHolder) holder;
                hashMap = finalArrayList.get(position);
                String videoTitle = hashMap.get("videoTitle");
                String videoId = hashMap.get("videoId");
                String videoImageLink = "https://img.youtube.com/vi/" + videoId + "/0.jpg";
                videoHolder.videoTitle.setText(videoTitle);
                Picasso.get().load(videoImageLink).into((ImageView) videoHolder.playerView.findViewById(R.id.thumbnail));
                videoHolder.playerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return finalArrayList.size();
        }

        @Override
        public int getItemViewType(int position) {
            hashMap = finalArrayList.get(position);
            String itemType = hashMap.get("itemType");
            if (itemType.contains("BOOK")) return BOOK_ITEM;
            else if (itemType.contains("AD")) return AD_ITEM;
            else return VIDEO_ITEM;
        }
    }
    private void createMainItem() {
        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();

        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "AD");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "AD");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "AD");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "AD");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "AD");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookName", "হারুকি মুরাকামির");
        hashMap.put("writer", "হুমায়ন আহমেদ");
        hashMap.put("bookLink", "https://rb.gy/ovg4ak");
        hashMap.put("bookImageLink", "https://rb.gy/24fvig");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "AD");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "VIDEO");
        hashMap.put("videoTitle", "LOVE ROMANTIC LOFI MASHUP SONG |SLOWED+REVERBED | MIND FRESH LOFI SONG | LOFI SONGS-LOVE HINDI SONG");
        hashMap.put("videoId", "uToWgjcC0SM");
        arrayList.add(hashMap);

    }
    private void createFinalItem() {
        finalArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 1 && i % 3 == 0) {
                HashMap<String, String> adMap = new HashMap<>();
                adMap.put("itemType", "AD");
                finalArrayList.add(adMap);
            }
            finalArrayList.add(arrayList.get(i));
        }
    }
}