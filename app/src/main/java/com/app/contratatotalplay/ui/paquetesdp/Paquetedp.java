package com.app.contratatotalplay.ui.paquetesdp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.contratatotalplay.Paquetes;
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

public class Paquetedp extends Fragment {

    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<Paquetes, Paquetedp.PaqueteViewHolder> paquetesrecycleradapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paquetesdp, container, false);

        recyclerView = view.findViewById(R.id.recycler4paquetesdp);

        LinearLayoutManager layoutManagervertical
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManagervertical);

        DatabaseReference Avisoss = FirebaseDatabase.getInstance().getReference().child("paquetesdp");
        /*DatabaseReference dat4num = FirebaseDatabase.getInstance().getReference().child("numero");
        dat4num.keepSynced(true);*/
        Query newPaquetes = Avisoss.orderByKey();
        Avisoss.keepSynced(true);

        final FirebaseRecyclerOptions<Paquetes> paquete = new FirebaseRecyclerOptions.Builder<Paquetes>().setQuery(newPaquetes, Paquetes.class).build();

        paquetesrecycleradapter = new FirebaseRecyclerAdapter<Paquetes, PaqueteViewHolder>(paquete) {
            @Override
            protected void onBindViewHolder(@NonNull PaqueteViewHolder paqueteViewHolder, int i, @NonNull final Paquetes paquetes) {
                paqueteViewHolder.setColor(paquetes.getColor());
                paqueteViewHolder.setNombredelpaquete(paquetes.getNombredelpaquete());
                paqueteViewHolder.setdescuentoendinero(paquetes.getDescuentoendinero());
                paqueteViewHolder.setrecibessincosto(paquetes.getRecibessincosto());
                paqueteViewHolder.setnumerodemegas(paquetes.getNumeromegas());
                paqueteViewHolder.settextoforwifi(paquetes.getTextoparawifi());
                paqueteViewHolder.setpreciolistauno(paquetes.getPreciodelistauno());
                paqueteViewHolder.setpreciolistados(paquetes.getPreciodelistados());
                paqueteViewHolder.setprecioprontopago(paquetes.getPrecioprontopagouno());
                paqueteViewHolder.setprecioprontopagodos(paquetes.getPreciodeprontopagodos());

                Button button = paqueteViewHolder.mView.findViewById(R.id.contratardp);
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

                        editTextpackint.setText(paquetes.getNombredelpaquete() + " en Double Play");

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
            public Paquetedp.PaqueteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.paquete_layoutdp, parent, false);

                return new Paquetedp.PaqueteViewHolder(view);
            }
        };
        paquetesrecycleradapter.startListening();
        recyclerView.setAdapter(paquetesrecycleradapter);

        return view;
    }

    public class PaqueteViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public PaqueteViewHolder(final View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setColor(String color){
            LinearLayout linearLayout4paquete = mView.findViewById(R.id.principalllcolor);
            linearLayout4paquete.setBackgroundColor(Color.parseColor(color));
        }
        public void setNombredelpaquete(String nombredelpaquete){
            TextView tv4nombredelpack = mView.findViewById(R.id.nombredelpack);
            tv4nombredelpack.setText(nombredelpaquete);
        }
        public void setdescuentoendinero(String descuentoendinero){
            TextView descuentoenmoney = mView.findViewById(R.id.descuentoendinero);
            descuentoenmoney.setText(descuentoendinero);
        }
        public void setrecibessincosto(String recibessincosto){
            TextView recibestwithoutcost = mView.findViewById(R.id.recibesincosto);
            recibestwithoutcost.setText(recibessincosto);
        }
        public void setnumerodemegas(String numeromegas){
            TextView numdemegas = mView.findViewById(R.id.nummegas);
            numdemegas.setText(numeromegas);
        }
        public void settextoforwifi(String textoforwifi){
            TextView tv4nombredelpack = mView.findViewById(R.id.textforwifi);
            tv4nombredelpack.setText(textoforwifi);
        }
        public void setpreciolistauno(String preciodelista1){
            TextView preciolista1 = mView.findViewById(R.id.preciodelista);
            preciolista1.setText(preciodelista1);
        }
        public void setprecioprontopago(String precioprontopago){
            TextView precioprontopag = mView.findViewById(R.id.precioprontopago);
            precioprontopag.setText(precioprontopago);
        }
        public void setpreciolistados(String preciodelista2){
            TextView preciolista2 = mView.findViewById(R.id.preciodelista2);
            preciolista2.setText(preciodelista2);
        }
        public void setprecioprontopagodos(String precioprontopago2){
            TextView precioprontopag2 = mView.findViewById(R.id.precioprontopago2);
            precioprontopag2.setText(precioprontopago2);
        }
    }
}
