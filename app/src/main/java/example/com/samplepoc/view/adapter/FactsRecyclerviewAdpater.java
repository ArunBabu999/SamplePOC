package example.com.samplepoc.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import example.com.samplepoc.R;
import example.com.samplepoc.model.FactsModel;

public class FactsRecyclerviewAdpater extends RecyclerView.Adapter<FactsRecyclerviewAdpater.FactsViewHolder> {
    private Context context;
    List<FactsModel> mFactModel;

    public FactsRecyclerviewAdpater(Context context, List<FactsModel> model) {
        this.context = context;
        mFactModel = model;
    }

    @Override
    public FactsRecyclerviewAdpater.FactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false);
        return new FactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FactsRecyclerviewAdpater.FactsViewHolder holder, int position) {

        FactsModel model = mFactModel.get(position);
        Glide.with(context).load(model.getImageHref()).into(holder.imageView);
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return mFactModel.size();
    }

    class FactsViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, description;

        public FactsViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }


    }


}


