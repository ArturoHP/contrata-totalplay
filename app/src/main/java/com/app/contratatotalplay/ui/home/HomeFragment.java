package com.app.contratatotalplay.ui.home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.contratatotalplay.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HomeFragment extends Fragment {
    private String packinterest;
    private String numerodelvendedor;

    private RecyclerView recycler4avisos;
    private FirebaseRecyclerAdapter<AvisosHome, AvisoViewHolder> avisosrecycleradapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recycler4avisos = view.findViewById(R.id.recycler4avisos);

        LinearLayoutManager layoutManagerhoriz
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recycler4avisos.hasFixedSize();
        recycler4avisos.setLayoutManager(layoutManagerhoriz);

        DatabaseReference Avisoss = FirebaseDatabase.getInstance().getReference().child("avisos");
        Query newAvisos = Avisoss.orderByKey();

        FirebaseRecyclerOptions Avisus = new FirebaseRecyclerOptions.Builder<AvisosHome>().setQuery(newAvisos, AvisosHome.class).build();


        avisosrecycleradapter = new FirebaseRecyclerAdapter<AvisosHome, AvisoViewHolder>(Avisus) {
            @Override
            protected void onBindViewHolder(@NonNull AvisoViewHolder avisoViewHolder, final int i, @NonNull final AvisosHome avisosHome) {
                avisoViewHolder.setImagen(getActivity(),avisosHome.getImagen());
                numerodelvendedor = avisosHome.getNumerodelvendedor();

                avisoViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {


                            Dialog dialog = new Dialog(getContext());
                            dialog.setContentView(R.layout.img_completa_dialog);
                            ImageView imageViewcompleta = (ImageView) dialog.findViewById(R.id.imgcompletadialog);
                            Picasso.with(getContext()).load(avisosHome.getImagen()).into(imageViewcompleta);
                            dialog.show();
                        }finally {
                            String namepack = avisosHome.getNombrepaquete();
                            Toast.makeText(getContext(),"Paquete: " + namepack,Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }

            @Override
            public HomeFragment.AvisoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_aviso, parent, false);

                return new HomeFragment.AvisoViewHolder(view);
            }

        };
        avisosrecycleradapter.startListening();
        recycler4avisos.setAdapter(avisosrecycleradapter);


        FloatingActionButton fabhome = view.findViewById(R.id.fab);

        final EditText tvname = view.findViewById(R.id.nombre);
        final EditText tvdireccion = view.findViewById(R.id.direccion);
        final EditText tvcorreo = view.findViewById(R.id.email);
        final EditText tvnumero = view.findViewById(R.id.numerotel);
        final EditText tvpack = view.findViewById(R.id.paqueteint);


        ImageButton deletename,deletedire,deleteemail,deletenum,getlocation;

        deletename = view.findViewById(R.id.deletename);
        deletedire = view.findViewById(R.id.deletedire);
        deleteemail = view.findViewById(R.id.deleteemail);
        deletenum = view.findViewById(R.id.deletenum);
        /*getlocation = view.findViewById(R.id.getlocation);*/

        deletename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvname.setText("");
            }
        });

        deletedire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvdireccion.setText("");
            }
        });

        deleteemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvcorreo.setText("");
            }
        });

        deletenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvnumero.setText("");
            }
        });

        /*getlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(getView(),"This is going to open maps",Snackbar.LENGTH_SHORT).setTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });*/

        fabhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Enviaras la informacion a uno de nuestros Agentes encargados en el area de ventas, ¿Deseas continuar?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String name,direccion,correo,numerotel,packinterested;

                                name = tvname.getText().toString();
                                direccion = tvdireccion.getText().toString();
                                correo = tvcorreo.getText().toString();
                                numerotel = tvnumero.getText().toString();

                                packinterested = tvpack.getText().toString();
                                if (packinterested.isEmpty()) {
                                    packinterested = "Ninguno, solo requiero informacion";
                                }

                                if (!tvname.getText().toString().isEmpty() && !tvcorreo.getText().toString().isEmpty() && !tvdireccion.getText().toString().isEmpty() && !tvnumero.getText().toString().isEmpty()) {

                                    PackageManager pm = getActivity().getPackageManager();
                                    try {

                                        Intent waIntent = new Intent(Intent.ACTION_VIEW);
                                        String mensaje = "Nombre: "+ name + "\n" + "Direccion: " + direccion + "\n" + "Correo: " + correo + "\n" + "Numero Telefono: " + numerotel + "\n" + "Paquete Interesado: " + packinterested;
                                        String url = null;
                                        try {

                                            url = "https://api.whatsapp.com/send?phone="+ numerodelvendedor +"&text=" + URLEncoder.encode(mensaje, "UTF-8");
                                        } catch (UnsupportedEncodingException e) {
                                            e.printStackTrace();
                                        }
                                        PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                                        waIntent.setData(Uri.parse(url));
                                        waIntent.setPackage("com.whatsapp");
                                        startActivity(waIntent);

                                    } catch (PackageManager.NameNotFoundException e) {
                                        Toast.makeText(getActivity(), "Whatsapp no esta instalado", Toast.LENGTH_SHORT).show();
                                    }
                                    Snackbar.make(view, "Redirigiendo a Whatsapp", Snackbar.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(getActivity(),"Ninguno de los campos debe ser dejado en blanco",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                final AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return view;
        }

    private void buildAlertMessageNoGps(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Tu GPS parece deshabilitado quisiera habilitarlo?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();

    }

    public static class AvisoViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public AvisoViewHolder(final View itemView) {
            super(itemView);
            mView = itemView;
        }

            public void setImagen(Context ctx, String image){
                ImageView avisoimg = mView.findViewById(R.id.image4aviso);
                Picasso.with(ctx).load(image).into(avisoimg);
            }
    }
}

