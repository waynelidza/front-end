package dto.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;

import dto.MembersDTO;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class SharedUtil {

    static final Gson gson = new Gson();

    public static final String MEMBER_JSON = "teamMember",
            EMAIL_JSON = "email";
    public static MembersDTO getTeamMember(Context ctx) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        String st = sp.getString(MEMBER_JSON, null);
        MembersDTO tm = null;
        if (st != null) {
            tm = gson.fromJson(st, MembersDTO.class);
        }
        return tm;
    }
    public static void saveTeamMember(Context ctx, MembersDTO evi) {

        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor ed = sp.edit();

        ed.putString(MEMBER_JSON, gson.toJson(evi));
        ed.commit();
        // Log.e("SharedUtil, LOCATION IMAGE: " + evi.getName() + " SAVED IN SharedPreferences");
    }
    public static void setSessionID(Context ctx, String sessionID) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);

        SharedPreferences.Editor ed = sp.edit();
        ed.putString(Statics.SESSION_ID, sessionID);
        ed.commit();

        Log.w("SharedUtil", "#### web socket session id saved: " + sessionID);

    }
    public static String getSessionID(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        String j = sp.getString(Statics.SESSION_ID, null);

        return j;
    }
}
