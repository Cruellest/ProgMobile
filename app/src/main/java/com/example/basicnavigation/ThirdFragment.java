package com.example.basicnavigation;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.navigation.fragment.NavHostFragment;

import com.example.basicnavigation.databinding.FragmentThirdBinding;

/**
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding ;

    private MediaPlayer mediaPlayer;


    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(v ->
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment));

        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),
                R.array.sons, android.R.layout.simple_spinner_item);
        binding.spinner2.setAdapter(adapter);
        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                switch (position) {
                    case 1:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.claps);
                        mediaPlayer.start();
                        break;

                    case 2:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.digitalbell);
                        mediaPlayer.start();
                        break;

                    case 3:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.estalardedos);
                        mediaPlayer.start();
                        break;

                    case 4:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.vibracaocelul);
                        mediaPlayer.start();
                        break;
                }
                if (mediaPlayer != null) {
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.release();
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });;
    }
}