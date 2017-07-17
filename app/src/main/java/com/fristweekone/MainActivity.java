package com.fristweekone;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fristweekone.fragment.ContentFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    /**
     * 横向滑动栏
     */
    @ViewInject(R.id.hsv_title)
    private HorizontalScrollView hsvTitle;

    /**
     * 横向标题布局，放入多个textView
     */
    @ViewInject(R.id.ll_title)
    private LinearLayout llTitle;

    /**
     * 内容显示控件
     */
    @ViewInject(R.id.vp_content)
    private ViewPager vpContent;
    /**
     * 放TextView集合
     */
    private List<String> titles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //初始化数据
        initData();
        //1.向LinearLayout里面添加数据
        //2 向ViewPager里添加Fragment
        addTitleAndFragment();

        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return ContentFragment.newInstance(titles.get(position));
                //return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

    }

    /**
     * 添加TextView和Fragment
     */
    private void addTitleAndFragment() {

        for (int i = 0; i < titles.size(); i++) {
            //添加textview
            TextView txt = new TextView(this);
            txt.setText(titles.get(i));
            //txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
            txt.setTextSize(19);
            txt.setTextColor(Color.BLACK);
            //设置textview要添加进的ViewGroup的宽度
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 5, 10, 5);
            //给textview设置一个相对父控件的参数
            txt.setLayoutParams(params);
            llTitle.addView(txt);
//添加Fragment
            Fragment fragment = ContentFragment.newInstance(titles.get(i));
            fragments.add(fragment);
        }
    }

    /**
     * 初始化数据
     */
    private void initData() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        titles.add("热门");
        titles.add("科技");
        titles.add("搜索");
        titles.add("篮球");
        titles.add("足球");
        titles.add("彩球");
        titles.add("网络");
        titles.add("国际");
        titles.add("社交");
        titles.add("陌陌");
        titles.add("英语");
        titles.add("人际");
        titles.add("社交");
    }
}
