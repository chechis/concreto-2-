package silicato_gris.myapplication.apoyo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import silicato_gris.myapplication.MainActivity;
import silicato_gris.myapplication.R;

public class AdapterProporcion extends RecyclerView.Adapter<AdapterProporcion.ConcretoHolder> {

    private List<Concreto> concretos;
    private ProporcionListener proporcionListener;
    public interface ProporcionListener{
        void deleteProporcion(int position);
        void editProporcion (int position);
        void verProporcion (int position);
    }


    public class ConcretoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtNombreProyecto, txtResistencia, txtAsentamiento, txtRelAC, txtPropVolArena, txtPropVolPiedrin,
                txtPropVolAgua, txtPropUniCemento, txtPropUniArena, txtPropUniPiedrin, txtPropUniAgua,
                txtSacoArena, txtSacoPiedrin, txtSacoAgua;

        ImageButton btnEditar, btnBorrar, btnVer;

        public ConcretoHolder (View itemView){
            super(itemView);
            txtNombreProyecto = (TextView) itemView.findViewById(R.id.txt_nombre_proyecto);
            txtResistencia = (TextView) itemView.findViewById(R.id.txt_resistencia);
            txtAsentamiento = (TextView) itemView.findViewById(R.id.txt_proporcion_asentamiento);
            txtRelAC = (TextView) itemView.findViewById(R.id.txt_proporcion_relAC);
            txtPropVolArena = (TextView) itemView.findViewById(R.id.txt_prop_vol_arena);
            txtPropVolPiedrin = (TextView) itemView.findViewById(R.id.txt_prop_vol_piedrin);
            txtPropVolAgua = (TextView) itemView.findViewById(R.id.txt_prop_vol_agua);
            txtPropUniCemento = (TextView) itemView.findViewById(R.id.txt_prop_uni_cemento);
            txtPropUniArena = (TextView) itemView.findViewById(R.id.txt_prop_uni_arena);
            txtPropUniPiedrin = (TextView) itemView.findViewById(R.id.txt_prop_uni_piedrin);
            txtPropUniAgua = (TextView) itemView.findViewById(R.id.txt_prop_uni_agua);
            txtSacoArena = (TextView) itemView.findViewById(R.id.txt_saco_arena);
            txtSacoPiedrin = (TextView) itemView.findViewById(R.id.txt_saco_piedrin);
            txtSacoAgua = (TextView) itemView.findViewById(R.id.txt_saco_agua);

            btnEditar = (ImageButton) itemView.findViewById(R.id.btn_proporcion_edit);
            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (proporcionListener != null){
                        proporcionListener.editProporcion(getAdapterPosition());
                    }
                }
            });
            btnVer = (ImageButton) itemView.findViewById(R.id.btn_ver_informacion);
            btnVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (proporcionListener != null){
                        proporcionListener.verProporcion(getAdapterPosition());
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

    public AdapterProporcion (List<Concreto> concretos) { this.concretos = concretos;}

    @NonNull
    @Override
    public AdapterProporcion.ConcretoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.plantilla_proporcion, parent, false);

        return new ConcretoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterProporcion.ConcretoHolder holder,int position) {
        Concreto concreto = concretos.get(position);

        holder.txtNombreProyecto.setText("Proyecto:   "+ concreto.getNombreProyecto());
        holder.txtResistencia.setText("f'c:   "+ concreto.getResistencia());
        holder.txtAsentamiento.setText("Asentamiento:  "+ concreto.getAsentamiento());
        holder.txtRelAC.setText("Relación A/C:  "+concreto.getRelAC());
        holder.txtPropVolArena.setText(": "+concreto.getPropVolFino());
        holder.txtPropVolPiedrin.setText(": "+concreto.getPropVolGrueso());
        holder.txtPropVolAgua.setText(": "+concreto.getRelAC());
        holder.txtPropUniCemento.setText(concreto.getPropUniCemento());
        holder.txtPropUniArena.setText(": "+concreto.getPropUniFino());
        holder.txtPropUniPiedrin.setText(": "+concreto.getPropUniGrueso());
        holder.txtPropUniAgua.setText(": "+concreto.getPropUniAgua());
        holder.txtSacoArena.setText("Arena: "+concreto.getCostalFino());
        holder.txtSacoPiedrin.setText("Piedrin: "+concreto.getCostalGrueso());
        holder.txtSacoAgua.setText("Agua: "+concreto.getCostalAgua());

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
