package com.example.libingzheng20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.libingzheng20200106.R;
import com.example.libingzheng20200106.entity.RightEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//右侧适配器
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightVH> {


    private Context context;
    private List<RightEntity.DataBean> list;

    public RightAdapter(Context context, List<RightEntity.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RightVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //连接布局
        View view = View.inflate(context, R.layout.item_right, null);
        return new RightVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightVH holder, int position) {
        holder.tvRight.setText(list.get(position).getGoods_name());
        //设置图片
        Glide.with(context).load(list.get(position).getGoods_thumb())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ivRight);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RightVH extends RecyclerView.ViewHolder {
        public  Unbinder bind;

        @BindView(R.id.iv_right)
        ImageView ivRight;
        @BindView(R.id.tv_right)
        TextView tvRight;
        public RightVH(@NonNull View itemView) {

            super(itemView);

            bind = ButterKnife.bind(this, itemView);
        }
    }
}
