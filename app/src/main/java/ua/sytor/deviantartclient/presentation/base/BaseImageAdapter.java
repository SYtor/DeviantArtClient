package ua.sytor.deviantartclient.presentation.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import ua.sytor.deviantartclient.R;
import ua.sytor.deviantartclient.core.network.data.deviation.Deviation;

public class BaseImageAdapter extends RecyclerView.Adapter<BaseImageAdapter.ImageViewHolder> {

    private List<Deviation> list = Collections.emptyList();

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Deviation deviation = list.get(position);
        Picasso.get().load(deviation.getContent().getSrc()).into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Deviation> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageView.setOnClickListener((v) -> {

            });
        }

        public ImageView getImageView() {
            return imageView;
        }

    }
}
