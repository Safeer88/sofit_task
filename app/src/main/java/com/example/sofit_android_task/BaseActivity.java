package com.example.sofit_android_task;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sofit_android_task.HomeFragment.HomeFragment;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener,IBadgeUpdateListener {
    private FragmentTransaction mFragTransctn;
    private FragmentManager mFragMgr;
    private final byte NUM_BOTTOM_TABS = 4;

    private final byte BOTTOM_HOME_SECONDARY_ITEM = -1;
    private final byte BOTTOM_TAB_Home = 0;
    private final byte BOTTOM_TAB_Services = 1;
    //    private final byte BOTTOM_TAB_CART = 2;
    private final byte BOTTOM_TAB_Settings = 2;
    private final byte BOTTOM_TAB_PROFILE = 3;

    private CheckBox arrchbBottomTab[];
    private TextView arrtxvBottomTab[];
    private LinearLayout arrllBottomTab[];
    private LinearLayout ll_btab_addtocart;

    private int colorBtabOn, colorBtabOff;
    TextView toolbartitle;
    LinearLayout llbackicon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mFragMgr = getSupportFragmentManager();
        toolbartitle = findViewById(R.id.laytlbr_txv_title);
        llbackicon=findViewById(R.id.laytlbr_ll_back_icon);
        llbackicon.setOnClickListener(this);

        setBottomTabBar();
        navtohomefragment();

    }
    private void navtohomefragment() {
        switchBottomTab(BOTTOM_TAB_Home);
        clearMyBackStack();
        Fragment frg = new HomeFragment();
        mFragTransctn = mFragMgr.beginTransaction();
        mFragTransctn.replace(R.id.act_main_content_fragment, frg, "HomeFragment");
//        mFragTransctn.addToBackStack(AppConstt.FragTag.FN_AddPatientFragment);
        mFragTransctn.commit();
    }
    private void setBottomTabBar() {

        colorBtabOn = ContextCompat.getColor(this, R.color.blue);
        colorBtabOff = ContextCompat.getColor(this, R.color.white);

        arrllBottomTab = new LinearLayout[NUM_BOTTOM_TABS];
        arrllBottomTab[BOTTOM_TAB_Home] = findViewById(R.id.laybttab_ll_home);
        arrllBottomTab[BOTTOM_TAB_Services] = findViewById(R.id.laybttab_ll_cart_histroy);
        arrllBottomTab[BOTTOM_TAB_Settings] = findViewById(R.id.laybttab_ll_profile);
        arrllBottomTab[BOTTOM_TAB_PROFILE] = findViewById(R.id.laybttab_ll_settings);

        for (int i = 0; i < NUM_BOTTOM_TABS; i++)
            arrllBottomTab[i].setOnClickListener(this);


        arrchbBottomTab = new CheckBox[NUM_BOTTOM_TABS];
        arrchbBottomTab[BOTTOM_TAB_Home] = findViewById(R.id.laybttab_chb_home);
        arrchbBottomTab[BOTTOM_TAB_Services] = findViewById(R.id.laybttab_chb_history);
        arrchbBottomTab[BOTTOM_TAB_Settings] = findViewById(R.id.laybttab_chb_profile);
        arrchbBottomTab[BOTTOM_TAB_PROFILE] = findViewById(R.id.laybttab_chb_settings);
//
//        arrtxvBottomTab = new TextView[NUM_BOTTOM_TABS];
//        arrtxvBottomTab[BOTTOM_TAB_Home] = findViewById(R.id.laybttab_txv_medicines);
//        arrtxvBottomTab[BOTTOM_TAB_Services] = findViewById(R.id.laybttab_txv_alerts);
//        arrtxvBottomTab[BOTTOM_TAB_Settings] = findViewById(R.id.laybttab_txv_chat);
//        arrtxvBottomTab[BOTTOM_TAB_PROFILE] = findViewById(R.id.laybttab_txv_profile);

//        rlBottomTabContainer = findViewById(R.id.act_main_rl_bttabbar);
//        vewBottomPlaceholder = findViewById(R.id.act_main_vew_bottomplaceholder);

//        setBottomTabVisiblity(View.VISIBLE);
    }

    private void switchBottomTab(int tabNum) {
        for (int i = 0; i < NUM_BOTTOM_TABS; i++) {
            arrchbBottomTab[i].setChecked(i == tabNum);
//            arrtxvBottomTab[i].setTextColor((i == tabNum) ? colorBtabOn : colorBtabOff);
        }
    }

    public void clearMyBackStack() {
        int count = mFragMgr.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            mFragMgr.popBackStackImmediate();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.laybttab_ll_home:

                navtohomefragment();

                break;
            case R.id.laytlbr_ll_back_icon:
//                hideMyKeyboard();
                onBackPressed();
                break;



        }


    }
    @Override
    public void onBackPressed() {
        if (mFragMgr.getBackStackEntryCount() > 0) {
            mFragMgr.popBackStack();

        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void setHeaderTitle(String strAppTitle) {
        toolbartitle.setText(strAppTitle);

    }
}
