package com.example.covidapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.R;
import com.example.covidapp.models.ModelCase;

import java.util.ArrayList;
import java.util.List;

public class CasesAdapter extends RecyclerView.Adapter<CasesAdapter.CasesViewHolder> {

    private Context context;
    private List<ModelCase> cases;

    public CasesAdapter(Context context, List<ModelCase> cases) {
        this.context = context;
        this.cases = new ArrayList<>(cases);
    }

    @NonNull
    @Override
    public CasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_case, parent, false);
        return new CasesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CasesViewHolder holder, int position) {
        ModelCase modelCase = cases.get(position);
        TextView nameTextView = holder.nameText;
        TextView idTextView = holder.idText;
        TextView phoneTextView = holder.phoneText;
        TextView residenceTextView = holder.residenceText;
        TextView dateOfDiseaseTextView = holder.dateOfDiseaseText;
        TextView genderTextView = holder.genderText;
        TextView closeContactsWithTextView = holder.closeContactWithText;
        TextView phoneOfCloseContactsTextView = holder.phonesOfCloseContactsText;
        TextView ageTextView = holder.ageText;
        TextView susceptibleTextView = holder.susceptibleText;

        idTextView.setText("ID: " + modelCase.getId());
        nameTextView.setText("Full Name: " + modelCase.getFirstName() + " " + modelCase.getLastName());
        phoneTextView.setText("Phone: " + modelCase.getPhone());
        residenceTextView.setText("Residence Region: " + modelCase.getResidenceRegion());
        dateOfDiseaseTextView.setText("Date Of Disease: " + modelCase.getDateOfDisease());
        genderTextView.setText("Gender: " + modelCase.getGender());
        ageTextView.setText("Age: " + modelCase.getAge());
        if(modelCase.isSusceptible()) {
            susceptibleTextView.setText("Susceptible: Yes");
        } else {
            susceptibleTextView.setText("Susceptible: No");
        }

        for(int i = 0; i < modelCase.getCloseContactWith().length; i ++)
        {
            if(i == 0) {
                closeContactsWithTextView.setText("Close Contact With: " + modelCase.getCloseContactWith()[0]);
                phoneOfCloseContactsTextView.setText("Close Contact With Phones: " + modelCase.getPhonesOfCloseContact()[0]);
            } else {
                closeContactsWithTextView.setText(closeContactsWithTextView.getText() + ", " + modelCase.getCloseContactWith()[i]);
                phoneOfCloseContactsTextView.setText(phoneOfCloseContactsTextView.getText() + ", " + modelCase.getPhonesOfCloseContact());
            }
        }

    }

    @Override
    public int getItemCount() {
        return cases.size();
    }

    public class CasesViewHolder extends RecyclerView.ViewHolder {

        TextView idText, nameText, phoneText, residenceText, dateOfDiseaseText,
        genderText, closeContactWithText, phonesOfCloseContactsText, ageText, susceptibleText;

        public CasesViewHolder(@NonNull View itemView) {
            super(itemView);
            idText = itemView.findViewById(R.id.id_text);
            nameText = itemView.findViewById(R.id.name_text);
            phoneText = itemView.findViewById(R.id.phone_text);
            residenceText = itemView.findViewById(R.id.residence_text);
            dateOfDiseaseText = itemView.findViewById(R.id.date_of_disease_text);
            genderText = itemView.findViewById(R.id.gender_text);
            closeContactWithText = itemView.findViewById(R.id.close_contact_with_text);
            phonesOfCloseContactsText = itemView.findViewById(R.id.phones_of_close_contacts_text);
            ageText = itemView.findViewById(R.id.age_text);
            susceptibleText = itemView.findViewById(R.id.susceptible_text);

        }
    }
}