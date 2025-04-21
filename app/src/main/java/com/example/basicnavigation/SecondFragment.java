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
                R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_8, R.drawable.sample_9, R.drawable.sample_10, R.drawable.sample_11,
                R.drawable.sample_12, R.drawable.sample_13, R.drawable.sample_14, R.drawable.sample_15,
                R.drawable.sample_16, R.drawable.sample_17
        };

        binding.grid.setAdapter(new Adaptador(getContext(), lista));

        // Dynamically set the number of columns based on screen size
        adjustGridColumns();

        binding.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String mensagem;
                switch (position) {
                    case 1: mensagem = "Beagle"; break;
                    case 2: mensagem = "Bulldog"; break;
                    case 3: mensagem = "Poodle"; break;
                    case 4: mensagem = "Labrador"; break;
                    case 5: mensagem = "Rottweiler"; break;
                    case 6: mensagem = "Pastor Alemão"; break;
                    case 7: mensagem = "Cachorro1"; break;
                    case 8: mensagem = "Yorkshire"; break;
                    case 9: mensagem = "Yorkshire"; break;
                    case 10: mensagem = "Yorkshir"; break;
                    case 11: mensagem = "Yorkshire"; break;
                    case 12: mensagem = "Yorkshire"; break;
                    case 13: mensagem = "Yorkshire"; break;
                    case 14: mensagem = "Yorkshire"; break;
                    case 15: mensagem = "Yorkshire"; break;
                    case 16: mensagem = "Yorkshire"; break;
                    case 17: mensagem = "Yorkshire"; break;
                    default: mensagem = "Outros"; break;
                }
                binding.raca.setText("Raça: " + mensagem);
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
