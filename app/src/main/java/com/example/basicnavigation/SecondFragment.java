package com.example.basicnavigation;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.basicnavigation.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void showBottomSheet(String nome, int imagemResId, int musicaResId) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_layout, null);

        ImageView imageView = view.findViewById(R.id.imageViewBottomSheet);
        TextView textView = view.findViewById(R.id.textViewBottomSheet);
        Button buttonPlay = view.findViewById(R.id.buttonPlay);

        imageView.setImageResource(imagemResId);
        textView.setText(nome);

        com.google.android.material.bottomsheet.BottomSheetDialog dialog = new com.google.android.material.bottomsheet.BottomSheetDialog(requireContext());
        dialog.setContentView(view);
        dialog.show();

        // Configurar o botão de play para tocar a música correspondente
        buttonPlay.setOnClickListener(v -> playMusic(musicaResId));

        dialog.setOnDismissListener(dialogInterface -> {
            // Aqui você pode liberar o MediaPlayer
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }

        });}

    private void playMusic(int musicaResId) {
        // Parar qualquer música em execução
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        // Inicializar e tocar a nova música
        mediaPlayer = MediaPlayer.create(getContext(), musicaResId);
        mediaPlayer.start();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set button to navigate back
        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );

        // Set up the GridView
        int[] lista = new int[]{
                R.drawable.akitaneru, R.drawable.hatsunemiku, R.drawable.kagaminelen, R.drawable.kagaminerin,
                R.drawable.kamuigakupo, R.drawable.kasaneteto, R.drawable.maika, R.drawable.megumimegpoid,
                R.drawable.megurineluka, R.drawable.momomomone, R.drawable.sakinemeiko, R.drawable.seeu,
                R.drawable.shionakaito, R.drawable.shionkaito, R.drawable.utaneuta, R.drawable.yowanehaku
        };

        binding.grid.setAdapter(new Adaptador(getContext(), lista));

        adjustGridColumns();

        binding.grid.setOnItemClickListener((parent, v, position, id) -> {
            String[] nomes = {
                    "Akita Neru", "Hatsune Miku", "Kagamine Len", "Kagamine Rin",
                    "Kamui Gakupo", "Kasane Teto", "Maika", "Megumi Megpoid",
                    "Megurine Luka", "Momo Momone", "Sakine Meiko", "SeeU",
                    "Shion Akaito", "Shion Kaito", "Utane Uta [Defuko]", "Yowane Haku"
            };

            int[] imagens = new int[]{
                    R.drawable.akitaneru, R.drawable.hatsunemiku, R.drawable.kagaminelen, R.drawable.kagaminerin,
                    R.drawable.kamuigakupo, R.drawable.kasaneteto, R.drawable.maika, R.drawable.megumimegpoid,
                    R.drawable.megurineluka, R.drawable.momomomone, R.drawable.sakinemeiko, R.drawable.seeu,
                    R.drawable.shionakaito, R.drawable.shionkaito, R.drawable.utaneuta, R.drawable.yowanehaku
            };

            int[] musicas = new int[]{
                    R.raw.akitaneru_ghostrule, R.raw.hatsunemiku_worldismine, R.raw.kagaminelen_butterflyonyourrightshoulder, R.raw.kagaminerin_meltdown,
                    R.raw.kamuigakupo_ghostrule, R.raw.kasaneteto_senbonzakura, R.raw.maika_thethingsideserve, R.raw.megumimegpoid_gumi,
                    R.raw.megurineluka_nightfever, R.raw.momonemomo_teo, R.raw.sakinomeiko_honey, R.raw.seeu_demosong,
                    R.raw.shionakaito_badapple, R.raw.shionkaito_rosarypale, R.raw.utaneuta_cantievendream, R.raw.yowanehaku_ghostrule
            };

            showBottomSheet(nomes[position], imagens[position], musicas[position]);
        });
    }

    // New method to adjust Grid columns based on screen width
    private void adjustGridColumns() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float screenWidthPx = displayMetrics.widthPixels;
        float density = displayMetrics.density;

        int columnWidthDp = 200; // Target width for each item (in dp)
        int numColumns = (int) (screenWidthPx / (columnWidthDp * density));
        if (numColumns < 3) numColumns = 3; // minimum 3 columns

        binding.grid.setNumColumns(numColumns);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        // Libere o MediaPlayer quando a view for destruída
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

        }
    }
}
