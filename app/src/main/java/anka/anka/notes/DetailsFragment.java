package anka.anka.notes;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    private static final String ARG_POSITION = "position_arg";

    private int position = -1;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(int position) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] descriptions = getResources().getStringArray(R.array.notes_descriptions);
        TextView descriptionView = view.findViewById(R.id.note_description);
        descriptionView.setText(descriptions[position]);

        String[] created_dates = getResources().getStringArray(R.array.notes_created_dates);
        TextView createdView = view.findViewById(R.id.note_created);
        createdView.setText(created_dates[position]);

    }
}