package com.example.projectssc.ui.example1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.projectssc.MainActivity;
import com.example.projectssc.R;
import com.example.projectssc.databinding.FragmentExample1Binding;
import com.example.projectssc.databinding.FragmentExample2Binding;

public class Example1Fragment extends Fragment {

    private static FragmentExample1Binding binding;

    private TextView statusLabel;
    private TextView percentageLabel;
    private ImageView batteryImage;
    private Button getBattery;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExample1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getBattery=root.findViewById(R.id.getBattery);
        getBattery.setOnClickListener(new View.OnClickListener(){
                                         @Override
                                         public void onClick(View v) {
                                             statusLabel = binding.getRoot().findViewById(R.id.statusLabel);
                                             percentageLabel = binding.getRoot().findViewById(R.id.percentageLabel);
                                             batteryImage = binding.getRoot().findViewById(R.id.batteryImage);
                                             statusLabel.setText(MainActivity.getmBatteryReceiver().getStatusLabel());
                                             percentageLabel.setText(MainActivity.getmBatteryReceiver().getPercentageLabel());
                                             batteryImage.setImageDrawable(MainActivity.getmBatteryReceiver().getBatteryImage());
                                         }
                                     }

        );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}