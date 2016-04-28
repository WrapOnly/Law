package com.handle.law.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.handle.law.R;
import com.handle.law.adapter.document.DocumentsAdapter;
import com.handle.law.base.BaseFragment;

/**
 * Created by Administrator on 2016/4/25.
 */
public class DocumentsFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener{

    private GridView gvDocuments;
    private DocumentsAdapter adapter;
    private String[] datas = {"报账单", "付款单", "入库单", "出库单", "收款单"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.document_fragment_layout, container, false);
        this.initViews(view);
        this.setListener();
        return view;
    }

    @Override
    protected void initViews(View _view) {
        this.gvDocuments = (GridView) _view.findViewById(R.id.gv_document_fragment);
        this.adapter = new DocumentsAdapter(getActivity(), datas);
        this.gvDocuments.setAdapter(adapter);
    }

    @Override
    protected void setListener() {
        this.gvDocuments.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "点击的位置"+position, Toast.LENGTH_SHORT).show();
    }
}
