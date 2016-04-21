/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lidaofu.www.loadmoreviewdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lidaofu.www.loadmoreviewdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TabFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    @Bind(R.id.webview)
    WebView webview;

    public static TabFragment newInstance(int position) {
        TabFragment f = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION, position);
        f.setArguments(bundle);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = getArguments().getInt(ARG_POSITION);
        View view = inflater.inflate(R.layout.fragment_tab, null);
        ButterKnife.bind(this, view);
        loadWeb(position);
        return view;
    }

    private void loadWeb(int position) {

        String url = null;
        switch (position) {
            case 0:
                url = "http://www.baidu.com";
                break;
            case 1:
                url = "http://wapbaike.baidu.com/?ssid=0&from=844b&bd_page_type=1&uid=0&pu=sz%401321_1001%2Cta%40utouch_2_5.0_3_537&itj=31";
                break;
            case 2:
                url = "http://www.baidu.com";
                break;
        }

        WebViewClient client = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        webview.setWebViewClient(client);
        webview.loadUrl(url);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}