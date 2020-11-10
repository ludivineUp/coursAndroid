package com.devforxkill.exampleapivollay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // url https://jsonplaceholder.typicode.com/todos/1

        // dans graddle compile 'com.android.volley:volley:1.1.0' et compile 'com.google.code.gson:gson:2.8.0'

        // Permission du manifest     <uses-permission android:name="android.permission.INTERNET" />

        // création de quoi faire la requête
        requestQueue = Volley.newRequestQueue(getApplicationContext());

            // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
            // that expects a JSON Array Response.
            // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html
            JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET,
                    "https://jsonplaceholder.typicode.com/todos",
                    null,
                    new Response.Listener<JSONArray>(){
                        @Override
                        public void onResponse(JSONArray response) { // ou JSONObject en param
                            // Check the length of our response (to see if the user has any repos)
                            if (response.length() > 0) {
                                // The user does have repos, so let's loop through them all.
                                for (int i = 0; i < response.length(); i++) {
                                    try {
                                        // Réponse JSON : {
                                        //	"userId": 1,
                                        //	"id": 1,
                                        //	"title": "delectus aut autem",
                                        //}
                                        JSONObject jsonObj = response.getJSONObject(i);
                                        Log.d("RESPONSE", jsonObj.get("userId").toString());
                                        Log.d("RESPONSE", jsonObj.get("id").toString());
                                        // penser à caster si les attributs ne sont pas des strings !!!
                                    } catch (JSONException e) {
                                        // If there is an error then output this to the logs.
                                        Log.d("Volley",  e.getStackTrace().toString());
                                    }

                                }
                            } else {
                                // pas d'infos reçues
                                Log.d("RESPONSES", "empty response");
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Volley", error.toString());
                        }
                    }
                    );

            // Add the request we just defined to our request queue.
            // The request queue will automatically handle the request as soon as it can.
            requestQueue.add(arrReq);
    }
    /* exemple de requête POST
    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
    new Response.Listener<String>()
    {
        @Override
        public void onResponse(String response) {
            // response
            Log.d("Response", response);
        }
    },
    new Response.ErrorListener()
    {
         @Override
         public void onErrorResponse(VolleyError error) {
             // error
             Log.d("Error.Response", response);
       }
    }
) {
    @Override
    protected Map<String, String> getParams()
    {
            Map<String, String>  params = new HashMap<String, String>();
            params.put("toto", "toto");
            params.put("titi", "titi");

            return params;
    }
};
queue.add(postRequest);
     */


}