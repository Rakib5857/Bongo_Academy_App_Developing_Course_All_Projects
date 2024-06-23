package xyz.rakib.appdevelopingcourse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.rakib.appdevelopingcourse.R;
import xyz.rakib.appdevelopingcourse.model.UponnasBook;

public class UponnasBookAdapter extends RecyclerView.Adapter<UponnasBookAdapter.BookViewHolder> {

    private List<UponnasBook> uponnasBookList;

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public ImageView bookCover;
        public TextView title, author, genre, price, publishDate, description;

        public BookViewHolder(View itemView) {
            super(itemView);
            genre = itemView.findViewById(R.id.genre);
            price = itemView.findViewById(R.id.price);
            publishDate = itemView.findViewById(R.id.publish_date);
            description = itemView.findViewById(R.id.description);
        }
    }

    public UponnasBookAdapter(List<UponnasBook> uponnasBooks) {
        this.uponnasBookList = uponnasBooks;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        UponnasBook uponnasBook = uponnasBookList.get(position);
        holder.title.setText(uponnasBook.getTitle());
        holder.author.setText(uponnasBook.getAuthor());
        holder.genre.setText(uponnasBook.getGenre());
        holder.price.setText(uponnasBook.getPrice());
        holder.publishDate.setText(uponnasBook.getPublishDate());
        holder.description.setText(uponnasBook.getDescription());

        // Placeholder for book cover image
        // Use an image loading library like Glide or Picasso to load images from a URL
        holder.bookCover.setImageResource(R.drawable.ic_add_black); // Replace with actual image loading logic
    }

    @Override
    public int getItemCount() {
        return uponnasBookList.size();
    }
}
