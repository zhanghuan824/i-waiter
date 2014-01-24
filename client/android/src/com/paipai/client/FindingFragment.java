package com.paipai.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paipai.client.data.RestaurantAdapter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class FindingFragment extends ListFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_findrestaurant_list,
				container, false);
		data.clear();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Name", "测试饭店名字");
		map.put("Rate", 50);
		map.put("AveragePrice", 50);
		map.put("Address", "地址测试");
		data.add(map);
		return v;
	}

	private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SimpleAdapter adapter = new RestaurantAdapter(getActivity(), data,
				R.layout.fragment_findrestaurant_list_item, new String[] {
						"Name", "Rate", "AveragePrice", "Address" }, new int[] {
						R.id.tvrestaurantname, R.id.restaurantrating,
						R.id.tvaverageprice, R.id.tvaddress });
		setListAdapter(adapter);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
	}

}
