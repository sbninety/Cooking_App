package com.example.cooking_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooking_app.Model.Instruction;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class InstructionAdapter extends RecyclerView.Adapter<InstructionAdapter.InstructionViewHolder>{
    private Context context;
    private ArrayList<Instruction> instructions;

    public InstructionAdapter(Context context, ArrayList<Instruction> instructions) {
        this.context = context;
        this.instructions = instructions;
    }

    @NonNull
    @Override
    public InstructionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_instruction,parent,false);
        return new InstructionViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionViewHolder holder, int position) {
        Instruction instruction = instructions.get(position);
        if(instruction == null){
            return;
        }
        holder.instruction.setText("- " + instruction.getDecription());
    }

    @Override
    public int getItemCount() {
        if (instructions != null){
            return instructions.size();
        }
        return 0;
    }

    public class InstructionViewHolder extends RecyclerView.ViewHolder {
        TextView instruction;
        public InstructionViewHolder(@NonNull View itemView) {
            super(itemView);
            instruction = itemView.findViewById(R.id.instruction);
        }
    }
}
