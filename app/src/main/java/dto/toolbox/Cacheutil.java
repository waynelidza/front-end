package dto.toolbox;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import dto.ResponseDTO;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class Cacheutil {
    public interface CacheUtilListener {
        public void onFileDataDeserialized(ResponseDTO response);

        public void onDataCached();
    }

    static CacheUtilListener listener;
    public static final int CACHE_DATA = 1, CACHE_REGISTER_DATA = 2, MEMBERS= 11;
    static int dataType, classID;
    static ResponseDTO response;
    static Context ctx;
    static final String JSON_CATEGORIES = "MESSAGES.json", JSON_DATA = "data.json",JSON_Memebers = "membersdata.json",
            Members_ACTIVITY = "membersActivity";
    public static void regiData(Context context, ResponseDTO r, int type, CacheUtilListener cacheUtilListener) {
        dataType = type;
        response = r;
        listener = cacheUtilListener;
        ctx = context;
        new CacheTask().execute();
    }

    public static void getCachedData(Context context, int type, CacheUtilListener cacheUtilListener) {
        Log.d(LOG, "################ getting cached data ..................");
        dataType = type;
        listener = cacheUtilListener;
        ctx = context;
        new CacheRetrieveTask().execute();
    }


    static class CacheTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String json = null;
            File file = null;
            FileOutputStream outputStream;
            try {
                switch (dataType) {
                    case MEMBERS:
                        json = gson.toJson(response);
                        outputStream = ctx.openFileOutput(JSON_Memebers, Context.MODE_PRIVATE);
                        write(outputStream, json);
                        file = ctx.getFileStreamPath(JSON_Memebers);
                        if (file != null) {
                            Log.e(LOG, "......Data cache json written to disk,  - path: " + file.getAbsolutePath() +
                                    " - length: " + file.length());
                        }
                        break;
                    default:
                        Log.e(LOG, "######### NOTHING done ...");
                        break;

                }

            } catch (IOException e) {
                Log.e(LOG, "Failed to cache data", e);
            }
            return null;
        }

        private void write(FileOutputStream outputStream, String json) throws IOException {
            outputStream.write(json.getBytes());
            outputStream.close();
        }

        @Override
        protected void onPostExecute(Void v) {
            listener.onDataCached();
        }
    }
    static class CacheRetrieveTask extends AsyncTask<Void, Void, ResponseDTO> {

        private ResponseDTO getData(FileInputStream stream) throws IOException {
            String json = getStringFromInputStream(stream);
            ResponseDTO response = gson.fromJson(json, ResponseDTO.class);
            if (response == null) {
                response = new ResponseDTO();
            }
            return response;
        }
        @Override
        protected ResponseDTO doInBackground(Void... voids) {
            ResponseDTO response = null;
            FileInputStream stream;
            Log.d(LOG, "########### doInBackground: getting cached data ....");
            try {
                switch (dataType) {
                    case MEMBERS:
                        stream = ctx.openFileInput(JSON_Memebers);
                        response = getData(stream);
                        break;
                }

            } catch (IOException e) {
                Log.e(LOG, "Failed to retrieve cache", e);
            }
            return response;
        }

        @Override
        protected void onPostExecute(ResponseDTO v) {
            if (v != null) {
                Log.e(LOG, "$$$$$$$$$$$$ cached data retrieved");
            }
            listener.onFileDataDeserialized(v);
        }
    }


    private static String getStringFromInputStream(InputStream is) throws IOException {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } finally {
            if (br != null) {
                br.close();
            }
        }
        String json = sb.toString();
        return json;

    }

    static final String LOG = "CacheUtil";
    static final Gson gson = new Gson();
}
