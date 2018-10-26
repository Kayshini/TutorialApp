package com.example.kayshini.tutorial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kayshini.tutorial.R;
import com.example.kayshini.tutorial.dto.ExceptionTopic;
import java.util.List;

/**
 * Provide views to RecyclerView with the exception topics data.
 */
public class ExceptionTopicAdapter extends RecyclerView.Adapter<ExceptionTopicAdapter.ExceptionTopicViewHolder> {

    private static final String TAG = "Adapter";

    public interface OnItemClickListener {
        void onItemClick(ExceptionTopic exceptionTopic);
    }

    private List<ExceptionTopic> data;
    private LayoutInflater layoutInflater;
    private OnItemClickListener itemClickListener;
    private Context context;

    public ExceptionTopicAdapter(List<ExceptionTopic> data, OnItemClickListener itemClickListener) {
        this.data = data;
        this.itemClickListener = itemClickListener;
    }

    /**
     * Create new exception topics views
     */
    @NonNull
    @Override
    public ExceptionTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        final View topicView = LayoutInflater.from(context).inflate(R.layout.topic_list_view, parent, false);
        return new ExceptionTopicViewHolder(topicView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExceptionTopicViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    /**
     * Return the size of the dataset
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * Provide a reference to the type of views
     */
    public class ExceptionTopicViewHolder extends RecyclerView.ViewHolder {

        private TextView topicTextView;
        private ImageView topicImageView;
        private CardView cardView;

        public ExceptionTopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTextView = itemView.findViewById(R.id.txt_topic);
            topicImageView = itemView.findViewById(R.id.image_topic);
            cardView = itemView.findViewById(R.id.card_view);
        }

        public void bind(final ExceptionTopic exceptionTopic) {
            if (exceptionTopic != null) {
                topicTextView.setText(exceptionTopic.getTopic());
                topicImageView.setImageResource(getImageId(exceptionTopic.getIcon()));
                cardView.setOnClickListener(v -> {
                    if (itemClickListener != null) {
                        Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                        itemClickListener.onItemClick(exceptionTopic);
                    }
                });
            }
        }
    }

    /**
     * Get the id of the drawable based on the name of the drawable
     */
    private int getImageId(String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName,
                null, context.getPackageName());
    }

}
