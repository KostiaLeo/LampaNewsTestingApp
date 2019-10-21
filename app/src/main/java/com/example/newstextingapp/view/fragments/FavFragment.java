package com.example.newstextingapp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newstextingapp.R;
/*
 * Author - Levitskiy Konstantin
 */
//3rd's Fragment class
public class FavFragment extends Fragment {
    private Context context;

    private FavFragment(Context context) {
        this.context = context;
    }

    static FavFragment newInstance(Context context) {
        return new FavFragment(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fav_fragment, container, false);
    }
}
