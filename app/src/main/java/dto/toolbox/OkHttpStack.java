package dto.toolbox;

import com.squareup.okhttp.OkHttpClient;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class OkHttpStack {
    private final OkHttpClient client;

    public OkHttpStack() {
        this(new OkHttpClient());
    }

    public OkHttpStack(OkHttpClient client) {
        if (client == null) {
            throw new NullPointerException("Client must not be null.");
        }
        this.client = client;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
