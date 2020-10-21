package com.devforxkill.geekquote.dao;

import android.util.Half;
import android.util.Log;

import com.devforxkill.geekquote.model.Quote;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Entity;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class QuoteDaoApiRest implements QuoteDao {

    private static String url = "";
    @Override
    public ArrayList<Quote> getQuotes() {
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet= new HttpGet();
            URI uri = new URI(url);

            HttpResponse response = httpClient.execute(httpGet);
            ///result =

        } catch(Exception e){
            Log.d("API", "error"+e.getStackTrace());
        }
        return null;
    }

    @Override
    public int addQuote(Quote q) {
        return 0;
    }

    @Override
    public void updateQuote(Quote q) {

    }

    @Override
    public Quote getByID(int id) {
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet= new HttpGet();
            URI uri = new URI(url);

            HttpResponse response = httpClient.execute(httpGet);
            return JSONtoQuote( new JSONObject(EntityUtils.toString(response.getEntity())));
        } catch(Exception e){
            Log.d("API", "error"+e.getStackTrace());
        }
        return null;
    }

    private Quote JSONtoQuote(JSONObject response){
        Quote res = null;
        try {
            int id = response.getInt("id");
            String str_quote = response.getString("str_quote");
            int rating = response.getInt("rating");
            LocalDate  date = LocalDate.parse(response.getString("creation_date"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            res = new Quote(id, str_quote, rating, date);
        } catch (JSONException e) {
            Log.d("API", "error"+e.getStackTrace());
        }
        return res;
    }

    private JSONObject quoteToJSON(Quote q){
        JSONObject res = new JSONObject();
        try {
            res.put("id",q.getId());
            res.put("str_quote",q.getStrQuote());
            res.put("rating",q.getRating());
            res.put("creation_date",q.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (JSONException e) {
            Log.d("API", "error"+e.getStackTrace());
        }
        return res;
    }
}
