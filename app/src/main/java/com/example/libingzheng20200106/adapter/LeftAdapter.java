package com.example.libingzheng20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libingzheng20200106.R;
import com.example.libingzheng20200106.entity.LeftEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//左侧适配器
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftVH> {
    private Context context;
    private List<String> leftEntities;

    public LeftAdapter(Context context, List<String> leftEntities) {
        this.context = context;
        this.leftEntities = leftEntities;
    }

    @NonNull
    @Override
    public LeftVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_left, null);
        return new LeftVH(view);
    }
    //绑定控件
    @Override
    public void onBindViewHolder(@NonNull LeftVH holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftOnClick.getLeftClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return leftEntities.size();
    }

    class LeftVH extends RecyclerView.ViewHolder {

        public Unbinder bind;
        @BindView(R.id.tv_left)
        TextView tvLeft;
        public LeftVH(@NonNull View itemView) {
            super(itemView);
            //绑定
            bind = ButterKnife.bind(this, itemView);
        }
    }
    private leftOnClick leftOnClick;

    public void setLeftOnClick(LeftAdapter.leftOnClick leftOnClick) {
        this.leftOnClick = leftOnClick;
    }
    //接口回调
    public interface leftOnClick{
        void getLeftClick(View id);
    }
}
