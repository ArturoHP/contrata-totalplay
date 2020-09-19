package com.app.contratatotalplay.ui.Contenido;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

import com.firebase.ui.database.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.contratatotalplay.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class ContenidoFragment extends Fragment {

    private String antesdelao;
    private RecyclerView recyclerView4imagen;
    private FirebaseRecyclerAdapter<video4packrecente, ImageViewHolder> recyclerAdapter4image;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_contenidos, container, false);

        recyclerView4imagen = view.findViewById(R.id.recyvler4video);

        LinearLayoutManager layoutManagervert
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView4imagen.hasFixedSize();
        recyclerView4imagen.setLayoutManager(layoutManagervert);

        DatabaseReference Avisoss = FirebaseDatabase.getInstance().getReference().child("imagen");
        Query newAvisos = Avisoss.orderByKey();
        Avisoss.keepSynced(true);

        FirebaseRecyclerOptions Avisus = new FirebaseRecyclerOptions.Builder<video4packrecente>().setQuery(newAvisos, video4packrecente.class).build();


        recyclerAdapter4image = new FirebaseRecyclerAdapter<video4packrecente, ImageViewHolder>(Avisus) {
            @Override
            protected void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i, @NonNull video4packrecente image4packrecentes) {
                final String linkrestante = image4packrecentes.getVideoparapaquetereciente();
                imageViewHolder.setImagenViewer(image4packrecentes.getImagenparapaquetereciente());

                imageViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public void onClick(View view) {
                        Dialog dialog4video = new Dialog(getContext());

                        dialog4video.setContentView(R.layout.layout_dialog4videocomplete);
                        final VideoView videoView = dialog4video.findViewById(R.id.video4vv);


                        Uri uri;
                        if (linkrestante.startsWith("/o/")){
                            uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/contrata-totalplay.appspot.com" + linkrestante);
                        }else {
                            uri = Uri.parse("https://youtu.be/" + linkrestante);
                        }

                        videoView.setVideoURI(uri);

                        final ImageButton playvid = dialog4video.findViewById(R.id.playbtndialogvideo);
                        playvid.setImageResource(android.R.drawable.ic_media_pause);
                        playvid.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (videoView.isPlaying()){
                                    videoView.pause();
                                    playvid.setImageResource(android.R.drawable.ic_media_play);
                                }else{
                                    videoView.start();
                                    playvid.setImageResource(android.R.drawable.ic_media_pause);
                                }
                            }
                        });




                        videoView.start();
                        dialog4video.show();

                    }
                });
            }

            @Override
            public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_recyclervideo, parent, false);


                return new ContenidoFragment.ImageViewHolder(view);
            }

        };
        recyclerAdapter4image.startListening();
        recyclerView4imagen.setAdapter(recyclerAdapter4image);

        return view;
    }



    public class ImageViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;



        }
            public void setImagenViewer(String image4framevideo) {
            ImageView imageView = mView.findViewById(R.id.image4videoframe);
            Picasso.with(getContext()).load(image4framevideo).into(imageView);
        }
    }
}