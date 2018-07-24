package com.example.huangcong.largeimage_worldmap.activity.list;

import android.content.Context;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.huangcong.largeimage_worldmap.R;
import com.example.huangcong.largeimage_worldmap.view.ImageSurfaceView;
import com.example.huangcong.largeimage_worldmap.view.ImageTextureView;
import com.example.large_image.LargeImageView;
import com.example.large_image.factory.InputStreamBitmapDecoderFactory;

import java.io.InputStream;

public class ListListenerImageActivity extends AppCompatActivity {

    ListView mLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_listener_iimage);

        getWindow().setFormat(PixelFormat.TRANSLUCENT);

        mLV = findViewById(R.id.lv);


        final ListAdapter adapter = new ListAdapter(this, getData());
        mLV.setAdapter(adapter);


        mLV.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                //Log.e("", "===>>> " + i + ", " + i1 + ", " + i2);

                LargeViewHolder largeViewHolder = adapter.getLargeViewHolder();
                if (largeViewHolder != null) {
                   // largeViewHolder.largeView.updateViewPort(20, largeViewHolder.itemView.getTop());
                }
            }
        });
        mLV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent me) {
                LargeViewHolder largeViewHolder = adapter.getLargeViewHolder();
                if (largeViewHolder != null) {
                    largeViewHolder.largeView.handleTouchEvent(me);
                }
                return false;
            }
        });

    }


    private SparseArray<ItemObj> getData() {
        SparseArray<ItemObj> data = new SparseArray<>();

        data.put(0, new ItemObj(R.mipmap.image_1, R.string.str_1));
        data.put(1, new ItemObj(R.mipmap.image_2, R.string.str_2));
        data.put(2, new ItemObj(R.mipmap.image_3, R.string.str_3));
        data.put(3, new ItemObj(R.mipmap.image_4, R.string.str_4));
        data.put(4, new ItemObj(R.mipmap.image_5, R.string.str_5));
        data.put(6, new ItemObj(R.mipmap.image_6, R.string.str_6));
        data.put(7, new ItemObj(R.mipmap.image_5, R.string.str_5));
        data.put(8, new ItemObj(R.mipmap.image_4, R.string.str_4));
        data.put(9, new ItemObj(R.mipmap.image_3, R.string.str_3));
        data.put(10, new ItemObj(R.mipmap.image_2, R.string.str_2));
        data.put(11, new ItemObj(R.mipmap.image_1, R.string.str_1));

        return data;
    }

    public static class ListAdapter extends BaseAdapter {

        Context context;
        LayoutInflater layoutInflater;
        SparseArray<ItemObj> data;

        LargeViewHolder largeViewHolder;
        InputStream inputStream;

        public ListAdapter(Context context, SparseArray<ItemObj> data) {
            this.context = context;
            this.data = data;

            try {
                inputStream = context.getAssets().open("world.jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        LargeViewHolder getLargeViewHolder() {
            return largeViewHolder;
        }

        @Override
        public int getCount() {
            return data != null ? data.size() + 1 : 1;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return position == 5 ? 0 : 1;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (getItemViewType(i) == 0) {
                if (view == null) {
                    if (layoutInflater == null) {
                        layoutInflater = LayoutInflater.from(context);
                    }
                    view = layoutInflater.inflate(R.layout.item_list_large, viewGroup, false);
                    largeViewHolder = new LargeViewHolder();
                    largeViewHolder.itemView = view;
                    largeViewHolder.largeView = view.findViewById(R.id.iv);
                    largeViewHolder.textView = view.findViewById(R.id.tv);
                    view.setTag(largeViewHolder);
                } else {
                    largeViewHolder = (LargeViewHolder) view.getTag();
                }
                try {
                    largeViewHolder.largeView.setImage(new InputStreamBitmapDecoderFactory(context.getAssets().open("world.jpg")));
                    largeViewHolder.largeView.setEnabled(true);
                    //largeViewHolder.largeView.setScale(2f);
                    largeViewHolder.textView.setText(R.string.str_large);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ListViewHolder viewHolder;
                if (view == null) {
                    if (layoutInflater == null) {
                        layoutInflater = LayoutInflater.from(context);
                    }
                    view = layoutInflater.inflate(R.layout.item_list, viewGroup, false);
                    viewHolder = new ListViewHolder();
                    viewHolder.imageView = view.findViewById(R.id.iv);
                    viewHolder.textView = view.findViewById(R.id.tv);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ListViewHolder) view.getTag();
                }
                ItemObj itemObj = data.get(i);
                viewHolder.imageView.setImageResource(itemObj.imageRes);
                viewHolder.textView.setText(itemObj.strRes);
            }
            return view;
        }
    }


    public static class ListViewHolder {
        ImageView imageView;
        TextView textView;
    }

    public static class LargeViewHolder {
        View itemView;
        LargeImageView largeView;
        TextView textView;
    }
}
