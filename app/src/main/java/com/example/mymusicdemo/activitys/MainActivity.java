package com.example.mymusicdemo.activitys;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicdemo.R;
import com.example.mymusicdemo.adapters.MusicGridAdapter;
import com.example.mymusicdemo.adapters.MusicListAdepter;
import com.example.mymusicdemo.helps.RealmHelp;
import com.example.mymusicdemo.models.MusicSourceModel;
import com.example.mymusicdemo.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {
// 项目 project
// 模块  module
//    statusBar

    private RecyclerView mRvGrid, mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdepter mListAdapter;
    private RealmHelp mRealmHelp;
    private MusicSourceModel mMusicSourceModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData () {
        mRealmHelp = new RealmHelp();
        mMusicSourceModel = mRealmHelp.getMusicSource();

    }

    private void initView () {
        initNavBar(false, "慕课音乐", true);

        mRvGrid = fd(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);
        mGridAdapter = new MusicGridAdapter(this, mMusicSourceModel.getAlbum());
        mRvGrid.setAdapter(mGridAdapter);

        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要手动计算RecyclerView的高度
         */
        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mListAdapter = new MusicListAdepter(this, mRvList, mMusicSourceModel.getHot());
        mRvList.setAdapter(mListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealmHelp.close();
    }
}