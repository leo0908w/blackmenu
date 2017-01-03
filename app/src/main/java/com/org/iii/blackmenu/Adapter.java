package com.org.iii.blackmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.org.iii.blackmenu.R.id.imageView;
import static com.org.iii.blackmenu.R.id.priceTextView;


/**
 * Created by user on 2016/12/27.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private FireBase fireBase;
    public ImageView imageView;
//    private Timer timer;

    private List<String> food;
    private List<String> path;
    private List<String> price;

    public Adapter(Context context ,List<String> food , List<String> path , List<String> price) {

        this.context = context;
        this.path = path;
        this.food = food;
        this.price = price;
    }


    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String app);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //App app = mApps.get(position);
        //holder.imageView.setImageResource(app.getDrawable());

            Picasso.with(context)
                    .load(path.get(position))
                    .error(R.drawable.rice1)
                    .placeholder(R.drawable.noodle1)
                    .resize(150, 150)
                    .centerCrop()
                    .into(imageView);

        holder.nameTextView.setText(food.get(position));
        holder.priceTextView.setText("$"+price.get(position));

        holder.itemView.setTag(""+position);

//        holder.itemView.setTag(app.getPrice());
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        public CardView cardView;
        public TextView priceTextView;
        public TextView nameTextView;
//        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
//            this.context = context;
//            itemView.setOnClickListener(this);
        }
    }

}