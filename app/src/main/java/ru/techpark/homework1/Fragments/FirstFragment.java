package ru.techpark.homework1.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import ru.techpark.homework1.Data.DataSource;
import ru.techpark.homework1.MainActivity;
import ru.techpark.homework1.R;

public class FirstFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        final MyDataAdapter adapter = new MyDataAdapter(DataSource.getInstance().getData());
        RecyclerView.LayoutManager mLayoutManager;
        final int columns = getResources().getInteger(R.integer.columns_count);
        mLayoutManager = new GridLayoutManager(getContext(), columns);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(view1 -> {
            int i = adapter.data.size();
            i++;
            DataSource.addiction(i);
            adapter.notifyDataSetChanged();
        });
        return view;
    }

    private void change(String i) {
        ((MainActivity) Objects.requireNonNull(getActivity())).onItemSelected(i);

    }


    class MyDataAdapter extends RecyclerView.Adapter<viewHolder> {

        final List<DataSource.MyData> data;

        private MyDataAdapter(List<DataSource.MyData> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new viewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            holder.count.setText(data.get(position).count);
            holder.count.setTextColor(data.get(position).color);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

    }

    class viewHolder extends RecyclerView.ViewHolder {

        private final TextView count;

        private viewHolder(@NonNull View itemView) {
            super(itemView);
            count = itemView.findViewById(R.id.counter);
            count.setOnClickListener(v -> change("" + count.getText()));
        }
    }


}
