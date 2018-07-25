package com.example.huangcong.largeimage_worldmap.activity.list;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.huangcong.largeimage_worldmap.R;
import com.example.huangcong.largeimage_worldmap.view.ImageTextureView;
import com.example.huangcong.largeimage_worldmap.view.PinchImageView;
import com.example.large_image.LargeImageView;

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
//        mLV.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent me) {
//                LargeViewHolder largeViewHolder = adapter.getLargeViewHolder();
//                if (largeViewHolder != null) {
//                    largeViewHolder.largeView.handleTouchEvent(me);
//                }
//                return false;
//            }
//        });

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
        data.put(11, new ItemObj(R.mipmap.image_2, R.string.str_2));
        data.put(12, new ItemObj(R.mipmap.image_1, R.string.str_1));
        data.put(13, new ItemObj(R.mipmap.image_2, R.string.str_2));
        data.put(14, new ItemObj(R.mipmap.image_3, R.string.str_3));
        data.put(15, new ItemObj(R.mipmap.image_4, R.string.str_4));
        data.put(16, new ItemObj(R.mipmap.image_5, R.string.str_5));

        return data;
    }

    public static class ListAdapter extends BaseAdapter {

        Context context;
        LayoutInflater layoutInflater;
        SparseArray<ItemObj> data;

        LargeViewHolder largeViewHolder;
        LargeTextureViewHolder largeTextureViewHolder;
        LargePinchViewHolder largePinchViewHolder;
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
            return data != null ? data.size() + 2 : 2;
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
            return 3;
        }

        @Override
        public int getItemViewType(int position) {
            return position == 5 ? 0 : (position == 10 ? 1 : 2);
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
                    largeViewHolder.largeView.setImage(/*new InputStreamBitmapDecoderFactory(context.getAssets().open("world.jpg")), */context.getResources().getDrawable(R.mipmap.image_1));
                    largeViewHolder.largeView.setEnabled(true);
                    //largeViewHolder.largeView.setScale(2f);
                    largeViewHolder.largeView.post(new Runnable() {
                        @Override
                        public void run() {
                            float scale = 1.0f * context.getResources().getDisplayMetrics().heightPixels / largeViewHolder.largeView.getMeasuredHeight() + 2.0f;
                            largeViewHolder.largeView.setScale(scale);
                        }
                    });
                    largeViewHolder.textView.setText(R.string.str_large);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (getItemViewType(i) == 1) {
                if (view == null) {
                    if (layoutInflater == null) {
                        layoutInflater = LayoutInflater.from(context);
                    }
                    view = layoutInflater.inflate(R.layout.item_list_large_texture, viewGroup, false);
                    largeTextureViewHolder = new LargeTextureViewHolder();
                    largeTextureViewHolder.itemView = view;
                    largeTextureViewHolder.largeView = view.findViewById(R.id.iv);
                    largeTextureViewHolder.textView = view.findViewById(R.id.tv);
                    view.setTag(largeTextureViewHolder);
                } else {
                    largeTextureViewHolder = (LargeTextureViewHolder) view.getTag();
                }
                try {
                    largeTextureViewHolder.largeView.setInputStream(inputStream);
                    largeTextureViewHolder.largeView.setViewportCenter();
                    largeTextureViewHolder.textView.setText(R.string.str_large);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (getItemViewType(i) == 3) {
                if (view == null) {
                    if (layoutInflater == null) {
                        layoutInflater = LayoutInflater.from(context);
                    }
                    view = layoutInflater.inflate(R.layout.item_list_large_pinch, viewGroup, false);
                    largePinchViewHolder = new LargePinchViewHolder();
                    largePinchViewHolder.itemView = view;
                    largePinchViewHolder.largeView = view.findViewById(R.id.iv);
                    largePinchViewHolder.textView = view.findViewById(R.id.tv);
                    view.setTag(largePinchViewHolder);
                } else {
                    largePinchViewHolder = (LargePinchViewHolder) view.getTag();
                }
                try {
                    largePinchViewHolder.largeView.setImageBitmap(BitmapFactory.decodeStream(inputStream));
                    largePinchViewHolder.textView.setText(R.string.str_large);
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

    public static class LargeTextureViewHolder {
        View itemView;
        ImageTextureView largeView;
        TextView textView;
    }

    public static class LargePinchViewHolder {
        View itemView;
        PinchImageView largeView;
        TextView textView;
    }
}
