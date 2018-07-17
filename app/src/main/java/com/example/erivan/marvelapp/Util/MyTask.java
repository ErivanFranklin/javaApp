package com.example.erivan.marvelapp.Util;

import android.os.AsyncTask;
import android.util.Log;

public class MyTask extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.e("sfdfds",MyTask.this.toString());
        System.out.println("PRINT : //2A");
        int i = 0;
        synchronized (this){

            while (i<10){
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        return "FINISH";
    }

    @Override
    protected void onPreExecute() {
        System.out.println("PRINT : //1");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        System.out.println("PRINT : //3");
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        System.out.println("PRINT : //2B");
        super.onProgressUpdate(values);
    }


}
