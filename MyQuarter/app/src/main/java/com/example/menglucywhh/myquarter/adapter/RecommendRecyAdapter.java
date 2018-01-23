package com.example.menglucywhh.myquarter.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.view.activity.MainActivity;
import com.example.menglucywhh.myquarter.view.fragment.CenterFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Menglucywhh on 2018/1/22.
 */

public class RecommendRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    FragmentManager childFragmentManager;

    private SlidingMenu menu;
    private TextView takecare;
    private TextView collection;
    private TextView friend;
    private TextView messages;
    private TextView night;
    private TextView myDirectory;
    private TextView settings;

    public RecommendRecyAdapter(Context context, FragmentManager childFragmentManager) {
        this.childFragmentManager = childFragmentManager;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.item_titletop, null);//第一个布局
            //View view = LayoutInflater.from(context).inflate(R.layout.item_titletop, null);
            parent.addView(view);
            return new OneViewHolder(view);//返回第一个布局
        }
        View view = View.inflate(context, R.layout.item_center, null);//第一个布局

        //View view = LayoutInflater.from(context).inflate(R.layout.item_center,parent,false);
        parent.addView(view);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            //第一个条目的点击事件
           oneViewHolder.touxiang.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(touClickListener!=null) {
                       touClickListener.click();
                   }

                   MainActivity.touClick();
               }
           });

        } else if (holder instanceof IViewHolder) {
            childFragmentManager.beginTransaction().replace(R.id.item_rela, new CenterFragment()).commit();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;//上面的蓝色标题
        }
        return 2;//中间的页面
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    //第一个条目
    public static class OneViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView touxiang;
        private final TextView top_text;
        private final ImageView edit;

        public OneViewHolder(View itemView) {
            super(itemView);
            touxiang = itemView.findViewById(R.id.touxiang);
            top_text = itemView.findViewById(R.id.top_text);
            edit = itemView.findViewById(R.id.edit);
        }
    }

    //第二个条目
    public static class IViewHolder extends RecyclerView.ViewHolder {

        public IViewHolder(View itemView) {
            super(itemView);

        }
    }

    TouClickListener touClickListener;
    public void setTouClickListener(TouClickListener touClickListener){
        this.touClickListener = touClickListener;
    }
    //接口回调
    public interface TouClickListener{
        public void click();
    }
}
