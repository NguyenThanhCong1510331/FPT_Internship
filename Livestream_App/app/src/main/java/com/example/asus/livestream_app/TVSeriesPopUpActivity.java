package com.example.asus.livestream_app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Welcome on 6/19/2018.
 */

public class TVSeriesPopUpActivity extends AppCompatActivity{

    private String TAG=MoviePopUpActivity.class.getName();
    private static String url="";
    TextView txtImdb,txtDuration,txtCountry,txtGenre,txtDirector,txtActor,descriptionFilm;
    RecyclerView recyclerView;
    ArrayList<ArrayList<String>> lst=new ArrayList<>();
    ArrayList<String> lstString=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_episode);

        txtImdb=(TextView)findViewById(R.id.txtIMDB);
        txtDuration=(TextView)findViewById(R.id.txtduration);
        txtCountry=(TextView)findViewById(R.id.txtcountry);
        txtDirector=(TextView)findViewById(R.id.txtdirector);
        txtActor=(TextView)findViewById(R.id.txtactor);
        txtGenre=(TextView)findViewById(R.id.txtgenre);
        recyclerView=(RecyclerView)findViewById(R.id.recycleView);

        descriptionFilm=(TextView)findViewById(R.id.descriptionFilm);

        addData();
        descriptionFilm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    setFocusDescription();
                }
                else{
                    setUnFocusDescription();
                }
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ListEpisodeAdapter listEpisodeAdapter=new ListEpisodeAdapter(TVSeriesPopUpActivity.this, lst);
        recyclerView.setAdapter(listEpisodeAdapter);
     /*   descriptionFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFocused) {
                    setFocusDescription();
                    isFocused=true;
                }
                else{
                    isFocused=false;
                    setUnFocusDescription();
                }
            }
        });*/
    }

    private void addData(){
        for(int i=0;i<12;i++){
            lstString.add("Tập "+ i);
        }
        lst.add(lstString);
        lstString.clear();
        for(int i=12;i<24;i++){
            lstString.add("Tập "+ i);
        }
        lst.add(lstString);
    }

    private void setFocusDescription(){
        descriptionFilm.setMovementMethod(new ScrollingMovementMethod());

    }

    private void setUnFocusDescription(){
        descriptionFilm.setMovementMethod(null);

    }

    private class getDataFilm extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr );
            if (jsonStr != null){
             /*   try {
                    JSONArray jobs = new JSONArray(jsonStr);

                    for (int i=0; i<jobs.length();i++){
                        JSONObject j = jobs.getJSONObject(i);
                        JobInfo job = new JobInfo();
                        job.setJobId(j.getString("id"));
                        job.setJobCreatedAt(j.getString("created_at"));
                        job.setJobTitle(j.getString("title"));
                        job.setLocation(j.getString("location"));
                        job.setType(j.getString("type"));
                        job.setDescription(j.getString("description"));
                        job.setCompany(j.getString("company"));
                        job.setCompanyURL(j.getString("company_url"));
                        job.setCompanyLogo(j.getString("company_logo"));
                        job.setHowToApply(j.getString("how_to_apply"));
                        job.setURL(j.getString("url"));
                        jobsList.add(i, job);
                    }
                }catch (final JSONException e){
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    getActivity().runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            Toast.makeText(getActivity().getApplicationContext(),"Json parsing error: " + e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                }*/
            }else {
               /* Log.e(TAG, "Couldn't get json from server.");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Couldn't get json from server!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });*/
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }

    }
}
