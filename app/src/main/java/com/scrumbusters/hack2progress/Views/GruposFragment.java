package com.scrumbusters.hack2progress.Views;


import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.scrumbusters.hack2progress.Model.ElementoConfigurable;
import com.scrumbusters.hack2progress.Presenter.PresenterElementoConfigurable;
import com.scrumbusters.hack2progress.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GruposFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GruposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GruposFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View rootView;

    PresenterElementoConfigurable presenterElementoConfigurable;
    private Button button;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ListView listViewGrupos;
    ArrayAdapter<ElementoConfigurable> adapter;
    AlertDialog.Builder masDialog;
    ArrayAdapter<String> arrayAdapter;

    private OnFragmentInteractionListener mListener;

    public GruposFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GruposFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GruposFragment newInstance(String param1, String param2) {
        GruposFragment fragment = new GruposFragment();
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


        rootView=inflater.inflate(R.layout.fragment_grupos, container, false);
        // Swipe and refresh
        // Al realizarlo lanza la tarea asíncrona de carga de datos
        mSwipeRefreshLayout = rootView.findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //refreshList();
                adapter = new ElementoConfigurableArrayAdapter(getContext(), 0, presenterElementoConfigurable.getGruposRaiz());
            }
        });
        PresenterElementoConfigurable presenterElementoConfigurable = new PresenterElementoConfigurable();

        presenterElementoConfigurable.createGrupo("Grupo 1","" ,"Descripción",
                null, false, null);
        presenterElementoConfigurable.createGrupo("Grupo 2","" ,"Descripción",
                null, false, null);
        presenterElementoConfigurable.createGrupo("Grupo 3","" ,"Descripción",
                null, false, null);
        presenterElementoConfigurable.createGrupo("Grupo 4","" ,"Descripción",
                null, false, null);
        presenterElementoConfigurable.createGrupo("Grupo 5","" ,"Descripción",
                null, false, null);
        presenterElementoConfigurable.createGrupo("Grupo 6","" ,"Descripción",
                null, false, null);


        adapter = new ElementoConfigurableArrayAdapter(getContext(), 0, presenterElementoConfigurable.getGruposRaiz());
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Añade un grupo");
        arrayAdapter.add("Añade un dispositivo");

        AlertDialog.Builder masDialog = new AlertDialog.Builder(getContext());
        masDialog.setTitle("Elige una accion");
        masDialog.setNegativeButton(R.string.cancel, null);

        //listViewGasolineras.setAdapter();
        listViewGrupos = rootView.findViewById(R.id.listViewGrupos);
        listViewGrupos.setAdapter(adapter);
        // Inflate the layout for this fragment
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMas();
            }
        });
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    static class ViewHolder {
        //protected ImageView logo;
        protected TextView nombre;
        protected TextView descripcion;
    }

    public void dialogMas() {
        masDialog.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Intent myIntent = new Intent(getContext(), anadirGrupoActivity.class);
                        startActivity(myIntent);
                        break;
                    case 1:

                        break;
                    default:
                        break;
                }
                dialog.cancel();
            }
        });
        masDialog.create();
        masDialog.show();
    }

    class ElementoConfigurableArrayAdapter extends ArrayAdapter<ElementoConfigurable> {

        private Context context;
        private List<ElementoConfigurable> listaElementos;

        // Constructor
        public ElementoConfigurableArrayAdapter(Context context, int resource, List<ElementoConfigurable> objects) {
            super(context, resource, objects);
            this.context = context;
            this.listaElementos = objects;
        }

        // Llamado al renderizar la lista
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;

            // Obtiene el elemento que se está mostrando
            ElementoConfigurable elemento = listaElementos.get(position);
            int idElemento = elemento.getId();

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_dispositivo, null);
                holder = new ViewHolder();

                holder.nombre = convertView.findViewById(R.id.textViewNombre);
                holder.descripcion = convertView.findViewById(R.id.textViewDescripcion);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            /**if(listaFavs.contains(idGasolinera)){
                holder.imgFavourite.setImageResource(android.R.drawable.btn_star_big_on);
            } else {
                holder.imgFavourite.setImageResource(android.R.drawable.btn_star_big_off);
            } **/

            // Y carga los datos del item
            //holder.imgFavourite.setTag(idGasolinera);
            holder.nombre.setText(elemento.getNombre());
            holder.nombre.setTag(idElemento);
            holder.descripcion.setText(elemento.getDescripcion());
  /**
            holder.horario.setText("Horario:  "+gasolinera.getHorario());
            if (filtrandoPorCombustible) {
                convertView.findViewById(R.id.textViewGasoleoALabel).setVisibility(View.INVISIBLE);
                convertView.findViewById(R.id.textViewGasolina95Label).setVisibility(View.INVISIBLE);
                holder.precioProducto.setText(" " + gasolinera.getPrecioProducto() + getResources().getString(R.string.moneda));
            } else {
                convertView.findViewById(R.id.textViewPrecioProductoLabel).setVisibility(View.INVISIBLE);
                String precioGasoleoA = String.valueOf(gasolinera.getGasoleoA())+getResources().getString(R.string.moneda);
                String precioGasolina95 = String.valueOf(gasolinera.getGasolina95()+getResources().getString(R.string.moneda));
                if (precioGasoleoA.equals("0.0€")) precioGasoleoA = "-";
                if (precioGasolina95.equals("0.0€")) precioGasolina95 = "-";

                holder.gasoleoA.setText(" " + precioGasoleoA);
                holder.gasolina95.setText(" " + precioGasolina95);
            }

            int imageID = context.getResources().getIdentifier(gasolinera.getRotulo().toLowerCase(),
                    "drawable", context.getPackageName());
            if (imageID == 0) {
                imageID = context.getResources().getIdentifier(getResources().getString(R.string.pordefecto),
                        "drawable", context.getPackageName());
            }
            holder.logo.setImageResource(imageID);

            // Si las dimensiones de la pantalla son menores
            // reducimos el texto de las etiquetas para que se vea correctamente
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < 720) {
                if (filtrandoPorCombustible) {
                    TextView tv = (convertView.findViewById(R.id.textViewPrecioProductoLabel));
                    RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams) tv.getLayoutParams());
                    params.setMargins(15, 0, 0, 0);
                    tv.setTextSize(11);
                    ((TextView) convertView.findViewById(R.id.textViewPrecioProducto)).setTextSize(11);
                } else {
                    TextView tv = (convertView.findViewById(R.id.textViewGasoleoALabel));
                    RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams) tv.getLayoutParams());
                    params.setMargins(15, 0, 0, 0);
                    tv.setTextSize(11);
                    ((TextView) convertView.findViewById(R.id.textViewGasolina95Label)).setTextSize(11);
                    holder.gasoleoA.setTextSize(11);
                    holder.gasolina95.setTextSize(11);
                }

            }

            holder.imgFavourite.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idGasolinera = (int) holder.imgFavourite.getTag();

                    if(listaFavs.contains(idGasolinera)){
                        holder.imgFavourite.setImageResource(android.R.drawable.btn_star_big_off);
                        listaFavs.remove(idGasolinera);
                        Toast.makeText(v.getContext(), // <- Line changed
                                "Borrada de favoritos",
                                Toast.LENGTH_LONG).show();

                        presenterFavoritas.removeGasolineraFavorita(idGasolinera);
                    } else {
                        holder.imgFavourite.setImageResource(android.R.drawable.btn_star_big_on);
                        listaFavs.add(idGasolinera);
                        Toast.makeText(v.getContext(), // <- Line changed
                                "Añadida a favoritos",
                                Toast.LENGTH_LONG).show();

                        presenterFavoritas.addGasolineraFavorita(idGasolinera);
                    }

                    if(filtradoFavoritas && isConected()){
                        refreshList();

                    }
                }
            });
 **/
            return convertView;
        }
    }
}
