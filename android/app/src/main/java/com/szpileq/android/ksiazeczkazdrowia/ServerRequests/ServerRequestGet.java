package com.szpileq.android.ksiazeczkazdrowia.ServerRequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class ServerRequestGet {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";


    public ServerRequestGet() {

    }

    public JSONObject getJSONObjFromUrl(String url, List<NameValuePair> params, String token   ) {


        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            String authorizeToken = "Bearer " + token;
            httpGet.setHeader("authorization", authorizeToken);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSON", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }


        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }


        return jObj;

    }
    JSONObject jobj;

    public String getJSONArrFromUrl(String url, List<NameValuePair> params, String token   ) {


        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            String authorizeToken = "Bearer " + token;
            httpGet.setHeader("authorization", authorizeToken);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSON", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }



        return json;

    }

    String jArr;
    public JSONObject getJSON(String url, List<NameValuePair> params, String token) {

        Params param = new Params(url,params, token);
        RequestObj myTask = new RequestObj();
        try{
            jobj= myTask.execute(param).get();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        return jobj;
    }
    public String getJSONArr(String url, List<NameValuePair> params, String token) {

        Params param = new Params(url,params, token);
        RequestArr myTask = new RequestArr();
        try{
            jArr= myTask.execute(param).get();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        return jArr;
    }

    private static class Params {
        String url;
        List<NameValuePair> params;
        String token;

        Params(String url, List<NameValuePair> params, String token) {
            this.url = url;
            this.params = params;
            this.token = token;
        }
    }

    private class RequestObj extends AsyncTask<Params, String, JSONObject> {

        @Override
        protected JSONObject doInBackground(Params... args) {

            ServerRequestGet request = new ServerRequestGet();
            JSONObject json = request.getJSONObjFromUrl(args[0].url,args[0].params, args[0].token);

            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json) {

            super.onPostExecute(json);

        }

    }
    private class RequestArr extends AsyncTask<Params, String, String> {

        @Override
        protected String doInBackground(Params... args) {

            ServerRequestGet request = new ServerRequestGet();
            String json = request.getJSONArrFromUrl(args[0].url,args[0].params, args[0].token);

            return json;
        }

        @Override
        protected void onPostExecute(String json) {

            super.onPostExecute(json);

        }

    }
}