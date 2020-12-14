package Service;

import Data.InternetConnectProperty;
import Interfaces.IHttpService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;

public class HttpServiceApache implements IHttpService {

    public HttpServiceApache(String url, InternetConnectProperty connectProperty) {
        _url = url;
        HttpClientBuilder hcBuilder = HttpClients.custom();

        if (connectProperty.IsSet) {
            HttpHost proxy = new HttpHost(connectProperty.ProxyServer, connectProperty.ProxyPort, "http");
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
            hcBuilder.setRoutePlanner(routePlanner);
        }

        _httpClient = hcBuilder
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build()).build();
    }

    //region PrivateField
    private final String _url;
    private final CloseableHttpClient _httpClient;

    public String RequestGet(String requestQuery) {
        HttpGet request = new HttpGet(String.format("%s/%s", _url, requestQuery));
        request.setProtocolVersion(HttpVersion.HTTP_1_1);

        try (CloseableHttpResponse response = _httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null) result = EntityUtils.toString(entity);

            return result;
        } catch (Exception ex) {
            return "Ошибка получения данных от сервера API: " + ex.getLocalizedMessage();
        }
    }

    public String RequestGet() {
       return RequestGet("");
    }
}