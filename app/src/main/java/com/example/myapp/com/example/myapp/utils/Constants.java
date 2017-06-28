package com.example.myapp.com.example.myapp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;

/**
 * Created by 2134 on 6/28/2017.
 */

public class Constants
{

    public static boolean hasConnection(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        return false;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void generatetoast(Context ctx, int img_resource, String tv_text) {
        Typeface tfl = Typeface.createFromAsset(ctx.getAssets(), "fonts/robotlight.ttf");

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast_message, null);
        ImageView imgtoasticon = (ImageView) layout.findViewById(R.id.imgtoasticon);
        TextView text = (TextView) layout.findViewById(R.id.tvtoast);
        Toast toast = new Toast(ctx.getApplicationContext());
        imgtoasticon.setImageResource(img_resource);
        text.setText(tv_text);
        text.setTypeface(tfl);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public static String SID = "0";
    public static String SID_url = "&SID=";
    public static String SID_url_ll = "?SID=";
    // public static String adress_url = "oncri4tmhgtg2vl8ouj7h8joa5";
    public static String App_name = "MyDentistChoice";

    public static String menuitems_url = "http://www.openyantra.com/japi/rest_catalog/getCategoryTree?SID=";
    public static String productitems_url = "http://www.openyantra.com/japi/rest_product/list?category_id=";
    public static String productview_url = "http://www.openyantra.com/japi/rest_product/detail?product_id=";
    public static String Register_Url = "http://www.openyantra.com/japi/rest_customer/register";
    public static String Login_Url = "http://www.openyantra.com/japi/rest_customer/login";
    public static String Create_address_url = "http://www.openyantra.com/japi/rest_customer/address";
    public static String Reset_pwd = "http://www.openyantra.com/japi/rest_customer/passwordreset";
    public static String Update_profile = "http://www.openyantra.com/japi/rest_customer/edit";
    public static String EmptyCart_Url = "http://www.openyantra.com/japi/rest_cart/emptyCart";
    public static String Deletecartitem_Url = "http://www.openyantra.com/japi/rest_cart/updateCart";
    public static String addtocart_url = "http://www.openyantra.com/japi/rest_cart/updateCart";
    public static String GetCart_Url = "http://www.openyantra.com/japi/rest_cart/getCart";
    public static String GetUser_Details = "http://www.openyantra.com/japi/rest_customer/getCustomer";
    public static String Assign_address = "http://www.openyantra.com/japi/rest_checkout/updateCartAddresses";
    public static String Get_methods = "http://www.openyantra.com/japi/rest_checkout/getCheckoutMethods";
    public static String update_shipping_method = "http://www.openyantra.com/japi/rest_checkout/updateShippingMethod";
    public static String update_payment_method = "http://www.openyantra.com/japi/rest_checkout/updatePaymentMethod";
    public static String collect_total_amount = "http://www.openyantra.com/japi/rest_checkout/collectTotals";
    public static String submit_order = "http://www.openyantra.com/japi/rest_checkout/submitOrder";
    public static String Search_url = "http://www.openyantra.com/japi/rest_product/search";
    public static String featuredproducts_url = "http://www.openyantra.com/japi/rest_product/getFeaturedProducts?category_id=";
    public static String newproducts_url = "http://www.openyantra.com/japi/rest_product/getNewProducts";
    public static String add_bundle_items_tocart_url = "http://www.openyantra.com/japi/rest_cart/updateCart";
    public static String Orderlist_url = "http://www.openyantra.com/japi/rest_customer/getCustomerOrderList";
    public static String Order_details_url = "http://www.openyantra.com/japi/rest_customer/getCustomerOrderDetails";
    public static String update_cartitem_url = "http://www.openyantra.com/japi/rest_cart/updateCart";
    public static String logout_url = "http://www.openyantra.com/japi/rest_customer/logout";
    public static String emptycart_url = "http://www.openyantra.com/japi/rest_cart/emptyCart";
    public static String Banner_images = "http://www.openyantra.com/japi/rest_cms/getBanners";
    public static String Fratured_brands = "http://www.openyantra.com/japi/rest_cms/getFeaturedBrands";
    public static String Push_notification = "http://www.openyantra.com/japi/rest_push/devicetoken";
    public static String Bank_nameids_url = "http://www.openyantra.com/japi/rest_cms/getAtomBankIds";
}
