package com.example.projectssc.ui.tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projectssc.R;
import com.example.projectssc.databinding.FragmentTutorialBinding;
import com.github.barteksc.pdfviewer.PDFView;

public class TutorialFragment extends Fragment {

    private FragmentTutorialBinding binding;
    private Button tutorialBtn;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) { 
        binding = FragmentTutorialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tutorialBtn=root.findViewById(R.id.tutorialBtn);
        tutorialBtn.setOnClickListener(e->{
            PDFView pdfView= root.findViewById(R.id.pdfView);
            pdfView.fromAsset("tutorial.pdf").load();
            tutorialBtn.setVisibility(View.GONE);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}