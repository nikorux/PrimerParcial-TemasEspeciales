package com.pucmm.primerparcial_temasespeciales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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

        final ArrayList<String> terminos = new ArrayList<>();
        terminos.add("La plataforma Android");
        terminos.add("SDK de Android");
        terminos.add("Google Play");
        terminos.add("Arquitectura de Android");
        terminos.add("Java API Framework");
        terminos.add("Java Native C/C++ Libraries");
        terminos.add("Hardware Abstraction Layer (HAL)");

        final ArrayList<String> infoTerminos = new ArrayList<>();
        infoTerminos.add("La plataforma Android está compuesta de un núcleo abierto, AOSP (Android Open Source Project), más los servicios y aplicaciones de Google que quedan bajo su regulación.");
        infoTerminos.add("El SDK de Android, provee de herramientas y APIs necesarios para comenzar a desarrollar aplicaciones en a plataforma Android.");
        infoTerminos.add("Es un catálogo de aplicaciones gratuitas o de pago.");
        infoTerminos.add("La arquitectura está diseñada para simplificar el re uso de componentes; cualquier aplicación puede publicar sus capacidades y cualquier otra aplicación puede luego hacer uso de esas capacidades sujeto a reglas de seguridad del framework.");
        infoTerminos.add("Todo el conjunto de funciones del SO Android está disponible mediante API escritas en el lenguaje Java. Estas API son los cimientos que necesitas para crear apps de Android simplificando la reutilización de componentes del sistema y servicios centrales y modulares.");
        infoTerminos.add("Muchos componentes y servicios centrales del sistema Android, como el ART y la HAL, se basan en código nativo que requiere bibliotecas nativas escritas en C y C++.");
        infoTerminos.add("La capa de abstracción de hardware (HAL) brinda interfaces estándares que exponen las capacidades de hardware del dispositivo al framework de la Java API de nivel más alto.");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, terminos);

        ListView infoLV = (ListView)view.findViewById(R.id.infoLV);
        infoLV.setAdapter(adapter);
        infoLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                InfoTerminosFragment detailFragment = new InfoTerminosFragment();
                String selectedData = infoTerminos.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("selected_data", selectedData);

                detailFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();

                switch (MainActivity.posicion2){

                    case 1:
                        manager.beginTransaction().replace(R.id.mainLayout, detailFragment).addToBackStack(null).commit();
                        break;

                    case 2:
                        manager.beginTransaction().replace(R.id.infoTerminosLy, detailFragment).commit();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + MainActivity.posicion2);
                }
            }
        });

        return view;
    }

}