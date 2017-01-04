package com.org.iii.blackmenu;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 2016/12/26.
 */

public class F2 extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener{
    private Toolbar toolbar;
    private Activity mActivity;
    private List<product> datas; //數據源
    private ShopAdapter adapter; //自定義調變器
    private ListView listView;   //ListView控件
    private TextView sumText;
    private product product;


    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
//        Log.v("will", "F1-onAttach");
    }

    DataSetObserver dataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            int sum = 0;

            for (int i = 0; i < datas.size(); i++) {
                sum += datas.get(i).getPrice();
            }
            sumText.setText("總金額: " + sum + "元");
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2_layout, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        listView = (ListView) view.findViewById(R.id.listView);
        sumText = (TextView) view.findViewById(R.id.sum_price);



        // 模擬數據
        datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            product = new product();
            product.setName("商品："+ i +":單價:"+ i);
            product.setNum(1);
            product.setPrice(i);
            datas.add(product);
        }
        adapter = new ShopAdapter(datas, mActivity);
        listView.setAdapter(adapter);
        adapter.registerDataSetObserver(dataSetObserver);

        //以上就是我们常用的自定義調變器ListView展示數據的方法了

        //解決問題：在哪裡處理按鈕的點擊響應事件，是調變器還是 Activity或者Fragment，這裡是在Activity本身處理接口
        //執行添加商品數量，减少商品數量的按鈕點擊事件接口回調
        adapter.setOnAddNum(this);
        adapter.setOnSubNum(this);
        listView.setOnItemClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {

        Object tag = view.getTag();
        switch (view.getId()){
            case R.id.item_btn_add: //點擊添加數量按鈕，執行相應的處理
                // 獲取 Adapter 中設置的 Tag
                if (tag != null && tag instanceof Integer) { //解決問題：如何知道你點擊的按鈕是哪一個列表項中的，通過Tag的position
                    int position = (Integer) tag;
                    //更改集合的數據
                    int num = datas.get(position).getNum();
                    num++;
                    datas.get(position).setNum(num); //修改集合中商品数量
                    datas.get(position).setPrice(position*num); //修改集合中该商品总价 数量*单价
                    //解决问题：点击某个按钮的时候，如果列表项所需的数据改变了，如何更新UI
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.item_btn_sub: //点击减少数量按钮 ，执行相应的处理
                // 获取 Adapter 中设置的 Tag
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    //更改集合的数据
                    int num = datas.get(position).getNum();
                    if (num > 0) {
                        num--;
                        datas.get(position).setNum(num); //修改集合中商品数量
                        datas.get(position).setPrice(position * num); //修改集合中该商品总价 数量*单价
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(mActivity,"點擊了第"+i+"個列表項",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.unregisterDataSetObserver(dataSetObserver);
    }


}
