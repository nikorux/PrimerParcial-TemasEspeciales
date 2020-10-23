package com.pucmm.primerparcial_temasespeciales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MuestraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MuestraFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public MuestraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MuestraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MuestraFragment newInstance(String param1, String param2) {
        MuestraFragment fragment = new MuestraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_muestra, container, false);

        ArrayList<String> terminos = new ArrayList<>();
        terminos.add("SDK de Android");
        terminos.add("Arquitectura de Android");
        terminos.add("Java API Framework");
        terminos.add("Android Runtime");
        terminos.add("Hardware Abstraction Layer (HAL)");
        terminos.add("Kernel de Linux");
        terminos.add("Intents");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, terminos);

        ListView infoLV = (ListView)view.findViewById(R.id.infoLV);
        infoLV.setAdapter(adapter);



        // Inflate the layout for this fragment
        return view;

    }
}