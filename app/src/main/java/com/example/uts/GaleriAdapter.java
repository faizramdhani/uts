package com.example.uts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GaleriAdapter extends RecyclerView.Adapter<GaleriAdapter.ViewHolder> {
    private List<GaleriClass> galeris;
    private Context context;
    public OnAdapterClickListener listener;

    public GaleriAdapter(List<GaleriClass> galeris, Context context) {
        this.galeris = galeris;
        this.context = context;
    }

    public void setListener(OnAdapterClickListener listener) {
        this.listener = listener;
    }

    interface OnAdapterClickListener{
        void DetailonClick(GaleriClass galeriClass);
    }

    @NonNull
    @Override
    public GaleriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_galeri,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GaleriAdapter.ViewHolder viewHolder, int i) {
        GaleriClass galeri = galeris.get(i);
        viewHolder.txtTitle.setText(galeri.getName());
        viewHolder.txtContent.setText(galeri.getPhoto());
        int id = context.getResources().getIdentifier("com.example.loginsqlite:drawable/"+galeri.getPhoto(),null,null);
        viewHolder.imgTitle.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return (galeris != null) ? galeris.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtContent;
        ImageView imgTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.text_title);
            txtContent = itemView.findViewById(R.id.text_content);
            imgTitle = itemView.findViewById(R.id.img_title);
            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.DetailonClick(galeris.get(getAdapterPosition()));
                        }
                    }
            );
        }
    }
}
