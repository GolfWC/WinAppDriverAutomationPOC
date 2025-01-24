package Utils;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TeamsNotifier {

    private static final String WEBHOOK_URL = "https://securiport.webhook.office.com/webhookb2/07bf445f-c4f9-4d07-8d1e-a9ddbff5bb58@ea681ba6-a990-4040-8c61-18addcbded7e/IncomingWebhook/59b6ceaf69e043769172b098f4ccb4db/998599f0-c4c9-40f1-91e8-dd4335af24a1/V2RpEK2Sp6fOxKwIVudRltZQhyVOi6eJcx-RWHwm6708g1";
      //      "https://securiport.webhook.office.com/webhookb2/07bf445f-c4f9-4d07-8d1e-a9ddbff5bb58@ea681ba6-a990-4040-8c61-18addcbded7e/IncomingWebhook/5ca8132b9ebc4bb49ebfd54fe68659e7/998599f0-c4c9-40f1-91e8-dd4335af24a1/V2AB8KfAmJ16XoY9NewL1o_x9wx2ncnPlNb_rZMe0q-Nw1";

    public static void sendMessage(String message) {
        try {
            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String payload = "{ \"text\": \"" + message + "\" }";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Failed to send message to Teams. HTTP error code: " + responseCode);
            } else {
                System.out.println("Message sent to Teams successfully.");
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendMessage(String message, String reportLink) {
        try {
            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String payload = "{ \"text\": \"" + message + "\\nReport Link: " + reportLink + "\" }";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }


            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Failed to send message to Teams. HTTP error code: " + responseCode);
            } else {
                System.out.println("Message sent to Teams successfully.");
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
