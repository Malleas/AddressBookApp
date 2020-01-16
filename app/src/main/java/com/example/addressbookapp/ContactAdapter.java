package com.example.addressbookapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter {

    Activity mActivity;
    MyContacts myContacts;

    public ContactAdapter(Activity mActivity, MyContacts contact) {
        this.mActivity = mActivity;
        this.myContacts = contact;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public MyContacts getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View contactOneLine;
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contactOneLine = inflater.inflate(R.layout.contact_one_line, parent, false);
        TextView tv_contactName = contactOneLine.findViewById(R.id.tv_contactName);
        TextView tv_contactBusinessName = contactOneLine.findViewById(R.id.tv_contactBusinessName);
        TextView tv_contactPhoneNumber = contactOneLine.findViewById(R.id.tv_contactPhoneNumber);
        TextView tv_contactStreetAddress = contactOneLine.findViewById(R.id.tv_contactStreetAddress);
        TextView tv_contactCity = contactOneLine.findViewById(R.id.tv_contactCity);
        TextView tv_contactState = contactOneLine.findViewById(R.id.tv_contactState);
        TextView tv_contactZipCode = contactOneLine.findViewById(R.id.tv_contactZipCode);
        TextView tv_contactDateOfBirth = contactOneLine.findViewById(R.id.tv_contactDateOfBirth);
        TextView tv_contactDescription = contactOneLine.findViewById(R.id.tv_contactDescription);
        TextView tv_contactBusinessOpenHour = contactOneLine.findViewById(R.id.tv_contactBusinessOpenHour);
        TextView tv_contactBusinessCloseHour = contactOneLine.findViewById(R.id.tv_contactBusinessClosingHour);
        TextView tv_contactwebsiteUrl = contactOneLine.findViewById(R.id.tv_contactWebsiteURL);
        ImageView iv_portraitPicture = contactOneLine.findViewById(R.id.iv_portraitPicture);

        MyContacts myContacts = this.getItem(position);
        BusinessContact businessContact = (BusinessContact) this.getItem(position);
        PersonalContact personalContact = (PersonalContact) this.getItem(position);
        int portrait_resource_numbers [] = {
                R.drawable.image_001,
                R.drawable.image_002,
                R.drawable.image_003,
                R.drawable.image_004,
                R.drawable.image_005,
                R.drawable.image_006,
                R.drawable.image_007,
                R.drawable.image_008,
                R.drawable.image_009,
                R.drawable.image_010,
                R.drawable.image_011,
                R.drawable.image_012,
                R.drawable.image_013,
                R.drawable.image_014,
                R.drawable.image_015,
                R.drawable.image_016
        };

        tv_contactName.setText(myContacts.getMyContacts().get(position).getName());
        tv_contactPhoneNumber.setText(myContacts.getMyContacts().get(position).getPhoneNumber());
        tv_contactStreetAddress.setText(myContacts.getMyContacts().get(position).getLocation().getStreetAddress());
        tv_contactCity.setText(myContacts.getMyContacts().get(position).getLocation().getCity());
        tv_contactState.setText(myContacts.getMyContacts().get(position).getLocation().getState());
        tv_contactZipCode.setText(myContacts.getMyContacts().get(position).getLocation().getZipCode());
        iv_portraitPicture.setImageResource(portrait_resource_numbers[myContacts.getMyContacts().get(position).getPhotoId()]);

        String type = myContacts.getMyContacts().get(position).getType();

        if(type.equals("Personal"){
            tv_contactBusinessCloseHour.setVisibility(View.INVISIBLE);
            tv_contactBusinessOpenHour.setVisibility(View.INVISIBLE);
            tv_contactBusinessName.setVisibility(View.INVISIBLE);
            tv_contactwebsiteUrl.setVisibility(View.INVISIBLE);
            tv_contactDateOfBirth.setText(personalContact.getDateOfBirth());
            tv_contactDescription.setText(personalContact.getDescription());

        }else if(type.equals("Business")){
            tv_contactDateOfBirth.setVisibility(View.INVISIBLE);
            tv_contactDescription.setVisibility(View.INVISIBLE);
            tv_contactBusinessName.setText(myContacts.getMyContacts().indexOf());
            tv_contactBusinessOpenHour.setText(businessContact.getOpeningHour());
            tv_contactBusinessCloseHour.setText(businessContact.getClosingHour());
            tv_contactwebsiteUrl.setText(businessContact.getWebsiteURL());
        }






        return contactOneLine;
    }
}
