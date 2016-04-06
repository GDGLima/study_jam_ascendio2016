package com.carlospinan.playme.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlospinan.playme.R;
import com.carlospinan.playme.callback.OnInteractorListener;
import com.carlospinan.playme.models.AudioModel;

import java.util.List;

/**
 * @author Carlos Piñan
 */
public class PlayMeAdapter extends RecyclerView.Adapter<PlayMeAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<AudioModel> audioModelList;
    private OnInteractorListener<AudioModel> interactorListener;

    public PlayMeAdapter(
            Context context,
            List<AudioModel> audioModelList,
            OnInteractorListener<AudioModel> interactorListener
    ) {
        this.audioModelList = audioModelList;
        this.interactorListener = interactorListener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_audio, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AudioModel audioModel = audioModelList.get(position);
        if (holder != null && audioModel != null) {
            holder.audioTitleTextView.setText(audioModel.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return audioModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView audioTitleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            audioTitleTextView = (TextView) itemView.findViewById(R.id.audioTitleTextView);
            if (interactorListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        interactorListener.onClickListener(audioModelList.get(getAdapterPosition()));
                    }
                });
            }
        }
    }
}
