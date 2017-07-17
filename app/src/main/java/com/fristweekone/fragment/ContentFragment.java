package com.fristweekone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fristweekone.R;


/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/7/5 14:52
 */
public class ContentFragment extends Fragment {
    private View view;
    private static final String KEY = "arg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_content, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txt = (TextView) view.findViewById(R.id.txt_content);
        String str = (String) getArguments().get(KEY);
        txt.setText(str);
    }

    /**
     * Fragment静态传值
     * @param str
     * @return
     */
    public static Fragment newInstance(String str) {
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        fragment.setArguments(bundle);
        return fragment;
    }

}
