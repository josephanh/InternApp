package com.example.app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.Adapter.AdapterNotification;
import com.example.app.Adapter.AdapterReport;
import com.example.app.Interface.OnclickNotification;
import com.example.app.Interface.OnclickReport;
import com.example.app.Model.Notification;
import com.example.app.Model.Report;
import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    List<Notification> list = new ArrayList<>();
    RecyclerView recyclerViewNotification;

    public NotificationFragment() {
    }

    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewNotification = view.findViewById(R.id.recycler_view_report);
        AddData();
        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        AdapterNotification adapterNotification = new AdapterNotification(list, requireContext(), new OnclickNotification() {
            @Override
            public void onClick(Notification notification) {

            }
        });
        recyclerViewNotification.setLayoutManager(manager);
        recyclerViewNotification.setAdapter(adapterNotification);
        return view;
    }

    private void AddData() {
        list.add(new Notification("Global Functionality Specialist", "report" ,"Newell Mews", "https://loremflickr.com/640/480/city","Chief" ));
        list.add(new Notification("Future Division Associate", "comment" ,"Prohaska Extensions", "https://loremflickr.com/640/480/city","Senior" ));
        list.add(new Notification("Chief Web Coordinator", "report" ,"Beier Streets", "https://loremflickr.com/640/480/city","Direct" ));
        list.add(new Notification("Dynamic Optimization Agent", "comment" ,"Goodwin Curve", "https://loremflickr.com/640/480/city","International" ));
        list.add(new Notification("Dynamic Integration Strategist", "report" ,"Dicki Island", "https://loremflickr.com/640/480/city","Investor" ));
        list.add(new Notification("International Directives Consultant", "report" ,"Beahan Extensions", "https://loremflickr.com/640/480/city","Corporate" ));
        list.add(new Notification("Dynamic Data Strategist", "comment" ,"Rippin Ridge", "https://loremflickr.com/640/480/city","National" ));
        list.add(new Notification("District Accounts Liaison", "report" ,"Dare Fall", "https://loremflickr.com/640/480/city","Forward" ));
        list.add(new Notification("Direct Quality Associate", "comment" ,"Bogan Station", "https://loremflickr.com/640/480/city","Senior" ));
        list.add(new Notification("Dynamic Response Director", "comment" ,"Meda Flats", "https://loremflickr.com/640/480/city","Regional" ));
        list.add(new Notification("Corporate Applications Planner", "comment" ,"Ryan Crest", "https://loremflickr.com/640/480/city","Chief" ));
        list.add(new Notification("Direct Tactics Officer", "report" ,"Kallie Summit", "https://loremflickr.com/640/480/city","Central" ));
        list.add(new Notification("Forward Marketing Planner", "comment" ,"Padberg Viaduct", "https://loremflickr.com/640/480/city","Direct" ));
        list.add(new Notification("Chief Brand Executive", "report" ,"Heathcote Terrace", "https://loremflickr.com/640/480/city","Principal" ));
        list.add(new Notification("International Brand Coordinator", "report" ,"Rahul Plains", "https://loremflickr.com/640/480/city","Investor" ));
        list.add(new Notification("Direct Operations Orchestrator", "post" ,"Wolf Meadow", "https://loremflickr.com/640/480/city","Principal" ));
        list.add(new Notification("Internal Division Executive", "report" ,"Wallace Parks", "https://loremflickr.com/640/480/city","Corporate" ));
    }
}