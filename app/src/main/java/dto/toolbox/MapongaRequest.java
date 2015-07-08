package dto.toolbox;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import org.apache.http.util.ByteArrayBuffer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import dto.ResponseDTO;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class MapongaRequest extends Request<ResponseDTO> {
    private Response.Listener<ResponseDTO> listener;
    private Response.ErrorListener errorListener;
    private long start, end;

    public MapongaRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    public MapongaRequest(int method, String url,
                          Response.Listener<ResponseDTO> responseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = responseListener;
        this.errorListener = errorListener;
        start = System.currentTimeMillis();
        Log.i(LOG, "...Cloud Server communication started ...");

    }

    @Override
    protected Response<ResponseDTO> parseNetworkResponse(
            NetworkResponse response) {
        ResponseDTO dto = new ResponseDTO();
        try {
            Gson gson = new Gson();
            String resp = new String(response.data);
            Log.i(LOG, "response string length returned: " + resp.length());
            try {
                dto = gson.fromJson(resp, ResponseDTO.class);
                if (dto != null) {
                    return Response.success(dto,
                            HttpHeaderParser.parseCacheHeaders(response));
                }
            } catch (Exception e) {
                // ignore, it's a zipped response
            }

            InputStream is = new ByteArrayInputStream(response.data);
            ZipInputStream zis = new ZipInputStream(is);
            @SuppressWarnings("unused")
            ZipEntry entry;
            ByteArrayBuffer bab = new ByteArrayBuffer(2048);

            while ((entry = zis.getNextEntry()) != null) {
                int size = 0;
                byte[] buffer = new byte[2048];
                while ((size = zis.read(buffer, 0, buffer.length)) != -1) {
                    bab.append(buffer, 0, size);
                }
                resp = new String(bab.toByteArray());
                Log.e(LOG, "Unable to complete request: " + resp.length());
                dto = gson.fromJson(resp, ResponseDTO.class);
            }
        } catch (Exception e) {
            VolleyError ve = new VolleyError("Exception parsing server data", e);
            errorListener.onErrorResponse(ve);
            // Log.e(LOG, "Unable to complete request: " + dto.getMessage(), e);
            return Response.error(new VolleyError(dto.toString()));
        }
        end = System.currentTimeMillis();
        //  Log.e(LOG,"#### comms elapsed time in seconds: " + getElapsed(start,end));
        return Response.success(dto,
                HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(ResponseDTO response) {
        end = System.currentTimeMillis();
        listener.onResponse(response);
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }
    static final String LOG = "mpRequest";
}
