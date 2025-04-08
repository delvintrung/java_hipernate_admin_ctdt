package org.example.project2.data;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallAPI {
    private static final OkHttpClient client = new OkHttpClient();
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public interface Callback {
        void onSuccess(String data);
        void onFailure(Exception e);
    }

    public void fetchData(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        executor.submit(() -> {
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    SwingUtilities.invokeLater(() -> callback.onSuccess(result));
                } else {
                    throw new IOException("Unexpected code " + response.code());
                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> callback.onFailure(e));
            }
        });
    }
}