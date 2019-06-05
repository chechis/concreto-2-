package silicato_gris.myapplication.apoyo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import silicato_gris.myapplication.R;

public class AdapterProporcion extends RecyclerView.Adapter<AdapterProporcion.ConcretoHolder> {

    private ProporcionListener proporcionListener;

    public interface ProporcionListener{
        void deleteProporcion(int position);
        void editProporcion (int position);
    }

    private List<Concreto> concretos;

    public AdapterProporcion (List<Concreto> concretos) { this.concretos = concretos;}

                                    

    public class ConcretoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtAguaCemento, txtAsentamiento, txtPropUnitaria, txtPropVol;
        ImageButton btnEditar, btnBorrar;

        public ConcretoHolder (View itemView){
            super(itemView);
            txtAguaCemento = (TextView) itemView.findViewById(R.id.txt_proporcion_ac);
            txtAsentamiento = (TextView) itemView.findViewById(R.id.txt_proporcion_asentamiento);
            txtPropUnitaria = (TextView) itemView.findViewById(R.id.txt_proporcion_unitaria);
            txtPropVol = (TextView) itemView.findViewById(R.id.txt_proporcion_volumetrica);

            btnEditar = (ImageButton) itemView.findViewById(R.id.btn_proporcion_edit);
            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (proporcionListener != null){
                        proporcionListener.editProporcion(getAdapterPosition());
                    }
                }
            });
            btnBorrar = (ImageButton) itemView.findViewById(R.id.btn_proporcion_delete);
            btnBorrar.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (proporcionListener != null){
                proporcionListener.deleteProporcion(getAdapterPosition());
            }
        }
    }

    @NonNull
    @Override
    public ConcretoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.plantilla_proporcion, parent, false);

        return new ConcretoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProporcion.ConcretoHolder holder, int position) {
        Concreto concreto = concretos.get(position);

        holder.txtAguaCemento.setText("A/C   "+ concreto.getAguaCemento());
        holder.txtAsentamiento.setText("Asentamiento    "+ concreto.getAsentamiento());
        holder.txtPropUnitaria.setText("Proporción Unitaria kg/m3    "+concreto.getPropUnitaria());
        holder.txtPropVol.setText("Proporción Volumetrica    "+concreto.getPropVol());
    }

    @Override
    public int getItemCount() {
        return concretos.size();
    }

    public ProporcionListener getProporcionListener() {
        return proporcionListener;
    }

    public void setProporcionListener(ProporcionListener proporcionListener) {
        this.proporcionListener = proporcionListener;
    }
}
