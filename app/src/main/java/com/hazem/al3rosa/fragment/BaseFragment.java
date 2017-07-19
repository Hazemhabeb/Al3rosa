package com.hazem.al3rosa.fragment;


import android.support.v4.app.Fragment;
import android.view.View;


/**
 * Created by hamdy on 11/21/2016.
 */
public abstract class BaseFragment extends Fragment {
    public final String TAG = getClass().getSimpleName();

    public abstract void onLowMemory();

    public abstract void initViews(View view);

    public abstract void attachListeners();

//    public BaseActivity getBaseActivity() {
//        return (BaseActivity) getActivity();
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        getBaseActivity().hideKeyboard();
        onLowMemory();

    }

    /*mha2 public void cancelAllRequests() {
        getBaseActivity().cancelAllRequests();
    }*/

    public void setToolbarTitle(int titleId) {
//        ((BaseActivity) getActivity()).setToolbarTitle(titleId);
    }

//    public boolean checkConnectivity() {
//        try {
//            return getBaseActivity().checkConnectivity();
//        } catch (NullPointerException e) {
//            //mha2 CrashlyticsCore.getInstance().log(2, TAG, "BaseActivity Is Null ");
//            return false;
//        }
//    }

//    public DatabaseManager getDatabaseManager() {
//        return getBaseActivity().getDatabaseManager();
//    }

    @Override
    public void onResume() {
        super.onResume();
//        AuthenticationUtls.isDriverNotAuthorized(getBaseActivity());
    }
}
