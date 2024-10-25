package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;
    private boolean hasCity;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }
    /**
     * Checks if city is in list
     * @param city
     * This is a candidate city to check
     */
    public boolean hasCity(City city){
        for (City currentCity : cities){
            if (currentCity.compareTo(city) == 0) {
                return true;
            }
        }
        return false;

    }
    /**
     * This removes a city to the list if the city exists
     * @param city
     * This is a candidate city to add
     */
    public void delete(City city){
        if (cities.contains(city)) {
            cities.remove(city);
        }

        else throw new IllegalArgumentException();
    }
    /**
     * Counts all cities in list
     * @return size
     * Returns int of the size
     */
    public int countCities(){
        int size = cities.size();
        return size;
    }


}

