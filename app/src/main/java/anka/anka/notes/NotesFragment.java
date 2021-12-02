package anka.anka.notes;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NotesFragment extends Fragment {
    private int currentPosition = -1;

    public NotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        LinearLayout linearLayout = view.findViewById(R.id.notes_container);
        String[] notes = getResources().getStringArray(R.array.notes_names);

        for (int i = 0; i < notes.length; i++) {
            String note = notes[i];
            TextView textView = new TextView(getContext());
            textView.setText(note);
            textView.setTextSize(30);
            textView.setTextColor(Color.BLACK);
            final int position = i;
            textView.setOnClickListener(v -> {
                currentPosition = position;
                showDetails(position);
                updateBackground();
            });

            linearLayout.addView(textView);
        }
    }


    void updateBackground(){
        LinearLayout linearLayout = getView().findViewById(R.id.notes_container);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);

            if (currentPosition == i){
                linearLayout.getChildAt(i).setBackgroundColor(Color.GRAY);
            }

        }
    }


    void showDetails(int position) {
        if (isLand()) {
            showDetailsLand(position);
        } else {showDetailsPort(position);}

    }

    void showDetailsPort(int position) {
        DetailsFragment detailFragment = DetailsFragment.newInstance(position);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container1, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    void showDetailsLand(int position) {
        DetailsFragment detailFragment = DetailsFragment.newInstance(position);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container2, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    private boolean isLand() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}