package com.example.basicnavigation;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.basicnavigation.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
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

        // Dynamically set the number of columns based on screen size
        adjustGridColumns();

        binding.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String mensagem;
                switch (position) {
                    case 1: mensagem = "Akita Neru"; break;
                    case 2: mensagem = "Hatsune Miku"; break;
                    case 3: mensagem = "Kagamine Len"; break;
                    case 4: mensagem = "Kagamine Rin"; break;
                    case 5: mensagem = "Kamui Gakupo"; break;
                    case 6: mensagem = "Kasane Teto"; break;
                    case 7: mensagem = "Maika"; break;
                    case 8: mensagem = "Megumi Megpoid"; break;
                    case 9: mensagem = "Megurine Luka"; break;
                    case 10: mensagem = "Momo Momone"; break;
                    case 11: mensagem = "Sakine Meiko"; break;
                    case 12: mensagem = "SeeU"; break;
                    case 13: mensagem = "Shion Akaito"; break;
                    case 14: mensagem = "Shion Kaito"; break;
                    case 15: mensagem = "Utane Uta [Defuko]"; break;
                    case 16: mensagem = "Yowane Haku"; break;
                    default: mensagem = ""; break;
                }
                binding.raca.setText("Voicebank: " + mensagem);
            }
        });
    }

    // New method to adjust Grid columns based on screen width
    private void adjustGridColumns() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float screenWidthPx = displayMetrics.widthPixels;
        float density = displayMetrics.density;

        int columnWidthDp = 200; // Target width for each item (in dp)
        int numColumns = (int) (screenWidthPx / (columnWidthDp * density));
        if (numColumns < 3) numColumns = 3; // minimum 2 columns

        binding.grid.setNumColumns(numColumns);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
