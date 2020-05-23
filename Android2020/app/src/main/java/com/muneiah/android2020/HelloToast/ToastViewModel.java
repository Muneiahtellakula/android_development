package com.muneiah.android2020.HelloToast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToastViewModel extends ViewModel
{
    MutableLiveData<String> liveData;

    public ToastViewModel(){
        liveData=new MutableLiveData<>();
       // liveData.setValue();
    }
}
