package com.aptron.sqlite;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context){
        this.context=context;
        preferences=
    }
    public void setSession(boolean flag){
        editor.putBoolean("set",flag);
    }
    public boolean getSession(){
        return true;
    }
}
