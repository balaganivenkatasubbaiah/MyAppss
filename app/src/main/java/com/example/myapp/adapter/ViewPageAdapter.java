package com.example.myapp.adapter;

import java.util.ArrayList;

import com.example.myapp.R;
import com.example.myapp.dto.BannerDto;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ViewPageAdapter extends PagerAdapter {

	Context mContext;
	LayoutInflater mLayoutInflater;
	// int[] mResources = { R.drawable.page1, R.drawable.page2,
	// R.drawable.page3, R.drawable.page4, R.drawable.page5 };
	ArrayList<BannerDto> list;
	ImageLoader imageLoader;

	public ViewPageAdapter(Context context, ArrayList<BannerDto> list) {
		mContext = context;
		this.list = list;
		imageLoader = ImageLoader.getInstance();
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
		mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((RelativeLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View itemView = mLayoutInflater.inflate(R.layout.viewpager_item, container, false);

		ImageView imageView = (ImageView) itemView.findViewById(R.id.flag);
		// imageView.setImageResource(mResources[position]);

		@SuppressWarnings("deprecation")
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
				// You can pass your own memory cache implementation
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator()).build();

		@SuppressWarnings("deprecation")
		DisplayImageOptions options = new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(20))
				.cacheInMemory(true).cacheOnDisc(true).build();

		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);
		imageLoader.displayImage(list.get(position).getImages(), imageView, options);
		// imageLoader.displayImage(list.get(position).getImages(), imageView);
		container.addView(itemView);

		return itemView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((RelativeLayout) object);
	}
}