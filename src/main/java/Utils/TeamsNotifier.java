package Utils;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class TeamsNotifier {

    private static final String WEBHOOK_URL = "https://outlook.office.com/webhook/your/webhook/url";

    public static void sendMessage(String message) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(WEBHOOK_URL);
            StringEntity entity = new StringEntity("{\"text\":\"" + message + "\"}");
            post.setEntity(entity);
            post.setHeader("Content-type", "application/json");
            client.execute(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
