package com.e.listafilmes.ui.filme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.e.listafilmes.R;
import com.e.listafilmes.data.model.Filme;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {

    //Atributos
    private List<Filme> lista;
    private static ItemFilmeClickListener itemFilmeClickListener;

    //Construtor
    public FilmeAdapter(ItemFilmeClickListener listener) {
        lista = new ArrayList<>();
        this.itemFilmeClickListener = listener;
    }


    //Primeiro metodo chamado quando o adapter é criado. Retorna uma instancia do FilmeViewHolder.
    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_filme, parent, false);

        //return null;
        return new FilmeViewHolder(view);
    }

    //Cada item, passa por esse método.
    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        holder.bind(lista.get(position));
    }

    //Pra cada item que exeiste na lista o método onCreateViewHolder chama o método onBindViewHolder passando a "position" da lista e renderizando pro usuário.
    @Override
    public int getItemCount() {
        return (lista != null && lista.size() > 0) ? lista.size() : 0;
    }

    //item da lista
    static class FilmeViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitulo;
        private ImageView ivPoster;
        private Filme filme;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = (TextView) itemView.findViewById(R.id.layout_item_fil_tvTitulo);
            ivPoster = (ImageView) itemView.findViewById(R.id.layout_item_fil_ivPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemFilmeClickListener != null){
                        itemFilmeClickListener.onItemClickListener(filme);
                    }
                }
            });
        }
        public void bind(Filme filme){
            this.filme = filme;
            Picasso
                    .get()
                    .load("https://image.tmdb.org/t/p/w342/"+filme.getCaminhoPoster())
                    .into(ivPoster);
            tvTitulo.setText(filme.getTitulo());
        }
    }

    public void setFilmes(List<Filme> listaFilmes){
        this.lista = listaFilmes;
        notifyDataSetChanged();
    }

    interface ItemFilmeClickListener{

        void onItemClickListener(Filme filme);

    }


}
