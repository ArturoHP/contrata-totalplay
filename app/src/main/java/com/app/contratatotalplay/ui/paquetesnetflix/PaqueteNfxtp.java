package com.app.contratatotalplay.ui.paquetesnetflix;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.contratatotalplay.ui.Paquetesnfx;
import com.app.contratatotalplay.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PaqueteNfxtp extends Fragment {

    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<Paquetesnfx, PaqueteNfxtp.PaqueteViewHolder> paquetesnfxrecycleradapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paquetesnfx, container, false);


        recyclerView = view.findViewById(R.id.recycler4paquetesnfx);

        LinearLayoutManager layoutManagervert
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManagervert);

        DatabaseReference Avisoss = FirebaseDatabase.getInstance().getReference().child("paquetesnfx");
        Query newAvisos = Avisoss.orderByKey();

        FirebaseRecyclerOptions Avisus = new FirebaseRecyclerOptions.Builder<Paquetesnfx>().setQuery(newAvisos, Paquetesnfx.class).build();


        paquetesnfxrecycleradapter = new FirebaseRecyclerAdapter<Paquetesnfx, PaqueteViewHolder>(Avisus) {
            @Override
            protected void onBindViewHolder(@NonNull PaqueteViewHolder paqueteViewHolder, int i, @NonNull final Paquetesnfx paquetesnfx) {
                paqueteViewHolder.setnumpack(paquetesnfx.getNumeropaquete());
                paqueteViewHolder.setmegasnet(paquetesnfx.getMegasnetflix());
                paqueteViewHolder.setinfo4megas(paquetesnfx.getInfomegasnetflix());
                paqueteViewHolder.setservtvnetflix(paquetesnfx.getServiciotvnetflix());
                paqueteViewHolder.setcanalesnet(paquetesnfx.getCanalesnetflix());
                paqueteViewHolder.setservlineas(paquetesnfx.getServiciolineas());
                paqueteViewHolder.setappsnetlfix(paquetesnfx.getAppsnetflix());
                paqueteViewHolder.settiponetf(paquetesnfx.getTiponetflix());
                paqueteViewHolder.setnetflixtvstipos(paquetesnfx.getNetflixtvstipo());
                paqueteViewHolder.setpreciolistauno(paquetesnfx.getPreciolistauno());
                paqueteViewHolder.setpreciolistanum(paquetesnfx.getPreciolistaennumuno());
                paqueteViewHolder.setpreciolistados(paquetesnfx.getPreciolistados());
                paqueteViewHolder.setpreciolistanumdos(paquetesnfx.getPreciolistaennumdos());

                paqueteViewHolder.setdescuentode(paquetesnfx.getDescuentode());

                paqueteViewHolder.setpreciopp(paquetesnfx.getPrecioprontopagonetflix());
                paqueteViewHolder.setprecioppdos(paquetesnfx.getPrecioprontopagonetflixdos());


                Button button = paqueteViewHolder.mView.findViewById(R.id.contratarpackwnetflix);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setMessage("Enviaras la informacion a uno de nuestros Agentes encargados en el area de ventas, ¿Deseas continuar?")
                                .setCancelable(false)
                                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {



                                        final Dialog dialog = new Dialog(getContext());
                                        dialog.setContentView(R.layout.layout_dialog4sendinfo);
                                        final FloatingActionButton fabhome = dialog.findViewById(R.id.fab4dialog);
                                        final EditText editTextname = (EditText) dialog.findViewById(R.id.nombredialog);
                                        final EditText editTextemail = (EditText) dialog.findViewById(R.id.emaildialog);
                                        final EditText editTextdireccion = (EditText) dialog.findViewById(R.id.direcciondialog);
                                        final EditText editTextnumero = (EditText) dialog.findViewById(R.id.numeroteldialog);
                                        final EditText editTextpackint = (EditText) dialog.findViewById(R.id.paqueteintdialog);

                                        editTextpackint.setText("Match " + paquetesnfx.getNumeropaquete() + " en Tripleplay");

                                        ImageButton deletename,deletedire,deleteemail,deletenum;

                                        deletename = dialog.findViewById(R.id.deletename);
                                        deletedire = dialog.findViewById(R.id.deletedire);
                                        deleteemail = dialog.findViewById(R.id.deleteemail);
                                        deletenum = dialog.findViewById(R.id.deletenum);

                                        deletename.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                editTextname.setText("");
                                            }
                                        });

                                        deletedire.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                editTextdireccion.setText("");
                                            }
                                        });

                                        deleteemail.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                editTextemail.setText("");
                                            }
                                        });

                                        deletenum.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                editTextnumero.setText("");
                                            }
                                        });


                                        fabhome.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                String name,direccion,email,numero,packint;
                                                name = editTextname.getText().toString();
                                                direccion = editTextdireccion.getText().toString();
                                                email = editTextemail.getText().toString();
                                                numero = editTextnumero.getText().toString();
                                                packint = editTextpackint.getText().toString();

                                                if (packint.isEmpty()) {
                                                    packint = "Ninguno, solo requiero informacion";
                                                }

                                                if (!editTextname.getText().toString().isEmpty() && !editTextemail.getText().toString().isEmpty() && !editTextdireccion.getText().toString().isEmpty() && !editTextnumero.getText().toString().isEmpty()) {

                                                    PackageManager pm = getActivity().getPackageManager();
                                                    try {

                                                        Intent waIntent = new Intent(Intent.ACTION_VIEW);
                                                        String mensaje = "Nombre: "+ name + "\n" + "Direccion: " + direccion + "\n" + "Correo: " + email + "\n" + "Numero Telefono: " + numero + "\n" + "Paquete Interesado: " + packint;
                                                        String url = null;
                                                        try {
                                                            url = "https://api.whatsapp.com/send?phone="+ "528115030888" +"&text=" + URLEncoder.encode(mensaje, "UTF-8");
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
                                        });
                                        dialog.show();
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
            }

            @Override
            public PaqueteNfxtp.PaqueteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.paquete_layoutnfxtp, parent, false);

                return new PaqueteNfxtp.PaqueteViewHolder(view);
            }

        };
        paquetesnfxrecycleradapter.startListening();
        recyclerView.setAdapter(paquetesnfxrecycleradapter);

        return view;
    }

    public class PaqueteViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public PaqueteViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setnumpack(String numpaquete){
            TextView text4numpack = mView.findViewById(R.id.numeropaquete);
            text4numpack.setText(numpaquete);
        }
        public void setmegasnet(String megasnetfl){
            TextView text4megasnet = mView.findViewById(R.id.megas4netflix);
            text4megasnet.setText(megasnetfl);
        }
        public void setinfo4megas(String infomegas){
            TextView text4infomegas = mView.findViewById(R.id.infomegasnetflix);
            text4infomegas.setText(infomegas);
        }
        public void setservtvnetflix(String servtvnet){
            TextView text4numpack = mView.findViewById(R.id.serviciotvnetflix);
            text4numpack.setText(servtvnet);
        }
        public void setcanalesnet(String canales){
            TextView text4numpack = mView.findViewById(R.id.canalesnetflix);
            text4numpack.setText(canales);
        }
        public void setservlineas(String servlineas){
            TextView text4numpack = mView.findViewById(R.id.serviciolineas);
            text4numpack.setText(servlineas);
        }
        public void setappsnetlfix(String apps){
            TextView text4numpack = mView.findViewById(R.id.apps4netflix);
            text4numpack.setText(apps);
        }
        public void settiponetf(String tiponetflix){
            TextView text4numpack = mView.findViewById(R.id.tiponetflix);
            text4numpack.setText(tiponetflix);
        }
        public void setnetflixtvstipos(String tvstipos){
            TextView text4numpack = mView.findViewById(R.id.netflixtvstipo);
            text4numpack.setText(tvstipos);
        }
        public void setpreciolistauno(String preciolistuno){
            TextView text4numpack = mView.findViewById(R.id.netflixpreciolistauno);
            text4numpack.setText(preciolistuno);
        }
        public void setpreciolistanum(String numlisuno){
            TextView text4numpack = mView.findViewById(R.id.preciodlistaennumuno);
            text4numpack.setText(numlisuno);
        }
        public void setpreciolistados(String preciolistdos){
            TextView text4numpack = mView.findViewById(R.id.netflixpreciolistados);
            text4numpack.setText(preciolistdos);
        }
        public void setpreciolistanumdos(String numlisdos){
            TextView text4numpack = mView.findViewById(R.id.preciodlistaennumdos);
            text4numpack.setText(numlisdos);
        }
        public void setdescuentode(String desc){
            TextView text4numpack = mView.findViewById(R.id.descuentode);
            text4numpack.setText(desc);
        }
        public void setpreciopp(String pppuno){
            TextView textView = mView.findViewById(R.id.netflixprecioprontopagouno);
            textView.setText(pppuno);
        }
        public void setprecioppdos(String pppdos){
            TextView textView = mView.findViewById(R.id.netflixprecioprontopagodos);
            textView.setText(pppdos);
        }

    }
}
