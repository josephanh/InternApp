package com.example.app.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.Adapter.AdapterReport;
import com.example.app.Dialog.DiaLogReport;
import com.example.app.Interface.OnclickReport;
import com.example.app.Model.Report;
import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<Report> list = new ArrayList<>();
    RecyclerView recyclerViewReport;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewReport = view.findViewById(R.id.recycler_view_report);
        AddData();
        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        AdapterReport adapterReport = new AdapterReport(list, requireContext(), new OnclickReport() {
            @Override
            public void onClick(Report report) {
                DiaLogReport diaLogReport = new DiaLogReport(requireContext());
                diaLogReport.onCreate(report);
                diaLogReport.onShow();
            }
        });
        recyclerViewReport.setLayoutManager(manager);
        recyclerViewReport.setAdapter(adapterReport);
        return view;
    }

    private void AddData() {
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/355.jpg", "Intelligent Cotton Tuna", "2004-04-14T11:22:21.053Z", "0"));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/355.jpg", "Intelligent Cotton Tuna", "2004-04-14T11:22:21.053Z","1" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1057.jpg", "Awesome Steel Car", "1991-11-03T09:00:58.869Z","2" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/378.jpg", "Modern Steel Gloves", "1987-03-09T02:36:37.796Z","3" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1232.jpg", "Fantastic Plastic Gloves", "1962-05-09T11:40:54.656Z","4" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/652.jpg", "Electronic Steel Chips", "1969-06-22T19:13:56.989Z","5" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/195.jpg", "Refined Wooden Bike", "2002-07-14T20:31:37.008Z","6" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/3.jpg", "Modern Concrete Pizza", "1943-11-28T07:31:58.363Z","7" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/483.jpg", "Tasty Soft Table", "1963-11-25T18:54:15.242Z","8" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/526.jpg", "Tasty Soft Towels", "1948-07-24T02:02:06.286Z","9" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1170.jpg", "Handcrafted Cotton Chair", "1960-06-28T12:21:05.426Z","10" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/922.jpg", "Ergonomic Metal Ball", "1966-05-14T12:41:17.409Z","11" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/341.jpg", "Modern Fresh Soap", "1983-11-08T07:35:49.526Z","12" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/147.jpg", "Elegant Rubber Sausages", "1997-07-23T21:23:13.508Z","13" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1158.jpg", "Rustic Metal Gloves", "2004-01-09T15:00:11.142Z","14" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/584.jpg", "Generic Fresh Sausages", "1990-07-04T21:58:24.689Z","15" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/467.jpg", "Modern Wooden Mouse", "1971-05-20T18:37:13.924Z","16" ));
        list.add(new Report("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/700.jpg", "Modern Concrete Sausages", "1988-10-09T10:36:55.384Z","17" ));

    }
}