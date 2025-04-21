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

import androidx.navigation.fragment.NavHostFragment;

import com.example.basicnavigation.databinding.FragmentThirdBinding;

import java.util.Objects;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(v ->
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment));

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(Objects.requireNonNull(getContext()),
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
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.akitaneru_ghostrule);
                        mediaPlayer.start();
                        break;

                    case 2:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.hatsunemiku_worldismine);
                        mediaPlayer.start();
                        break;

                    case 3:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.kagaminelen_butterflyonyourrightshoulder);
                        mediaPlayer.start();
                        break;

                    case 4:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.kagaminerin_meltdown);
                        mediaPlayer.start();
                        break;

                    case 5:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.kamuigakupo_ghostrule);
                        mediaPlayer.start();
                        break;

                    case 6:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.kasaneteto_senbonzakura);
                        mediaPlayer.start();
                        break;

                    case 7:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.maika_thethingsideserve);
                        mediaPlayer.start();
                        break;

                    case 8:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.megumimegpoid_gumi);
                        mediaPlayer.start();
                        break;

                    case 9:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.megurineluka_nightfever);
                        mediaPlayer.start();
                        break;

                    case 10:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.momonemomo_teo);
                        mediaPlayer.start();
                        break;

                    case 11:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.sakinomeiko_honey);
                        mediaPlayer.start();
                        break;

                    case 12:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.seeu_demosong);
                        mediaPlayer.start();
                        break;

                    case 13:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.shionakaito_badapple);
                        mediaPlayer.start();
                        break;

                    case 14:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.shionkaito_rosarypale);
                        mediaPlayer.start();
                        break;

                    case 15:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.utaneuta_cantievendream);
                        mediaPlayer.start();
                        break;

                    case 16:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.yowanehaku_ghostrule);
                        mediaPlayer.start();
                        break;
                }
                if (mediaPlayer != null) {
                    mediaPlayer.setOnCompletionListener(mp -> mediaPlayer.release());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}